package backend.util;

// import backend.util.Character.directionOfChar;

// -------------------------------------------------------------------------
/**
 * This interface represents an (x, y) coordinate pair, used to indicate cell
 * locations in the maze.
 *
 * @author Mary-Wynn Rogers (marywynn)
 * @version 2013.11.11
 */
public class Location
    implements ILocation
{
    /**
     * location for map
     */
    Location[][]  map;
    /**
     * x location of map
     */
    protected int x;
    /**
     * y location of map
     */
    protected int y;


    // private State status;

    // ----------------------------------------------------------
    /**
     * Create a new Location object.
     *
     * @param x
     *            the x location
     * @param y
     *            the y location
     */
    public Location(int x, int y)
    {
        if (x >= 0 && y >= 0)
        {
            this.x = x;
            this.y = y;
            map = new Location[x][y];
        }
    }


    /**
     * Gets the x-coordinate of the location.
     *
     * @return returns the x position
     */
    public int x()
    {
        return x;
    }


    /**
     * Gets the y-coordinate of the location.
     *
     * @return returns the y location
     */
    public int y()
    {
        return y;
    }


    /**
     * Gets a new location that represents the (x, y) coordinates one cell east
     * of this location.
     *
     * @return returns the location east
     */
    public ILocation east()
    {
        return new Location(x + 1, y);
    }


    /**
     * Gets a new location that represents the (x, y) coordinates one cell north
     * of this location.
     *
     * @return returns the location north
     */
    public ILocation north()
    {
        return new Location(x, y - 1);
    }


    /**
     * Gets a new location that represents the (x, y) coordinates one cell south
     * of this location.
     *
     * @return returns the location south
     */
    public ILocation south()
    {
        return new Location(x, y + 1);
    }


    /**
     * Gets a new location that represents the (x, y) coordinates one cell west
     * of this location.
     *
     * @return returns the location west
     */
    public ILocation west()
    {
        return new Location(x - 1, y);
    }


    /**
     * true if one object equals another, false if they don't
     *
     * @param object
     *            an object that is getting compared
     * @return returns true of object = map, false if not
     */
    public boolean equals(Object object)
    {
        return object instanceof Location
            && (this.x() == (((Location)object).x()) && this.y() == (((Location)object)
                .y()));
    }


    /**
     * returns a string representation of the location
     *
     * @return returns a string of coordinates in terms of x and y
     */
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
