package backend.util;
import student.TestCase;

import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 *  Tests the character class
 *
 *  @author Alycia Rouffa (arouffa)
 *  @version 11.15.2013
 */
public class CharacterTest extends TestCase
{
    private Character character;
    //Character test;

    private Random rand;

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
     * Tests the levelUp() method.
     */
    public void testLevelUp()
    {
        character.levelUp();
        assertEquals(2, character.getLevel());
        assertEquals(110, character.getHealth());
        assertEquals(11, character.getStrength());
    }

    /**
     * comment.
     */
    public void testLevelSetHealth()
    {
        character.levelUp();
        character.setBaseHealth(50);
        assertEquals(55, character.getHealth());
    }

    /**
     * comment.
     */
    public void testLevelSetStrength()
    {
        character.levelUp();
        character.setBaseStrength(11);
        assertEquals(12, character.getStrength());
    }
}
