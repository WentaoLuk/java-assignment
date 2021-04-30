package com.algonquincollege.cst8284.assignment2.util;

/**
 * This is a enum Class. Unchangeable variables are created using the
 * parameterized constructor to initialize each of the variables' private field.
 * 
 * Learning source: 
 * https://www.w3schools.com/java/java_enums.asp
 * https://stackoverflow.com/questions/8811815/is-it-possible-to-assign-numeric-value-to-an-enum-in-java
 * https://blog.csdn.net/echizao1839/article/details/80890490
 * 
 * @author Wentao Lu
 * 
 *
 */
public enum Dice {

	/**
	 * during the declaration of the enum, the numeral parameter will be passed into
	 * its constructor to indicate the number value of the enum.
	 */
	FOUR(4), SIX(6), EIGHT(8), TEN(10), TWELVE(12), TWENTY(20), HUNDRED(100);

	/**
	 * the private field of the Dice enum.
	 */
	private int numVal;

	/**
	 * Constructor of to dice objects. This will set up the private field of the
	 * object with the number value of itself.
	 * 
	 * @param numVal the number value set for the enum.
	 */
	Dice(int numVal) {
		this.numVal = numVal;
	}

	/**
	 * getter of the numVal.
	 * 
	 * @return numeric value of the enum
	 */
	public int getNumVal() {
		return numVal;
	}

}