/**
 * 
 */
package frctCalc;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 *
 */
public class FractionCalculator {
	
	private Fraction f;
	String p1 = "[+-*/]";
	String p2 = "\n";
	String p3 = "\\d";
	String p4 = "\\d/\\d";
	String p5 = "[Qq]|quit|Quit";
	
	public FractionCalculator(){
		Pattern p = Pattern.compile(p4);
		f = new Fraction(0,1);
	}
	
	public static void main(String[] arg){
		System.out.println("wellcome in Fraction calculator  \\o/\n");
		System.out.println("please enter data in following format: \"3/4 + 1/-3 * 7 / 5\"");
		System.out.println("you can enter data in multiple lines (provided you know how)!");
		
		boolean contin = true;
		String s="";
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Please, enter data to calculate Fraction: ");
			
			
			s = sc.nextLine();
			sc.hasNext();
			
			
			
			contin = !(s.contains("q") || s.contains("Q"));
		}while(contin);
		sc.close();
		System.out.println("main loop exited...");
		
	}	
	
	public Fraction evaluate(Fraction fr, String s){
		System.out.println("the string is: "+s);
		// to do !!!!
		return new Fraction(1,1);
	}
	
}
