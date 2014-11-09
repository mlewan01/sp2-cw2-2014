package juTest;

import org.junit.Test;

import except.FractionDenomExc;
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
		
		Fraction f=null;
		try{
			 f = new Fraction(0,1);
		}catch(FractionDenomExc e){
			System.out.println("fractions' denominator cannot be equal to 0  !!!");
		}
		
		System.out.println(f);
		String s = "3/4 + 1/-3 * 7 / 5";
		FractionCalculator fc = new FractionCalculator();
		
		try{
			fc.evaluate(s);
		}catch (FractionDenomExc e){
        	System.out.println("exception in class FractionCalculatorTest");
        	System.out.println("Please remember, Fraction with denominator = 0 do not exist");
		}
	}
}
