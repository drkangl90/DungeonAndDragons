package backend.util;

import sofia.graphics.Color;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 *  Creates the key object on a cell of the map. To be implemeted
 *  by MapScreen.
 *
 *  @author Alycia Rouffa (arouffa)
 *  @version 12.07.13
 */
public class Key extends RectangleShape
{
    private Location keyLoc;

    /**
     * Place a description of your method here.
     * @param left The left position of the key
     * @param top The top position of the key
     * @param right The right position of the key
     * @param bottom The bottom position of the key
     */
    public Key(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setFillColor(Color.gold);
        keyLoc = new Location(7, 0);
    }

    /**
     * gets the location of the key
     *
     * @return returns the location that the key is
     */
    public ILocation getLocation()
    {
        return keyLoc;
    }

    /**
     * sets the location of the key
     *
     * @return returns the location that the key is
     */
    public ILocation setLocation()
    {
        return keyLoc;
    }
}
