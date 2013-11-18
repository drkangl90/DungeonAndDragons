package backend.util;

import java.util.Random;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 *  Tests the character class
 *
 *  @author Alycia Rouffa (arouffa)
 *  @author Mary-Wynn Rogers (marywynn)
 *  @version 11.15.2013
 */
public class CharacterTest extends TestCase
{
    private Character fighter;
    private Character rogue;
    private Character wizard;
    //Character test;

    private Random          rand;
    private int healthField;
    private int strengthField;

    /**
     * Sets up the information to be tested
     */
    public void setUp()
    {
        healthField = 100;
        strengthField = 10;
    }

    /**
     * Tests the attack() method
     */
    public void testAttack()
    {
        //I'm not sure how to test for Random numbers
        Random.setNextInts(1);
        fighter.attack();
        assertEquals(0, fighter.getStrength());
    }

    /**
     * Tests the getHealth and setHealth method for fighter
     */
    public void testSetHealth()
    {
       fighter.setHealth(fighter);
       assertEquals(100, fighter.getHealth());
    }

    /**
     * Tests the getHealth and setHealth method for rogue
     */
    public void testSetHealth1()
    {
       rogue.setHealth(rogue);
        assertEquals(90, rogue.getHealth());
    }

    /**
     * Tests the getHealth and setHealth method for rogue
     */
    public void testSetHealth2()
    {
       wizard.setHealth(wizard);
        assertEquals(80, wizard.getHealth());
    }

    /**
     * Tests the getStrength and setStrength method for wizard
     */
    public void testSetStrength()
    {
       fighter.setStrength(fighter);
        assertEquals(20, fighter.getStrength());
    }

    /**
     * Tests the getStrength and setStrength method for rogue
     */
    public void testSetStrength1()
    {
       rogue.setStrength(rogue);
        assertEquals(15, rogue.getStrength());
    }

    /**
     * Tests the getStrength and setStrength method for wizard
     */
    public void testSetStrength2()
    {
       wizard.setStrength(wizard);
        assertEquals(20, wizard.getStrength());
    }
}
