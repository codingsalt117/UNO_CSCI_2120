// Robin Johnson
// HW 1 Complex Number Tester

public class ComplexNumberTester1{

	public static void main(String[] args){
		//Creating array of complex numbers to be tested in operations

		ComplexNumber[] numbers = new ComplexNumber[3];
		numbers[0] = new ComplexNumber(4,-2);
		numbers[1] = new ComplexNumber(2,3);  
		numbers[2] = new ComplexNumber(3,4);

		// Enhance for-loop to go over copmplexnumbers for testing
		// Created a local ComplexNumber object to be used in operation 
		//   simple number to facilitate a manually check                                            

		for (ComplexNumber number : numbers){
			ComplexNumber newnumber;
			ComplexNumber opNumber = new ComplexNumber(1,1);
			System.out.println("Complex Numbers:\n" + number + "\n" + opNumber);
			newnumber = number.add(opNumber);
			System.out.printf( "ComplexNumberAdd: %s\n", newnumber.toString());
			newnumber = number.subtraction(opNumber);
			System.out.printf( "ComplexNumberSubtract: %s\n", newnumber.toString());
			newnumber = number.division(opNumber);
			System.out.printf( "ComplexNumberDivide: %s\n", newnumber.toString());
			newnumber = number.multiplication(opNumber);
			System.out.printf( "ComplexNumberMultiply: %s\n", newnumber.toString());
			System.out.printf( "ComplexNumberEquals: %b\n", number.equals(opNumber));
			
		}
	}
}