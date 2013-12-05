package backend.util;

import sofia.graphics.RectangleShape;
import sofia.graphics.Color;
//import android.graphics.Color;

// -------------------------------------------------------------------------
/**
 *  The MapScreen will have all of the GUI for this project.
 *
 *  @author Ben
 *  @version Nov 15, 2013
 */

public class MapScreen
    extends sofia.app.ShapeScreen
{
    private Map map;
    private RectangleShape[][] mapArray;
    private float side;
    private boolean hasBeenClicked = false; //for testing

    public void initialize()
    {
        map = new Map(8);
        mapArray  = new RectangleShape[8][8];
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
     * @param hasBeenClicked the hasBeenClicked to set
     */
    public void setHasBeenClicked(boolean hasBeenClicked)
    {
        this.hasBeenClicked = true;
    }

}
