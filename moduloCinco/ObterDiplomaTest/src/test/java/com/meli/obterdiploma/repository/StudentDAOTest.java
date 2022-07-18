package com.meli.obterdiploma.repository;

import com.meli.obterdiploma.exception.StudentNotFoundException;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

// As ferramentas de teste não fazem parte do Java. O JUnit, Assert, são libs que fazem teste unitário em Java.

// Convenção de nomenclatura de métodos em teste: nomeDoMetodo_oQueFaz_Quando

class StudentDAOTest {

    /* A linha abaixo instância o objeto, só que é preciso desacoplar essa responsabilidade de dentro do arquivo de testes
        private StudentDAO studentDAO = new StudentDAO();
     */

    /* Injeção de Dependência no Spring

        O Spring busca o objeto a ser instanciado, através da implementação da interface.
        Esse objeto injetado pelo Spring será usado para rodar os cenários de testes.
        Nesse caso a implementação da interface é a classe StudentDAO que implementa os métodos da Interface IStudentDAO.

        O processo de injeção de dependências é passar uma interface para o Spring e ele procura a implementação dela para usar.
        Como só existe 1 classe implementando a dita interface, o Spring saberá qual usar.

        Neste exemplo, foi removida a Injeção de Dependência do Spring, para usar o método setup() declarado na linha 39.
            @Autowired
            private IStudentDAO studentDAO;
     */

    //@Autowired
    private IStudentDAO studentDAO; // Instancia o objeto

    // Método executado antes de cada este para limpar a base de dados
    @BeforeEach
    void setup() {
        TestUtilsGenerator.emptyUsersFile();
        studentDAO = new StudentDAO();
    }

    // Método executado após rodar todos os testes, limpa qualquer resíduo existente na base de dados
    // @AfterAll
    // precisa ser declarado como método estático
    // public static void tearDown() {
        // apaga todos os registros do arquivo que simula a base de dados
        //TestUtilsGenerator.emptyUsersFile();
    //}

    @Test
    @DisplayName("Salva novo estudante, quando o registro não existe na base de dados")
    void save_saveStudent_WhenNewStudent() {
        // Prepara o cenário
        // Cria um estudante sem ID - registro novo, ainda sem ID.
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();

        // Executa a instrução anterior, salvando efetivamente o registro
        StudentDTO savedStudent = studentDAO.save(newStudent);

        // Teste dos cenários possíveis
        assertThat(savedStudent).isNotNull();
        assertThat(savedStudent.getId().doubleValue()).isPositive();
        assertThat(savedStudent.getStudentName()).isEqualTo(newStudent.getStudentName());
    }

    @Test
    @DisplayName("Atualiza estudante quando o mesmo já existe na base de dados")
    void save_updateStudent_WhenStudentWithId() {
        /* Quando acontece a tentativa de salvar um estudante com ID existente, então isso indica que
        o registro já existe, portanto o método save se comportará como um update, atualizando as informações do registro existente*/

        // salvar um novo estudante garantindo que existe um registro no banco de dados
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();

        /* O objetivo é testar o cenário de um registro existente na base de dados, para isso é necessário criar/persistir
        os dados no banco, devido ao fato da base de dados passar por um processo de limpeza a cada teste. Feito isso
        poderemos testar o comportamento, pois haverá registro na base de dados.*/

        StudentDTO savedStudent = studentDAO.save(newStudent);
        savedStudent.setStudentName("Novo nome");
        savedStudent.getSubjects().get(0).setName("Nova disciplina");

        // Executa o cenário (comportamento)
        // agora quero salvar novamente, porém atualizado, o comportamento será de atualizar o registro que está salvo
        StudentDTO updatedStudent = studentDAO.save(savedStudent);

        // Testa efetivamente o comportamento do método
        assertThat(updatedStudent).isNotNull();
        assertThat(updatedStudent.getId()).isEqualTo(savedStudent.getId());
        assertThat(updatedStudent.getStudentName()).isEqualTo(savedStudent.getStudentName());
        assertThat(updatedStudent.getSubjects().get(0).getName()).isEqualTo(savedStudent.getSubjects().get(0).getName());
    }

    @Test
    @DisplayName("Lança exceção quando o estudante não existir na base de dados")
    void save_throwException_WhenStudentWithIdAndNotExist() {
        // Prepara o cenário
        StudentDTO student = TestUtilsGenerator.getStudentWithId();

        /* Execução do cenário - espera que seja lançada a exceção ???
           O método Assertions.assertThrows espera dois parâmetros (o tipo da exceção(classe que modela a exceção),
           ação que provoca o estouro da exceção)
         */
        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> {
            StudentDTO savedStudent = studentDAO.save(student);

        });

        // Testa o comportamento à partir da exceção lançada
        /* Essa exceção está sendo gerenciada pelo teste, por isso é necessário usar o getErro
         Testa se o ID do estudante está dentro da mensagem da exceção */
        assertThat(exception.getError().getDescription()).contains(student.getId().toString());
        // Testa se o status code lançado é o NOT_FOUND
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Deleta estudante quando estudante existe")
    void delete_removeStudent_whenStudentExist() {
        // Criação do cenário - cria estudante na base de dados
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        StudentDTO savedStudent = studentDAO.save(newStudent);

        // Executa o cenário - deleta o estudante
        studentDAO.delete(savedStudent.getId());

        // Testa o cenário - se o estudante foi removido da base de dados
        assertThat(studentDAO.exists(savedStudent)).isFalse();
    }

    @Test
    @DisplayName("Lança exceção quando o estudante não existe")
    void delete_throwException_whenStudentNotExist() {
        // Criação do cenário - cria estudante na base de dados
        StudentDTO student = TestUtilsGenerator.getStudentWithId();

        // Executa o cenário - deleta o estudante

        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.delete(student.getId());
        });

        // Testa o cenário
        assertThat(exception.getError().getDescription()).contains(student.getId().toString());
        // Testa se o status code lançado é o NOT_FOUND
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Retorna true quando o estudante existe na base de dados")
    void exists_returnTrue_whenStudentExist() {
        // Prepara o cenário
        // Criando e salvando um estudante sem ID
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        StudentDTO savedStudent = studentDAO.save(newStudent);

        // Execução do cenário - Se existe um estudante na base de dados
        boolean found = studentDAO.exists(savedStudent);

        // Testagem do comportamento - espera-se que seja True
        assertThat(found).isTrue();
    }

    @Test
    @DisplayName("Retorna falso quando o estudante não existe")
    void exists_returnFalse_whenStudentNotExist() {
        // Prepara o cenário
        StudentDTO student = TestUtilsGenerator.getStudentWithId();

        // Execução do cenário
        boolean found = studentDAO.exists(student);

        // Testagem do cenário - Retorna false quando não existe o estudante procurado na base de dados
        assertThat(found).isFalse();
    }

    @Test
    void findById_returnStudent_whenStudentExist() {
        // Prepara o cenário
        // Criação de estudante já com ID
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        StudentDTO savedStudent = studentDAO.save(newStudent);

        // Execução do cenário
        StudentDTO foundStudent = studentDAO.findById(savedStudent.getId());

        // Testagem do cenário
        assertThat(foundStudent).isNotNull();
        assertThat(foundStudent.getId()).isEqualTo(savedStudent.getId());
        assertThat(foundStudent.getStudentName()).isEqualTo(savedStudent.getStudentName());

    }

    @Test
    void findById_throwException_whenStudentNotExist() {
        // Prepara cenário
        StudentDTO student = TestUtilsGenerator.getStudentWithId();

        // Não salva o estudante na base de dados
        // Arquivo está vazio
        // Lançamento da exceção para o cenário de não encontrarmos o estudante pelo atributo ID
        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> {
            // Busca o ID do estudante, sem sucesso, uma vez que o arquivo está vazio
            StudentDTO foundStudent = studentDAO.findById(student.getId());

        });

        // Testa cenário
        assertThat(exception.getError().getDescription()).contains(student.getId().toString());
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);

    }
}