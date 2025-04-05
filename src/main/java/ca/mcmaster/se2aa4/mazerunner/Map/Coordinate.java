package ca.mcmaster.se2aa4.mazerunner.Map;

/*
 * Coordinate class to help track the position of the runner, entry and exit in the maze.
 */

public class Coordinate {
    private int cordX;
    private int cordY;
    private Orientation orientation;

    /**
     * Constructor to initialize the coordinate with given x and y values.
     * 
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Coordinate(int x, int y) {
        this.cordX = x;
        this.cordY = y;
        this.orientation = Orientation.EAST;
    }

    /**
     * Constructor to initialize the coordinate with given x and y values and an orientation.
     * 
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param orientation The orientation of the coordinate.
     */
    public Coordinate(int x, int y, Orientation orientation) {
        this.cordX = x;
        this.cordY = y;
        this.orientation = orientation;
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
     * Gets the orientation of the coordinate.
     * 
     * @return The orientation of the coordinate.
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Moves the coordinate forward based on the orientation.
     * 
     * @param orientation The direction to move the coordinate.
     */
    public void moveForward(){
        switch(orientation){
            case NORTH:
                cordY--;
                break;
            case SOUTH:
                cordY++;
                break;
            case EAST:
                cordX++;
                break;
            case WEST:
                cordX--;
                break;
        }
    }

    /**
     * Turns the coordinate to the right.
     */
    public void turnRight(){
        this.orientation = orientation.turnRight();
    }

    /**
     * Turns the coordinate to the left.
     */
    public void turnLeft(){
        this.orientation = orientation.turnLeft();
    }   
}

