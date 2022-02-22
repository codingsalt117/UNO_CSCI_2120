//Robin Johnson
//2120 Homework 1

class ComplexNumber{
	// The instance variables a and b representing
	// the real parts of the complex number
	
	private float a;
	private float b;

	// Complex number constructor
	//		parameters two floats

	public ComplexNumber(float a, float b){
		this.a = a;
		this.b = b;
	}

	// Addition Operation
	// 		Adding one complex number to another complex number
	//			new local ComplexNumber object "newComplex" created to store resulting complex number

	public ComplexNumber add(ComplexNumber otherNumber){
		ComplexNumber newComplex;
		float newA = a + otherNumber.getA();
		float newB = b + otherNumber.getB();
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;
	}

	// Subtraction Operation
	// 		Subtrating one complex number from another complex number
	//			new local ComplexNumber object "newComplex" created to store resulting complex number

	public ComplexNumber subtraction(ComplexNumber otherNumber){
		ComplexNumber newComplex;
		float newA = a - otherNumber.getA();
		float newB = b - otherNumber.getB();
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;
	}

	// Getter A

	public float getA(){
		return this.a;
	}

	// Getter getB

	public float getB(){
		return this.b;
	}

	// Multiplication Operation
	// 		Multipling two complex numbers together
	//			new local ComplexNumber object "newComplex" created to store resulting complex number 
   
	public ComplexNumber multiplication(ComplexNumber otherNumber){
		ComplexNumber newComplex;
		float newA = this.a * otherNumber.getA() - this.b * otherNumber.getB();
		float newB = this.a * otherNumber.getB() + this.b * otherNumber.getA();
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;

	}

	// Division Operation
	// 		Dividing one complex number by another complex number
	//			new varible "square" created to represent the shared part of the operation
	//			new local ComplexNumber object "newComplex" created to store resulting complex number 

	public ComplexNumber division(ComplexNumber otherNumber){
		ComplexNumber newComplex;
		float square = ((otherNumber.getA() * otherNumber.getA()) + (otherNumber.getB() * otherNumber.getB()));
		float newA = (this.a * otherNumber.getA()) + (this.b * otherNumber.getB())/square;
		float newB = (this.a * otherNumber.getB()) - (this.b * otherNumber.getA())/square;
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;

	}

	// Equals Method
	// 		Comparing two complex number objects together to see if they are equal to eachother

	@Override
	public boolean equals(Object otherNumber){
		if(otherNumber instanceof ComplexNumber){
			if ((otherNumber != null) && (((ComplexNumber)otherNumber).getA() == this.a) && (((ComplexNumber)otherNumber).getB() == this.b)){
				return true;
			}
			else {
				return false;
			}
		}
		else{
			return false;
		}	
	}

	// Overridding ToString Method
	// 		Creating the complex number format for print out

	@Override
	public String toString() {
		if (this.b < 0){
			return this.a + " " + this.b + "i";
		}
		else {
			return this.a + " + " + this.b + "i";
		}
	}

}