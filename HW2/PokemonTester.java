/**
 * 	Test class for Pokemon class	 
 * @author Robin Johnson
 * @version 17March2022
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 * Pokemon tester is testing each method of  class Pokemon 
 */
public class PokemonTester{

	/**
	 * Test Fixtures
	 * <p>
	 * Creating 3 private Pokemon objects for testing use
	 */
	private Pokemon dudley;
	private Pokemon spudzilla;
	private Pokemon frankfurt;

	/**
	 * Test Enviorment
	 * <p>
	 * Using Pokemon's constructor, constructing 3 Pokemon objects assigning to the test fixtures respectively
	 * 
	 * @custom.require name != ""
	 * @custom.require initialHealth > 0
     * @custom.require initialAttackPower > 0
     * @custom.ensure  getName() != "" && getName() == name
     * @custom.ensure  getHealth() > 0 && getHealth() == initialHealth
     * @custom.ensure  getAttackPower() > 0 && getAttackPower() == initialAttackPower 
	 */
	@Before
	public void setUp(){
		dudley = new Pokemon("Dudley", 0, 5);
		spudzilla = new Pokemon("Spudzilla", 10, 3);
		frankfurt = new Pokemon("Frankfurt", 2, 3);
	}

	/**
	 * Testing getName(), passing the pokemon to method to test methods retrieval of correct String representation of the name of pokemon
	 * 
	 * @custom.require name != ""
	 * @custom.ensure  getName() != "" && getName() == name  
	 */
	@Test
	public void testGetName(){
		assertEquals("Spudzilla", spudzilla.getName());
		assertEquals("Dudley", dudley.getName());
		assertEquals("Frankfurt", frankfurt.getName());	
	}

	/**
	 * Testing getHealth(), passing the pokemon to method to test methods retrieval of correct int vaule of Pokemon's health
	 * 
	 * @custom.require myHealth > 0
	 * @custom.ensure  getHealth() >= 0 
	 */
	@Test
	public void testGetHealth(){
		int myHealth1 = spudzilla.getHealth();
		int myHealth2 = dudley.getHealth();
		int myHealth3 = frankfurt.getHealth();
		assertTrue(myHealth1 >= 0);
		assertTrue(myHealth2 >= 0);
		assertTrue(myHealth3 >= 0);
		assertEquals(10, myHealth1);
		assertEquals(0, myHealth2);
		assertEquals(2, myHealth3);

	}

	/**
	 * Testing getAttackPower(), passing the pokemon to method to test methods retrieval of correct int vaule of Pokemon's attack power
	 * 
	 * @custom.require initialAttackPower > 0
	 * @custom.ensure  getAttackPower() > 0 && getAttackPower() == initialAttackPower
	 */
	@Test
	public void testGetAttackPower(){
		int myAttackPower1 = spudzilla.getAttackPower();
		int myAttackPower2 = dudley.getAttackPower();
		int myAttackPower3 = frankfurt.getAttackPower();
		assertTrue(myAttackPower1 > 0);
		assertTrue(myAttackPower2 > 0);
		assertTrue(myAttackPower3 > 0);
		assertEquals(3, myAttackPower1);
		assertEquals(5, myAttackPower2);
		assertEquals(3, myAttackPower3);		
	}

	/**
	 * Testing isDead(), passing the pokemon to method to test methods retrieval of correct boolean vaule of Pokemon being dead of not 
	 * 
	 * @custom.require myHealth >= 0
	 * @custom.ensure isDead() = true || isDead() = false
	 */
 	@Test
 	public void testIsDead(){
 		assertEquals(false, spudzilla.isDead());
 		assertEquals(true, dudley.isDead());
 		assertEquals(false, frankfurt.isDead());
 	}

	/**
	 * Testing attack(), through a series of method calls testing if attack works at reducing health and will is bring health properly to zero fulfilling isDead() conditions
	 *  
	 * @custom.require myHealth > 0
	 * @custom.ensure  getHealth() >= 0 && getHealth() == myHealth
	 */
 	@Test
 	public void testAttack(){
 		dudley.attack(spudzilla);
 		assertTrue(spudzilla.getHealth() < 10);
 		assertEquals(5, spudzilla.getHealth());
 		spudzilla.attack(frankfurt);
 		assertTrue(frankfurt.getHealth() < 2);
 		assertEquals(0, frankfurt.getHealth());
 		assertEquals(true, frankfurt.isDead());

 	}
 		
	/**
	 * Testing takeDamage(), through a series of method calls that test various taking damage sources and target, tests if take damage brings health to min allowed zero to fulill isDead() conditions
	 * 
	 * @custom.require amountofdamage > 0 && getHealth() >= 0
	 * @custome.ensure getHealth() >= 0 
	 */
 	@Test
 	public void testTakeDamage(){
 		spudzilla.takeDamage(3, frankfurt);
 		assertTrue(spudzilla.getHealth() < 10);
 		assertEquals(7, spudzilla.getHealth());
 		spudzilla.takeDamage(8, dudley);
 		assertEquals(0, spudzilla.getHealth());
 		assertEquals(true, spudzilla.isDead());
 	}

	/**
	 * Testing toSting(), passing the pokemon to method to test methods retrieval of correct String representation of Pokemon being properly formated
	 * 
	 * @custom.require name != ""
	 * @custom.ensure  getName() != "" && getName() == name && toString() == formated string
	 */
 	@Test 
 	public void testToString(){
 		assertEquals(dudley.toString(), ("Pokemon " + dudley.getName() + ":\n\thealth: " + dudley.getHealth() + "\n\tattack: " + dudley.getAttackPower()));
 		assertEquals(spudzilla.toString(), ("Pokemon " + spudzilla.getName() + ":\n\thealth: " + spudzilla.getHealth() + "\n\tattack: " + spudzilla.getAttackPower()));
 		assertEquals(frankfurt.toString(), ("Pokemon " + frankfurt.getName() + ":\n\thealth: " + frankfurt.getHealth() + "\n\tattack: " + frankfurt.getAttackPower()));
 	}
}