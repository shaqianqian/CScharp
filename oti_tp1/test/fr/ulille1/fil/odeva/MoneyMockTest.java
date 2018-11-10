package fr.ulille1.fil.odeva;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class MoneyMockTest {
    private MoneyFactory mf;
    private Money f12EUR,  f14EUR,f12CHF,f14CHF;


    @Before
    public void init() throws UnexistingCurrencyException
    {
        mf=MoneyFactory.getDefaultFactory();

    }


    @Test
    public void simpleAdd_Mock() throws IncompatibleCurrencyException, UnexistingCurrencyException {

        Money f12EUR = mock(Money.class);
        doReturn(12).when(f12EUR).getValue();
        doReturn("EUR").when(f12EUR).getCurrency();

        Money f14EUR = mock(Money.class);
        doReturn(14).when(f14EUR).getValue();
        doReturn("EUR").when(f14EUR).getCurrency();

        Money result = MoneyOps.simpleAdd(f12EUR, f14EUR);
        assertEquals(result.getValue(), 26);
    }
    @Test
    public void simpleAddWithDifferentValueAndSameCurrency() throws UnexistingCurrencyException
    {
        Money f12EUR = mock(Money.class);
        doReturn(12).when(f12EUR).getValue();
        doReturn("EUR").when(f12EUR).getCurrency();
        Money result = MoneyOps.simpleAdd(f12EUR, f12EUR);
        assertNotEquals(result.getValue(), 26);
        }



        }
