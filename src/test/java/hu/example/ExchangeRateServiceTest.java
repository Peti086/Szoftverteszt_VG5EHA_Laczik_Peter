package hu.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExchangeRateServiceTest {

    @Test
    void testRate() {
        ExchangeRateService rateService = mock(ExchangeRateService.class);

        when(rateService.getRate("EUR", "HUF")).thenReturn(400.0);

    }
}