
/*******************************************************************************
*This class is responsible for computing different mathematical operations     * 
*involving ComplexNumbers. These operations include addition, subtraction,     *
*multiplication, division and even calculating the norm of a ComplexNumber.    *
*******************************************************************************/

public class ComplexNumber {
	
	private final MyDouble real; /*real component of the ComplexNumber 
								 initialized in the constructor.*/  
	private final MyDouble imag; /*imaginary component of the ComplexNumber
								 initialized in the constructor.*/
	 

/*******************************************************************************
*This constructor takes in two MyDouble parameters in order to initialize the  *
*real and imaginary components that are needed to make up a complex number.    *          
*******************************************************************************/
	
	public ComplexNumber(MyDouble realIn, MyDouble imagIn) {
		this.real = realIn;
		this.imag = imagIn;
	}
	
/*******************************************************************************
*This constructor takes in one MyDouble parameter in order to create a         *
*ComplexNumber which has only a real component and an imaginary component of   *
*zero. i.e 0.0i                                                                *            
*******************************************************************************/

	public ComplexNumber(MyDouble real1) {
		this.real = real1;
		this.imag = new MyDouble(0);
	}
	
/*******************************************************************************
*This is a copy constructor which is used to create a copy of another existing * 
*ComplexNumber.    														       *
*******************************************************************************/

	public ComplexNumber(ComplexNumber otherNumber) {
		this.real = otherNumber.real;
		this.imag = otherNumber.imag;
	}
	
/*******************************************************************************
*This method is a getter for the real component of the ComplexNumber.    	   *
*******************************************************************************/

	public MyDouble getReal() {
		return this.real;
	}
	
/*******************************************************************************
*This method is a getter for the imaginary component of the ComplexNumber.     *
*******************************************************************************/

	public MyDouble getImag() {
		return this.imag;
	}
/*******************************************************************************
*This method involves adding two ComplexNumbers. i.e the addition of current   * 
*object(1st ComplexNumber) and the ComplexNumber x (2nd ComplexNumber)         *
*passed in as parameter.     (This is a Public Instance Methods)               *        	
*******************************************************************************/

	public ComplexNumber add(ComplexNumber x) {
		ComplexNumber sum = new ComplexNumber(this.real.add(x.real), 
				this.imag.add(x.imag));
		return sum;
	}
	
/*******************************************************************************
*This method involves subtracting two ComplexNumbers. i.e the subtraction of   * 
*ComplexNumber x (2nd ComplexNumber) passed in as parameter from the current   *
*object(1st ComplexNumber).   (This is a Public Instance Methods)              * 	
*******************************************************************************/

	public ComplexNumber subtract(ComplexNumber x) {
		ComplexNumber diffrence = new ComplexNumber(this.real.subtract(x.real), 
				this.imag.subtract(x.imag));
		return diffrence;
	}
	
/*******************************************************************************
*This method involves multiplying two ComplexNumbers. i.e the multiplication   *
*of the current object(1st ComplexNumber) and the ComplexNumber x              *
*(2nd ComplexNumber) passed in as parameter.(This is a Public Instance Methods)* 	
*******************************************************************************/

	public ComplexNumber multiply(ComplexNumber x) { 
		MyDouble newReal = (this.real.multiply(x.real)).subtract(this.imag.
				multiply(x.imag)); //real component of the ComplexNumber.
		MyDouble newImag = (this.real.multiply(x.imag)).add(this.imag.multiply
				(x.real)); //imaginary component of the ComplexNumber.
		ComplexNumber multiplication = new ComplexNumber(newReal, newImag);
		return multiplication;
	}
	
/*******************************************************************************
*This method involves dividing two ComplexNumbers. i.e the division of the     *
*current object(1st ComplexNumber) by the ComplexNumber x(2nd ComplexNumber)   *
*passed in as parameter.   (This is a Public Instance Methods)                 * 	
*******************************************************************************/

	public ComplexNumber divide(ComplexNumber x) {
		//real component of the ComplexNumber.
		MyDouble newReal = (((this.real).multiply(x.real)).add((this.imag).
				multiply(x.imag))).divide(((x.real).multiply(x.real).
						add((x.imag).multiply(x.imag))));
		//imaginary component of the ComplexNumber.
		MyDouble newImag = (((this.imag).multiply(x.real)).subtract((this.real).
				multiply(x.imag)).divide(((x.real).multiply(x.real).add
						((x.imag).multiply(x.imag)))));
		ComplexNumber division = new ComplexNumber(newReal, newImag);
		return division;
	}
/*******************************************************************************
*This method checks if the current object(1st ComplexNumber) is equal to the   *
*ComplexNumber x(2nd ComplexNumber) passed in as parameter. It returns true if *
*they are equal and false otherwise. (This is a Public Instance Methods)       * 
*******************************************************************************/

	public boolean equals(ComplexNumber x) {
		return this.real.equals(x.real) && this.imag.equals(x.imag);
	}
	
/*******************************************************************************
*This method compares the norm of the current object(1st ComplexNumber) to     *
*the norm of the ComplexNumber x(2nd ComplexNumber) passed in as parameter.    *
*If the norms are equal, this method returns 0; if the norm of the current     *
*object is less than the norm of the parameter, this method returns -1; if the * 
*norm of the current object is greater than the norm of the parameter, this    *
*method returns 1.       (This is a Public Instance Methods)                   *
*******************************************************************************/

	public int compareTo(ComplexNumber x) {
		int value = 0;
		if (norm(this).compareTo(norm(x)) == 0) {
			return value = 0;
		}
		if (norm(this).compareTo(norm(x)) < 0) {
			return value = -1;
		}
		if (norm(this).compareTo(norm(x)) > 0) {
			return value = 1;
		}
		return value;
	}
	
/*******************************************************************************
*This method returns a string of a ComplexNumber.                			   *
*(This is a Public Instance Methods)                       					   *
*******************************************************************************/
	
	public String toString() {
		String value = null;
		//if the imaginary component is positive this is used.
		if (this.imag.compareTo(this.imag.abs()) == 0){
			return value = this.real + "+" + this.imag + "i" ;
		} 
		//if the imaginary component is negative this is used.
		if (this.imag.compareTo(this.imag.abs()) != 0){
			return value = this.real + "" + this.imag + "i" ;
		}
		return value;
	}
	
/*******************************************************************************
*This method calculates the norm of the ComplexNumber x passed in as a         *
*parameter. The norm is equal to sqrt(a^2 + b^2).                              *
* (This is a Public static Methods)  										   *
*******************************************************************************/

	public static MyDouble norm(ComplexNumber x) {
		MyDouble squares  = ((x.real.multiply(x.real))).add((x.imag.multiply
				(x.imag))); //adds a^2 and b^2.
		return squares.sqrt(); //finds the square root of a^2 + b^2.
	}
	
/*******************************************************************************
*This this method takes in the parameter string x and returns a ComplexNumber. *
*This this method will parse the String and return a ComplexNumber that        *
*represents the value described by the String. 								   *
*(This is a Public static Methods)                                             *
*******************************************************************************/

	public static ComplexNumber parseComplexNumber(String x) {
		x = x.replaceAll(" ", ""); /*replaces all the spaces in the string with
								   nothing to remove all the excess spaces.*/
		int index = 0;
		/*checks for the middle of the string to find the real and imaginary
		components that make up the ComplexNumber.*/
		for (int counter = 1; counter <= x.length(); counter++) {
			if (x.charAt(counter) == '+' || x.charAt(counter) == '-') {
				index = counter;
				break;
			}
		}
		/*changes the real and imaginary components of the string to a 
		ComplexNumber. i.e parses the string and returns a ComplexNumber.*/
		MyDouble parsingReal = new MyDouble(Double.parseDouble(x.substring
				(0, index)));
		MyDouble parsingImag = new MyDouble(Double.parseDouble(x.substring
				(index, x.length() - 1)));
		ComplexNumber parsed = new ComplexNumber(parsingReal, parsingImag);
		return parsed;
	}
}
