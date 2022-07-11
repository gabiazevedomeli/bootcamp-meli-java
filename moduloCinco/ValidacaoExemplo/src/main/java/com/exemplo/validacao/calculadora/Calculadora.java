package com.exemplo.validacao.calculadora;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculadora {
    // uma unidade que possui uma lógica que precisa ser testada
    private double n1, n2;

    public double dividir() {
        if (n2 == 0) {
            return 0;
        } else {
            return n1 / n2;
        }
    }
}
