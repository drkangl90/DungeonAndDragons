package backend.util;

import java.util.Random;

// -------------------------------------------------------------------------
/**
 *  Tests the character class
 *
 *  @author Alycia Rouffa
 *  @author Mary-Wynn Rogers (marywynn)
 *  @version 11.15.2013
 */
public class CharacterTest extends student.TestCase
{
    private Character fighter;
    private Character rogue;
    private Character wizard;
    Character test;

    private int health;
    private int strength;

    /**
     * Sets up the information to be tested
     */
    public void setUp()
    {
        health = 100;
        strength = 10;
    }

    /**
     * Tests the attack() method
     */
    public void testAttack()
    {
        //I'm not sure how to test for Random numbers
    }

    /**
     * Tests the getHealth and setHealth method for fighter
     */
    public void testSetHealth()
    {
       test.setHealth(fighter);
       assertEquals(100, test.getHealth());
    }

    /**
     * Tests the getHealth and setHealth method for rogue
     */
    public void testSetHealth1()
    {
       test.setHealth(rogue);
        assertEquals(90, test.getHealth());
    }

    /**
     * Tests the getHealth and setHealth method for rogue
     */
    public void testSetHealth2()
    {
       test.setHealth(wizard);
        assertEquals(80, test.getHealth());
    }

    /**
     * Tests the getStrength and setStrength method for wizard
     */
    public void testSetStrength()
    {
       test.setStrength(fighter);
        assertEquals(20, test.getStrength());
    }

    /**
     * Tests the getStrength and setStrength method for rogue
     */
    public void testSetStrength1()
    {
       test.setStrength(rogue);
        assertEquals(15, test.getStrength());
    }

    /**
     * Tests the getStrength and setStrength method for wizard
     */
    public void testSetStrength2()
    {
       test.setStrength(wizard);
        assertEquals(20, test.getStrength());
    }
}
