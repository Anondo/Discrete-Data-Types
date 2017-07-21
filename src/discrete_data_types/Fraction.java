package discrete_data_types;

import java.io.Console;
import java.lang.Math;

public class Fraction {
	private int numerator;
	private int denominator;
	private String result;
	
	public Fraction()
	{
		this(1,1);
	}
	public Fraction(int numerator , int denominator)
	{
		this.numerator = numerator;
		this.denominator=  denominator;
		checkDenominator();
	    result = "(" + numerator + "/" + denominator + ")";
	}
	
	//data setting methods
	public void setArguments(int numerator , int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
		checkDenominator();
		result = "(" + numerator + "/" + denominator + ")";
	}
	public void setNumerator(int numerator)
	{
		this.numerator = numerator;
		result = "(" + numerator + "/" + denominator + ")";
	}
	public void setDenominator(int denominator)
	{
		this.denominator = denominator;
		checkDenominator();
		result = "(" + numerator + "/" + denominator + ")";
	}
	
	//data getting methods
	public String getResult() {return result;}
	public int getNumerator() {return numerator;}
	public int getDenominator() {return denominator;}
	public double getFloatingResult() {return (float)numerator/denominator;}
	
	//data manipulating methods
	private void checkDenominator()
	{
		if(denominator == 0)
		{
			System.out.println("Alert: Assigning denominator with value 1 to avoid zero division error!");
			denominator = 1;
		}
			
	}
	public void setValue(double value)
	{
		convert(value);
	}
	private void convert(double value)
	{
		String[] parts = String.valueOf(value).split("\\.");
		String beforePoint = parts[0];
		String afterPoint = parts[1];
		String den = "1";
		for(int i = 0; i < afterPoint.length(); i++)
		{
			den += "0";
		}
		setNumerator(Integer.parseInt(beforePoint + afterPoint));
		setDenominator(Integer.parseInt(den));
		cancelOut();
	}
	
	public void cancelOut()
	{
		if(Math.abs(numerator) > Math.abs(denominator))
			cancel(Math.abs(denominator));
		else
			cancel(Math.abs(numerator));
	}
	private void cancel(int number)
	{
		if(numerator % number == 0 && denominator % number == 0)
		{
			setArguments(numerator/number , denominator/number);
			return;
		}
		for(int i = number/2; i > 1; i--)
		{
			if(numerator % i == 0 && denominator % i == 0)
			{
				setArguments(numerator/i , denominator/i);
			}
			if(numerator == 1 || denominator == 1)
				break;
		}
	}
	private double reducePrecision(double value)
	{
		String[] parts = String.valueOf(value).split("\\.");
		String reducedStr = "";
		for(int i = 0; i < parts[1].length(); i++)
		{
			if(i > 7)
				break;
			reducedStr += parts[1].charAt(i);
		}
		String finalStr = parts[0] + "." + reducedStr;
		return Double.parseDouble(finalStr);
		
	}
	
	public Fraction add(Fraction f)
	{
		Fraction temp = new Fraction();
		double total = getFloatingResult() + f.getFloatingResult();
		total = reducePrecision(total);
		temp.setValue(total);
		return temp;
		
	}
	public Fraction add(double value)
	{
		Fraction temp = new Fraction();
		double total = getFloatingResult() + value;
		total = reducePrecision(total);
		temp.setValue(total);
		return temp;
		
	}
	
	public Fraction sub(Fraction f)
	{
		Fraction temp = new Fraction();
		double diff = getFloatingResult() - f.getFloatingResult();
		diff = reducePrecision(diff);
		temp.setValue(diff);
		return temp;
		
	}
	public Fraction sub(double value)
	{
		Fraction temp = new Fraction();
		double diff = getFloatingResult() - value;
		diff = reducePrecision(diff);
		temp.setValue(diff);
		return temp;
		
	}
	public Fraction div(Fraction f)
	{
		Fraction temp = new Fraction();
		double quo = getFloatingResult() / f.getFloatingResult();
		quo = reducePrecision(quo);
		temp.setValue(quo);
		return temp;
		
	}
	public Fraction div(double value)
	{
		Fraction temp = new Fraction();
		double quo = getFloatingResult() / value;
		quo = reducePrecision(quo);
		temp.setValue(quo);
		return temp;
		
	}
	public Fraction mul(Fraction f)
	{
		Fraction temp = new Fraction();
		double pro = getFloatingResult() * f.getFloatingResult();
		pro = reducePrecision(pro);
		temp.setValue(pro);
		return temp;
		
	}
	public Fraction mul(double value)
	{
		Fraction temp = new Fraction();
		double pro = getFloatingResult() * value;
		pro = reducePrecision(pro);
		temp.setValue(pro);
		return temp;
		
	}
	
	public boolean equals(Fraction f)
	{
		return getFloatingResult() == f.getFloatingResult();
	}
	public boolean equals(double value)
	{
		return getFloatingResult() == value;
	}
	public int compare(Fraction f)
	{
		double result1 = getFloatingResult();
		double result2 = f.getFloatingResult();
		if(result1 == result2)
			return 0;
		else if(result1 < result2)
			return -1;
		else
			return 1;
	}
	public int compare(double value)
	{
		double result1 = getFloatingResult();
		double result2 = value;
		if(result1 == result2)
			return 0;
		else if(result1 < result2)
			return -1;
		else
			return 1;
	}
	
	
	public String toString()
	{
		return result;
	}
}
