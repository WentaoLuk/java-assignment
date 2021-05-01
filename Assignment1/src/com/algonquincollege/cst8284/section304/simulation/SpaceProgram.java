package com.algonquincollege.cst8284.section304.simulation;

import java.util.Scanner;

/**
 * This program will first prompt the user to input y or n to determine whether
 * to display bars on the simulation, and then it will run the simulation by
 * executing the runSimulation() method using the simulator object it create.
 * 
 * Student Name: Wentao Lu; Student Number: 040991469; Section Number:
 * CST8284-304; Project: Assignment 01;
 * 
 * @author Stanley Pieda, Wentao Lu
 */
public class SpaceProgram {

	/**
	 * 
	 * The main method is to start the whole program.
	 * 
	 * @param args the main method with the default parameter.
	 * 
	 * @see SpaceExplorationSimulator
	 */
	public static void main(String[] args) {

		/**
		 * the String variable is used for setting whether to show the bars on the
		 * simulation.
		 */
		String choice;

		/**
		 * the keyboard is a Scanner object used for taking the user's input.
		 */
		Scanner keyboard = new Scanner(System.in);

		/**
		 * In here we set up an object and name it simulator.
		 */
		SpaceExplorationSimulator simulator = new SpaceExplorationSimulator();

		/**
		 * prompt the user to input y or n to choose whether to show the bars. the
		 * drawBars is false by default. Thus the bars will show up only if the user
		 * input "y", which will set the variable into true. Then it will trigger the
		 * transformation from "|" into a blank space in the program.
		 */
		System.out.println("Do you want to show the bars on the simulation?[y/n(default)]");
		choice = keyboard.next();
		if (choice.equals("y")) {
			simulator.setDrawBars(true);
		}

		/**
		 * The simulator will start to run the simulation by calling runSimulation().
		 * 
		 * @see SpaceExplorationSimulator
		 */
		simulator.runSimulation();

		/**
		 * after running the program, the Scanner object will be closed.
		 */
		keyboard.close();// close the scanner object.
	}

}
