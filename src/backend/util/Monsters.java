package backend.util;

import java.util.Random;

// -------------------------------------------------------------------------
/**
 * Class that creates the interactions that the character should have in the
 * maze. Will compensate for level of map screen.
 *
 * @author Alycia Rouffa (arouffa)
 * @version 11.15.2013
 */
public class Monsters
{
    // full health
    private int    healthField;
    // full capacity of attack
    private int    strengthField;
    private Random rand;
    private int level;


    // Constructor ----------------------------------------------------------
    /**
     * Create a new Monster object.
     */
    public Monsters()
    {
        // creates the random number generator to be used in following methods.
        rand = new Random();
        level = 1;

        healthField = 30;
        strengthField = 5;
    }


    /**
     * This is the attack method of the monster. It will return a random integer
     * that will then be called from the damage() method in the Map class on the
     * Character
     *
     * @return returns the integer value of the attack to the Monster
     */
    public int attack()
    {
        int temp = rand.nextInt(2);
        if (temp == 1)
        {
            return 0;
        }
        else
        {
            return strengthField;
        }
    }


    /**
     * This is the getHeatlh() method, which gets the health based on the
     * monster being fought.
     *
     * @return returns the amount of health the monster generated has
     */
    public int getHealth()
    {
        return healthField;
    }

    /**
     * This is the getStrength() method, which gets the strength based on the
     * monster generated.
     *
     * @return returns the amount of strength for attacks that the monster
     *         generated has
     */
    public int getStrength()
    {
        return strengthField;
    }

    /**
     * Changes what level the character is at, and increments the health and
     * strength in relation.
     */
    public void levelUp()
    {
        level++;
        healthField += healthField * .2;
        strengthField += strengthField * .2;
    }

    /**
     * This gets the level of the character.
     * @return the current level of the character
     */
    public int getLevel()
    {
        return level;
    }
}
