package primeiroTest;

import org.assertj.core.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrimeiroTeste {

    @Mock
    Calculadora calculadora;
        int a = 10, b = 5;

    @BeforeEach
    public void setUp() {
         calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar dois Numeros")
    public void deveSomarDoisNumeros() {
        // cenario

        // execução
        int resultado = calculadora.somar(a,b);

        // verificações
        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test
    @DisplayName("Não Deve somar numeros negativos")
    public void nãoDeveSomarNumerosNegativos() {
        // cenario

        int a = -10, b = 5;

        // execução
        org.junit.jupiter.api.Assertions
                .assertThrows(RuntimeException.class, () -> calculadora.somar(a,b) );
    }
    @Test
    @DisplayName("Deve Subtrair com dois Numeros")
    public void deveSubtrairComDoisNumeros() {
        // cenario

        // execução
        int resultado = calculadora.subtracao(a,b);

        // verificacao
        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test
    @DisplayName("Deve Multiplicar os numeros")
    public void multiplicacao() {
        // cenario

        // execução
        calculadora.multiplicacao(a,b);
    }

    @Test
    @DisplayName("Deve Dividir os numeros")
    public void deveDividirDoisNumeros() {
        // cenario

        // execução
        calculadora.divisao(a,b);

        // Vrificação
        float resultado = calculadora.divisao(a,b);

        Assertions.assertThat(resultado).isGreaterThan(0);
    }

    @Test
    @DisplayName(" Não Deve Dividir os numeros por zero")
    public void nãoDeveDividirPorZero() {
        // cenario
        int num1 = 10, num2 = 0;
        //execução
        org.junit.jupiter.api.Assertions
                .assertThrows(ArithmeticException.class, () -> calculadora.divisao(num1,num2) );

    }
}

class Calculadora  {

    public int somar (int num, int num2) {
        if(num < 0 || num2 < 0) {
            throw new RuntimeException("Não é permitido somar numeros negativos.");
        }
        return num + num2;
    }

    public int multiplicacao (int num, int num2) {
        return num * num2;
    }

    public int subtracao (int num, int num2) {
        return num - num2;
    }

    public float divisao(float num, float num2) {
        if(num == 0 || num2 == 0) {
            throw new ArithmeticException("Não é permitido dividir por zero.");
        }
        return num / num2;
    }
}
