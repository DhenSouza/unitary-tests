package primeiroTest;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CadastroPessoasTeste {
    private CadastroPessoas cadastro ;
    private Pessoa pessoa;

    @Before
    public void setUp() {
        cadastro = new CadastroPessoas();
         pessoa = new Pessoa();
    }


    @Test
    public void deveCriarOCadastroDePessoas() {
        // Cenario e execução


        // Verificação
        Assertions.assertThat(cadastro.getPessoas() ).isEmpty();
    }
    @Test
    public void deveAddUmaPessoa() {
        // Cenario
        pessoa.setNome("Denilson");
        // Execução


        cadastro.adicionar(pessoa);
        // Verificação

        Assertions.assertThat(cadastro.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }
    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAddPessoaComNomeVazio() {

        // Execução
        cadastro.adicionar(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa() {

        // Cenario
        pessoa.setNome("Dhenilson");
        cadastro.adicionar(pessoa);

        // Execução
        cadastro.remover(pessoa);

        // verificação

        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }
    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {


        // execução
        cadastro.remover(pessoa);
    }
}
