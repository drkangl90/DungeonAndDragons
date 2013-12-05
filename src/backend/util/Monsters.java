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
    private int            healthField;
    // full capacity of attack
    private int            strengthField;
    private Random         rand;

    // Constructor ----------------------------------------------------------
    /**
     * Create a new Monster object.
     *
     * @param health
     *            The health of the monster
     * @param strength
     *            The strength of the monster.
     */
    public Monsters(int health, int strength)
    {
        // creates the random number generator to be used in following methods.
        rand = new Random();

        healthField = health;
        strengthField = strength;
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
     * This is the setHealth() method, which sets the health based on the
     * monster generated.
     *
     * @param monster
     *            The monster that was generated.
     */
    public void setHealth(Monsters monster)
    {
        // attack and strength arbitrarily chosen.
        //
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
     * This is the setStrength() method which sets the strength based on the
     * character selected.
     *
     * @param monster
     *            The character that was selected decides the stats.
     */
    public void setStrength(Monsters monster)
    {
        // attack and strength arbitrarily chosen.
        //
    }
}
