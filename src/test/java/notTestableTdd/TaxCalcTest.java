package notTestableTdd;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class TaxCalcTest {
    @Test
    public void withMaam() throws Exception {
        new TaxCalc().withMaam(100);
    }

}