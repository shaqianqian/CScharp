package fr.ulille1.fil.odeva;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MoneyFactoryTest {
    private MoneyFactory mf;
    @Before
    public void init() {
        mf = MoneyFactory.getDefaultFactory();
    }

    @Test
    public void createMoney() throws UnexistingCurrencyException {
        Money newMoney = mf.createMoney(14, "EUR");
        assertEquals(newMoney.getCurrency(), "EUR");
        assertEquals(newMoney.getValue(), 14);
    }
}
