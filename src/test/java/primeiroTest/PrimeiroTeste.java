package primeiroTest;

import org.assertj.core.api.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PrimeiroTeste {
        Calculadora calculadora;
        int a = 10, b = 5;

    @Before
    public void setUp() {
         calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisNumeros() {
        // cenario


        // execução
        int resultado = calculadora.somar(a,b);

        // verificações
        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)
    public void nãoDeveSomarNumerosNegativos() {
        // cenario

        int a = -10, b = 5;

        // execução
        calculadora.somar(a,b);


    }
    @Test
    public void deveSubtrairComDoisNumeros() {
        // cenario

        // execução
        int resultado = calculadora.subtracao(a,b);

        // verificacao
        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test
    public void multiplicacao() {
        // cenario

        // execução
        calculadora.multiplicacao(a,b);
    }

    @Test
    public void deveDividirDoisNumeros() {
        // cenario

        // execução
        calculadora.divisao(a,b);

        // Vrificação
        float resultado = calculadora.divisao(a,b);

        Assertions.assertThat(resultado).isGreaterThan(0);
    }

    @Test(expected = ArithmeticException.class)
    public void nãoDeveDividirPorZero() {
        // cenario
        int num1 = 10, num2 = 0;

        //execução
        calculadora.divisao(num1,num2);


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
