package backend.util;


import backend.util.Map.MapCell;
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
    private Monsters[][]       monsterMap;
    private Key key;
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
                tile.setImage("grass");
                //tile.setFillColor(Color.black);
                add(tile);
                mapArray[i][j] = tile;
            }
        }

        character = new Character(30, 20, 1, 1, (int)side, (int)side);
        //character.setFillColor(Color.green);
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
        monsterMap = new Monsters[size][size];
        addMonsters();
        addKey(7, 0);
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

        if (map.getCell(loc) == MapCell.MONSTER)
        {
            Monsters mon = monsterMap[loc.x()][loc.y()];
            mon.takeDamage(character.attack());

            if (mon.getHealth() <= 0)
            {
                mon.remove();
                map.setCell(loc, MapCell.UNEXPLORED);
            }
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
        map.setCell(loc, MapCell.MONSTER);
        add(mon);
        monsterMap[loc.x()][loc.y()] = mon;
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
   public void addKey(int x, int y)
   {
       key = new Key(
           x * side + 1,
           y * side + 1,
           (x + 1) * side + 1,
           (y + 1) * side + 1);
       key.setFillColor(Color.gold);
       add(key);
   }


    /**
     * moves the character north
     */
    public void northClicked()
    {
        // character moves north
        status = directionOfChar.NORTH;
        ILocation loc = character.getLocation().north();
        if (character.getLocation().y() > 0 && map.getCell(loc) != MapCell.MONSTER)
        {
            character.moveBy(0, -side);
            character.setDirection(status);
            character.setLocation(loc);
            reachedGoal();
        }
    }

    /**
     * moves the character south
     */
    public void southClicked()
    {
        // character moves south
        status = directionOfChar.SOUTH;
        ILocation loc = character.getLocation().south();
        if (character.getLocation().y() < size - 1 && map.getCell(loc) != MapCell.MONSTER)
        {
            character.moveBy(0, side);
            character.setDirection(status);
            character.setLocation(loc);
            reachedGoal();
        }
    }


    /**
     * moves the character east
     */
    public void eastClicked()
    {
        // character moves east
        status = directionOfChar.EAST;
        ILocation loc = character.getLocation().east();
        if (character.getLocation().x() < size - 1 && map.getCell(loc) != MapCell.MONSTER)
        {
            character.moveBy(side, 0);
            character.setDirection(status);
            character.setLocation(loc);
            reachedGoal();
        }
    }


    /**
     * moves the character west
     */
    public void westClicked()
    {
        // character moves west
        status = directionOfChar.WEST;
        ILocation loc = character.getLocation().west();
        if (character.getLocation().x() > 0 && map.getCell(loc) != MapCell.MONSTER)
        {
            character.moveBy(-side, 0);
            character.setDirection(status);
            character.setLocation(loc);
            reachedGoal();
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
     * Reaching the goal.
     */
    public void reachedGoal()
    {
        if (character.getLocation().equals(key.getLocation()))
        {
            key.remove(); //You Win
        }
    }
}
