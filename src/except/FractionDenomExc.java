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
public class FractionDenomExc extends Exception {
	
	public String msg;

	public FractionDenomExc(String s){
		super(s);
		msg=s;
	}
	
} 