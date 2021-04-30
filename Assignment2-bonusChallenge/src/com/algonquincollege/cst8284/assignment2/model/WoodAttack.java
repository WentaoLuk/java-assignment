package com.algonquincollege.cst8284.assignment2.model;

/**
 * This is a WoodAttack class extended from Attack class. It is a sub-type of
 * attack and may have different impact on different roles.
 * 
 * @author Wentao Lu
 *
 */
public class WoodAttack extends Attack {

	/**
	 * no-argument constructor for WoodAttack. This method is chained to the the
	 * parameterized constructor.
	 * 
	 * @see BasicAttack
	 */
	public WoodAttack() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This is a parameterized constructor to create a WoodAttack object.
	 * 
	 * @param damage the damage that will have an impact on the target
	 */
	public WoodAttack(int damage) {
		super(damage);
		// TODO Auto-generated constructor stub
	}

}
