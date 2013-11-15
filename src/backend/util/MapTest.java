package backend.util;

import backend.util.Map.MapCell;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Mary-Wynn Rogers (marywynn)
 *  @version 2013.11.15
 */
public class MapTest extends student.TestCase
{
 // ~ Fields ................................................................
    private int size = 10;
    private Map map;
    private Location locat;

 // ~ Constructor ...........................................................

    /**
     * Creates a new MapTest object.
     */
    public MapTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    // ~ Public methods ........................................................

    /**
     * Called before each test to initialize a fresh state.
     */
    public void setUp()
    {
       map = new Map(size);        locat = new Location(2, 2);
    }

    // ----------------------------------------------------------
    /**
     * tests the get cell method by setting the cell
     */
    public void testGetCell()
    {
        map.setCell(locat,  MapCell.CURRENT_PATH);
        System.out.println(map.getCell(locat));
        assertTrue(MapCell.CURRENT_PATH.equals(map.getCell(locat)));
    }

    // ----------------------------------------------------------
    /**
     * tests the get cell method by setting the start location
     */
    public void testGetCell1()
    {
        map.setCell(locat, MapCell.WALL);
        assertTrue(MapCell.WALL.equals(map.getCell(locat)));
        map.setStartLocation(locat);
        assertTrue(MapCell.UNEXPLORED.equals(map.getCell(locat)));
    }
}
