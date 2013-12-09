package backend.util;

import student.TestCase;
import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 * Tests the character class
 *
 * @author Alycia Rouffa (arouffa)
 * @version 11.15.2013
 */
public class CharacterTest
    extends TestCase
{
    private Character character;


    // Character test;

    // private Random rand;

    /**
     * Sets up the information to be tested
     */
    public void setUp()
    {
        character = new Character(100, 10);
    }


    /**
     * Tests the attack() method
     */
    public void testAttack()
    {
        Random.setNextInts(1, 2, 0);
        assertEquals(character.attack(), 0);
        assertEquals(character.attack(), 5);
        assertEquals(character.attack(), 10);
    }


    /**
     * Tests the getHealth and setHealth methods
     */
    public void testSetHealth()
    {
        character.setBaseHealth(120);
        assertEquals(120, character.getHealth());
    }


    /**
     * Tests the getStrength and setStrength methods
     */
    public void testSetStrength()
    {
        character.setBaseStrength(20);
        assertEquals(20, character.getStrength());
    }


    /**
     * Tests how leveling up affects health.
     */
    public void testLevelSetHealth()
    {
        character.levelUp();
        character.setBaseHealth(50);
        assertEquals(55, character.getHealth());
    }


    /**
     * Tests how leveling up affects strength.
     */
    public void testLevelSetStrength()
    {
        character.levelUp();
        character.setBaseStrength(11);
        assertEquals(12, character.getStrength());
    }


    /**
     * Tests the takeDamage() method
     */
    public void testTakeDamage()
    {
        character.takeDamage(20);
        assertEquals(character.getHealth(), 80);
    }


    /**
     * Testing the direction of the character
     */
    public void testDirection()
    {
        character.setDirection(directionOfChar.NORTH);
        assertEquals((int) character.getRotation(), 270);
    }

    /**
     * Testing the location of the character.
     */
    public void testLocation()
    {
        Location location = new Location(0, 1);
        character.setLocation(new Location(0, 1));
        assertTrue(character.getLocation().equals(location));
    }
}
