/**
 * 
 */
package frctCalc;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import except.FractionCalculatorQuitException;
import except.FractionDenominatorException;
import except.FractionOperationRepeat;

/**
 * Copy rights Mariusz Lewandowski
 * http://www.artemlux.com
 * @author: mlwan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014, cw2
 */
public class FractionCalculator {
	
	private Fraction f;  //  current state of the calculator
	private String ope;  //  last remembered operation
	boolean quit;  // exit the program control
	
	public FractionCalculator(){
		try{
			f = new Fraction(1,1);
		}catch (FractionDenominatorException e){
        	System.out.println("exception in method negate, class FractionCalculator");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
		}
		ope=null;
		quit=false;
	}
	
	public static void main(String[] arg){
		boolean b;
		try{
			do{
				b=false;
				System.out.println("wellcome in Fraction calculator  \\o/\n");
				System.out.println("please enter data in following format: \"3/4 + 1/-3 * 7 / 5\"");
				System.out.println("permitted operations: *, /, +, -, abs, neg, clear, quit");
				System.out.println("you can enter data in multiple lines (provided you know how)!");
				
				String s = "";
				Scanner sc = new Scanner(System.in);
				FractionCalculator fc = new FractionCalculator();
				do{
					System.out.println("Please, enter data to calculate Fraction: ");
					s = sc.nextLine();
					try{
						fc.evaluate(s);
					}catch (FractionDenominatorException e){
			        	System.out.println("exception in method main, class FractionCalculator");
			        	System.out.println("one of the fractions has its denominator set to 0. Please try again...!");
			        	continue;
					}catch(NumberFormatException ex){
						System.out.println("exception in method main, class FractionCalculator");
			        	System.out.println("one of the numbers is too large, it cannot be represented. Sorry!! Please try again...!");
			        	continue;
					}
					System.out.println("----------------------------------------");
					System.out.println("Fraction value after this calculations is: "+ fc.getFraction() + "  operation:  " + fc.getOperation());
					System.out.println("----------------------------------------");
				}while(!fc.quit);
				
				sc.close();
				System.out.println("main loop exited...");
			}while(b);
		}catch(Exception exc){
			System.out.println("some unexpected error has occured, reseting the program...");
			b=true;
		}
		
	}	
	/**
     * method will evaluate string supplied as a parameter and will decode what calculation user
     * would like to perform. Base on this decoding function will call appropriate class functions
     * in order to perform appropriate calculations 
     * @param input the string representing user input to be decoded
     */
	public void evaluate(String input) throws FractionDenominatorException, NumberFormatException{
		
		String regAbs = "abs|ABS|Abs|a|A";  // absolute value 
		String regNegate = "neg|NEG|Neg|n|N";  // negate the value
		String regClear = "clear|CLEAR|Clear|c|C"; // clear
		String regFraction = "(\\-)?\\d{1,}/(\\-)?\\d{1,}"; // fraction
		String regDigit = "(\\s)?(\\-)?\\d{1,}(\\s)?"; // number
		String regOperation = "(\\s)?(\\+|\\-|\\*|/)(\\s)?"; // operation
		String regQuit = "quit|QUIT|Quit|q{1,1}|Q{1,1}";  // quit
		
		StringTokenizer st = new StringTokenizer(input);
		
		do{
			String s = null;
			try{
				s = st.nextToken();
			}catch(NoSuchElementException e){
				System.out.println("Nothing has been entred to the program for calculations... Please try again!");
				break;
			}
			if( s.matches(regQuit)){   // quit
				try{
					quit("user must have choosen to exit the program");
				}catch(FractionCalculatorQuitException e){
					System.out.println(e.getMessage());
					quit=true;
					break;
				}
			} else if(s.matches(regClear)){  // clear
				this.clear();
			} else if(s.matches(regOperation)){  // operation
				System.out.println("found Operation:  " + s);
				try{
					this.setOperation(s);
				}catch(FractionOperationRepeat e){ 
					e.getMessage();
					/* nothing else is required to be done in this implementation*/}
			} else if(s.matches(regAbs)){  // absolute value 
				System.out.println("requested  ABS ");
				this.f = this.f.absValue();
			}else if(s.matches(regNegate)){  // negate the value
				System.out.println("requested  Negate ");
				this.f = this.f.negate();
			}else if(s.matches(regFraction)){  // fraction
				System.out.println("found  Fraction:   " + s);
				setFraction(s);
			}else if(s.matches(regDigit)){ // single Number
				System.out.println("found a Digit:    " + s);
				setNumber(s);
			}else {
				System.out.print("found nothing what could be decoded as opertion on class Fraction...:   ");
				System.out.println(s);
				clear();
			}
			System.out.println("Fraction value after this decoded element is: "+ this.getFraction() + "  operation:  " + this.getOperation());
		}while(st.hasMoreTokens());
		
	}
	
	/**
     * method will decide whether to remember new entered operation or not
     * @param s contains new value for this objects field ope, operation to remember
     */
	public void setOperation(String s) throws FractionOperationRepeat{
		if(this.ope != null) {
			String tmp =this.ope;
			this.ope = s;
			throw new FractionOperationRepeat("there was already an operation memorised... " + tmp);
			
		} else if (s == null){
			this.ope = null;
		} else this.ope = s;
	}
	
	/**
     * method returns currently memorised operation 
     * @return currently memorised operation
     */
	public String getOperation(){
		return this.ope;
	}
	
	/**
     * function will decide whether to just set new Fraction
     * or to perform calculations, according to the memorised operation,
     * before setting new fraction in class FractionCalculator
     * @param s represents part of the user entered string representing a fraction
     */
	public void setFraction(String s)throws FractionDenominatorException, NumberFormatException{
		int index = s.indexOf("/");
		int i = Integer.valueOf(s.substring(0, index));
		int j = Integer.valueOf(s.substring(index+1, s.length()));
		Fraction f = new Fraction(i,j);
		if(this.ope==null){
			this.f = f;
		}else{
			operation(f,this.ope);
			this.ope=null;
		}
	}
	
	/**
     * function will decide whether to just set new Fraction from given number
     * or to perform calculations, according to the memorised operation,
     * before setting new fraction in class FractionCalculator
     * @param s represents part of the user entered string representing a number
     */
	public void setNumber(String s) throws NumberFormatException{
		int i = Integer.valueOf(s);
		Fraction f = null;
		try{
			f = new Fraction(i);
		}catch (FractionDenominatorException e){
        	System.out.println("exception in method negate, class Fraction");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
		}
		
		if(this.ope==null){
			this.f = f;
		}else{
			operation(f,this.ope);
			this.ope=null;
		}
	}

	/**
     * method will return fraction currently held by this class. The Fraction represents
     * last state of the calculations performed
     * @return the Fraction currently held by this class
     */
	public Fraction getFraction(){
		return this.f;
	}
	
	/**
     * method will decode string passed as a parameter and will call appropriate method according
     * to the string value and  will pass Fraction f as a parameter to that function
     * @param f represents a Fraction witch will be used to perform calculation on this object
     * @param s represents a String witch holds information about an operation to be performed
     */
	public void operation(Fraction f, String s){
		switch (s){
			case "+": this.f = (this.f).add(f);
				break;
			case "-": this.f = (this.f).subtract(f);
				break;
			case "*": this.f = (this.f).multiply(f);
				break;
			case "/": this.f = (this.f).divide(f);
				break;
			default: System.out.println("Fraction Calculator -> operation -> unrecognized operation...");
		}
	}
	/**
     * method will reset value of the class field Fraction f to (0,1) and will resent value of the field String ope to null
     */
	public void clear(){
		System.out.println("requested to clear calculator's state");
		this.ope = null;
		try{
			this.f = new Fraction(0,1);
		}catch (FractionDenominatorException e){
        	System.out.println("exception in method negate, class Fraction");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
		}
	}
	/**
     * method will throw a exit exception
     * @param s variable transporting an exit related message
     */
	public void quit(String s)throws FractionCalculatorQuitException{
		throw new FractionCalculatorQuitException(s);
	}
}
