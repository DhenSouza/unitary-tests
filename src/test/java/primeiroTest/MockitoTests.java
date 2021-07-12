package primeiroTest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito() {
     List<String> lista = Mockito.mock(ArrayList.class);

     // Mockito.when( lista.size() ).thenReturn(2);
      //  Assertions.assertThat(size).isEqualTo(2);

        lista.size();
        lista.add("");

        // executar na ordem esperada.
        InOrder inOrder = Mockito.inOrder(lista);
        inOrder.verify(lista).size();
        inOrder.verify(lista).add("");

    }
}
