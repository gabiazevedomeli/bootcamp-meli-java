package com.dh.meli.crudjpa.service;

import com.dh.meli.crudjpa.model.Student;
import com.dh.meli.crudjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* classe StudentService que implementa os métodos declarados na Interface
    recebe o StudentRepository via injeção de dependência, gerenciada pelo Spring à partir da anotação
    @Autowired
 */

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentsList = (List<Student>) studentRepository.findAll();
        return studentsList;
    }

    @Override
    @Transactional(readOnly = true)
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }
}
