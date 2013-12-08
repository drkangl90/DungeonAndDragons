package backend.util;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the key class
 *
 * @author Alycia Rouffa (arouffa)
 * @version 12.08.13
 */
public class KeyTest
    extends TestCase
{
    private Key      key;
    private Location location;


    /**
     * Creates the key object
     */
    public void setUp()
    {
        key = new Key(0, 0, 0, 0);
        location = new Location(7, 0);
    }


    /**
     * Tests the getters and setters of the key.
     */
    public void testKey()
    {
        assertTrue(key.getLocation().equals(location));

        key.setLocation(0, 0);
        assertFalse(key.getLocation().equals(location));

    }

}
