package backend.util;

// -------------------------------------------------------------------------
/**
 * Test Cases for the MapScreen
 *
 * @author Benjamin Robohn (brobohn)
 * @author Alycia Rouffa (arouffa)
 * @author Mary-Wynn Rogers (marywynn)
 * @version Nov 15, 2013
 */

public class MapScreenTest
    extends student.AndroidTestCase<MapScreen>
{
    // ----------------------------------------------------------
    /**
     * Create a new MapScreenTest object.
     */
    public MapScreenTest()
    {
        super(MapScreen.class);
    }


    // ----------------------------------------------------------
    /**
     * Tests the initial set up of the screen
     */
    public void testInitialize()
    {
        assertNotNull(getScreen().getCharacter());
        assertEquals(getScreen().getCharacter().getLocation(), new Location(
            0,
            0));
    }


    /**
     * Tests starting Level 2
     */
    public void testLevel2()
    {
        getScreen().level2();
        assertNotNull(getScreen().getCharacter());
        assertEquals(getScreen().getCharacter().getHealth(), 37);
    }


    /**
     * Tests starting Level 3
     */
    public void testLevel3()
    {
        getScreen().level3();
        assertNotNull(getScreen().getCharacter());
        assertEquals(getScreen().getCharacter().getHealth(), 43);
    }


    /**
     * Tests the movement of the character around the corners of map
     */
    public void testMovement()
    {
        getScreen().northClicked();
        assertEquals(new Location(0, 0), getScreen().getCharacter()
            .getLocation());
        getScreen().westClicked();
        assertEquals(new Location(0, 0), getScreen().getCharacter()
            .getLocation());

        getScreen().eastClicked();
        assertEquals(new Location(1, 0), getScreen().getCharacter()
            .getLocation());
        getScreen().southClicked();
        assertEquals(new Location(1, 1), getScreen().getCharacter()
            .getLocation());

        //move to the bottom right of the screen
        getScreen().getCharacter().setLocation(new Location(7, 7));

        getScreen().eastClicked();
        assertEquals(new Location(7, 7), getScreen().getCharacter()
            .getLocation());
        getScreen().southClicked();
        assertEquals(new Location(7, 7), getScreen().getCharacter()
            .getLocation());

        getScreen().northClicked();
        assertEquals(new Location(7, 6), getScreen().getCharacter()
            .getLocation());
        getScreen().westClicked();
        assertEquals(new Location(6, 6), getScreen().getCharacter()
            .getLocation());

    }
}
