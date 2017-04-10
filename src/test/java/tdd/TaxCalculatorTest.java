package tdd;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class TaxCalculatorTest {
    @Test
    public void withNds() throws Exception {
        TaxCalculator taxCalculator = new TaxCalculator();
        NdsResolver ndsResolverMock = mock(NdsResolver.class);
        when(ndsResolverMock.getNds()).thenReturn(0.18);
        taxCalculator.setNdsResolver(ndsResolverMock);
        double result = taxCalculator.withNds(100);
        Assert.assertEquals(118,result,0.000001);
    }

}