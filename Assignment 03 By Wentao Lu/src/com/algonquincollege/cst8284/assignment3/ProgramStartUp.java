package com.algonquincollege.cst8284.assignment3;

/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Wentao Lu
 * Lab Section: CST8284-304
 * Lab Professor: Carolyn Maclsaac
 */


/**
 * This class launches the application.
 *
 * @author piedas, Wentao Lu
 */
public class ProgramStartUp {
    /**
     * The main method simply instantiates the CharacterRecordUtility
     * and calls method processFile() to run the program.
     *
     * @param args Command Line Arguments are not used by this program.
     */
    public static void main(String[] args) {

        new CharacterRecordUtility().processFile();

    }
}
