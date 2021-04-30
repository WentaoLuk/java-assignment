/*
 * Copyright(2021) Algonquin College
 * CST8284 (21W) Assignment 2 Starter Code
 */
package com.algonquincollege.cst8284.assignment2.util;

import java.util.Random;

/**
 * This class contains utility methods to simulate rolling
 * a variety of polyhedral dice, 4-sided, 6-sided, 8-sided,
 * 10-sided, 12-sided, 20-sided, and 100-sided.
 * @author piedas
 *
 */
public class DiceBag {
	/**
	 * This instance of random is used for all of the 
	 * methods in the class.
	 */
	private static Random random = new Random();
	
	/**
	 * This method will pass a Dice enum object into it as a parameter,
	 * and use its getter to get its number value.
	 * @param dice The dice can be the enum of different number values depending
	 * on the user settings. different number value will influence the return.
	 * @return the return will be a random value from 1 to the number value.
	 */
	public static int roll(Dice dice) {
        return random.nextInt(dice.getNumVal()) + 1;
	}
		
}
