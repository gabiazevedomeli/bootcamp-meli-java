package com.dh.meli.crudjpa.service;

import com.dh.meli.crudjpa.model.Student;

import java.util.List;

public interface IStudentService {

    // método que retorna uma lista de estudantes à partir de uma busca por todos os registros de estudantes
    List<Student> getStudents();

    // método que não retorna nada, apenas recebe um objeto do tipo estudante e salva no DB
    void saveStudent(Student student);

    // método que não retorna nada, apenas recebe um id do tipo Long e deleta o objeto do id correspondente do DB
    void deleteStudent(Long id);

    // método que retorna um objeto do tipo Student à partir de busca pelo id no DB
    Student findStudentById(Long id);

}
