package frctCalc;
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
    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        //System.out.println("CONSTRUCTOR GCDfunction: " + gcd);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }
    
    /**
     * constructor with only one parameter where fraction's denominator is equal 1
     * @param num represents a numerator in a fraction
     */
    public Fraction(int num){
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
    public void setDenominator(int den) {
        denominator = den;
    }

    /**
     * desc:
     * @param some int i
     * @return
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
     * desc:
     * @param some int i
     * @return
     */
    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }
    
    public Fraction negate(){
    	int tn = this.getNumerator()*(-1);
    	int td = this.getDenominator();
    	return new Fraction(tn, td);
    }
    
    public Fraction absValue(){
    	int tn = this.getNumerator();
    	int td = this.getDenominator();
    	if(tn<0) tn=tn*(-1);
    	if(td<0) td= td*(-1);
    	return new Fraction(tn, td);
    }
    
    public Fraction divide(Fraction other){
    	int od = other.getDenominator();
    	int on = other.getNumerator();
    	int td = this.getDenominator();
    	int tn = this.getNumerator();
    	return new Fraction(tn*od, td*on);
    }
    
    public Fraction subtract(Fraction other){
    	int od = other.getDenominator();
    	int on = other.getNumerator();
    	int td = this.getDenominator();
    	int tn = this.getNumerator();
    	if(od == td) return new Fraction(tn-on, od);
    	else {
    		int i = tn*od - on*td;
    		return new Fraction(i, td*od);
    	}
    }
    
    public Fraction add(Fraction other){
    	int od = other.getDenominator();
    	int on = other.getNumerator();
    	int td = this.getDenominator();
    	int tn = this.getNumerator();
    	if(od == td) return new Fraction(on+tn, od);
    	else {
    		int i = tn*od + on*td;
    		return new Fraction(i, td*od);
    	}
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
