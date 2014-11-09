package juTest;

import org.junit.Test;
import frctCalc.Fraction;
import frctCalc.FractionCalculator;

/**
 * Copy rights Mariusz Lewandowski
 * http://www.artemlux.com
 * @author: mlwan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014, cw2
 */
public class FractionCalculatorTest {

	@Test
	public void testEvaluate() {
		Fraction f = new Fraction(0,1);
		System.out.println(f);
		String s = "3/4 + 1/-3 * 7 / 5";
		FractionCalculator fc = new FractionCalculator();
		
		fc.evaluate(s);
	}
}
