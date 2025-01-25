package ca.mcmaster.se2aa4.mazerunner;

/*
 * Coordinate class to help track the position of the runner, entry and exit in the maze.
 */

public class Coordinate {
    private int cordX;
    private int cordY;

    /**
     * Constructor to initialize the coordinate with given x and y values.
     * 
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Coordinate(int x, int y) {
        cordX = x;
        cordY = y;
    }

    /**
     * Gets the x coordinate.
     * 
     * @return The x coordinate.
     */
    public int getX() {
        return cordX;
    }

    /**
     * Gets the y coordinate.
     * 
     * @return The y coordinate.
     */
    public int getY() {
        return cordY;
    }

    /**
     * Moves the coordinate forward based on the orientation.
     * 
     * @param orientation The direction to move the coordinate.
     */
    public void move(Orientation orientation){
        // TODO: Implementation to move the coordinate based on the orientation
    }
}

