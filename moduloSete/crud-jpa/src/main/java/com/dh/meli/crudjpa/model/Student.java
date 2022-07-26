package com.dh.meli.crudjpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* Modelagem da classe que representará a Entidade Student no DB
   Sempre lembrar colocar as anotações de Getter e Setter
   Configuração de chave primária e demais atributos da Entidade
 */

@Getter @Setter
@Entity
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private String lastname;

}
