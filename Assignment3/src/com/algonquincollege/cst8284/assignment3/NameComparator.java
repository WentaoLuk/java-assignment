package com.algonquincollege.cst8284.assignment3;

import java.util.Comparator;

/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Wentao Lu
 * Lab Section: CST8284-304
 * Lab Professor: Carolyn Maclsaac
 */
/**
 * This class is an implementation of Comparator class, which overrites the compare method
 * to enable the program to compare the attackchance of two different CharacterRecord o
 * @author Wentao Lu
 *
 */
public class NameComparator implements Comparator<CharacterRecord> {

	/**
	 * This method compares two different CharacterRecord objects with their names.
	 */
    @Override
    public int compare(CharacterRecord c1, CharacterRecord c2) {
        return c1.getName().compareToIgnoreCase(c2.getName());
    }
}


