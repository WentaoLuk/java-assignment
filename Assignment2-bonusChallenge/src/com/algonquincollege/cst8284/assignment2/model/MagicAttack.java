package com.algonquincollege.cst8284.assignment2.model;
/**
 * This is a MagicAttack class extended from Attack class.
 * It is a sub-type of attack and may have different impact on different roles.
 * @author Wentao Lu
 *
 */
public class MagicAttack extends Attack{

	/**
	 * no-argument constructor for MagicAttack.
	 * This method is chained to the the parameterized constructor.
	 * @see BasicAttack
	 */
	public MagicAttack() {
		super();

	}

	/**
	 * This is a parameterized constructor to create a MagicAttack object.
	 * @param damage the damage that will have an impact on the target
	 */
	public MagicAttack(int damage) {
		super(damage);

	}

}
