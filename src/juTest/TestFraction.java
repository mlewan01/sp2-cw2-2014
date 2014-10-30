/**
 * 
 */
package juTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import frctCalc.Fraction;

/**
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 */
public class TestFraction {
	
	private static Fraction frac;
	private static int num = 2;
	private static int den = 4;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		
		frac = new Fraction(num,den);
		System.out.println("Creating Fraction: " + num + "  " + den);
		System.out.println("Numerator: " + frac.getNumerator());
		System.out.println("Denumerator: " + frac.getDenominator());
	}
	@Test
	public void testAdd(){
		
	}
	@Test
	public void testMultiply(){
		Fraction f = frac.multiply(new Fraction(num, den));
		int i = f.getDenominator();
		assertTrue("is multiplying correct ?", i!=0);
		
	}
	@Test
	public void testDenominator() {
		int denu = frac.getDenominator();
		assertFalse(" is deniminator equal to zero? ", denu == 0);
		
	}
	@Test
	public void testToString(){
		
		frac.setDenominator(1);
		boolean b=true;
		String s = frac.toString();
		if(s.contains("/") && frac.getDenominator() != 1) b=false;
		if(!s.contains("/") && frac.getDenominator() == 1) b=false;
		assertFalse("is toString improved ? ", b);
	}

}