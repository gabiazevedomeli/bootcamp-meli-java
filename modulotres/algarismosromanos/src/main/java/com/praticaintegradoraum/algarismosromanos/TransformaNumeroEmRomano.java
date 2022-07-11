package com.praticaintegradoraum.algarismosromanos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converteNumero")
public class TransformaNumeroEmRomano {

    @GetMapping("/{numeroInteiro}")
    public ResponseEntity<String> converteNumeroEmRomano(@PathVariable int numeroInteiro) {
        String mensagem = "Não existe o número 0 em algarismo romano, por isso não pode ser transformado!!!";
        if (numeroInteiro == 0) return new ResponseEntity<String>(mensagem,
                HttpStatus.BAD_REQUEST);

        // https://pt.stackoverflow.com/questions/247563/converter-n%C3%BAmeros-romanos-em-java

        int[] inteiros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "1"};

        String resposta = "";
        int i = 0;
        while (numeroInteiro > 0) {
            if (numeroInteiro >= inteiros[i]) {
                resposta += romanos[i];
                numeroInteiro -= inteiros[i];
            } else {
                i++;
            }
        }
        return new ResponseEntity<String>(resposta, HttpStatus.OK);
    }
}
