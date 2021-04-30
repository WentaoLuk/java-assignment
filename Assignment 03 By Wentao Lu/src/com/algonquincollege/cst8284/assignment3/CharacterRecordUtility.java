package com.algonquincollege.cst8284.assignment3;

/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Wentao LU
 * Lab Section: CST8284-304
 * Lab Professor: Carolyn Maclsaac
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class rearrange the detail in the csv file to list in a required order,
 * and output the result as a separate file.
 *
 * @author Wentao Lu
 */
public class CharacterRecordUtility {

    /**
     * Create a list to store all the value of each game character.
     */
    private List<CharacterRecord> records = new ArrayList<CharacterRecord>();

    /**
     * it contains the title of the table as a whole String including the commas inside.
     */
    private String title;

    // No need for a constructor, let the compiler
    // provide the default-no-parameter constructor for this class.

    /**
     * This method will first load the file into memory, then using different methods to rearrange
     * the lists in different orders and then create or overwrite two csv files in the project root directory.
     * These two csv sorts the data by name and attack1chance respectively.
     */
    public void processFile() { //Step 1

    	try {
        System.out.println(
                "Attempting to open CharacterRecordsUnsorted.csv ...");
        loadFile(); //Step 2

        System.out.println("Sorting by name ...");
        sortName(); //Step 3

        System.out.println("Saving to SortedByName.csv ...");
        System.out.println("(Will overwrite any file with same name)");
        saveFile("SortedByName.csv"); //Step 4

        System.out.println("Sorting by attackChance1 ...");
        sortAttackChance1();//Step 6

        System.out.println("Saving to SortedByAttackChance1.csv ...");
        System.out.println("(Will overwrite any file with same name)");
        saveFile("SortedByAttackChance1.csv");

        System.out.println("Character Data Sorted and Saved.");
        System.out.println("Program by Wentao Lu");
    	} catch (Exception e) {
    	    throw new UnsupportedOperationException(
                  "Failed to run the program.");
    	}

    }

   /**
    * This method will load the file from the memory and put them into an array of CharacterReport class.
    */
    private void loadFile() { //Step2

        records.clear();//Clear the list
        
        /**
         * The path of the file that need to be read.
         */
        String filePath = "CharacterRecordsUnsorted.csv";
        
        /**
         * The line of each row of the file.
         */
        String line = "";
        
        /**
         * The boolean variable shows whethere the first row, which is the title row, has already been noted
         * into the memory. The program will seperate the title and the detail row because they are different
         * types of information.
         */
        boolean titleAlreadyStored = false;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            while (((line = bufferedReader.readLine()) != null)) {//This way the line has been replaced by the newest array.

                CharacterRecord character = new CharacterRecord();// Create a temporary character object
                
                /**
                 * the detail array contains all the info of the current row.
                 */
                String[] detail = line.split(",");//seperate by comma

                /**
                 * if the title has been stored, all the rows below the title will be loaded in to memory one by one.
                 */
                if (titleAlreadyStored) {

                    //This is to very the name column to make sure no data will exceed 50 characters.
                    if (detail[0].length() > 50) {
                        throw new IllegalArgumentException("name cannot exceed 50 characters");

                    }
                    character.setName(detail[0]);
                    character.setHealth(detail[1]);
                    character.setStrength(detail[2]);
                    character.setAttackDamage(detail[3]);
                    character.setAttackChance1(Integer.parseInt(detail[4]));
                    character.setAttackChance2(Integer.parseInt(detail[5]));
                    character.setAttackType1(detail[6]);
                    character.setAttackType2(detail[7]);
                    character.setDefense(detail[8]);
//                            System.out.println(detail[1]);//----------------
                    records.add(character);
                } else {
                    title = line; //this will only run once.
                    titleAlreadyStored = true;
                }

            }//End of while loop: all the lines are read into the buffer.
            
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /**
     * This method will sort all the records by their names in an alphabetical order.
     */
    private void sortName() { //Step 3

        Collections.sort(records, new NameComparator());

    }

    /**
     * This method will sort the records by attackchance1 in an ascending order.
     */
    private void sortAttackChance1() { //Step 6
        Collections.sort(records, new AttackChance1Comparator());

//        throw new UnsupportedOperationException(
//                "not implemented yet (DID YOU FORGET SOMETHING??");
    }

    /**
     * This method will save the file into the project root location.
     * @param fileName the name that will be used. If there is a file already using this name,
     * the file will be overwritten.
     */
    private void saveFile(String fileName) {

        // - Tip3: You will need to add any CheckExceptions to the method signature.

        try {
            FileWriter fileWriter = new FileWriter(fileName, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(title);
            for (CharacterRecord record : records) {
                printWriter.println(record.toString());
                printWriter.flush();//This is to clean up the PrintWriter Object to avoid mistakes.
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException(
                    "Failed to save the file! ");
        }

    }
}
