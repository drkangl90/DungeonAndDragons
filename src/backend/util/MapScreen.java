package backend.util;

import android.widget.ProgressBar;
import backend.util.Map.MapCell;
import android.widget.Button;
import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 * Screen displayed for the game.
 *
 * @author Benjamin Robohn (brobohn)
 * @author Alycia Rouffa (arouffa)
 * @author Mary-Wynn Rogers (marywynn)
 * @version Nov 15, 2013
 */

public class MapScreen
    extends ShapeScreen
{
    private Map                map;
    private int                size;
    private Character          character;
    private Monsters           mon;
    private RectangleShape[][] mapArray;
    private float              side;
    public Button              north;
    public Button              south;
    public Button              east;
    public Button              west;
    public Button              fight;
    private directionOfChar    status;
    private ProgressBar        health;
    private ProgressBar        monHealth;
    private Monsters[][]       monsterMap;
    private Key                key;
    private int                level = 1;


    /**
     * Called when the screen is opened.
     */
    public void initialize()
    {
        size = 8;
        map = new Map(size);
        mapArray = new RectangleShape[size][size];
        side = Math.min(getWidth(), getHeight());
        side /= size;
        side--;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                RectangleShape tile =
                    new RectangleShape(
                        i * side,
                        j * side,
                        (i + 1) * side,
                        (j + 1) * side);
                tile.setColor(Color.white);
                tile.setImage("grass");
                add(tile);
                mapArray[i][j] = tile;
            }
        }

        character = new Character(30, 20, 1, 1, (int)side, (int)side);
        character.setLocation(new Location(0, 0));
        add(character);
        status = directionOfChar.EAST;
        monsterMap = new Monsters[size][size];
        for (Monsters[] row : monsterMap)
        {
            for (int i = 0; i < row.length; i++)
            {
                row[i] = null;
            }
        }
        addMonstersLevel1();
        addKey(7, 0);
        health.setVisibility(ProgressBar.VISIBLE);
        health.setProgress(100);
        health.setMax(character.getHealth());
        monHealth.setVisibility(ProgressBar.VISIBLE);
        monHealth.setProgress(30);
        monHealth.setMax(30);
    }


    /**
     * Causes a character to attack a monster, if present.
     */
    public void fightClicked()
    {
        if (character != null)
        {
            ILocation loc =
                new Location(character.getLocation().x(), character
                    .getLocation().y());
            if (status == directionOfChar.NORTH)
            {
                loc = loc.north();
            }
            else if (status == directionOfChar.EAST)
            {
                loc = loc.east();
            }
            else if (status == directionOfChar.SOUTH)
            {
                loc = loc.south();
            }
            else
            {
                loc = loc.west();
            }

            if (map.getCell(loc) == MapCell.MONSTER)
            {
                mon = monsterMap[loc.x()][loc.y()];
                mon.takeDamage(character.attack());
                monHealthBar();

                character.takeDamage(mon.attack());
                this.healthBar();

                if (character.getHealth() <= 0)
                {
                    character.remove();
                    character = null;
                }

                if (mon.getHealth() <= 0)
                {
                    mon.remove();
                    map.setCell(loc, MapCell.UNEXPLORED);
                    monsterMap[loc.x()][loc.y()] = null;
                    mon = null;
                }
            }
        }
    }


    /**
     * the health bar for the character
     */
    public void healthBar()
    {
        int currentPosition = character.getHealth();
        if (character != null)
        {
            currentPosition = character.getHealth();
        }
        health.setProgress(currentPosition);
    }


    /**
     * the health bar for the last monster that was attacked
     */
    public void monHealthBar()
    {
        int currentPosition = mon.getHealth();
        monHealth.setProgress(currentPosition);
        if (mon != null)
        {
            currentPosition = mon.getHealth();
        }
        monHealth.setProgress(currentPosition);
    }


    /**
     * Adds a Monster to the map.
     *
     * @param loc
     *            the location at which to add the monster
     */
    public void addMonster(ILocation loc)
    {
        Monsters monster =
            new Monsters(loc.x() * side + 1, loc.y() * side + 1, (loc.x() + 1)
                * side + 1, (loc.y() + 1) * side + 1);
        map.setCell(loc, MapCell.MONSTER);
        add(monster);
        monsterMap[loc.x()][loc.y()] = monster;
    }


    /**
     * Adds the Monsters preset for level one.
     */
    public void addMonstersLevel1()
    {
        addMonster(new Location(3, 3));
        addMonster(new Location(2, 6));
        addMonster(new Location(7, 7));
    }


    /**
     * Adds the Monsters preset for level two.
     */
    public void addMonstersLevel2()
    {
        addMonster(new Location(2, 3));
        addMonster(new Location(1, 4));
        addMonster(new Location(7, 7));
        addMonster(new Location(8, 5));
        addMonster(new Location(7, 8));
    }


    /**
     * Adds the Monsters preset for level three.
     */
    public void addMonstersLevel3()
    {
        addMonster(new Location(2, 5));
        addMonster(new Location(5, 2));
        addMonster(new Location(6, 7));
        addMonster(new Location(8, 3));
        addMonster(new Location(6, 8));
        addMonster(new Location(1, 3));
        addMonster(new Location(7, 3));
    }


    /**
     * Sets the location and adds to the screen
     *
     * @param x
     *            the x coordinate of the key
     * @param y
     *            the y coordinate of the key
     */
    public void addKey(int x, int y)
    {
        key =
            new Key(x * side + 1, y * side + 1, (x + 1) * side + 1, (y + 1)
                * side + 1);
        key.setLocation(x, y);
        key.setImage("key");
        add(key);
    }


    /**
     * moves the character north
     */
    public void northClicked()
    {
        if (character != null)
        {
            // character moves north
            status = directionOfChar.NORTH;
            ILocation loc = character.getLocation().north();
            character.setDirection(status);
            if (character.getLocation().y() > 0
                && map.getCell(loc) != MapCell.MONSTER)
            {
                character.moveBy(0, -side);
                character.setLocation(loc);
                reachedGoal();
            }
        }
    }


    /**
     * moves the character south
     */
    public void southClicked()
    {
        if (character != null)
        {
            // character moves south
            status = directionOfChar.SOUTH;
            ILocation loc = character.getLocation().south();
            character.setDirection(status);
            if (character.getLocation().y() < size - 1
                && map.getCell(loc) != MapCell.MONSTER)
            {
                character.moveBy(0, side);
                character.setLocation(loc);
                reachedGoal();
            }
        }
    }


    /**
     * moves the character east
     */
    public void eastClicked()
    {
        if (character != null)
        {
            // character moves east
            status = directionOfChar.EAST;
            ILocation loc = character.getLocation().east();
            character.setDirection(status);
            if (character.getLocation().x() < size - 1
                && map.getCell(loc) != MapCell.MONSTER)
            {
                character.moveBy(side, 0);
                character.setLocation(loc);
                reachedGoal();
            }
        }
    }


    /**
     * moves the character west
     */
    public void westClicked()
    {
        if (character != null)
        {
            // character moves west
            status = directionOfChar.WEST;
            ILocation loc = character.getLocation().west();
            character.setDirection(status);
            if (character.getLocation().x() > 0
                && map.getCell(loc) != MapCell.MONSTER)
            {
                character.moveBy(-side, 0);
                character.setLocation(loc);
                reachedGoal();
            }
        }
    }


    /**
     * Accessor method for the character on screen.
     *
     * @return returns the character being called.
     */
    public Character getCharacter()
    {
        return character;
    }


    /**
     * Reaching the goal.
     */
    public void reachedGoal()
    {
        boolean allDead = true;

        for (Monsters[] row : monsterMap)
        {
            for (Monsters monster : row)
            {
                if (monster != null)
                {
                    allDead = false;
                }
            }
        }

        if (character.getLocation().equals(key.getLocation()) && allDead)
        {
            key.remove(); // You Win
            level++;
            if (level == 2)
            {
                level2();
            }
            if (level == 3)
            {
                level3();
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Initiates Level 2
     */
    public void level2()
    {
        character.remove();
        size++;
        map = new Map(size);
        mapArray = new RectangleShape[size][size];
        side = Math.min(getWidth(), getHeight());
        side /= size;
        side--;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                RectangleShape tile =
                    new RectangleShape(
                        i * side,
                        j * side,
                        (i + 1) * side,
                        (j + 1) * side);
                tile.setColor(Color.white);
                tile.setImage("grass");
                add(tile);
                mapArray[i][j] = tile;
            }
        }

        character = new Character(37, 27, 1, 1, (int)side, (int)side);
        character.setLocation(new Location(0, 0));
        add(character);
        status = directionOfChar.EAST;
        monsterMap = new Monsters[size][size];
        for (Monsters[] row : monsterMap)
        {
            for (int i = 0; i < row.length; i++)
            {
                row[i] = null;
            }
        }
        addMonstersLevel2();
        addKey(8, 3);
        healthBar();
    }


    // ----------------------------------------------------------
    /**
     * Initiates Level 3
     */
    public void level3()
    {
        character.remove();
        size++;
        map = new Map(size);
        mapArray = new RectangleShape[size][size];
        side = Math.min(getWidth(), getHeight());
        side /= size;
        side--;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                RectangleShape tile =
                    new RectangleShape(
                        i * side,
                        j * side,
                        (i + 1) * side,
                        (j + 1) * side);
                tile.setColor(Color.white);
                tile.setImage("grass");
                add(tile);
                mapArray[i][j] = tile;
            }
        }

        character = new Character(43, 33, 1, 1, (int)side, (int)side);
        character.setLocation(new Location(0, 0));
        add(character);
        status = directionOfChar.EAST;
        monsterMap = new Monsters[size][size];
        for (Monsters[] row : monsterMap)
        {
            for (int i = 0; i < row.length; i++)
            {
                row[i] = null;
            }
        }
        addMonstersLevel3();
        addKey(7, 9);
        healthBar();
    }


    /**
     * Returns the map
     *
     * @return the map
     */
    public Map getMap()
    {
        return map;
    }


    /**
     * Returns the monster
     *
     * @return the current monster
     */
    public Monsters getMonster()
    {
        return mon;
    }
}
