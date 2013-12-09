package backend.util;

import sofia.util.Random;
import sofia.graphics.RectangleShape;

// import java.util.Random;

// -------------------------------------------------------------------------
/**
 * Class that creates the interactions that the character should have in the
 * maze. Will compensate for level of map screen.
 *
 * @author Alycia Rouffa (arouffa)
 * @author Mary-Wynn Rogers (marywynn)
 * @author Ben Robohn (brobohn)
 * @version 11.15.2013
 */
public class Character
    extends RectangleShape
{

    // full health
    private int    baseHealth;
    private int    totalHealth;
    // full capacity of attack
    private int    baseStrength;
    private int    totalStrength;

    private int    level;
    private Random rand;
    private int    x;
    private int    y;


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
        super();
        // creates the random number generator to be used in following methods.
        rand = new Random();

        level = 1;
        baseHealth = health;
        totalHealth = health;
        baseStrength = strength;
        totalStrength = strength;
        setImage("combat103_woodelf");
    }


    /**
     * Create a new Character object on a cell of the map.
     *
     * @param health
     *            The health of the character
     * @param strength
     *            The strength of the character.
     * @param left
     *            The left position of the Character
     * @param top
     *            The top position of the Character
     * @param right
     *            The right position of the Character
     * @param bottom
     *            The bottom position of the Character
     */
    public Character(
        int health,
        int strength,
        int left,
        int top,
        int right,
        int bottom)
    {
        super(left, top, right, bottom);
        // creates the random number generator to be used in following methods.
        rand = new Random();

        level = 1;
        baseHealth = health;
        totalHealth = health;
        baseStrength = strength;
        totalStrength = strength;
        setImage("combat103_woodelf");
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


    // ----------------------------------------------------------
    /**
     * Deals damage to the character
     *
     * @param damage
     *            the amount of damage taken
     */
    public void takeDamage(int damage)
    {
        totalHealth -= damage;
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
     * @param health
     *            Sets the health of the character
     */
    public void setBaseHealth(int health)
    {
        baseHealth = health;
        totalHealth = baseHealth;
        for (int i = 1; i < level; i++)
        {
            totalHealth += totalHealth * .1;
        }
    }


    /**
     * This is the getStrength() method, which gets the strength of the
     * character. Incorporates for leveling up.
     *
     * @return returns the amount of strength for attacks that the character has
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
        totalHealth += baseHealth * (.1 * level);
        totalStrength += totalStrength * .1;
    }


    /**
     * This gets the level of the character.
     *
     * @return the current level of the character
     */
    public int getLevel()
    {
        return level;
    }


    /**
     * This is the setStrength() method which sets the strength of the
     * character.
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


    // ----------------------------------------------------------
//    /**
//     * gets the direction of the character in the map
//     *
//     * @return returns the location of the character
//     */
//    public Location getDirection()
//    {
//        return getDirection();
//    }


    // ----------------------------------------------------------
    /**
     * sets the direction of the character
     *
     * @param status
     */
    public void setDirection(directionOfChar status)
    {
        if (status == directionOfChar.NORTH)
        {
            setRotation(270);
        }
        else if (status == directionOfChar.EAST)
        {
            setRotation(0);
        }
        else if (status == directionOfChar.WEST)
        {
            setRotation(0);
        }
        else if (status == directionOfChar.SOUTH)
        {
            setRotation(90);
        }
    }


    // ----------------------------------------------------------
    /**
     * gets the location of the character
     *
     * @return returns the location character is currently at
     */
    public ILocation getLocation()
    {
        return new Location(x, y);
    }


//    /**
//     * public ILocation getLocation() { return getLocation(); }
//     */

    // ----------------------------------------------------------
    /**
     * sets the new location of the character
     *
     * @param loc
     *            if the status matches move the character to new location
     */
    public void setLocation(ILocation loc)
    {
        x = loc.x();
        y = loc.y();
    }
}