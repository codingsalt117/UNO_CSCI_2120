/**
 *@author: Robin Johnson
 *@version: 1.0
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/**
 * Tester class for testing Recursive.java
 * @custom.require at least one ArrayList of strings
 */
public class RecursiveTester{
	//Initializing three ArrayList of Strings
	ArrayList<String> animals;
	ArrayList<String> objects;
	ArrayList<String> contains;
	
	// Setting up testing enviorment
	// Filling in the elements of my ArrayLists
	@Before
	public void setup(){ 
		//Invoking arraylist for general test in the natural order and filling in its elements
		animals = new ArrayList<String>();
		animals.add("cat");    
		animals.add("dog");    
		animals.add("horse");    
		animals.add("zebra");     
		//Invoking an arraylist for natural order in a list not in natural order and filling in its elements
		objects = new ArrayList<String>();
		objects.add("stuff");    
		objects.add("case");    
		objects.add("box");    
		objects.add("things");     
		//Invoking an arraylist with words that share the same letters 
		contains = new ArrayList<String>(); 
		contains.add("car");    
		contains.add("cars");    
		contains.add("carpet");    
		contains.add("carbon");    
	}//End of @Before

    /**
     * Tester method for Recursive.compare()
     */
	@Test
	public void testCompare(){
		assertEquals(-1,Recursive.compare("dog","duck"));
		assertEquals(-1,Recursive.compare("cat","cats"));
		assertEquals(0,Recursive.compare("HORSE","HORSE"));
		assertEquals(0,Recursive.compare("zebra","ZEBRA"));
	}//End of @Test (1)

    /**
     * Tester method for Recursive.compare()
     */
	@Test 
	public void testFindMinimum(){
		assertEquals("cat",Recursive.findMinimum(animals));
		assertEquals("box",Recursive.findMinimum(objects));
		assertEquals("car",Recursive.findMinimum(contains));


	}//End of @Test (2)

}//End of Class