/**
 * 
 */
package juTest;

import static org.junit.Assert.*;

import org.junit.Test;

import frctCalc.Fraction;

/**
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 */
public class TestFraction {

	@Test
	public void testMultiply(){
		
	}
	@Test
	public void test() {
		int nume = 0;
		int denu = 1;
		Fraction f = new Fraction(nume, denu);
		assertEquals(" is deniminator equal to zero? ", false , f.getDenominator() == 0);
		
	}

}
