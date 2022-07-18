package com.meli.obterdiploma.integration;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.repository.StudentDAO;
import com.meli.obterdiploma.util.TestUtilsGenerator;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// O Spring escolhe a porta para subir o servidor, randomicamente
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentIntegration {

    // O Spring vai preencher o valor dessa variável com a porta escolhida para subir o servidor
    @LocalServerPort
    private int port;

    // TestRestTemplate é uma classe usada para desenvolver testes e é uma dependência injetada pelo Spring
    @Autowired
    TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setup() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    @DisplayName("Inserindo um novo estudante")
    public void registerStudent_saveStudent_whenNewStudent() {
        // Preparação do cenário
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        String baseUrl = "http://localhost:" + port + "/student";
        HttpEntity<StudentDTO> httpEntity = new HttpEntity<>(newStudent);

        /* Simulação da requisição (como se fosse o Postman)
           1 - URL;
           2 - Método Http da requisição;
           3 - O que estou enviando (nesse caso body da req);
           4 - Tipo do objeto enviado
         */
        // Execução
        ResponseEntity<StudentDTO> result =  testRestTemplate.exchange(baseUrl + "/registerStudent", HttpMethod.POST, httpEntity, StudentDTO.class);

        // Objeto retornado da requisição, para comparação ao objeto enviado no método post
        StudentDTO studentReturned = result.getBody();
        // Testagem
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(studentReturned).isNotNull();
        assertThat(studentReturned.getId()).isPositive();
        assertThat(studentReturned.getStudentName()).isEqualTo(newStudent.getStudentName());

    }

    @Test
    @DisplayName("Retorna BAD_REQUEST quando o estudante tem ID")
    public void registerStudent_returnBadRequest_whenStudentHasId() {
        // Preparação do cenário
        StudentDTO newStudent = TestUtilsGenerator.getStudentWithId();
        String baseUrl = "http://localhost:" + port + "/student";
        HttpEntity<StudentDTO> httpEntity = new HttpEntity<>(newStudent);

        /* Simulação da requisição (como se fosse o Postman)
           1 - URL;
           2 - Método Http da requisição;
           3 - O que estou enviando (nesse caso body da req);
           4 - Tipo do objeto enviado
         */
        // Execução
        ResponseEntity<StudentDTO> result =  testRestTemplate.exchange(baseUrl + "/registerStudent", HttpMethod.POST, httpEntity, StudentDTO.class);

        // Testagem
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void getStudent_returnStatusNotFound_whenStudentNotExist() {
        // Preparação do cenário
        StudentDTO student = TestUtilsGenerator.getStudentWithId();
        String baseUrl = "http://localhost:" + port + "/student";

        /* Simulação da requisição (como se fosse o Postman)
           1 - URL;
           2 - Método Http da requisição;
           3 - O que estou enviando (nesse caso body da req);
           4 - Tipo do objeto enviado
         */
        // Execução
        ResponseEntity<StudentDTO> result =  testRestTemplate.exchange(
                baseUrl + "/getStudent" + student.getId(),
                HttpMethod.GET,
                null,
                StudentDTO.class);

        // Testagem
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void getStudent_returnStatusNotFound_whenStudentExist() {
        // Preparação do cenário
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        String baseUrl = "http://localhost:" + port + "/student/getStudent/";
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentSaved = studentDAO.save(newStudent);

        String url = String.format(baseUrl+"%d", studentSaved.getId());

        /* Simulação da requisição (como se fosse o Postman)
           1 - URL;
           2 - Método Http da requisição;
           3 - O que estou enviando (nesse caso body da req);
           4 - Tipo do objeto enviado
         */
        // Execução
        ResponseEntity<StudentDTO> result =  testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                StudentDTO.class);

        // Testagem
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().getId()).isEqualTo(studentSaved.getId());
        assertThat(result.getBody().getStudentName()).isEqualTo(studentSaved.getStudentName());
    }

    

}
