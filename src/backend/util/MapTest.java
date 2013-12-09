package backend.util;

import backend.util.Map.MapCell;

// -------------------------------------------------------------------------
/**
 * Test class for the map screen
 *
 * @author Mary-Wynn Rogers (marywynn)
 * @version 2013.11.15
 */
public class MapTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private int      size = 10;
    private Map      map;
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
        map = new Map(size);
        locat = new Location(2, 2);
    }


    // ----------------------------------------------------------
    /**
     * tests the get cell method by setting the cell
     */
    public void testGetCell()
    {
        map.setCell(locat, MapCell.CURRENT_PATH);
        System.out.println(map.getCell(locat));
        assertEquals(MapCell.CURRENT_PATH, map.getCell(locat));
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


    /**
     * Tests the get cell method by setting the cell
     */
    public void testGetCell2()
    {
        map.setCell(new Location(2, 2), MapCell.WALL);
        assertTrue(MapCell.WALL.equals(map.getCell(new Location(2, 2))));
        map.setGoalLocation(new Location(2, 2));
        assertTrue(MapCell.UNEXPLORED.equals(map.getCell(new Location(2, 2))));
    }


    /**
     * Tests the get cell method by setting the cell
     */
    public void testGetCell3()
    {
        map.getCell(new Location(-2, 0));
        map.getCell(new Location(0, -2));
        map.getCell(new Location(size + 1, 1));
        map.getCell(new Location(1, size + 1));

        assertTrue(map.getCell(new Location(-2, 0)).equals(
            map.getCell(new Location(0, -2))));
    }


    /**
     * tests the getcell and setcell method
     */
    public void testgetCell4()
    {
        map.setCell(map.getStartLocation(), MapCell.WALL);
        assertTrue(map.getCell(map.getStartLocation()).equals(MapCell.WALL));
        map.setStartLocation(new Location(0, 0));
        assertFalse(map.getCell(map.getStartLocation()).equals(MapCell.WALL));
        map.setCell(map.getGoalLocation(), MapCell.WALL);
        assertTrue(map.getCell(map.getGoalLocation()).equals(MapCell.WALL));
        map.setGoalLocation(new Location(size - 1, size - 1));
        assertFalse(map.getCell(map.getGoalLocation()).equals(MapCell.WALL));
        map.setCell(locat, MapCell.WALL);
        assertTrue(map.getCell(locat).equals(MapCell.WALL));
        map.setCell(locat, MapCell.CURRENT_PATH);
        assertFalse(map.getCell(locat).equals(MapCell.WALL));

    }


    /**
     * tests the get goal location by setting the goal location
     */
    public void testGetGoalLocation()
    {
        assertEquals(9, map.getGoalLocation().x());
        assertEquals(9, map.getGoalLocation().y());

    }


    /**
     * tests the get start location by setting the start location
     */
    public void testGetStartLocation()
    {
        Location temp = new Location(0, 0);
        map.setCell(temp, MapCell.WALL);
        assertTrue(MapCell.WALL.equals(map.getCell(temp)));
        map.setStartLocation(temp);
        assertTrue(MapCell.UNEXPLORED.equals(map.getCell(temp)));
        assertEquals(temp.toString(), map.getStartLocation().toString());
    }


    /**
     * tests the size of the maze
     */
    public void testSize()
    {
        assertEquals(10, map.size());
    }


    /**
     * tests the size of the maze
     */
    public void testSize1()
    {
        size = 0;
        map = new Map(size);
        assertEquals(0, map.size());
    }

}
