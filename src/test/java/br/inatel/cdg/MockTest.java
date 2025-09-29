package br.inatel.cdg;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MockTest {

    @Test
    void testBuscarTimeMock() {
        // Criando mock
        TimeDAO mockDao = mock(TimeDAO.class);

        // Configurando comportamento
        Time corinthians = new Time("Corinthians", 1910);
        corinthians.setId(1);

        when(mockDao.findById(1)).thenReturn(corinthians);

        // Usando o mock
        Time result = mockDao.findById(1);

        // Verificando resultado
        assertNotNull(result);
        assertEquals("Corinthians", result.getNome());
        assertEquals(1910, result.getAnoFundacao());
    }


}