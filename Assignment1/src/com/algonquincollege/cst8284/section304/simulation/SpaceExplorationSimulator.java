package com.algonquincollege.cst8284.section304.simulation;

import java.util.Scanner;

/**
 * This is a simulator class containing methods related to the simulation process
 * to finally draw maps about the simulation of ships and asteroids.
 * The moveActors() will call all the method in this class to accomplish the process.
 * Student Name: Wentao Lu
 * Student Number: 040991469
 * Section Number: CST8284-304
 * Project: Assignment 01
 * @author Stanley Pieda, Wentao Lu
 */
public class SpaceExplorationSimulator {
	
	/**
	 * drawBars is used to determine whether to draw the bars on the simulation or not.
	 */
	private boolean drawBars = false;
	
	/**
	 * The constant variable of the maximum number of rows.
	 */
	private final int MAX_ROWS = 5;
	
	/**
	 *  The constant variable of the maximum number of columns.
	 */
	private final int MAX_COLUMNS = 20;
	
	/**
	 * The constant variable of the maximum number of ships.
	 */
	private final int MAX_SHIPS = 5;
	
	/**
	 * ONE_UNIT_MOVE is the longest distance an actor can move within a turn.
	 */
	private final int ONE_UNIT_MOVE = 1;
	
	/**
	 * Counters of the destroyed ships, ships that escape successfully.
	 */
	private int shipsDestroyed = 0;
	
	/**
	 * Counters of the total number of the ships that escape from the map.
	 */
	private int shipsEscaped = 0;
	
	/**
	 * Counters of the total number of turns the simulation has played.
	 */
	private int turnCount = 0;
	
	/**
	 * set up a Scanner object to take user's input later.
	 */
	private Scanner input = new Scanner(System.in);
	
	/**
	 * This 2D array, actors[][] will hold a reference to the array of the 5 actors[], which is 
	 * the maximum number of rows in the simulation, where each actors[] is a reference to the array
	 * of 20 actors. i.e. Each actors will be the displayed as a basic unit in the simulation, and 
	 * they will be arranged in 5 rows and 20 columns as the simulation interface.
	 * 
	 */
	private Actor[][] actors = new Actor[MAX_ROWS][MAX_COLUMNS]; //[5][20]

	/**
	 * The method is to set the private field drawBars of the Class
	 * SpaceExplorationSimulator. The value is false by default.
	 * 
	 * @param drawBars
	 * 		  The parameter passed by user to decide
	 * 		  whether to show the bars on the simulation or not.
	 */
	
	/**
	 * This default constructor is chained to the constructor below by setting the
	 * array as new Actor[5][20].
	 */
	public SpaceExplorationSimulator() {
		this(new Actor[5][20]);
	}
	
	/**
	 * This constructor is chained to the constructor below by adding a Scanner
	 * object as a parameter called new Scanner(System.in)
	 * 
	 * @param actors 	the layout of the actors that will be displayed on the map
	 */
	public SpaceExplorationSimulator(Actor[][] actors) {
		this(new Scanner(System.in), actors);
	}
	
	/**
	 * This constructor is chained to the constructor below by adding a integer
	 * number as the count of the turn
	 * 
	 * @param input		the Scanner object that will take the user's input to decide
	 * 					whether to stop the program
	 * @param actors	the layout of the actors that will be displayed on the map
	 */
	public SpaceExplorationSimulator(Scanner input, Actor[][] actors) {
		this(0, input, actors);
	}
	
	/**
	 * This constructor is chained to the constructor below by adding a integer
	 * number as the count of the ship that escape successfully
	 * 
	 * @param turnCount	the count number of the turn
	 * @param input		the Scanner object that will take the user's input to decide
	 * 					whether to stop the program
	 * @param actors	the layout of the actors that will be displayed on the map
	 */
	public SpaceExplorationSimulator(int turnCount,
			Scanner input, Actor[][] actors) {
		this(0, turnCount, input, actors);
	}
	
	/**
	 *  This constructor is chained to the constructor below by adding a integer
	 * number as the count of ships that are destroyed by asteroids
	 * 
	 * @param shipsEscaped	the number of the ship escape from the map
	 * @param turnCount		the count number of the turn
	 * @param input			the Scanner object that will take the user's input to decide
	 * 						whether to stop the program
	 * @param actors		the layout of the actors that will be displayed on the map
	 */
	public SpaceExplorationSimulator(int shipsEscaped, int turnCount,
			Scanner input, Actor[][] actors) {
		this(0,  shipsEscaped,  turnCount, input, actors);
	}
	
	/**
	 * This constructor is chained to the constructor below by adding a boolean
	 * variable as whether the program should draw bars as part of the map
	 * 
	 * @param shipsDestroyed	The number of ships that are destroyed by the asteroids
	 * @param shipsEscaped		the number of the ship escape from the map
	 * @param turnCount			the count number of the turn
	 * @param input				the Scanner object that will take the user's input to decide
	 * 							whether to stop the program
	 * @param actors			the layout of the actors that will be displayed on the map
	 */
	public SpaceExplorationSimulator(int shipsDestroyed, int shipsEscaped, int turnCount,
			Scanner input, Actor[][] actors) {
		this(false,  shipsDestroyed,  shipsEscaped,  turnCount, input, actors);
	}
	
	/**
	 *  This constructor takes all the parameter passed from user or other constructors to 
	 *  create a SpaceExplorationSimulator object.
	 *  
	 * @param drawBars			Whether to draw bars or not. False means do not draw and vice versa
	 * @param shipsDestroyed	The number of ships that are destroyed by the asteroids
	 * @param shipsEscaped		the number of the ship escape from the map
	 * @param turnCount			the count number of the turn
	 * @param input				the Scanner object that will take the user's input to decide
	 * 							whether to stop the program
	 * @param actors			the layout of the actors that will be displayed on the map
	 */
	public SpaceExplorationSimulator(boolean drawBars, int shipsDestroyed, int shipsEscaped, int turnCount,
			Scanner input, Actor[][] actors) {
		this.drawBars = drawBars;
		this.shipsDestroyed = shipsDestroyed;
		this.shipsEscaped = shipsEscaped;
		this.turnCount = turnCount;
		this.input = input;
		this.actors = actors;
	}

	public void setDrawBars(boolean drawBars) {
		this.drawBars = drawBars;
	}
	
	/**
	 * Run the simulation and then ask the user to continue for each run or stop the simulation
	 * immediately.
	 * The turnCount is the count of turns, which will start from 0.
	 * The greeting words will be shown for only once, and then the map
	 * Will be drawn before the simulation starts.
	 * After that, the program will enter the first term by executing
	 * A series of methods one by one.
	 * addAsteroid() will randomly generate some asteroids.
	 * prepareActorsForMovement() will set every actor ready for moving.
	 * moveActors() will then move all the actors in the map.
	 * drawSpaceSimulation() will redraw the may by new actors' locations.
	 */
	public void runSimulation() {
		// run the simulation asking the user to continue for each turn,
		// or until the end of the simulation is detected.
		// add a new asteroid using the addAsteroid() method every 10 turns.
		// Senior Programmer: This method was verified, do not change it or
		//                    we will fire you.
		turnCount = 0;
		boolean continueSimulation = true;
		
		System.out.println("Welcome to Space Simulation");
		System.out.println("Use enter key to run next turn");
		System.out.println("Typing anything other than return will end program");
		initializeArray();
		drawSpaceSimulation();
		
		do {
			addAsteroid();
			prepareActorsForMovement();
			moveActors();
			drawSpaceSimulation();
			turnCount++;
			System.out.println("Use enter key to run next turn");
			System.out.println("Typing anything other than return will end program");
			String userInput = input.nextLine();
			if(userInput.length() > 0) {
				continueSimulation = false;
			}
		}while(continueSimulation && ! isEndOfSimulation());
		// once the simulation ends the program shuts down.
		System.out.println("Thanks for using the simulation");
	}

	/**
	 *   the for loop will set up for start of simulation, placing actors
	 *   put 5 ships at the far left in each of the rows in column 0
	 *   add one asteroid using method addAsteroid()
	 */
	private void initializeArray() {
		
		for(int row = 0; row < actors.length; row++) {
			actors[row][0] = new Actor('S');
		}
		addAsteroid();
	}

	/**
	 * This method is to add asteroid to the simulation, while there will only be 10%
	 * of chance the asteroid can be generated successfully. Hereby we use Math.random()
	 * algorithm to randomly generate the result. And if the result comes out with an 
	 * asteroid generated, the program will start to judge whether there is an obstacle in
	 * front of the asteroid. 
	 * 
	 * place one asteroid in the right-most column, but in a row randomly selected from 0 to 4. 
	 * if there is a ship in the right-most column when the asteroid is added it should 
	 * destroy the ship and increment the shipsDestroyed variable.
	 */
	private void addAsteroid() {

		/**
		 * the 10% of the chance that the asteroid can be generated successfully.
		 */
		final int CHANCE = 10;
		
		/**
		 * The randomly generated integer number ranging from 1 to 100
		 */
		int result = (int)(Math.random() * 100) + 1;
		if(result < CHANCE) {

			/**
			 * randomly generate a row to put the asteroid (from 1 to 5,integer)
			 */
			int row = (int)(Math.random() * 5);
			
			/**
			 * The column will always be the last column of the row.
			 */
			int col = actors[row].length - 1;
			if(actors[row][col] == null) {
				actors[row][col] = new Actor('A');
			}
			else if(actors[row][col].getIcon() == 'S') {
				actors[row][col] = new Actor('A');
				shipsDestroyed++;
			}
			else { // asteroid to asteroid, so they destroy each other
				actors[row][col] = null;
			}
		}
	}
	
	/**
	 * Move all the actor according to the simulation's rule. First set up the constant variable
	 * for readability. DEFAULT_ZERO is for declaring member variables and there are GO_UP,
	 * GO_RIGHT and GO_DOWN standing for 0,1 and 2 respectively.
	 * 
	 * The nested for loops will start the simulation from the first actor and work the way 
	 * from left to right until it gets to the last actor, before moving to the second row.
	 * And so on until the end of the fifth line.
	 * 
	 * In each actor the method randomly generate the integer number from 1 to 3, it will decide the
	 * direction where the current actor will go. If there is room to move, then for those spaceships,
	 * we use mover()method to simulate the result and for the asteroids we simulate the result within this
	 * method. Asteroids will keep moving left until it reaches the bound or it crashes by bumping into 
	 * another asteroid.
	 * 
	 * Every actor will only have one chance to move each turn.
	 */
	private void moveActors() {
		// - loop over the 2-D array and move each actor, depending
		//   on the icon, S for ship, A for asteroid.
		// movement rules:
		// - Ships move up, right, down at random.
		// - Asteroids move left only.
		// - After each actor is moved, it is flagged so that it is not moved
		//   more than once per call of this method. Another method is used to 
		//   flag the actors as movable before this method is called again.
		// - Ship to Asteroid: Ship is destroyed (set element to null)
		// - Ship to Ship: The ship skips it's turn and does not move.
		// - Asteroid to Ship: Ship is removed, asteroid moves.
		// - Asteroid to Asteroid: Both asteroids are removed.
		// - Ships are not allowed to leave the top or bottom of the play area
		// - Ships that are destroyed should be counted.
		// - Ships that attempt to move past the right-most column are 
		//   considered safe and should be removed from the simulation, 
		//   i.e. mark their place in the 2D array as null, and counted as safe.
		/**
		 * The default number for declaring member variables.
		 */
		final int DEFAULT_ZERO = 0;
		
		/**
		 * If the system generate 0, the actor will try go up
		 */
		final int GO_UP = 0;
		
		/**
		 * If the system generate 1, the actor will try go right
		 */
		final int GO_RIGHT = 1;
		
		/**
		 * If the system generate 2, the actor will try go down
		 */
		final int GO_DOWN = 2;
		
		/**
		 * The old location of the actor info sent back by 
		 * mover() that will be used to replace the current old location
		 */
		final int OLD_LOCATION_INFO = 0;
		
		/**
		 * The new location of the actor info sent back by 
		 * mover() that will be used to replace the current new location
		 */
		final int NEW_LOCATION_INFO = 1;
		
		for(int row = 0; row < actors.length; row++) {
			for(int col = 0; col < actors[row].length; col++) {
				if(actors[row][col] != null && ! actors[row][col].isMoved() ) {
					
					/**
					 * the new row the actor is about to move to
					 */
					int newRow = DEFAULT_ZERO;
					
					/**
					 * the new column the actor is about to move to
					 */
					int newCol = DEFAULT_ZERO;
					
					actors[row][col].setMoved(true);
					if(actors[row][col].getIcon() == 'S') { 
						int direction = (int)(Math.random() * 3); // 0 to 2
						switch(direction) { 
						
						case GO_UP: // up
							newRow = row - ONE_UNIT_MOVE; // deduct 1 to move 'up'		
							newCol = col; // In this case, the column will not be changed
							if(! isMoveOffBoard(newRow, col)) {
								Actor[] newSet = mover(actors[row][col], actors[newRow][newCol]);//use the mover method to move the actor
								actors[row][col]= newSet[OLD_LOCATION_INFO];
								actors[newRow][newCol] = newSet[NEW_LOCATION_INFO];
							}
							break;
						case GO_RIGHT: // to the right
							newCol = col + ONE_UNIT_MOVE;
							newRow = row;
							if(! isMoveOffBoard(row, newCol)) {
								Actor[] newSet = mover(actors[row][col], actors[newRow][newCol]);//use the mover method to move the actor
								actors[row][col]= newSet[OLD_LOCATION_INFO];
								actors[newRow][newCol] = newSet[NEW_LOCATION_INFO];
							}
							else { // can't move right? ship escaped
								actors[row][col] = null; // remove from array
								shipsEscaped++;
							}
							
							break;
						case GO_DOWN: // down
							newRow = row + ONE_UNIT_MOVE; // add 1 to move 'down'
							newCol = col;
							if(! isMoveOffBoard(newRow, col)) {
								Actor[] newSet = mover(actors[row][col], actors[newRow][newCol]);//use the mover method to move the actor
								actors[row][col]= newSet[OLD_LOCATION_INFO];
								actors[newRow][newCol] = newSet[NEW_LOCATION_INFO];
							}
							break;
							
						}
					}
					else { // it is an asteroid we are moving
						newCol = col - ONE_UNIT_MOVE;
						if(! isMoveOffBoard(row, newCol)) {
							if(actors[row][newCol] == null) { 
								actors[row][newCol] = actors[row][col];
								actors[row][col] = null;
							}
							else if(actors[row][newCol].getIcon() == 'S') {
								// collided with ship, remove ship
								actors[row][newCol] = actors[row][col];
								actors[row][col] = null;
								shipsDestroyed++;
							}
							else { // is an asteroid to the left, remove both
								actors[row][newCol] = null;
								actors[row][col] = null;
							}
						}
						else { // can't move left? asteroid escaped
							actors[row][col] = null; // remove from simulation
						}
					}
				}
			}
		}
	}

	/**
	 * stimulate the results when the spaceship is about to
	 * move to its destination. If there is an empty available space
	 * in front of the ship, it will reach to the new spot. And the 
	 * old spot it stayed will turn null. If the ship runs into an asteroid,
	 * it will crash and the asteroid will remain still. If there is
	 * another ship in the destination spot, the spaceship will not move
	 * and skip this term.
	 * 
	 * After the stimulation, the program will redefine the oldLocation and
	 * the newLocation. Any of them may remain the same or may not. 
	 * 
	 * @param 	oldLocation The old area from where the space ship will move
	 * @param 	newLocation The new area where the space ship is about to go
	 * @return	the method will return a new array containing the newly defined 
	 * 			oldLocation and newLocation.
	 */
	private Actor[] mover(Actor oldLocation, Actor newLocation) {

		if(newLocation == null) {
			newLocation = oldLocation;
			oldLocation = null;
		}
		else if(newLocation.getIcon() == 'A') {
			oldLocation = null;
			shipsDestroyed++;
		}
		else {
			// no move
		}
		Actor[] moveIcon = {oldLocation,newLocation};
		
		return moveIcon;
	}

	/**
	 * The method will draw the space map from the first row from the left to the right
	 * and then draw the second row and so on until the last row is drawn.
	 * 
	 * After the for loop, the map will be fully drawn. Then the program will check if 
	 * user has required to hide the bar by checking whether the boolean variable
	 * drawBars is false. If it is false, the program will replace all the "|" with
	 * " ".(blank space)
	 * 
	 * After drawing the map, the method will print the author's name and the count of
	 * ships and turns.
	 */
	private void drawSpaceSimulation() {
		String rowText = "";
		for(Actor[] row: actors) { 
			rowText += "|";
			for(Actor actor: row) { 
				if(actor == null) {
					rowText += " ";
				}
				else {
					rowText += actor.getIcon();
				}
				rowText += "|";
			}
			
			rowText += "\n";
		}
		if (drawBars == false) {
			rowText = rowText.replace("|", " ");
		}
		System.out.print(rowText);
		System.out.println("Simulation by Wentao Lu");
		System.out.println("Ships destroyed: " + shipsDestroyed);
		System.out.println("Ships escaped: " + shipsEscaped);
		System.out.println("Turn number: " + turnCount);
		System.out.println();
	}

	/**
	 * Judge if the program has come to an end by calculating the sum
	 * of the destroyed ship and the ships that has escaped. If the sum
	 * reach the original number of ships, if will return a boolean 
	 * value of true. 
	 * @return	if the simulation is not end, if will return false as default.
	 * 			Otherwise, it will return true indicating the simulation is
	 * 			over.
	 */
	private boolean isEndOfSimulation() {
		
		/**
		 * Whether it is end of the simulation. True for yes and false(default) for no.
		 */
		boolean result = false;
		if(shipsDestroyed + shipsEscaped >= MAX_SHIPS) {
			result = true; // it is end of simulation
		}
		return result;
	}

	/**
	 * checks if a proposed move would be outside the bounds of the 2D array,
	 * if it is outside the bounds it reports true.
	 * @param newRow	the new target row the actor is about to move to.
	 * @param newCol	the new target column the actor is about to move to.
	 * @return			The boolean number determine wheter the program can keep
	 * 					going. It is true if the destination is out of the border. 
	 * 					If it is  within the border, the return will be false.
	 */
	private boolean isMoveOffBoard(int newRow, int newCol) {
		
		/**
		 * Whether the destination is out of the border. True for yes and false for no.
		 */
		boolean isOffBoard = true;
		if((newRow >= 0 && newRow < MAX_ROWS)&&(newCol >= 0 && newCol < MAX_COLUMNS)) {
			isOffBoard = false; // attempt to move too far left or right
		}
		return isOffBoard;
	}

	/**
	 * This methods loops over the 2D array and re-activates all of the actors
	 * so that when the moveActors() methods loops over the array each actor
	 * will be moved at least once.
	 * every element will be reset as long as it is not null.
	 * The reset will start from the first column rightward,
	 * and go to the next column after the first column is
	 * fully reset. 
	 */
	private void prepareActorsForMovement() {
		for(int row = 0; row < actors.length; row++) {
			for(int col = 0; col < actors[row].length; col++) {
				if(actors[row][col] != null) { 
					actors[row][col].setMoved(false);
				}
			}
		}
	}


}
