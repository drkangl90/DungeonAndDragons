package backend.util;
import sofia.util.Random;

//import java.util.Random;

//-------------------------------------------------------------------------
/**
 * Class that creates the interactions that the character should have in the
 * maze. Will compensate for level of map screen.
 *
 * @author Alycia Rouffa (arouffa)
 * @version 11.15.2013
 */
public class Character
{
    // full health
    private int             baseHealth;
    private int             totalHealth;
    // full capacity of attack
    private int             baseStrength;
    private int             totalStrength;

    private int             level;
    private Random          rand;
    private directionOfChar leDirection;


    // Constructor ----------------------------------------------------------
    /**
     * Create a new Character object.
     *
     * @param health
     *            The health of the character
     * @param strength
     *            The strength of the character.
     */
    public Character(int health, int strength)
    {
        // creates the random number generator to be used in following methods.
        rand = new Random();

        level = 1;
        baseHealth = health;
        totalHealth = health;
        baseStrength = strength;
        totalStrength = strength;
    }


    /**
     * This is the attack method of the character. It will return a random
     * integer that will then be called from the damage() method in the Map
     * class on the Monsters
     *
     * @return returns the integer value of the attack to the Monsters
     */
    public int attack()
    {
        int temp = rand.nextInt(3);
        if (temp == 1)
        {
            return 0;
        }
        else if (temp == 2)
        {
            return baseStrength / 2;
        }
        else
        {
            return baseStrength;
        }
    }


    /**
     * This is the getHeatlh() method, which gets the health of the character.
     *
     * @return returns the amount of health the character has
     */
    public int getHealth()
    {
        return totalHealth;
    }


    /**
     * This is the setHealth() method, which sets the health of the character.
     * Incorporates for leveling up.
     *
     * @param health Sets the health of the character
     */
    public void setBaseHealth(int health)
    {
        baseHealth = health;
        totalHealth = health;
        for (int i = 1; i < level; i++)
        {
            totalHealth += totalHealth * .1;
        }
    }


    /**
     * This is the getStrength() method, which gets the strength of
     * the character. Incorporates for leveling up.
     *
     * @return returns the amount of strength for attacks that the character
     *         has
     */
    public int getStrength()
    {
        return totalStrength;
    }

    /**
     * Changes what level the character is at, and increments the health and
     * strength in relation.
     */
    public void levelUp()
    {
        level++;
        totalHealth += totalHealth*.1;
        totalStrength += totalStrength *.1;
    }

    /**
     * This gets the level of the character.
     * @return the current level of the character
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * This is the setStrength() method which sets the strength
     * of the character.
     *
     * @param strength
     *            The set strength of the character.
     */
    public void setBaseStrength(int strength)
    {
        baseStrength = strength;
        totalStrength = strength;
        for (int i = 1; i < level; i++)
        {
            totalStrength += totalStrength * .1;
        }
    }
}
