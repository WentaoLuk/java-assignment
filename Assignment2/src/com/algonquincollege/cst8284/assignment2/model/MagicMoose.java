package com.algonquincollege.cst8284.assignment2.model;

import com.algonquincollege.cst8284.assignment2.util.Dice;
import com.algonquincollege.cst8284.assignment2.util.DiceBag;

/**
 * The MagicMoose is an extended sub-class of Character class. It acts as a type
 * of role module with special skills and reaction in the game. Users can choose
 * a role generated by the program based on this class module.
 * 
 * @author Wentao Lu
 *
 */
public class MagicMoose extends Character {

	/**
	 * no-argument constructor for the MagicMoose object. This will set up the
	 * maximum health and strength using Random function and initialize the current
	 * health for the player.
	 */
	public MagicMoose() {
		super.setMaxHealth(10 * DiceBag.roll(Dice.TWENTY));
		super.setStrength(10 * DiceBag.roll(Dice.FOUR));
		super.setCurrentHealth(getMaxHealth());
//		maxHealth = 10 * DiceBag.rollTwentySidedDice();
//		strength = 10 * DiceBag.rollFourSidedDice();
//		currentHealth = maxHealth;
	}

	/**
	 * This is a parameterized constructor overwriting the upper class constructor.
	 * It allows user to set up the parameter of the role manually.
	 * 
	 * @param maxHealth     the maximum health of the character
	 * @param currentHealth the current health of the character
	 * @param strength      the strength of the character
	 */
	public MagicMoose(int maxHealth, int currentHealth, int strength) {
		super(maxHealth, currentHealth, strength);
	}

	/**
	 * This is an overwrote function to invoke the attack instruction. The method
	 * will set up a damage rate and decide what type of damage it will apply by
	 * using a simple algorithm containing a preset number and a Random method.
	 */
	@Override
	public Attack attack() {

		/**
		 * The damage rate the player will have.
		 */
		int myDamage = getStrength() * DiceBag.roll(Dice.TWENTY);
//		Attack attack = DiceBag.rollOneHundredSidedDice() <= 60 ? new BasicAttack(myDamage) : new MagicAttack(myDamage);

		/**
		 * Decide what kind of attack the player will apply.
		 */
		if (DiceBag.roll(Dice.HUNDRED) <= 60) {
			Attack attack = new BasicAttack(myDamage);
			return attack;
		} else {
			Attack attack = new MagicAttack(myDamage);
			return attack;
		}
	}

	/**
	 * This is an defense method that allows the player to take 
	 * different reaction when facing different types of attacks.
	 * The Magic Moose eats wood and heals for half of the intended 
	 * damage, up to max health recovery.
	 */
	@Override
	public AttackReport defend(Attack attack) {
		AttackReport result = null;
		if (attack != null) {
			result = new AttackReport();
			
			/**
			 * The number parameter of the damage the player will receive.
			 */
			int damage = attack.getDamage();

			/**
			 * The temporary variable to store the current health of the player 
			 * retrieved from the super class.
			 */
			int currentHealthTemp = getCurrentHealth();
			if (attack instanceof WoodAttack) {
				damage /= 2;
				setCurrentHealth(currentHealthTemp + damage);
				currentHealthTemp = getCurrentHealth();
				// If currentHealth exceeds the maxHealth, bring it back to the maxHealth.
				setCurrentHealth(currentHealthTemp <= getMaxHealth() ? currentHealthTemp : getMaxHealth());
				result.setReport(getTypeClassName() + " heals for half of the intended wood attack!");
			} else {
				setCurrentHealth(currentHealthTemp - damage);
				result.setReport(getTypeClassName() + " Took full damage!");
			}
			result.setActualDamage(damage);

		}
		return result;
	}

}