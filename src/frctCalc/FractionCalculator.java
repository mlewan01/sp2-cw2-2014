/**
 * 
 */
package frctCalc;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 *
 */
public class FractionCalculator {
	
	private Fraction f;  //  current state of the calculator
	private String ope;  //  last remembered operation
	boolean quit;  // exit the program control
	
	public FractionCalculator(){
		
		f = new Fraction(0,1);
		ope=null;
		quit=false;
	}
	
	public static void main(String[] arg){
		
		System.out.println("wellcome in Fraction calculator  \\o/\n");
		System.out.println("please enter data in following format: \"3/4 + 1/-3 * 7 / 5\"");
		System.out.println("you can enter data in multiple lines (provided you know how)!");
		
		String s = "";
		Scanner sc = new Scanner(System.in);
		FractionCalculator fc = new FractionCalculator();
		
		do{
			System.out.println("Please, enter data to calculate Fraction: ");
			s = sc.nextLine();
			fc.evaluate(fc.f, s);
			System.out.println("----------------------------------------");
			System.out.println("Fraction falue after this alculations is: "+fc.f);
			System.out.println("----------------------------------------");
		}while(!fc.quit);
		
		sc.close();
		System.out.println("main loop exited...");
		
	}	
	
	public Fraction evaluate(Fraction fr, String input){
		
		String regAbs = "abs|ABS|Abs|a|A";  // absolute value 
		String regNegate = "neg|NEG|Neg|n|N";  // negate the value
		String regClear = "clear|CLEAR|Clear|c|C"; // clear
		String regFraction = "(\\-)?\\d/(\\-)?\\d"; // fraction
		String regDigit = "(\\s)?(\\-)?\\d(\\s)?"; // single digit
		String regOperation = "(\\s)?(\\+|\\-|\\*|/)(\\s)?"; // operation
		String regQuit = "quit|QUIT|Quit|q{1,1}|Q{1,1}";  // quit
		
		StringTokenizer st = new StringTokenizer(input);
		Fraction fnew = new Fraction(0,1);
		
		do{
			String s = st.nextToken();
			if( s.matches(regQuit)){   // quit
				System.out.println("found quit request");
				quit=true;
				break;
			} else if(s.matches(regClear)){  // clear
				System.out.println("requested  Clear ");
				this.f.setDenominator(1);
				this.f.setNumerator(0);
			} else if(s.matches(regOperation)){  // operation
				System.out.println("found Operation ");
				this.setOperation(s);
			} else if(s.matches(regAbs)){  // absolute value 
				System.out.println("requested  ABS ");
				this.f = this.f.absValue();
			}else if(s.matches(regNegate)){  // negate the value
				System.out.println("requested  Negate ");
				this.f = this.f.negate();
			}else if(s.matches(regFraction)){  // fraction
				System.out.println("found  Fraction");
				// this.f           <<<<--------------------------
			}else if(s.matches(regDigit)){ // single digit
				System.out.println("found a Digit");
			}else {
				System.out.print("found nothing from the regular Expressions:   ");
				System.out.println(s);
			}
		}while(st.hasMoreTokens());
		
		return new Fraction(1,1);
	}
	
	public void setFraction(Fraction frac){
		this.f = frac;
	}
	public Fraction getFraction(){
		return this.f;
	}
	public void setOperation(String s){
		this.ope = s;
	}
	public String getOperation(){
		return this.ope;
	}
	
}
