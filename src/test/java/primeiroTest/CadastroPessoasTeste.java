package primeiroTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoasTeste {


    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarOCadastroDePessoas() {
        // Cenario e execução
        CadastroPessoas cadastro = new CadastroPessoas();

        // Verificação
        Assertions.assertThat(cadastro.getPessoas() ).isEmpty();
    }
   @Test
    @DisplayName("Deve adicionar uma Pessoa")
    public void deveAddUmaPessoa() {
        // Cenario
       CadastroPessoas cadastroPessoas = new CadastroPessoas();
       Pessoa pessoa = new Pessoa();


       // Execução
       pessoa.setNome("Denilson");

       cadastroPessoas.adicionar(pessoa);
        // Verificação

        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }
    @Test
    @DisplayName("Não pode adicionar pessoa com nome Vazio")
    public void naoDeveAddPessoaComNomeVazio() {
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        // Execução
      org.junit.jupiter.api.Assertions
              .assertThrows(PessoaSemNomeException.class, () -> cadastroPessoas.adicionar(pessoa) );
    }

    @Test
    @DisplayName("Remover uma Pessoa")
    public void deveRemoverUmaPessoa() {

        // Cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        // Execução
        pessoa.setNome("Dhenilson");
        cadastroPessoas.adicionar(pessoa);
        cadastroPessoas.remover(pessoa);

        // verificação

        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }
     @Test
    @DisplayName("DLançar erro ao tentar remover uma pessoa")
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {
         CadastroPessoas cadastroPessoas = new CadastroPessoas();
         Pessoa pessoa = new Pessoa();
        // execução
      org.junit.jupiter.api.Assertions.assertThrows(CadastroVazioException.class, () -> cadastroPessoas.remover(pessoa) );
    }
}
