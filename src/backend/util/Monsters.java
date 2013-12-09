package backend.util;

import sofia.graphics.RectangleShape;
import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 * Class that creates the interactions that the character should have in the
 * maze. Will compensate for level of map screen.
 *
 * @author Alycia Rouffa (arouffa)
 * @version 11.15.2013
 */
public class Monsters
    extends RectangleShape
{
    // full health
    private int    healthField;
    // full capacity of attack
    private int    strengthField;
    private Random rand;
    private int    level;
    private int    x;
    private int    y;


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
     * Create a new Monster object.
     *
     * @param left
     *            the left position
     * @param top
     *            the top position
     * @param right
     *            the right position
     * @param bottom
     *            the bottom position
     */
    public Monsters(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setImage("monster3");
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
     *
     * @return the current level of the character
     */
    public int getLevel()
    {
        return level;
    }


    /**
     * Setting the location of the monster.
     *
     * @param loc
     *            the location of the monster
     */
    public void setLocation(ILocation loc)
    {
        x = loc.x();
        y = loc.y();
    }


    /**
     * Gets the location of the monster
     * @return returns the location of the monster
     */
    public ILocation getLocation()
    {
        return new Location(x, y);
    }


    // ----------------------------------------------------------
    /**
     * Deals damage to the monster
     *
     * @param damage
     *            the amount of damage taken
     */
    public void takeDamage(int damage)
    {
        healthField -= damage;
    }
}
