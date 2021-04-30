package com.algonquincollege.cst8284.assignment2.model;

import com.algonquincollege.cst8284.assignment2.util.Dice;
import com.algonquincollege.cst8284.assignment2.util.DiceBag;
/**
 * The GnarledRootBeast is an extended sub-class of Character class. It acts as a type
 * of role module with special skills and reaction in the game. Users can choose
 * a role generated by the program based on this class module.
 * 
 * @author Wentao Lu
 *
 */
public class GnarledRootBeast extends Character {

	/**
	 * no-argument constructor for the GnarledRootBeast object. This will set up the
	 * maximum health and strength using Random function and initialize the current
	 * health for the player.
	 */
	public GnarledRootBeast() {
		super.setMaxHealth(100 * DiceBag.roll(Dice.FOUR));
		super.setStrength(40 * DiceBag.roll(Dice.FOUR));
		super.setCurrentHealth(getMaxHealth());
	}

	/**
	 * This is a parameterized constructor overwriting the upper class constructor.
	 * It allows user to set up the parameter of the role manually.
	 * 
	 * @param maxHealth     the maximum health of the character
	 * @param currentHealth the current health of the character
	 * @param strength      the strength of the character
	 */
	public GnarledRootBeast(int maxHealth, int currentHealth, int strength) {
		super(maxHealth, currentHealth, strength);
	}

	/**
	 * This is an overwrote function to invoke the attack instruction. The method
	 * will set up a damage rate and decide what type of damage it will apply by
	 * using a simple algorithm containing a preset number and a Random method.
	 */
	@Override
	public Attack attack() {

		int myDamage = getStrength() * DiceBag.roll(Dice.FOUR);
		Attack attack = DiceBag.roll(Dice.HUNDRED) <= 25 ? new BasicAttack(myDamage) : new WoodAttack(myDamage);
		return attack;
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
			
			/**
			 * decide whether the character will reduce the damage and change the current health. 
			 * At last, send out the report of the damage.
			 */
			if (attack instanceof MagicAttack) {
				damage = 0 - damage / 2;
				setCurrentHealth(currentHealthTemp - damage);
				currentHealthTemp = getCurrentHealth();
				// If currentHealth exceeds the maxHealth, bring it back to the maxHealth.
				setCurrentHealth(currentHealthTemp <= getMaxHealth() ? currentHealthTemp : getMaxHealth());
				result.setReport(getTypeClassName() + " heals for half of the intended magic attack!");
			} else if (attack instanceof WoodAttack) {
				damage = damage > getStrength() ? damage - getStrength() : 0;
				setCurrentHealth(currentHealthTemp - damage);
				result.setReport(getTypeClassName() + " Damage reduced by strength!");
			} else {
				// This is for other sorts of damages.
				setCurrentHealth(currentHealthTemp - damage);
				result.setReport(getTypeClassName() + " Took full damage!");
			}
			result.setActualDamage(damage);
		}
		return result;
	}

}