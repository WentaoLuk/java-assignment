/*
 * Copyright(2021) Algonquin College
 * CST8284 (21W) Assignment 2 Starter Code
 */
package com.algonquincollege.cst8284.assignment2.model;

import com.algonquincollege.cst8284.assignment2.util.Dice;
import com.algonquincollege.cst8284.assignment2.util.DiceBag;

/**
 * This class represents a Character prototype, suitable for
 * use in a Role-Playing Game.
 * @author piedas
 *
 */
public abstract class Character {

	/**
	 * Max health for the character as an integer value.
	 */
	private int maxHealth;
	
	/**
	 * Current health for the character as an integer value.
	 */
	private int currentHealth;
	
	/**
	 * Strength of the character as an integer value.
	 */
	private int strength;
	
	/**
	 * This constructor uses the DiceBag class to randomize
	 * the max health and strength of the character at creation.
	 * maxHealth will be 10 to 200 (inclusive), strength will
	 * be 3 to 18 (inclusive). The current health is set to be the
	 * same as the maxHealth.
	 * @see DiceBag
	 */
	public Character() {
		maxHealth = DiceBag.roll(Dice.TWENTY) * 10;
		currentHealth = maxHealth;
		strength = DiceBag.roll(Dice.SIX) * 3;
	}
	
	/**
	 * This constructor allows specific values to be set.
	 * @param maxHealth the maximum health of the character
	 * @param currentHealth the current health of the character
	 * @param strength the strength of the character
	 */
	public Character(int maxHealth, int currentHealth, int strength) {
		setMaxHealth(maxHealth);
		setCurrentHealth(currentHealth);
		setStrength(strength);
	}
	
	/**
	 * Reports the class name for this instance, it also removes any
	 * package information returning only the class name itself.
	 * @return name of the class definition for this object
	 */
	public String getTypeClassName() {
		String className = getClass().getName();
		int index = className.lastIndexOf("."); // where is last . in packages
		if(index != -1) {
			className = className.substring(index + 1); // +1 to skip the . char
		}
		//Returns:	An int value, representing the index of the first occurrence of 
		//the character in the string, or -1 if it never occurs
		return className;
	}
	
	/**
	 * Gets max health for this character, method fullRecover()
	 * will use this value to update the currentHealth
	 * @return maximum health of this character
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * Sets the max Health value for this character, there
	 * is no data validation.
	 * @param maxHealth maximum health for this character
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	/**
	 * Gets the current health of this character
	 * @return current health of this character
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	/**
	 * Sets a new value for the current health of this character
	 * @param currentHealth current health for this character
	 */
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	/**
	 * Gets the strength for this character, strength
	 * is used as part of attack calculations for this character
	 * @return The strength of this character
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * Sets the strength for this character, there
	 * is no data validation.
	 * @param strength strength for this character
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	/**
	 * Provides a String representation for this Character, 
	 * formatted as "type: %s, max health: %d, current health
	 *               %d, strength: %d"
	 * A new-line character is not added to the end of the String
	 */
	@Override
	public String toString() {
		String reportFormat = 
				"type: %s, max health: %d, " +
		        "current health: %d, strength: %d";
		String report =
				String.format(reportFormat, 
						getTypeClassName(),getMaxHealth(),
						getCurrentHealth(), getStrength());
		return report;
	}
	
	/**

	
	/**
	 * This abstract method's implementation methods should be able to invoke the
	 * attack and return the related information.
	 * @return the Attack information about the damage amount it contains
	 */
	public abstract Attack attack();
	
	/**
	 * This is an abstract class indicating the method requires an Attack object
	 * to be passed into the method as the attack information to help the character
	 * to analyze the type and choose the defend logic.
	 * @param attack the attack object set up by the character's opponent.
	 * @return the defend report showing the actual damage that has been caused.
	 */
	public abstract AttackReport defend(Attack attack);

	

	/**
	 * This is a convenience method, it simply changes the 
	 * currentHealth to match the maxHealth.
	 */
	public void fullRecover() {
		currentHealth = maxHealth;
	}
}
