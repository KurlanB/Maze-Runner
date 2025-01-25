package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * The maze chosen and its properties.
 */

public class Maze {

    private static final Logger logger = LogManager.getLogger();

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
        try {
            logger.info("**** Reading the maze from file " + filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            
            //Constructing maze from file
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        logger.debug("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        logger.debug("PASS ");
                    }
                }
                logger.debug(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ Could not read maze from file /!\\");
        }
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
     * @param path The path to check.
     * @return True if the path is correct, false otherwise.
     */
    public boolean checkPathEast(String path){
        // TODO: Implementation to check if the path given is correct from the east
    }

    /**
     * Checks if the path given is correct from the west.
     * 
     * @param path The path to check.
     * @return True if the path is correct, false otherwise.
     */
    public boolean checkPathWest(String path){
        // TODO: Implementation to check if the path given is correct from the west
    }
}
