package juTest;

import org.junit.BeforeClass;
import org.junit.Test;

import except.FractionDenominatorException;
import except.FractionOperationRepeat;
import frctCalc.Fraction;
import frctCalc.FractionCalculator;

/**
 * Copy rights Mariusz Lewandowski
 * http://www.artemlux.com
 * @author: mlwan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014, cw2
 */
public class FractionCalculatorTest {
	
	static Fraction f;
	static FractionCalculator fc;
	
	@BeforeClass
	public static void settingUp(){
		fc = new FractionCalculator();
		f=null;
		try{
			 f = new Fraction(3,2);
		}catch(FractionDenominatorException e){
			 System.out.println(e.getMessage());
		}
	}

	@Test
	public void testEvaluate() {
		
		System.out.println(f);
		String s = "3/4 + 1/-3 * 7 / 5";
		
		try{
			fc.evaluate(s);
		}catch (FractionDenominatorException e){
        	System.out.println("exception in class FractionCalculatorTest");
        	System.out.println(e.getMessage());
		}
	}
	@Test
	public void testSetOperation(){
		try{
			System.out.println("getOperation before  " +fc.getOperation());
			fc.setOperation("/");
			fc.setOperation("*");
			System.out.println("getOperation after  " +fc.getOperation());
		}catch(FractionOperationRepeat e){
			System.out.println(e.getMessage());
			System.out.println("getOperation after  " +fc.getOperation());
		}
	}
	@Test
	public void testSetFraction(){
		String s = "11111111111111111111111111111111111/2";
		try{
			fc.setFraction(s);
		}catch(FractionDenominatorException e){
			System.out.println(e.getMessage());
		}catch(NumberFormatException e2){
			System.out.println(e2.getMessage());
		}
	}
}
