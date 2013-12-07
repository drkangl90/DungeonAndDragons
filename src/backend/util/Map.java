package backend.util;

import sofia.graphics.RectangleShape;
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
public class Map extends RectangleShape
{
    private int                size;
    private MapCell[][]        world;
    private ILocation          start;
    private ILocation          goal;
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
         * cell with the Key
         */
        KEY,
        /**
         * cell with a wall
         */
        WALL,
        /**
         * cell that can't be traversed
         */
        INVALID_CELL,
        /**
         * cell that contains a Monster
         */
        MONSTER;
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
                //setImage("grass");
            }
        }
        start = new Location(0, 0);
        goal = new Location(0, 0);
        if (size > 0)
        {
            goal = new Location(size - 1, size - 1);
        }
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
     * gets the goal location in the maze
     *
     * @return returns the goal location
     */
    public ILocation getGoalLocation()
    {
        return goal;
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
        if (cell == MapCell.WALL
            && !(location.equals(goal) || location.equals(start)))
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
        if (getCell(location) == MapCell.WALL)
        {
            setCell(location, MapCell.UNEXPLORED);
        }
        start = location;
    }


    /**
     * sets the goal location
     *
     * @param location
     *            the location for the goal
     */
    public void setGoalLocation(ILocation location)
    {
        if (getCell(location) == MapCell.WALL)
        {
            setCell(location, MapCell.UNEXPLORED);
        }
        goal = location;
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


    /**
     * Calculates distance between the character and a monster.
     */
    public int getDistance(/* Monster mon */)
    {
        /*
         * int charX = MapScreen.getCharacter().getX(); int charY =
         * MapScreen.getCharacter().getY(); int monsX =
         * MapScreen.getMonster().getX(); int monsY =
         * MapScreen.getMonster().getY(); return Math.sqrt(Math.pow(charX -
         * monsX, 2) + Math.pow(charY - monsY, 2));
         */

        return 0;
    }


    /**
     * Loads a board based on the strings given. O = UNEXPLORED W = WALL K = KEY
     * S = Start G = Goal
     *
     * @param board
     *            the rows given to build the board
     */
    public void loadBoardState(String... board)
    {
        String[] rows = board;

        for (int i = 0; i < rows.length; i++)
        {
            for (int j = 0; j < rows.length; j++)
            {
                if (rows[j].charAt(i) == 'W')
                {
                    ILocation loc = new Location(i, j);
                    setCell(loc, MapCell.WALL);
                }
                else if (rows[j].charAt(i) == 'K')
                {
                    ILocation loc = new Location(i, j);
                    setCell(loc, MapCell.KEY);
                }
                else if (rows[j].charAt(i) == 'S')
                {
                    ILocation loc = new Location(i, j);
                    setStartLocation(loc);
                }
                else if (rows[j].charAt(i) == 'G')
                {
                    ILocation loc = new Location(i, j);
                    setGoalLocation(loc);
                }
            }
        }
    }
}
