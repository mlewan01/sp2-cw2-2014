package juTest;

import org.junit.Test;

import frctCalc.Fraction;
import frctCalc.FractionCalculator;

/**
 * @author me
 *
 */
public class FractionCalculatorTest {

	@Test
	public void testEvaluate() {
		Fraction f = new Fraction(0,1);
		String s = "3/4 + 1/-3 * 7 / 5";
		FractionCalculator fc = new FractionCalculator();
		
		fc.evaluate(f, s);
	}

}
