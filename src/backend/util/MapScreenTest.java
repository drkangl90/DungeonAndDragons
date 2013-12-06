package backend.util;


// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Ben
 *  @version Nov 15, 2013
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
     * Tests a click on the screen
     */
    public void testCharacter()
    {
        assertNotNull(getScreen().getCharacter());
        assertEquals(getScreen().getCharacter().getLocation(),
            new Location(0, 0));
    }
}
