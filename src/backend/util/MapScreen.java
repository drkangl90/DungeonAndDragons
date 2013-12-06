package backend.util;


import sofia.graphics.OvalShape;
import backend.util.Character.State;
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
    private boolean            hasBeenClicked = false; // for testing
    private Button             north;
    private Button             south;
    private Button             east;
    private Button             west;
    private Button             fight;
    private Button             defend;
    private Button             flee;
    private ProgressBar        health;
    private State              status;
    private OvalShape  start;
    private OvalShape  goal;


    public void initialize()
    {
        map = new Map(8);
        mapArray = new RectangleShape[8][8];
        side = Math.min(getWidth(), getHeight());
        side /= 8;
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
        north.setEnabled(true);
        south.setEnabled(true);
        east.setEnabled(true);
        west.setEnabled(true);
        fight.setEnabled(false);
        defend.setEnabled(false);
        flee.setEnabled(false);

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
        setHasBeenClicked(true);
    }


    // ----------------------------------------------------------
    /**
     * @return the hasBeenClicked
     */
    public boolean isHasBeenClicked()
    {
        return hasBeenClicked;
    }


    // ----------------------------------------------------------
    /**
     * @param hasBeenClicked
     *            the hasBeenClicked to set
     */
    public void setHasBeenClicked(boolean hasBeenClicked)
    {
        this.hasBeenClicked = true;
    }


    /**
     * moves the character north
     */
    public void northClicked()
    {
        // character moves north
        status = State.NORTH;
    }


    /**
     * moves the character south
     */
    public void southClicked()
    {
        // character moves south
        status = State.SOUTH;
    }


    /**
     * moves the character east
     */
    public void eastClicked()
    {
        // character moves east
        status = State.EAST;
    }


    /**
     * moves the character west
     */
    public void westClicked()
    {
        // character moves west
        status = State.WEST;
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

        if (status == State.NORTH)
        {
            character.setDirection(State.NORTH);
            character.setLocation(State.NORTH);
        }
        else if (status == State.EAST)
        {
            character.setDirection(State.EAST);
            character.setLocation(State.EAST);
        }
        else if (status == State.SOUTH)
        {
            character.setDirection(State.SOUTH);
            character.setLocation(State.SOUTH);
        }
        else if (status == State.WEST)
        {
            character.setDirection(State.WEST);
            character.setLocation(State.WEST);
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
}
