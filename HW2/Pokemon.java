// javadoc -d docs/ *jav
/**
 *  @author Christopher Summa
 *  @version 1.0
 * 
 * 
 *  parse custom tags with the following command:
 *
 *   javadoc -tag custom.require:cm:"Precondition:" -tag custom.ensure:cm:"Postcondition:" -Xdoclint:none  *.java
 *
 *   Specify an output directory for the generated files by adding the `-d ./doc` option of the above command.
 *
 *   Link to the java API by adding the `-link https://docs.oracle.com/javase/8/docs/api/` option as well.
*/
public class Pokemon{

    private int myHealth;  /** @invariant myHealth >=0 */
    private int myAttackPower; /** @invariant myAttackPower >= 0 */
    private String myName; /** @invariant myName != "" */
    
    /**
     *   @param name The name of the Pokemon
     *   @param initialHealth The initial health of the Pokemon
     *   @param initialAttackPower The initial attack power of the Pokemon
     *   @since Sunday, Sep 9, 2018
     *
     *   @custom.require name != ""
     *   @custom.require initialHealth > 0
     *   @custom.require initialAttackPower > 0
     *   @custom.ensure  getName() != "" && getName() == name
     *   @custom.ensure  getHealth() > 0 && getHealth() == initialHealth
     *   @custom.ensure  getAttackPower() > 0 && getAttackPower() == initialAttackPower
    */
    public Pokemon(String name, int initialHealth, int initialAttackPower) {
        myName = name;
        myAttackPower = initialAttackPower;
        myHealth = initialHealth;
    }
    /**       
     *   Returns the integer value of health of a Pokemon stored in myHealth
     *   <p>
     *   @custom.require initialHealth >= 0
     *   @custom.ensure myHealth >= 0
     *   @return int myHealth      
    */
    public int getHealth() {
        return myHealth;
    }
    /**
     *   Returns the integer value of attack power of a Pokemon stored in myAttackPower
     *   <p>
     *   @custom.require initialAttackPower >= 0
     *   @custom.ensure myAttackPower >= 0
     *   @return int myAttackPower      
     */
    public int getAttackPower() {
        return myAttackPower;
    }
    /**
     *   Returns the string value of a name of a Pokemon stored in myName
     *   <p>
     *   @custom.require name != ""
     *   @custom.ensure  getName() != "" && getName() == name
     *   @return String myName      
     */
    public String getName() {
        return myName;
    }
    /**
     *   Returns boolean value. Uses myHealth of a pokemon, evaluates if the int value of myHealth is equal to zero.
     *   <p>
     *   If myHealth is equal to zero, isDead is true. Returns true, Pokemon is dead.
     *   <p>
     *   If myHealth is not equal to zero, isDead is false. Returns false, Pokemon is not dead.
     *   <p>
     *   @custom.ensure isDead() != null
     *   @return boolean true equals 0 || false otherwise
     */
    public boolean isDead() {
        if (myHealth == 0)
            return true;
        return false;
    }
    /**
     *   Method for attacking anothing pokemon object. The method takes in pokemon being attack
     *   <p>
     *   Attacked pokemon calls takeDamage(), takes damage equal to myAttackPower
     *   <p>
     *   @param Pokemon object
     *   @custom.require myHealth > 0 && attackPower > 0 && >= two pokemon objects
     *   @custom.ensure  myHealth >= 0
     */
    public void attack(Pokemon other) {
        other.takeDamage(this.myAttackPower, this);
    }
    /**
     *   Method is used in cpnjuction with attack to simulate a pokemon taking damage from another pokemon
     *   <p>
     *   Determines if attack will reduce a myhealth to 0, if not preforms operation that reduces the myhealth by attackpower value
     *   <p>
     *   @param amountDamage damage being done
     *   @param Pokemon attacking pokemon 
     *   @custom.require myHealth > 0 && myAttackPower > 0
     *   @custom.ensure myHealth >= 0
     */
    public void takeDamage(int amountOfDamage, Pokemon attacker) {
        int amtOfDamageActuallyDealt;
        if (amountOfDamage > myHealth) {
            amtOfDamageActuallyDealt = myHealth;
            myHealth = 0;
        }
        else {
            myHealth -= amountOfDamage;
            amtOfDamageActuallyDealt = amountOfDamage;
        }
    }
    /**
     *   Method for returning a formatted string representation of a pokemon object
     *   <p>
     *
     *   @custom.require myName != nul && myHealth >= 0 && myAttackPower > 0
     *   @return String Returnval 
     */
    public String toString() {
        String returnval = "";
        returnval += "Pokemon " + myName + ":\n\thealth: " + myHealth + "\n\tattack: " + myAttackPower;
        return returnval;
    }

} // end class Pokemon
