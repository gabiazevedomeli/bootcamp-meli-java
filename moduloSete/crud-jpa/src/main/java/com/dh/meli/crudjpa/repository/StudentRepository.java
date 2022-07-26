package com.dh.meli.crudjpa.repository;

import com.dh.meli.crudjpa.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* Não esquecer da anotação @Repository, para marcar que esta interface é um repository
extender da interface JpaRepository, pois é ela quem provê os métodos de interação com o db, para as diferentes
operações do CRUD
    No parâmetro, a Interface JpaRepository recebe o objeto (Entidade) que será persistido no
    DB e o identificador (Long)
*/

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
