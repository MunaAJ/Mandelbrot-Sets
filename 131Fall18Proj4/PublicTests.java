import static org.junit.Assert.*;

import org.junit.Test;

public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);
		
		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && x.getImag().compareTo(b) 
				== 0);
		
		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && z.getImag().compareTo
				(new MyDouble(0)) == 0);
	}
	
	@Test
	public void testCopyConstructor() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 && y.getImag().compareTo(b)
				== 0);
	}
	
	@Test 
	public void testAdd() {
		ComplexNumber tester = new ComplexNumber(new MyDouble(10), 
				new MyDouble(10));
		ComplexNumber tester1 = new ComplexNumber(new MyDouble(-26), 
				new MyDouble(-27));
		MyDouble real = new MyDouble(5);
		MyDouble imag = new MyDouble(5);
		MyDouble real1 = new MyDouble(5);
		MyDouble imag1 = new MyDouble(5);
		ComplexNumber x = new ComplexNumber(real, imag);
		ComplexNumber y = new ComplexNumber(real1, imag1);
		MyDouble real2 = new MyDouble(-15);
		MyDouble imag2 = new MyDouble(-10);
		MyDouble real3 = new MyDouble(-11);
		MyDouble imag3 = new MyDouble(-17);
		ComplexNumber a = new ComplexNumber(real2, imag2);
		ComplexNumber b = new ComplexNumber(real3, imag3);
		assertTrue(x.add(y).equals(tester));
		assertTrue(a.add(b).equals(tester1));
	}
	
	@Test 
	public void testSubtract() {
		ComplexNumber tester = new ComplexNumber(new MyDouble(5), 
				new MyDouble(5));
		ComplexNumber tester1 = new ComplexNumber(new MyDouble(-3), 
				new MyDouble(4));
		MyDouble real = new MyDouble(10);
		MyDouble imag = new MyDouble(10);
		MyDouble real1 = new MyDouble(5);
		MyDouble imag1 = new MyDouble(5);
		ComplexNumber x = new ComplexNumber(real, imag);
		ComplexNumber y = new ComplexNumber(real1, imag1);
		MyDouble real2 = new MyDouble(-15);
		MyDouble imag2 = new MyDouble(-13);
		MyDouble real3 = new MyDouble(-12);
		MyDouble imag3 = new MyDouble(-17);
		ComplexNumber a = new ComplexNumber(real2, imag2);
		ComplexNumber b = new ComplexNumber(real3, imag3);
		assertTrue(x.subtract(y).equals(tester));
		assertTrue(a.subtract(b).equals(tester1));
	}
	
	@Test 
	public void testMult() {
		ComplexNumber tester = new ComplexNumber(new MyDouble(125), 
				new MyDouble(300));
		ComplexNumber tester1 = new ComplexNumber(new MyDouble(-41), 
				new MyDouble(411));
		MyDouble real = new MyDouble(15);
		MyDouble imag = new MyDouble(10);
		MyDouble real1 = new MyDouble(15);
		MyDouble imag1 = new MyDouble(10);
		ComplexNumber x = new ComplexNumber(real, imag);
		ComplexNumber y = new ComplexNumber(real1, imag1);
		MyDouble real2 = new MyDouble(-15);
		MyDouble imag2 = new MyDouble(-13);
		MyDouble real3 = new MyDouble(-12);
		MyDouble imag3 = new MyDouble(-17);
		ComplexNumber a = new ComplexNumber(real2, imag2);
		ComplexNumber b = new ComplexNumber(real3, imag3);
		assertTrue(x.multiply(y).equals(tester));
		assertTrue(a.multiply(b).equals(tester1));
	}
	
	@Test 
	public void testDiv() {
		ComplexNumber tester = new ComplexNumber(new MyDouble(-0.6), 
				new MyDouble(0.8));
		ComplexNumber tester1 = new ComplexNumber(new MyDouble(1), 
				new MyDouble(0));
		MyDouble real = new MyDouble(5);
		MyDouble imag = new MyDouble(10);
		MyDouble real1 = new MyDouble(5);
		MyDouble imag1 = new MyDouble(-10);
		ComplexNumber x = new ComplexNumber(real, imag);
		ComplexNumber y = new ComplexNumber(real1, imag1);
		MyDouble real2 = new MyDouble(-1345);
		MyDouble imag2 = new MyDouble(-1980);
		MyDouble real3 = new MyDouble(-1345);
		MyDouble imag3 = new MyDouble(-1980);
		ComplexNumber a = new ComplexNumber(real2, imag2);
		ComplexNumber b = new ComplexNumber(real3, imag3);
		assertTrue(x.divide(y).equals(tester));
		assertTrue(a.divide(b).equals(tester1));
	}
	
	@Test 
	public void testEqComp() {
		MyDouble real = new MyDouble(5);
		MyDouble imag = new MyDouble(5);
		MyDouble real1 = new MyDouble(5);
		MyDouble imag1 = new MyDouble(5);
		ComplexNumber x = new ComplexNumber(real, imag);
		ComplexNumber y = new ComplexNumber(real1, imag1);
		MyDouble real2 = new MyDouble(-15);
		MyDouble imag2 = new MyDouble(-23);
		MyDouble real3 = new MyDouble(-15);
		MyDouble imag3 = new MyDouble(-23);
		ComplexNumber a = new ComplexNumber(real2, imag2);
		ComplexNumber b = new ComplexNumber(real3, imag3);
		assertTrue(x.equals(y));
		assertTrue(x.compareTo(y) == 0);
		assertTrue(a.equals(b));
		assertTrue(a.compareTo(b) == 0);
	}
	
	@Test 
	public void testNorm() {
		MyDouble real = new MyDouble(3);
		MyDouble imag = new MyDouble(4);
		MyDouble real1 = new MyDouble(-12);
		MyDouble imag1 = new MyDouble(-5);
		ComplexNumber x = new ComplexNumber(real, imag);
		ComplexNumber y = new ComplexNumber(real1, imag1);
		assertTrue(ComplexNumber.norm(x).equals(new MyDouble(5)));
		assertTrue(ComplexNumber.norm(y).equals(new MyDouble(13)));
	}
	
	@Test 
	public void testParse() {
		String x = "5+36i";
		String y = "   - 8  -  89  i  ";
		MyDouble real = new MyDouble(5);
		MyDouble imag = new MyDouble(36);
		MyDouble real1 = new MyDouble(-8);
		MyDouble imag1 = new MyDouble(-89);
		ComplexNumber a = new ComplexNumber(real, imag);
		ComplexNumber b = new ComplexNumber(real1, imag1);
		assertTrue(a.equals(ComplexNumber.parseComplexNumber(x)));
		assertTrue(b.equals(ComplexNumber.parseComplexNumber(y)));
	}
}
