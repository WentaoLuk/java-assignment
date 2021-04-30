package com.algonquincollege.cst8284.assignment2.model;

/**
 * This is a basicAttack class extended from Attack class. It is a sub-type of
 * attack and may have different impact on different roles.
 * 
 * @author Wentao Lu
 *
 */
public class BasicAttack extends Attack {

	/**
	 * no-argument constructor for BassicAttack. This method is chained to the the
	 * parameterized constructor.
	 * 
	 * @see BasicAttack
	 */
	public BasicAttack() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This is a parameterized constructor to create a BasicAttack object.
	 * 
	 * @param damage the damage that will have an impact on the target
	 */
	public BasicAttack(int damage) {
		super(damage);
		// TODO Auto-generated constructor stub
	}

}
