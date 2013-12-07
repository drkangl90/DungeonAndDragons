package backend.util;

import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
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
    extends RectangleShape
{
    // full health
    private int    healthField;
    // full capacity of attack
    private int    strengthField;
    private Random rand;
    private int level;
    private int       x;
    private int       y;


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
     * @param left the left position
     * @param top the top position
     * @param right the right position
     * @param bottom the bottom position
     */
    public Monsters(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setFillColor(Color.red);
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

    /**
     * Setting the location of the monster.
     * @param loc the location of the monster
     */
    public void setLocation(ILocation loc)
    {
        x = loc.x();
        y = loc.y();
    }
}
//=======
////-------------------------------------------------------------------------
///**
//* Class that creates the interactions that the character should have in the
//* maze. Will compensate for level of map screen.
//*
//* @author Alycia Rouffa
//* @version 11.15.2013
//*/
//public class Monsters
//{
// // full health
// private int             healthField;
// // full capacity of attack
// private int             strengthField;
// private Monsters       rat;
// private Monsters       orc;
// private Monsters       goblin;
// private Random          rand;
// private directionOfMon leWay;
//
//
// // Constructor ----------------------------------------------------------
// /**
//  * Create a new Monster object.
//  *
//  * @param health
//  *            The health of the monster
//  * @param strength
//  *            The strength of the monster.
//  */
// public Monsters(int health, int strength)
// {
//     // creates the random number generator to be used in following methods.
//     rand = new Random();
//     rand.nextInt(2);
//
//     healthField = health;
//     strengthField = strength;
// }
//
//
// /**
//  * This is the attack method of the monster. It will return a random
//  * integer that will then be called from the damage() method in the Map
//  * class on the Character
//  *
//  * @return returns the integer value of the attack to the Monster
//  */
// public int attack()
// {
//     if (rand.nextInt() == 0)
//     {
//         strengthField = 0;
//         return strengthField;
//     }
//     else if (rand.nextInt() == 1)
//     {
//         strengthField /= 2;
//         return strengthField;
//     }
//     else
//     {
//         return strengthField;
//     }
// }
//
//
// /**
//  * This is the getHeatlh() method, which gets the health based on the
//  * monster being fought.
//  *
//  * @return returns the amount of health the monster generated has
//  */
// public int getHealth()
// {
//     return healthField;
// }
//
//
// /**
//  * This is the setHealth() method, which sets the health based on the
//  * monster generated.
//  *
//  * @param monster
//  *            The monster that was generated randomly.
//  */
// public void setHealth(Monsters monster)
// {
//     // attack and strength arbitrarily chosen.
//     if (monster == rat)
//     {
//         healthField = 30;
//     }
//     else if (monster == orc)
//     {
//         healthField = 40;
//     }
//     else
//     {
//         healthField = 60;
//     }
// }
//
//
// /**
//  * This is the getStrength() method, which gets the strength based on the
//  * monster generated.
//  *
//  * @return returns the amount of strength for attacks that the monster
//  *         generated has
//  */
// public int getStrength()
// {
//     return strengthField;
// }
//
//
// /**
//  * This is the setStrength() method which sets the strength based on the
//  * character selected.
//  *
//  * @param monster
//  *            The character that was selected decides the stats.
//  */
// public void setStrength(Monsters monster)
// {
//     // attack and strength arbitrarily chosen.
//     if (monster == rat)
//     {
//         strengthField = 10;
//     }
//     else if (monster == orc)
//     {
//         strengthField = 15;
//     }
//     else
//     {
//         strengthField = 20;
//     }
// }
//
//
// /**
//  * The enum types available.
//  */
// public enum directionOfMon
// {
//     /**
//      * This faces the monster to the north direction.
//      */
//     NORTH,
//     /**
//      * This faces the monster to the east direction.
//      */
//     EAST,
//     /**
//      * This faces the monster to the south direction.
//      */
//     SOUTH,
//     /**
//      * This faces the monster to the west direction.
//      */
//     WEST
// }
//}
//>>>>>>> Stashed changes
