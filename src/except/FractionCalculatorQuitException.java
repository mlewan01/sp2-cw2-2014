/**
 * 
 */
package except;

/**
 * Copy rights Mariusz Lewandowski
 * http://www.artemlux.com
 * @author: mlwan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014, cw2
 */

public class FractionCalculatorQuitException extends Exception {
	
	String msg;
	
	public FractionCalculatorQuitException(String s){
		super(s);
		msg=s;
	}

}
