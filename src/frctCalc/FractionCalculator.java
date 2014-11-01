/**
 * 
 */
package frctCalc;

import java.util.Scanner;

/**
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 *
 */
public class FractionCalculator {
	
	private Fraction f;
	
	public FractionCalculator(){
		f = new Fraction(0,1);
	}
	
	public static void main(String[] arg){
		System.out.println("wellcome in Fraction calculator");
		
		boolean contin = true;
		String s;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Please, enter data to calculate Fraction: ");
			
			s=sc.next();

		}while(s.contains("q") || s.contains("Q"));
		sc.close();
	}
	
	public Fraction evaluate(Fraction fr, String s){
		System.out.println("the string is: "+s);
		// to do !!!!
		return new Fraction(1,1);
	}
	
}
