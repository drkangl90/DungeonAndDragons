package backend.util;

import student.TestCase;

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
    public MapScreenTest()
    {
        super(MapScreen.class);
    }

    public void testFirstClick()
    {
        getScreen().onTouchDown(1, 1);
        assertTrue(getScreen().isHasBeenClicked());
    }
}
