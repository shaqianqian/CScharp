package fr.ulille1.fil.odeva.test;

import static org.junit.Assert.*;

import fr.ulille1.fil.odeva.Money;
import fr.ulille1.fil.odeva.MoneyFactory;
import fr.ulille1.fil.odeva.MoneyOps;
import fr.ulille1.fil.odeva.UnexistingCurrencyException;
import org.junit.*;

/*
 * Unit test for simple App.
 */
public class MoneyAddTestCase
{
    private Money f12EUR,  f14EUR;
    private MoneyFactory mf;
    
    @Before
    public void init() throws UnexistingCurrencyException
    {
      mf=MoneyFactory.getDefaultFactory();
      f12EUR=mf.createMoney(12, "EUR");
      f14EUR=mf.createMoney(14, "EUR");;
    }

    /**
     * simpleAdd
     */
    @Test
    public void simpleAdd() throws UnexistingCurrencyException
    {
        Money expected=mf.createMoney(26, "EUR");
        Money result=MoneyOps.simpleAdd(f12EUR,f14EUR);
        assertEquals(expected,result);
//        assertEquals(expected.getValue(),result.getValue());
//        assertEquals(expected.toString(),result.toString());

    }

    /**
     * simpleAdd
     */
    @Test
    public void MVHD() throws UnexistingCurrencyException
    {
        Money expected=mf.createMoney(26, "EUR");
        Money result=MoneyOps.simpleAdd(f12EUR,f12EUR);
        assertNotEquals(expected,result);
//        assertEquals(expected.getValue(),result.getValue());
//        assertEquals(expected.toString(),result.toString());

    }


    /**
     * simpleAdd
     */
    @Test
    public void MVHD2() throws UnexistingCurrencyException
    {
        Money expected=mf.createMoney(26, "eur");
        Money result=MoneyOps.simpleAdd(f12EUR,f14EUR);
        assertEquals(expected,result);
//        assertEquals(expected.getValue(),result.getValue());
//        assertEquals(expected.toString(),result.toString());

    }
}
