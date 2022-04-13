/**
 *@author: Robin Johnson
 *@version: 1.0
 *Class campares strings ustilizing recursion. 
 *<p>
 *Class finds natural order minimum of a string using recursion and a helper method.
 *
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class Recursive{
	/**
	 * @custom.require String s1 
	 * @custom.require String s2
	 * <p> 
	 * This method compares String s2 to String s1. 
	 * <p>
	 * @custom.ensure Returns -1: if String s2 is not empty and String s1 is, if String s1 comes 1st in natural order
	 * @custom.ensure Returns 0 if the two strings are the same.
	 * @custom.ensure Returns 1 if String s1 is not empty when String s2 is, and default return
	*/	

	public static int compare(String s1, String s2){ // this is to compare two strings. also says what to do if one string is longer than another
		// if s2 is not empty and s1 is
		if (s1.isEmpty() && !s2.isEmpty()) {
			return -1;
		}

		// if s1 is not empty and si is
		if (!s1.isEmpty() && s2.isEmpty()){
			return 1;
		}

		//creating two varibles assigned the characters in index 0 in each string respectivley.
		//used for determining which character comes first in the natural order
		char indexTracker1 = Character.toUpperCase(s1.charAt(0));
		char indexTracker2 = Character.toUpperCase(s2.charAt(0));

		// if both strings only have one character length and they are the same 0 is returned
		if ((s1.length() == 1 && s2.length() ==1) && (indexTracker1 == indexTracker2)){
			return 0;
		}

		// if the index trackers are not the same, and indextracker1 comes first in the natural order returns -1
		if (indexTracker1 < indexTracker2) {
			return -1;
		}
		// if both strings have more than one charcter left and the saves charcter ing the indextrakers are the same, a recursive call is made
		// to continue down the string until one of the above conditions are met.
		else if (indexTracker1 == indexTracker2) {
			return compare(s1.substring(1),s2.substring(1));
		}

		else{
			//requires some return
			return 1;
		}
	}//End of compare method

	/**
	 * @custom.require ArrayList<String>
	 * @custom.ensure minimum element in a ArrayList returned
	 * <p>
	 * This method will find the minimum of an ArrayList, does use an additional recursive helper method minimumHelper().
	 * <p>
	*/

	//Takes in ArrayList of strings seperates & removes whats at index 0 and saves to a local variable.
	//Then passes that variable(stringTracker) and the remaining stringArray
	public static String findMinimum(ArrayList<String> stringArray){
		String stringTracker = stringArray.get(0);
		stringArray.remove(0);
		return minimumHelper(stringTracker, stringArray);
	
	}//End of findMinimum method
	

	/**
	 * @custom.require String minTracker
	 * @custom.require ArrayList<String>
	 * @custom.ensure minimum element in a ArrayList returned
	 * <p>
	 * This method will helpfind the minimum of an ArrayList, by manipulating ArrayList object and recusive calls to itself and calls to compare
	 * <p>
	*/
	private static String minimumHelper(String minTracker,ArrayList<String> stringArray){ // if the array list is empty then the program is over{
		//if there is nothing left in the StringArray, then the minimum has been found return minTracker
		if(stringArray.isEmpty()){
			return minTracker;			
		}

		//If StringArray is not empty and when the two parameters are sent to compare() and its return =1,
		// complete a recursive call to minimumHelper()
		else if(compare(minTracker,stringArray.get(0)) == 1){ // this sets the new min
			minTracker = stringArray.get(0);
			stringArray.remove(0);
			return minimumHelper(minTracker,stringArray);
		}

		else{ 
			//if there is nothing else to pass back to findMinimum
			return minTracker;
		}
	}//End of minimumHelper
}//End of class