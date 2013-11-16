package backend.util;

import java.util.Random;

//-------------------------------------------------------------------------
/**
* Class that creates the interactions that the character should have in the
* maze. Will compensate for level of map screen.
*
* @author Alycia Rouffa
* @version 11.15.2013
*/
public class Character
{
 // full health
 private int             healthField;
 // full capacity of attack
 private int             strengthField;
 private Character       fighter;
 private Character       rogue;
 private Character       wizard;
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
     rand.nextInt(2);

     healthField = health;
     strengthField = strength;
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
     if (rand.nextInt() == 0)
     {
         strengthField = 0;
         return strengthField;
     }
     else if (rand.nextInt() == 1)
     {
         strengthField /= 2;
         return strengthField;
     }
     else
     {
         return strengthField;
     }
 }


 /**
  * This is the getHeatlh() method, which gets the health based on the
  * character selected.
  *
  * @return returns the amount of health the character selected has
  */
 public int getHealth()
 {
     return healthField;
 }


 /**
  * This is the setHealth() method, which sets the health based on the
  * character selected.
  *
  * @param character
  *            The character that was selected decides the stats.
  */
 public void setHealth(Character character)
 {
     // attack and strength arbitrarily chosen.
     if (character == fighter)
     {
         healthField = 100;
     }
     else if (character == rogue)
     {
         healthField = 90;
     }
     else
     {
         healthField = 80;
     }
 }


 /**
  * This is the getStrength() method, which gets the strength based on the
  * character selected.
  *
  * @return returns the amount of strength for attacks that the character
  *         selected has
  */
 public int getStrength()
 {
     return strengthField;
 }


 /**
  * This is the setStrength() method which sets the strength based on the
  * character selected.
  *
  * @param character
  *            The character that was selected decides the stats.
  */
 public void setStrength(Character character)
 {
     // attack and strength arbitrarily chosen.
     if (character == fighter)
     {
         strengthField = 10;
     }
     else if (character == rogue)
     {
         strengthField = 15;
     }
     else
     {
         strengthField = 20;
     }
 }


 /**
  * The enum types available.
  */
 public enum directionOfChar
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
}
