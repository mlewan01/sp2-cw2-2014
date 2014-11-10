package juTest;

import except.FractionDenominatorException;
import frctCalc.Fraction;

/**
 * Created by keith for the second coursework assignment.
 *
 * All the tests should be (re-)written using JUnit
 *
 * Copy rights Mariusz Lewandowski
 * http://www.artemlux.com
 * @author: mlwan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014, cw2
 */
public class FractionTestOrginal {
    public static void main(String[] args) {
    	try{
		        // test divide by zero - should print an error and exit
		        new Fraction(1, 0);
		        // test multiply
			Fraction f = new Fraction(3,10);
			Fraction g = new Fraction(1,2);
			Fraction h = new Fraction(3,5);
			if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
		        // test equals
			test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
			test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
			test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
			test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
			test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");
		
		        // extend with extra tests
    	}catch (FractionDenominatorException e){
        	System.out.println("exception in class TestFraction");
        	System.out.println("Please remember, fraction with denominator = 0 do not exist");
		}
    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
