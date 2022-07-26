package com.dh.meli.crudjpa.controller;

import com.dh.meli.crudjpa.model.Student;
import com.dh.meli.crudjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "The student was added successfully";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> studentsList = studentService.getStudents();
        return studentsList;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @PutMapping("/edit/{id}")
    public Student editStudent(@PathVariable Long id,
                               @RequestParam ("name") String newName,
                               @RequestParam ("lastName") String newLastName) {

        Student studentFound = studentService.findStudentById(id);

        studentFound.setName(newName);
        studentFound.setLastname(newLastName);
        studentService.saveStudent(studentFound);

        return studentFound;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "The student was deleted successfully";
    }
}





























