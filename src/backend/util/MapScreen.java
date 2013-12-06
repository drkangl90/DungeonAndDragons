package backend.util;


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


    public void initialize()
    {
        map = new Map(8);
        mapArray = new RectangleShape[8][8];
        side = Math.min(getWidth(), getHeight());
        side /= 8;
        side--;
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
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

        character = new Character(0, 0);
        character.setLocation(new Location(0, 0));
        add(character);
        north.setEnabled(true);
        south.setEnabled(true);
        east.setEnabled(true);
        west.setEnabled(true);
        fight.setEnabled(false);
        //defend.setEnabled(false);
        //flee.setEnabled(false);
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
     * moves the character north
     */
    public void northClicked()
    {
        // character moves north
        status = directionOfChar.NORTH;
    }


    /**
     * moves the character south
     */
    public void southClicked()
    {
        // character moves south
        status = directionOfChar.SOUTH;
    }


    /**
     * moves the character east
     */
    public void eastClicked()
    {
        // character moves east
        status = directionOfChar.EAST;
    }


    /**
     * moves the character west
     */
    public void westClicked()
    {
        // character moves west
        status = directionOfChar.WEST;
    }


    /**
     * handles the touch events for the maze solver
     *
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     */
    public void processTouch(float x, float y)
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
    }

    /**
     * Accessor method for the character on screen.
     */
    public Character getCharacter()
    {
        return character;
    }
}
