package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

/*
 * The maze chosen and its properties.
 */

public class Maze {

    // 2d ArrayList of boolean to store the maze layout, where false represents a wall 
    private final ArrayList<ArrayList<Boolean>> maze = new ArrayList<ArrayList<Boolean>>();

    private Coordinate entry;
    
    private Coordinate exit;


    /**
     * Constructor to initialize the maze from a file.
     * 
     * @param filePath The path to the maze file.
     */
    public Maze(String filePath) {
        // TODO: Implementation to read the maze from the file and initialize the maze grid
    }

    /**
     * Finds the entry point of the maze.
     * 
     * @return The coordinate of the entry point.
     */
    public Coordinate findEntry(){
        // TODO: Implementation to find the entry point of the maze
    }

    /**
     * Gets the entry point of the maze.
     * 
     * @return The coordinate of the entry point.
     */
    public Coordinate getEntry() {
        return entry;
    }

    /**
     * Finds the exit point of the maze.
     * 
     * @return The coordinate of the exit point.
     */
    public Coordinate findExit(){
        // TODO: Implementation to find the exit point of the maze
    }

    /**
     * Gets the exit point of the maze.
     * 
     * @return The coordinate of the exit point.
     */
    public Coordinate getExit() {
        return exit;
    }

    /**
     * Gets the length of the maze.
     * 
     * @return The length of the maze.
     */
    public int getLength(){
        // TODO: Implementation to get the length of the maze
    }

    /**
     * Gets the width of the maze.
     * 
     * @return The width of the maze.
     */
    public int getWidth(){
        // TODO: Implementation to get the width of the maze
    }

    /**
     * Checks if the coordinate is open.
     * 
     * @param c The coordinate to check.
     * @return True if the coordinate is open, false otherwise.
     */
    public boolean isOpen(Coordinate c) {
        // TODO: Implementation to check if the coordinate is open
    }

    /**
     * Checks if the path given is correct from the east.
     * 
     * @return True if the path is correct, false otherwise.
     */
    public boolean checkPathEast(){
        // TODO: Implementation to check if the path given is correct from the east
    }

    /**
     * Checks if the path given is correct from the west.
     * 
     * @return True if the path is correct, false otherwise.
     */
    public boolean checkPathWest(){
        // TODO: Implementation to check if the path given is correct from the west
    }
}
