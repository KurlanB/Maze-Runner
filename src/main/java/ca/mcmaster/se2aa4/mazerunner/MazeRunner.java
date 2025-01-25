package ca.mcmaster.se2aa4.mazerunner;

/*
 * Interface to define the method for the maze runner to solve the maze.
 */
public interface MazeRunner {
    /**
     * Method to escape the maze.
     * 
     * @param maze The maze to escape.
     * @return The path to escape the maze.
     */
    public String escapeMaze(Maze maze);
}
