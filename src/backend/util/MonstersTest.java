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
public class MonstersTest extends TestCase
{
    private Monsters monster;
    //Character test;

    private Random rand;

    /**
     * Sets up the information to be tested
     */
    public void setUp()
    {
        monster = new Monsters();
    }

    /**
     * Tests the attack() method
     */
    public void testAttack()
    {
        Random.setNextInts(1, 0);
        assertEquals(monster.attack(), 5);
        assertEquals(monster.attack(), 0);
    }

    /**
     * Tests the levelUp() method.
     */
    public void testLevelUp()
    {
        monster.levelUp();
        assertEquals(2, monster.getLevel());
        assertEquals(36, monster.getHealth());
        assertEquals(6, monster.getStrength());
    }

    /**
     * Tests the levelUp() method on the health.
     */
    public void testLevelGetHealth()
    {
        monster.levelUp();
        monster.levelUp();
        assertEquals(43, monster.getHealth());
    }

    /**
     * Tests the levelUp() method on the strength.
     */
    public void testLevelGetStrength()
    {
        monster.levelUp();
        monster.levelUp();
        assertEquals(7, monster.getStrength());
    }
}
