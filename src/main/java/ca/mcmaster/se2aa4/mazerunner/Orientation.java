package ca.mcmaster.se2aa4.mazerunner;

/**
 * The Orientation enum represents the four directions and methods when turning right or left.
 */
public enum Orientation {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    /**
     * Turns the orientation to the right.
     * 
     * @return The new orientation after turning right.
     */
    public Orientation turnRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
        }
        throw new IllegalStateException("Invalid orientation");
    }

    /**
     * Turns the orientation to the left.
     * 
     * @return The new orientation after turning left.
     */
    public Orientation turnLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
        }
        throw new IllegalStateException("Invalid orientation");
    }
}
