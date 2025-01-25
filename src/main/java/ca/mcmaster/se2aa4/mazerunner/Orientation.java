package ca.mcmaster.se2aa4.mazerunner;

public enum Orientation {
    NORTH,
    SOUTH,
    EAST,
    WEST;

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
