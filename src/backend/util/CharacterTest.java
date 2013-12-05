package backend.util;
import student.TestCase;

<<<<<<< Updated upstream
import sofia.util.Random;
=======
import java.util.Random;
>>>>>>> Stashed changes

// -------------------------------------------------------------------------
/**
 * Tests the character class
 *
<<<<<<< Updated upstream
 *  @author Alycia Rouffa (arouffa)
 *  @version 11.15.2013
 */
public class CharacterTest extends TestCase
{
    private Character character;
    //Character test;

    private Random rand;
=======
 * @author Alycia Rouffa
 * @author Mary-Wynn Rogers (marywynn)
 * @version 11.15.2013
 */
public class CharacterTest
    extends student.TestCase
{
    private Character wizard;
    private Character fighter;
    private Character rogue;
    Character         test;

    private int       health;
    private int       strength;
    private Random    rnd;

>>>>>>> Stashed changes

    /**
     * Sets up the information to be tested
     */
    public void setUp()
    {
<<<<<<< Updated upstream
        character = new Character(100, 10);
=======
        // How do we set this as the selected character?
        wizard = new Character(health, strength);
        rnd = new Random();
        health = 100;
        strength = 20;
>>>>>>> Stashed changes
    }


    /**
     * Tests the attack() method
     */
    public void testAttack()
    {
<<<<<<< Updated upstream
        Random.setNextInts(1, 2, 0);
        assertEquals(character.attack(), 0);
        assertEquals(character.attack(), 5);
        assertEquals(character.attack(), 10);
=======
        // I'm not sure how to test for Random numbers
        rnd.nextInt(1);
        test.attack();
        assertEquals(0, test.getStrength());
>>>>>>> Stashed changes
    }


    /**
<<<<<<< Updated upstream
     * Tests the getHealth and setHealth methods
=======
     * Tests the getHealth and the setHealth method for a fighter
>>>>>>> Stashed changes
     */
    public void testSetHealth()
    {
<<<<<<< Updated upstream
        character.setBaseHealth(120);
        assertEquals(120, character.getHealth());
=======
        test.setHealth(fighter);
        assertEquals(100, test.getHealth());
>>>>>>> Stashed changes
    }


    /**
<<<<<<< Updated upstream
     * Tests the getStrength and setStrength methods
=======
     * Tests the setHealth and getHealth method for a wizard
>>>>>>> Stashed changes
     */
    public void testSetStrength()
    {
        character.setBaseStrength(20);
        assertEquals(20, character.getStrength());
    }

    /**
     * Tests the levelUp() method.
     */
    public void testLevelUp()
    {
<<<<<<< Updated upstream
        character.levelUp();
        assertEquals(2, character.getLevel());
        assertEquals(110, character.getHealth());
        assertEquals(11, character.getStrength());
=======
        test.setHealth(wizard);
        assertEquals(80, test.getHealth());
    }


    /**
     * tests the setHealth and the getHealth method for a rogue
     */
    public void testSetHealth1()
    {
        test.setHealth(rogue);
        assertEquals(90, test.getHealth());
    }


    /**
     * Tests the setStrength() method for fighter
     */
    public void testSetStrength()
    {
        test.setStrength(fighter);
        assertEquals(10, test.getStrength());
>>>>>>> Stashed changes
    }


    /**
<<<<<<< Updated upstream
     * comment.
     */
    public void testLevelSetHealth()
    {
        character.levelUp();
        character.setBaseHealth(50);
        assertEquals(55, character.getHealth());
=======
     * Tests the getStrength() method for rogue
     */
    public void testSetStrength1()
    {
        test.setStrength(rogue);
        assertEquals(15, test.getStrength());
>>>>>>> Stashed changes
    }


    /**
<<<<<<< Updated upstream
     * comment.
     */
    public void testLevelSetStrength()
    {
        character.levelUp();
        character.setBaseStrength(11);
        assertEquals(12, character.getStrength());
=======
     * Tests the getStrength() method for wizard
     */
    public void testSetStrength2()
    {
        test.setStrength(wizard);
        assertEquals(20, test.getStrength());
>>>>>>> Stashed changes
    }

}
