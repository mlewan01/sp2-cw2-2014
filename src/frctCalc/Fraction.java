package frctCalc;


import except.FractionDenominatorException;

/**
 * Created by keith for the second coursework assignment.
 * Copy rights Mariusz Lewandowski
 * http://www.artemlux.com
 * @author: mlwan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014, cw2
 */

public class Fraction {
	
    private int numerator;
    private int denominator;
    
    /**
     * constructor with two parameters
     * @param num represents a numerator in a fraction
     * @param denom represent a denominator in a fraction
     */
    public Fraction(int num, int denom) throws FractionDenominatorException{
        if (denom == 0) {
            setDenominator(0);
            return;
        }else{
	        int gcd = myGcd(num, denom);
	        setNumerator(num / gcd);
	        setDenominator(denom / gcd);
        }
    }
    
    /**
     * constructor with only one parameter where fraction's denominator is equal 1
     * @param num represents a numerator in a fraction
     */
    public Fraction(int num) throws FractionDenominatorException{
    	setNumerator(num);
    	setDenominator(1);
    }

    /**
     * method returns string representation of the object
     */
    @Override
    public String toString() {
    	if( denominator == 1) return "" + getNumerator();
        return "" + getNumerator() + '/' + getDenominator();
    }

    /**
     * method returns Numerator class' field
     * @return field numerator 
     */
    public int getNumerator() {
        return numerator;
    }
    /**
     * method sets the class field numerator with the passed value
     * @param num represent a new value of the class' field numerator
     */
    public void setNumerator(int num) {
        numerator = num;
    }

    /**
     * method returns class' field denominator
     * @return class' field denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * method sets class' denominator field with the passed value
     * @param den represent a new value class' field denominator will be updated with
     */
    public void setDenominator(int den) throws FractionDenominatorException {
    	if(den == 0){
    		throw new FractionDenominatorException("Error. Fraction objects cannot have denominator = 0");
    	}
        denominator = den;
    }

    /**
     * method checks for objects equality among objects of the same class
     * @param o object to check for equality with this object
     * @return returns true if objects are equale and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    /**
     * method calculates and returns class' hash code
     * @return class hash code 
     */
    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    /**
     * method multiplies this object with the object passed as a parameter
     * @param other an object this class will be multiplied with 
     * @return new object of class Fraction, outcome of multiplication
     */
    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        try{
        	other = new Fraction(num, denom);
        }catch (FractionDenominatorException e){
        	System.out.println("exception in method multiplication, class Fraction");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
        }
        return other;
    }
    
    /**
     * method will negate value of this object and return it as a new object of class Fraction
     * @return new object Fraction with the value equal -(this Fraction)
     */
    public Fraction negate(){
    	int tn = this.getNumerator()*(-1);
    	int td = this.getDenominator();
    	Fraction some = null;
    	try{
    		some = new Fraction(tn, td);
    	}catch (FractionDenominatorException e){
        	System.out.println("exception in method negate, class Fraction");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
        }
    	return some;
    }
    /**
     * method will absolute value the value of this object and return it as a new object of class Fraction
     * @return new object of class Fraction with value equal to absolute value of this Fraction
     */
    public Fraction absValue(){
    	int tn = this.getNumerator();
    	int td = this.getDenominator();
    	if(tn<0) tn=tn*(-1);
    	if(td<0) td= td*(-1);
    	Fraction some = null;
    	try{
    		some = new Fraction(tn, td);
    	}catch (FractionDenominatorException e){
        	System.out.println("exception in method absValue, class Fraction");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
        }
    	return some;
    }
    
    /**
     * method will divide this object with the object passed as a parameter
     * @param other represents fraction with which this object will be divided with
     * @return new object of class Fraction with value of this devision 
     */
    public Fraction divide(Fraction other){
    	int od = other.getDenominator();
    	int on = other.getNumerator();
    	int td = this.getDenominator();
    	int tn = this.getNumerator();
    	try{
    		other = new Fraction(tn*od, td*on);
    	}catch(FractionDenominatorException e){
    		System.out.println("division of two Fractions with value 0/1");
    		// this exception will only occur when both fractions are 0/1
    		// in normal world result of divide operation would be equal to 0
    		// in this application world result has to be equal to 0/1
    		try{
    			other = new Fraction(0,1);
    		}catch(FractionDenominatorException ex){
    			// this exception cannot occur 
    		}
    	}
    	return other;
    }
    
    /**
     * method will subtract value of the object passed as a parameter form this object
     * @param other represents an object value of which will be subtracted from this object
     * @return new object of class Fraction with value of this subtraction
     */
    public Fraction subtract(Fraction other){
    	int od = other.getDenominator();
    	int on = other.getNumerator();
    	int td = this.getDenominator();
    	int tn = this.getNumerator();
    	try{
    		if(od == td) other = new Fraction(tn-on, od);
    	}catch(FractionDenominatorException e){
    		System.out.println("exception in method substract, class Fraction");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
    	}
    	
    	try{
    		if(od != td) other = new Fraction(tn*od - on*td, td*od);
    	}catch(FractionDenominatorException e){
    		System.out.println("exception in method substract, class Fraction");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
    	}
    	
    	return other;
    }
    
    /**
     * dmethod will add value of the object passed as a parameter to this object
     * @param other represents an object value of which will be added to this object
     * @return new object of class Fraction with value of this subtraction 
     */
    public Fraction add(Fraction other){
    	int od = other.getDenominator();
    	int on = other.getNumerator();
    	int td = this.getDenominator();
    	int tn = this.getNumerator();
    	try{
    		if(od == td) other = new Fraction(on+tn, od);
    	}catch(FractionDenominatorException e){
    		System.out.println("exception in method substract, class Fraction");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
    	}
    	try{
    		if(od != td) other = new Fraction(tn*od + on*td, td*od);
    	}catch(FractionDenominatorException e){
    		System.out.println("exception in method substract, class Fraction");
        	System.out.println("it is impossible for this exception to occur in this method so will ignore it");
    	}
    	
    	return other;
    }
    
    /**
     * method will return a greatest common divisor of the two parameters
     * @param a one of the two parameters to calculate greatest common divisor
     * @param b second of the two parameters to calculate greatest common divisor
     * @return a greatest common divisor of the two supplied parameters 
     */
    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
