package backend.util;

import java.util.Random;


// -------------------------------------------------------------------------
/**
 *  Tests the character class
 *
 *  @author Alycia Rouffa
 *  @version 11.15.2013
 */
public class CharacterTest extends student.TestCase
{
    //private Character char1;
    Character test;

    private int health;
    private int attack;

    /**
     * Sets up the information to be tested
     */
    public void setUp()
    {
        //How do we set this as the selected character?
        //char1 = fighter;
        health = 100;
        attack = 10;
    }

    /**
     * Tests the attack() method
     */
    public void testAttack()
    {
        //I'm not sure how to test for Random numbers
    }

    /**
     * Tests the getHealth() method
     */
    public void testGetHealth()
    {
//        test.setHealth(health);
//        assertEquals(health, test.getHealth(health));
    }

    /**
     * Tests the setHealth() method
     */
    public void testSetHealth()
    {
//       test.setHealth(health);
//       assertEquals(health, test.getHealth());
    }

    /**
     * Tests the getAttack() method
     */
    public void testGetAttack()
    {
        //
    }

    /**
     * Tests the setAttack() method
     */
    public void testSetAttack()
    {
        //
    }
}
