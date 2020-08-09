import java.awt.Color;

/*******************************************************************************
*This class contains two static methods which use the ComplexNumber class to do* 
*calculations used to create the Mandelbrot set. The two methods in this class *
*are isBig and divergence. 							                           *
*******************************************************************************/

public class MandelbrotTools {

/*******************************************************************************
*This this method takes in one parameter, the ComplexNumber x. It calculates   * 
*the addition of the squares of the real and imaginary components of the       *
*CompelxNumber and compares it to the the static variable called               *
*Controller.DIVERGENCE_BOUNDARY. If the addition of the squares of the real    *
*and imaginary components of the CompelxNumber is greater than the value of the* 
*variable named DIVERGENCE_BOUNDARY, then the method returns true.             *
*Otherwise it returns false.  				                                   *
*******************************************************************************/

	public static boolean isBig(ComplexNumber x) {
		MyDouble a = (x.getReal().multiply(x.getReal())).add(x.getImag().
				multiply(x.getImag()));
		if (a.compareTo( Controller.DIVERGENCE_BOUNDARY) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
/*******************************************************************************
*This this method takes in one parameter, a ComplexNumber Z0. This method      *
*calculates a sequence of complex numbers Z1, Z2,Z3, Z4, etc. as follows:      *
*Z1 = Z0^2 + Z0; Z2 = Z1^2 + Z0; Z3 = Z2^2 + Z0; Z4 = Z3^2 + Z0 e.t.c. After   *
*each of these values are computed, the isBig method will be used to check if  *
*the ComplexNumebr is big enough. If the index of the ComplexNumebr reaches    *
*its limit and none of them are big enough an integer value of -1 is returned. *                                                    
*******************************************************************************/
	
	public static int divergence(ComplexNumber Z0) {
		int value = 0;
		ComplexNumber begin = new ComplexNumber(Z0.getReal(), Z0.getImag());
		ComplexNumber Zcounter;
		ComplexNumber Znew = begin;
		for (int counter = 1; counter <= Controller.LIMIT; counter++) {
			Zcounter = (Znew.multiply(Znew)).add(begin);
			if (isBig(Zcounter) == true) { /*checks to see if the ComplexNumebr 
										   isBig.*/
				return value = counter;
			}
			if (counter == Controller.LIMIT && isBig(Zcounter) == false) {
				return value = -1;/*returns -1 if none of the ComplexNumbers 
								  within the limit are big enough*/
			}
			Znew = Zcounter;
		} 
		return value;
	}

	public static Color getColor(int divergence) {
		Color returnValue;

		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence  % 2 == 0)? Color.WHITE : Color.RED;
		}

		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255/5);
			int greenAmount = (value % 7) * (255/7);
			int blueAmount = (value % 9) * (255/9);
			returnValue = new Color(redAmount, greenAmount, blueAmount); 
		}

		else if (Controller.colorScheme == Controller.STUDENT_DEFINED){


			/***************************************************************
			 * Modify this block to create your own color scheme!          *
			 ***************************************************************/
			returnValue = Color.WHITE;  // take out and return something useful 
		}
		else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}

}
