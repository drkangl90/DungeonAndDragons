package backend.util;


import java.util.HashMap;
import sofia.graphics.OvalShape;
//import backend.util.Character.directionOfChar;
import android.widget.ProgressBar;
import android.widget.Button;
import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;


// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Ben
 * @author Alycia Rouffa (arouffa)
 * @author Mary-Wynn Rogers (marywynn)
 * @version Nov 15, 2013
 */

public class MapScreen
    extends ShapeScreen
{
    private Map                map;
    private int                size;
    private Character          character;
    private RectangleShape[][] mapArray;
    private float              side;
    private Button             north;
    private Button             south;
    private Button             east;
    private Button             west;
    private Button             fight;
    //private Button             defend;
    //private Button             flee;
    private ProgressBar        health;
    private directionOfChar    status;
    private OvalShape  start;
    private OvalShape  goal;
    private HashMap<ILocation, Monsters> monsterList;
    private boolean hasKey;


    public void initialize()
    {
        size = 8;
        map = new Map(size);
        mapArray = new RectangleShape[size][size];
        side = Math.min(getWidth(), getHeight());
        side /= size;
        side--;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                RectangleShape tile =
                    new RectangleShape(
                        i * side,
                        j * side,
                        (i + 1) * side,
                        (j + 1) * side);
                tile.setColor(Color.white);
                tile.setFillColor(Color.black);
                add(tile);
                mapArray[i][j] = tile;
            }
        }

        character = new Character(30, 20, 1, 1, (int)side, (int)side);
        character.setFillColor(Color.green);
        character.setLocation(new Location(0, 0));
        add(character);
        status = directionOfChar.EAST;
        north.setEnabled(true);
        south.setEnabled(true);
        east.setEnabled(true);
        west.setEnabled(true);
        fight.setEnabled(true);
        //defend.setEnabled(false);
        //flee.setEnabled(false);
        monsterList = new HashMap<ILocation, Monsters>();
        addMonsters();
        keyLocation();
        hasKey = false;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void onTouchDown(float x, float y)
    {

    }

    /**
     * Causes a character to attack a monster, if present.
     */
    public void fightClicked()
    {
        ILocation loc = new Location(
            character.getLocation().x(),
            character.getLocation().y());
        if (status == directionOfChar.NORTH)
        {
            loc = loc.north();
        }
        else if (status == directionOfChar.EAST)
        {
            loc = loc.east();
        }
        else if (status == directionOfChar.SOUTH)
        {
            loc = loc.south();
        }
        else
        {
            loc = loc.west();
        }

        if (monsterList.containsKey(loc))
        {
            Monsters mon = monsterList.get(loc);

            character.attack();
        }
    }


    /**
     * @param loc
     */
    public void addMonster(ILocation loc)
    {
        Monsters mon = new Monsters(
            loc.x() * side + 1,
            loc.y() * side + 1,
            (loc.x() + 1) * side + 1,
            (loc.y() + 1) * side + 1);
        add(mon);
        monsterList.put(loc, mon);
    }


    /**
     *
     */
    public void addMonsters()
    {
        addMonster(new Location(3, 3));
        addMonster(new Location(2, 6));
        addMonster(new Location(7, 7));
    }

    /**
    * Sets the location and adds to the screen
    * @param location The location of the tile of the key.
    */
   public void addKey(ILocation location)
   {
       Key key = new Key(
           location.x() * side + 1,
           location.y() * side + 1,
           (location.x() + 1) * side + 1,
           (location.y() + 1) * side + 1);
       key.setFillColor(Color.gold);
       add(key);
   }

   /**
    * Sets the physical location of the key
    */
   public void keyLocation()
   {
       addKey(new Location(7, 0));
   }



    /**
     * moves the character north
     */
    public void northClicked()
    {
        // character moves north
        status = directionOfChar.NORTH;
        if (character.getLocation().y() > 0)
        {
            character.moveBy(0, -side);
            character.setLocation(new Location(
                character.getLocation().x(),
                character.getLocation().y() - 1));
        }
    }

    /**
     * moves the character south
     */
    public void southClicked()
    {
        // character moves south
        status = directionOfChar.SOUTH;
        if (character.getLocation().y() < size - 1)
        {
            character.moveBy(0, side);
            character.setLocation(new Location(
                character.getLocation().x(),
                character.getLocation().y() + 1));
        }
    }


    /**
     * moves the character east
     */
    public void eastClicked()
    {
        // character moves east
        status = directionOfChar.EAST;
        if (character.getLocation().x() < size - 1)
        {
            character.moveBy(side, 0);
            character.setLocation(new Location(
                character.getLocation().x() + 1,
                character.getLocation().y()));
        }
    }


    /**
     * moves the character west
     */
    public void westClicked()
    {
        // character moves west
        status = directionOfChar.WEST;
        if (character.getLocation().x() > 0)
        {
            character.moveBy(-side, 0);
            character.setLocation(new Location(
                character.getLocation().x() - 1,
                character.getLocation().y()));
        }
    }


//    /**
//     * handles the touch events for the maze solver
//     *
//     * @param x
//     *            the x coordinate
//     * @param y
//     *            the y coordinate
//     */
    /*public void processTouch(float x, float y)
    {
        float cellSize = Math.min(getWidth(), getHeight()) / 8;
        int i = (int)(x / cellSize);
        int j = (int)(y / cellSize);
        Location locat = new Location(i, j);

        if (status == directionOfChar.NORTH)
        {
            character.setDirection(directionOfChar.NORTH);
            //character.setLocation(directionOfChar.NORTH);
        }
        else if (status == directionOfChar.EAST)
        {
            character.setDirection(directionOfChar.EAST);
            //character.setLocation(directionOfChar.EAST);
        }
        else if (status == directionOfChar.SOUTH)
        {
            character.setDirection(directionOfChar.SOUTH);
            //character.setLocation(directionOfChar.SOUTH);
        }
        else if (status == directionOfChar.WEST)
        {
            character.setDirection(directionOfChar.WEST);
            //character.setLocation(directionOfChar.WEST);
        }
        else
        {
            map.setGoalLocation(locat);
            goal.setPosition(
                ((i + cellSize) + (cellSize / 2)),
                ((j * cellSize) + (cellSize / 2)));
            add(goal);
            map.setStartLocation(locat);
            start.setPosition(
                ((i + cellSize) + (cellSize / 2)),
                ((j * cellSize) + (cellSize / 2)));
            add(start);
        }
    }*/

    /**
     * Accessor method for the character on screen.
     * @return returns the character being called.
     */
    public Character getCharacter()
    {
        return character;
    }

    /**
     * Grabbing the key.
     */
    public void grabKey()
    {
        //if the character cell = key cell
        hasKey = true;
        //remove the key?
    }

    /**
     * Reaching the goal.
     */
    public void reachedGoal()
    {
        if (hasKey != true)
        {
            //nothing happens
        }
        else
        {
            //Yay you won!
        }
    }
}
