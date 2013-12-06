package backend.util;

import sofia.graphics.ShapeView;
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
 * @version 11.15.2013
 */
public class Character
    extends RectangleShape
{

    // full health
    private int       baseHealth;
    private int       totalHealth;
    // full capacity of attack
    private int       baseStrength;
    private int       totalStrength;

    private int       level;
    private Random    rand;
    private Location  direction;
    private int       x;
    private int       y;
    private ILocation north;
    private ILocation east;
    private ILocation south;
    private ILocation west;


    /**
     * The enum types available.
     */
    public enum State
    {
        /**
         * This faces the character to the north direction.
         */
        NORTH,
        /**
         * This faces the character to the east direction.
         */
        EAST,
        /**
         * This faces the character to the south direction.
         */
        SOUTH,
        /**
         * This faces the character to the west direction.
         */
        WEST
    }


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
        totalHealth += totalHealth * .1;
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
    /**
     * gets the direction of the character in the map
     *
     * @param status
     *            the status of the cell
     * @return returns the location of the character
     */
    public Location getDirection()
    {
        return new Location(x, y);
    }


    // ----------------------------------------------------------
    /**
     * sets the location of the character
     *
     * @param status
     */
    public void setDirection(State status)
    {
        if (status == State.NORTH)
        {
            setRotation(90);
        }
        else if (status == State.EAST)
        {
            setRotation(0);
        }
        else if (status == State.WEST)
        {
            setRotation(180);
        }
        else if (status == State.SOUTH)
        {
            setRotation(270);
        }
    }


    // ----------------------------------------------------------
    /**
     * gets the location of the character
     * @param status the status of a cell
     *
     * @return returns the location character is currently at
     */
    public ILocation getLocation()
    {
        return getLocation();
    }


    // ----------------------------------------------------------
    /**
     * sets the new location of the character
     *
     * @param status
     *            if the status matches move the character to new location
     * @return returns the new location
     */
    public void setLocation(State status)
    {
        if (status == State.NORTH)
        {
            north = direction.east();
        }
        else if (status == State.EAST)
        {
            east = direction.east();
        }
        else if (status == State.SOUTH)
        {
            south = direction.south();
        }
        else
        {
            west = direction.west();
        }

    }
}

//
// =======
// // full health
// private int healthField;
// // full capacity of attack
// private int strengthField;
// private Character fighter;
// private Character rogue;
// private Character wizard;
// private Random rand;
// private directionOfChar leDirection;
//
//
// // Constructor ----------------------------------------------------------
// /**
// * Create a new Character object.
// *
// * @param health
// * The health of the character
// * @param strength
// * The strength of the character.
// */
// public Character(int health, int strength)
// {
// // creates the random number generator to be used in following methods.
// rand = new Random();
// rand.nextInt(3);
//
// healthField = health;
// strengthField = strength;
// }
//
//
// /**
// * This is the attack method of the character. It will return a random
// * integer that will then be called from the damage() method in the Map
// * class on the Monsters
// *
// * @return returns the integer value of the attack to the Monsters
// */
// public int attack()
// {
// if (rand.nextInt() == 1)
// {
// strengthField = 0;
// return strengthField;
// }
// else if (rand.nextInt() == 2)
// {
// strengthField /= 2;
// return strengthField;
// }
// else
// {
// return strengthField;
// }
// }
//
//
// /**
// * This is the getHeatlh() method, which gets the health based on the
// * character selected.
// *
// * @return returns the amount of health the character selected has
// */
// public int getHealth()
// {
// return healthField;
// }
//
//
// /**
// * This is the setHealth() method, which sets the health based on the
// * character selected.
// *
// * @param character
// * The character that was selected decides the stats.
// */
// public void setHealth(Character character)
// {
// // attack and strength arbitrarily chosen.
// if (character == fighter)
// {
// healthField = 100;
// }
// else if (character == rogue)
// {
// healthField = 90;
// }
// else
// {
// healthField = 80;
// }
// }
//
//
// /**
// * This is the getStrength() method, which gets the strength based on the
// * character selected.
// *
// * @return returns the amount of strength for attacks that the character
// * selected has
// */
// public int getStrength()
// {
// return strengthField;
// }
//
//
// /**
// * This is the setStrength() method which sets the strength based on the
// * character selected.
// *
// * @param character
// * The character that was selected decides the stats.
// */
// public void setStrength(Character character)
// {
// // attack and strength arbitrarily chosen.
// if (character == fighter)
// {
// strengthField = 10;
// }
// else if (character == rogue)
// {
// strengthField = 15;
// }
// else
// {
// strengthField = 20;
// }
// }
//
//
// /**
// * The enum types available.
// */
// public enum directionOfChar
// {
// /**
// * This faces the character to the north direction.
// */
// NORTH,
// /**
// * This faces the character to the east direction.
// */
// EAST,
// /**
// * This faces the character to the south direction.
// */
// SOUTH,
// /**
// * This faces the character to the west direction.
// */
// WEST
// }
// >>>>>>> Stashed changes
// }
