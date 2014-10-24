/**
 * 
 */
package juTest;

import static org.junit.Assert.*;

import org.junit.Test;

import frctCalc.Fraction;

/**
 * @author me
 *
 */
public class TestFraction {

	@Test
	public void test() {
		
		int nume = 0;
		int denu = 1;
		
		Fraction f = new Fraction(nume, denu);
		assertEquals(" is deniminator equal to zero? ", false , f.getDenominator() == 0);
		
	}

}
