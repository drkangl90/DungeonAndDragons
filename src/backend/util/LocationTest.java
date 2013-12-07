package backend.util;

/**
 * This class tests the location class that the methods within are working
 * properly
 *
 * @author Mary-Wynn Rogers (marywynn)
 * @version 2013.12.07
 */
public class LocationTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private final int w = 10;
    private final int h = 10;
    private ILocation map;


    // ~ Constructor ...........................................................

    /**
     * Creates a new Maze object.
     */
    public LocationTest()
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
        map = new Location(w, h);
    }


    // ~ Test Cases ------------------------------------------------------------

    /**
     * tests the height of board
     */
    public void testY()
    {
        assertEquals(h, map.y());
    }


    /**
     * tests the width of the board
     */
    public void testX()
    {
        assertEquals(w, map.x());
    }


    /**
     * test that it returns location east of set position
     */
    public void testEast()
    {
        assertEquals(11, map.east().x());
        assertEquals(10, map.east().y());
    }


    /**
     * test that it returns location north of set position
     */
    public void testNorth()
    {
        assertEquals(10, map.north().x());
        assertEquals(9, map.north().y());
    }


    /**
     * test that it returns location south of set position
     */
    public void testSouth()
    {
        assertEquals(10, map.south().x());
        assertEquals(11, map.south().y());
    }


    /**
     * test that it returns location west of set position
     */
    public void testWest()
    {
        assertEquals(9, map.west().x());
        assertEquals(10, map.west().y());
    }


    /**
     * Tests the to string method
     */
    public void testToString()
    {
        assertEquals("(10, 10)", map.toString());
    }


    /**
     * tests the equals method
     */
    public void testEquals()
    {
        ILocation locat1 = new Location(10, 10);
        assertTrue(map.equals(locat1));
        ILocation locat2 = new Location(5, 5);
        assertFalse(locat1.equals(locat2));
    }
}
