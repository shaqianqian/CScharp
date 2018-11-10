package fr.ulille1.fil.odeva;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/*
 * Unit test for simple App.
 */
public class MoneyAddTestCase
{
    private Money f12EUR,  f14EUR,f12CHF,f14CHF;
    private MoneyFactory mf;
    
    @Before
    public void init() throws UnexistingCurrencyException
    {
      mf=MoneyFactory.getDefaultFactory();
      f12EUR=mf.createMoney(12, "EUR");
      f14EUR=mf.createMoney(14, "EUR");
      f12CHF=mf.createMoney(12, "CHF");
      f14CHF=mf.createMoney(14, "CHF");;
    }

    @Test
    public void simpleAdd() throws UnexistingCurrencyException
    {
        Money expected=mf.createMoney(26, "EUR");
        Money result=MoneyOps.simpleAdd(f12EUR,f14EUR);
        assertEquals(expected,result);

    }

    @Test
    public void simpleAddWithDifferentValueAndSameCurrency() throws UnexistingCurrencyException
    {
        Money expected=mf.createMoney(26, "EUR");
        Money result=MoneyOps.simpleAdd(f12EUR,f12EUR);
        assertNotEquals(expected,result);
    }

    @Test
    public void simpleAddWithSameValueAndDifferentCurrency() throws UnexistingCurrencyException
    {
        Money expected=mf.createMoney(26, "CHF");
        Money result=MoneyOps.simpleAdd(f12EUR,f14EUR);
        assertNotEquals(expected,result);
    }


    @Test
    public void simpleAddWithDifferentValueAndSameCurrency2() throws UnexistingCurrencyException
    {
        Money expected=mf.createMoney(26, "eur");
        Money result=MoneyOps.simpleAdd(f12EUR,f14EUR);
        assertEquals(expected,result);


    }
    @Test(expected = IncompatibleCurrencyException.class)
    public void IncompatibleCurrencyException() throws IncompatibleCurrencyException, UnexistingCurrencyException {
        MoneyOps.simpleAdd(f12EUR, f12CHF);
    }


}
