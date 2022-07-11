package com.exemplo.validacao.calculadora;

import com.exemplo.validacao.util.CalculadoraCreate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    // não utilizar if's para testar. Caso eu entenda que o teste possui mais de um cenário, é preciso fazer mais de um teste.

    private Calculadora calculadora;

    @BeforeEach
    public void setup() {
        calculadora = CalculadoraCreate.create();
    }

    @Test
    @DisplayName("Valida parâmetros diferentes de zero")
    void divide_ReturnValueDouble_WhenParamAreDifferent() {
        double expected = CalculadoraCreate.create().getN1() / CalculadoraCreate.create().getN2();

        double resultado = calculadora.dividir();

        assertEquals(expected, resultado);
    }

    @Test
    @DisplayName("Valida parâmetros denominador zero")
    void divide_ReturnZero_WhenParamEqualZero() {
        double expected = 0;
        calculadora.setN2(0);

        double resultado = calculadora.dividir();

        assertEquals(expected, resultado);
    }
}