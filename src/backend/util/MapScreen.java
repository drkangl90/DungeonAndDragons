package backend.util;

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
    }


    /**
     * moves the character south
     */
    public void southClicked()
    {
        // character moves south
    }


    /**
     * moves the character east
     */
    public void eastClicked()
    {
        // character moves east
    }


    /**
     * moves the character west
     */
    public void westClicked()
    {
        // character moves west
    }
}
