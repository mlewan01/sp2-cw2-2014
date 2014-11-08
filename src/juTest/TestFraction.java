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
	private static int num = 1;
	private static int den = 2;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		frac = new Fraction(num,den);
		System.out.println("Creating Fraction: " + num + "  " + den);
		System.out.println("Numerator: " + frac.getNumerator());
		System.out.println("Denumerator: " + frac.getDenominator());
		System.out.println("toString method:  " + frac);
	}
	@Test
	public void testNegate(){
		Fraction f = frac.negate();
		System.out.println("Negate value from: "+frac.toString()+" equals: "+f.toString());
	}
	@Test
	public void testAbsVAlue(){
		Fraction f = frac.absValue();
		System.out.println("Absolute value from: "+frac.toString()+" equals: "+f.toString());
	}
	@Test
	public void testDivide(){
		Fraction n = new Fraction(3,2);
		Fraction ne = frac.divide(n);
		System.out.println("Dividing "+frac.toString()+" and "+n.toString()+" equals "+ne.toString());
	}
	@Test
	public void testSubtract(){
		Fraction n = new Fraction(3,2);
		Fraction ne = frac.subtract(n);
		System.out.println("Subtructing: "+frac.toString()+" and "+n.toString() +" equals "+ne.toString());
	}
	@Test
	public void testAdd(){
		Fraction n = new Fraction(3,2);
		Fraction ne = frac.add(n);
		System.out.println("Adding: "+frac.toString()+" and "+n.toString() +" equals "+ne.toString());
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
		
		//frac.setDenominator(1);
		boolean b=true;
		String s = frac.toString();
		if(s.contains("/") && frac.getDenominator() != 1) b=false;
		if(!s.contains("/") && frac.getDenominator() == 1) b=false;
		assertFalse("is toString improved ? ", b);
	}

}