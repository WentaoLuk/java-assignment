package com.algonquincollege.cst8284.section304.simulation;

/**
 * The class contains the actors roles in the simulation including ships and
 * asteroids. It has two attributes that determine the role of the actor and
 * whether it has already moved. These two attributes will affect the simulation.
 * 
 * Student Name: Wentao Lu 
 * Student Number: 040991469 
 * Section Number: CST8284-304
 * Project: Assignment 01
 * 
 * @author Stanley Pieda, Wentao Lu
 * 
 * @see SpaceExplorationSimulator#addAsteroid()
 * @see SpaceExplorationSimulator#moveActors()
 * @see SpaceExplorationSimulator#mover(Actor oldLocation, Actor newLocation)
 */
public class Actor {
	
	/**
	 * This is to identify the role of the actor. it can be 'A' or 'S', which stand for
	 * Asteroid and Spaceship respectively. the default constructor will set it as 'A'.
	 */
	private char icon;
	
	/**
	 * The boolean value that identify the object has been moved or not.
	 * True for yes and false for no.
	 */
	private boolean isMoved;

	/**
	 * This default constructor is chained to the constructor below by setting the
	 * icon as 'A', which means the simulation will assume all newly created Actor objects
	 * without passing the char parameter are Asteroids.
	 */
	public Actor() {
		this('A');// constructor chaining
	}

	/**
	 * This constructor is chained to the constructor with two parameters. Which
	 * means the program will set the isMoved as false by default.
	 * 
	 * @param icon The role of the actor. It can be A or S.(Asteroid or Spaceship)
	 */
	public Actor(char icon) {
		this(icon, false);// constructor chaining
	}

	/**
	 * This constructor is chained to the constructor with two parameters. Which
	 * means the program will set the icon as 'A' by default.
	 * 
	 * @param isMoved whether the actor has already moved. true means it has moved
	 *                and false means it has not.
	 */
	public Actor(boolean isMoved) {
		this('A', isMoved);// constructor chaining
	}

	/**
	 * The constructor with both icon and isMoved parameter passed into the method.
	 * 
	 * @param icon    The role of the actor. It can be A or S.(Asteroid or
	 *                Spaceship)
	 * @param isMoved whether the actor has already moved. true means it has moved
	 *                and false means it has not.
	 */
	public Actor(char icon, boolean isMoved) {
		this.icon = icon;
		this.isMoved = isMoved;
	}

	/**
	 * Getter for icon. This will return the role of the actor as 'A' or 'S', which stand
	 * for Asteroid and Spaceship respectively.
	 * 
	 * @return The role of the actor. It can be 'A' or 'S'.
	 */
	public char getIcon() {
		return icon;
	}

	/**
	 * Setter for icon. This will set up the value of icon as 'A' for Asteroid
	 * or 'S' for spaceship.
	 * 
	 * @param icon the role of the actor. It can be 'A' or 'S'.
	 */
	public void setIcon(char icon) {
		this.icon = icon;
	}

	/**
	 * Getter for icon. This will return a boolean number indicating whether the
	 * actor has already moved.
	 * 
	 * @return The boolean number. True means it has already moved, while false
	 *         means it has not.
	 */
	public boolean isMoved() {
		return isMoved;
	}

	/**
	 * Setter for icon. This will set up a boolean number indicating whether the
	 * actor has already moved.
	 * 
	 * @param isMoved The boolean number. True means it has already moved, while
	 *                false means it has not.
	 */
	public void setMoved(boolean isMoved) {
		this.isMoved = isMoved;
	}

}
