package backend.util;

import java.util.Stack;

// -------------------------------------------------------------------------
/**
 * Class that creates the world in which can be explored. All cells that the
 * character has not explored are marked unexplored, while the path the
 * character is on is marked as current path, and cells that the character can
 * not move over are marked as invalid paths.
 *
 * @author Mary-Wynn Rogers (marywynn)
 * @version 2013.11.11
 */
public class Map
{
    private int                size;
    private MapCell[][]        world;
    private ILocation          start;
    /**
     * stack to store the location of where the character has already been
     */
    protected Stack<ILocation> stack;


    // -------------------------------------------------------------------------
    /**
     * the type of cells in the world
     */
    public enum MapCell
    {
        /**
         * cell that has yet to have been explored
         */
        UNEXPLORED,
        /**
         * cell that is currently on
         */
        CURRENT_PATH,
        /**
         * cell that can't be traversed
         */
        INVALID_CELL;
    }


    /**
     * constructor of the map. creates a new map object that can then be
     * explored by a character
     *
     * @param size
     *            the size of the world
     */
    public Map(int size)
    {
        this.size = size;
        world = new MapCell[size][size];
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                Location club = new Location(x, y);
                setCell(club, MapCell.UNEXPLORED);
            }
        }
        start = new Location(0, 0);
        this.stack = new Stack<ILocation>();
    }


    /**
     * gets the type of cell
     *
     * @param location
     *            the location in the maze
     * @return returns the location of a cell
     */
    public MapCell getCell(ILocation location)
    {
        if (location.x() < size && location.y() < size && location.x() > -1
            && location.y() > -1)
        {
            return world[location.x()][location.y()];
        }
        else
        {
            return MapCell.INVALID_CELL;
        }
    }


    /**
     * gets the start location of the board returns the starting location
     *
     * @return returns the starting location
     */
    public ILocation getStartLocation()
    {
        return start;
    }


    /**
     * sets the cell
     *
     * @param location
     *            the location of the cell you want to set
     * @param cell
     *            the cell that is going to be changed
     */
    public void setCell(ILocation location, MapCell cell)
    {
        int x = location.x();
        int y = location.y();
        if (!location.equals(start))
        {
            System.out.println("test - " + location.x() + ", " + location.y());
            world[location.x()][location.y()] = cell;

        }
        else
        {
            world[x][y] = cell;
        }
    }


    /**
     * sets the starting location
     *
     * @param location
     *            the location for starting the maze
     */
    public void setStartLocation(ILocation location)
    {
        setCell(location, MapCell.UNEXPLORED);
        start = location;
    }


    /**
     * returns the size of the maze
     *
     * @return returns the size of the maze
     */
    public int size()
    {
        return size;
    }


    /**
     * prints a view of the map
     */
    private void printMaze()
    {
        for (int y = 0; y < size; y++)
        { //
            System.out.print("+------+");
            String row = "";
            for (int x = 0; x < size; x++)
            {
                System.out.print("+------+");
                row += "| " + cellDesc(new Location(x, y)) + " |";
            }
            System.out.println("\n" + row);
        }
    }


    /**
     * provides a string of a certain cell
     */
    private String cellDesc(ILocation loc)
    {
        String str = "WALL";
        if (getCell(loc) == MapCell.INVALID_CELL)
        {
            str = "INVD";
        }
        else if (getCell(loc) == MapCell.CURRENT_PATH)
        {
            str = "CURR";
        }
        else if (getCell(loc) == MapCell.UNEXPLORED)
        {
            str = "UNEX";
        }
        return str;
    }


    /**
     * the string of the locations the character has already been
     *
     * @return either returns the string of the path of the character or it
     *         returns null
     */
    public String path()
    {
        printMaze();

        int x = 0;
        stack = new Stack<ILocation>();
        stack.push(start);
        x++;

        while (!stack.isEmpty())
        {
            ILocation temp = stack.peek();
            setCell(temp, MapCell.CURRENT_PATH);
            System.out.println("Iterating...");
            System.out.println("CURRENT: " + cellDesc(temp));
            System.out.println("\tNORTH: " + cellDesc(temp.north()));
            System.out.println("\tSOUTH: " + cellDesc(temp.south()));
            System.out.println("\tEAST: " + cellDesc(temp.east()));
            System.out.println("\tWEST: " + cellDesc(temp.west()));

            if (getCell(temp.north()).equals(MapCell.UNEXPLORED))
            {
                System.out.println("Pushing -" + temp.north().x() + ","
                    + temp.north().y());
                stack.push(temp.north());
                x++;
            }
            else if (getCell(temp.east()).equals(MapCell.UNEXPLORED))
            {
                System.out.println("Pushing -" + temp.east().x() + ","
                    + temp.east().y());
                stack.push(temp.east());
                x++;
            }
            else if (getCell(temp.south()).equals(MapCell.UNEXPLORED))
            {
                System.out.println("Pushing -" + temp.south().x() + ","
                    + temp.south().y());
                stack.push(temp.south());
                x++;
            }
            else
            {
                System.out.println("Pushing -" + temp.west().x() + ""
                    + temp.west().y());
                stack.push(temp.west());
                x++;
            }
        }
        return null;
    }
}
