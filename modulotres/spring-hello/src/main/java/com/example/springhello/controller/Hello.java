package com.example.springhello.controller;

import com.example.springhello.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que esta classe é um controller Rest. Para cada recurso terei uma classe controller para escrever os métodos
@RequestMapping("/user") // Indica que "/user" é usado para acionar este controller. Aqui eu indico o recurso da minha API
public class Hello {

    @GetMapping
    public String digaOla() {
        return "Olá!!!";
    }

    @GetMapping("/ola/{nome}/{id}") // Este método é acionado por uma requisição GET (aqui indico o verbo HTTP e quais parâmetros serão passados no endpoint da requisição)
    public String digaHello(@PathVariable String nome, @PathVariable int id) { // A anotação @PathVariable precisa ser usada para cada parâmetro que o método recebe via requisição

        return "Olá " + nome + ": " + id + " !";
    }

    @GetMapping("/hello") // Este método é acionado por uma requisição GET
    public String sayHello(@RequestParam String nome, @RequestParam int id) {
        return "Hello " + nome + ": " + id + " !";
    }

    @PostMapping
    public ResponseEntity<UserDTO> getUser(@RequestBody User user) {
        if (user.getId() == 123) {
            UserDTO userDTO = new UserDTO(user);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    // teste
}
