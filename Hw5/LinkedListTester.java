/**
*@author: Robin Johnson
*@version: 1.0
*LinkedListTester: Test of the LinkedList method functionality 
*
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Tests:
 * <p>
 * Add,equals/not equals,contains,indexing, iterator next, iterator prior, iterator hasNext & iterator hasPrior
 */
public class LinkedListTester{
	String[] names;
	LinkedList list1;
	LinkedList list2;
	Iterator iterator1;
	Iterator iterator2;
	@Before
  /**
  *All varriables that need to be intialized for test 
  *
  */
	public void setup() {
		list1 = new LinkedList();
		list2 = new LinkedList();
		iterator1 = list1.getIterator();
		iterator2 = list2.getIterator();

		//Adding dogs to list
		list1.add(new Dog("Jose", 74, 15));    
		list1.add(new Dog("Bear", 23,23));  
		list1.add(new Dog("TheJuice", 39,45));     
		list1.add(new Dog("TheRock", 44,78));
		list1.add(new Dog("Alber", 57, 45));    
		list1.add(new Dog("Dude", 76, 78));     
		list1.add(new Dog("DumDum", 125, 89));
		list1.add(new Dog("Salsa", 48, 12));      
		list1.add(new Dog("Sniffer", 68, 23));     
		list1.add(new Dog("Snuggles", 87, 56));   
	}

	@Test
	/**
	*tests if element have been add method is functioning as expected 
	*/
	public void addTest(){
	  assertNotEquals(list2,list1);
	  for(int i = 0; i < list1.size(); i++){
	  	//adds element to new list2 from list1
		list2.add(list1.get(i));               
		// The test of add through iterating elements in new list against orignal
		assertEquals(list2.get(i),list1.get(i));  
	  }
	}

	@Test
	/**
	*add element to new list by index
	*<p> 
	* test if added element an different indexes makes new list different from orignal list2
	*/
	public void noEqualTest(){
		assertNotEquals(list2,list1);
		//new dogs created, duplicating list, adding via index(and at different indexes)
		Dog Dino = new Dog("Dino",23,45); 
		Dog King = new Dog("King",23,45); 
		for(int i = 0; i< list1.size();i++){
			list2.add(list1.get(i));         
		}
		list2.add(Dino,3);                 
		list2.add(King,7);
		list1.add(Dino,5);              
		list1.add(King,1);
		// testing lists add method             
		assertNotEquals(list2.get(3), list1.get(3));	
		assertNotEquals(list2.get(7), list1.get(7)); 	
		assertNotEquals(list2.get(6), list1.get(6));		
		assertNotEquals(list2.get(1), list1.get(1));
	}

	@Test
	/*
	*adds element to new list by index, testing if adding is done correctly via equals
	*/
	public void equalTest(){
		assertNotEquals(list2,list1);
		Dog Spike = new Dog("Spike",23,45);
		Dog Dudley = new Dog("Dudley",23,45);
		for(int i = 0; i< list1.size();i++){
			list2.add(list1.get(i));
		}
		
		list2.add(Spike,3);
		list2.add(Dudley,7);
		list1.add(Spike,3);
		list1.add(Dudley,7);
		
		for(int i2 = 0; i2 < list1.size(); i2++){
			assertEquals(list2.get(i2),list1.get(i2));
		}
	}

	@Test
	/*
	*Test that added element is conatined within the list
	*/
	public void containsTest(){
		for(int i = 0; i< list1.size();i++){
			list2.add(list1.get(i));
			//Testing contains method via indices
			assertTrue(list2.contains(list1.get(i)));
			assertTrue(list1.contains(list2.get(i)));
		}
		//Creating new dogs and adding for testing contains witrh names
		Dog Mitzi = new Dog("Mitzi",23,45);
		Dog Tot = new Dog("Tot",23,45);
		list2.add(Mitzi,4);
		list2.add(Tot,5);
		//Testing
		assertTrue(list2.contains(Tot));	
		assertTrue(list2.contains(Mitzi));	
		assertFalse(list1.contains(Tot));
		assertFalse(list1.contains(Mitzi));
	}

	@Test
	/*
	*Testing IndexOf method, does the method return the known indices correctly
	*
	*/
	public void indexTest(){
	// creating some new dogs and adding to list to text indices
	Dog pam = new Dog("Pam", 125,34);
	Dog spot = new Dog("Spot",23,45);
    Dog drake = new Dog("Drake", 102,67);
    Dog shawn = new Dog("Shawn", 39,89);
    Dog bud = new Dog("Bud", 130,98);
    Dog jake = new Dog("Jake", 12,76);
	Dog peter = new Dog("Peter", 32,56);
	list2.add(pam);
	list2.add(drake);
	list2.add(shawn);
	list2.add(spot);
	list2.add(bud,3);
	list2.add(jake,2);
	list2.add(peter,13);

	//the assert equals test
    assertEquals(0, list2.indexOf(pam));  
    assertEquals(1, list2.indexOf(drake));   
    assertEquals(4, list2.indexOf(bud));   
    assertEquals(-1,list2.indexOf(peter));
	
	}
	
	@Test
	/*
	* Tests iterator, does its next method function as expected
	*/
	public void iteratorNextTest(){
		for(int i = 0; i< list1.size(); i++){
			list2.add(list1.get(i));
		}
		iterator1.setToBeg();
		iterator2.setToBeg();
		assertEquals(iterator1.next(),iterator2.next());
	}
	
	@Test
	/*
	*Test that iterator the method prior in iterator returns 
	*the element that came prior to current element
	*/
	public void iteratorPriorTest(){
		for(int i = 0; i< list1.size(); i++){
			list2.add(list1.get(i));
		}
		iterator1.setToEnd();
		iterator2.setToEnd();
		assertEquals(iterator1.prior(), iterator2.prior());
	}
	
	@Test
	//test that list has next 
	//returns true if ther is a next element in the list
	public void hasNextTest(){
		iterator1.setToBeg();
		assertTrue(iterator1.hasNext());
	}
	
	@Test
	//test that list has prior
	//returns true if there ia a prior element in the list
	public void hasPriorTest(){
		iterator1.setToEnd();
		assertTrue(iterator1.hasPrior());
	}
}