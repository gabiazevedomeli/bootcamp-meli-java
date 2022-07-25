package com.dh.meli.perolas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
@Entity
@Table(name = "tb_jewel")
public class JewelDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Material must to be specified.")
    @Column(name = "material", length = 80, nullable = false)
    private String material;

    @NotNull(message = "Weight must to be specified.") // validation
    @Column(name = "weight", scale = 2, nullable = false) // JPA
    private Double weight;

    @NotNull(message = "Carats must to be specified.")
    @Column(name = "carats", nullable = false)
    private Integer carats;
}


