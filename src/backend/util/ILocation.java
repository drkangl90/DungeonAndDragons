package backend.util;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Mary-Wynn Rogers (marywynn)
 *  @version 2013.11.11
 */
public interface ILocation
{
    // ~ Methods ...............................................................
    /**
     * Gets a new location that represents the (x, y) coordinates one cell east
     * of this location.
     *
     * @return returns the location east
     */
    ILocation east();

    /**
     * Gets a new location that represents the (x, y) coordinates one cell west
     * of this location.
     *
     * @return returns the location west
     */
    ILocation west();

    /**
     * Gets a new location that represents the (x, y) coordinates one cell north
     * of this location.
     *
     * @return returns the location north
     */
    ILocation north();

    /**
     * Gets a new location that represents the (x, y) coordinates one cell south
     * of this location.
     *
     * @return returns the location south
     */
    ILocation south();

    /**
     * Gets the x-coordinate of the location.
     *
     * @return returns the x position
     */
    int x();

    /**
     * Gets the y-coordinate of the location.
     *
     * @return returns the y location
     */
    int y();

    /**
     * true if one object equals another, false if they don't
     *
     * @param object
     *            an object that is getting compared
     * @return returns true of object = maze, false if not
     */
    boolean equals(Object object);

}
