package com.example.springhello.dto;

import com.example.springhello.controller.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String nome;

    public UserDTO(User user) {
        this.nome = user.getNome();
    }
}
