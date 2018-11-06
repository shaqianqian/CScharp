package fr.ulille1.fil.odeva;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Money {
	private int value;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
		Money money = (Money) o;
		return value == money.value &&
				Objects.equals(currency.toLowerCase(), money.currency.toLowerCase());
	}

	@Override
	public int hashCode() {

		return Objects.hash(value, currency);
	}

	private String currency;
	

	Money(int value, String currency)
	{
		this.value=value;
		this.currency=currency;
	}

	public int getValue()
	{
		return this.value;
	}

	public String getCurrency()
	{
		return this.currency;
	}

    public String toString() {
     	return this.getValue()+" ("+this.getCurrency()+")";
    }

}
