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

    private final Coordinate entry;
    
    private final Coordinate exit;

    /**
     * Constructor to initialize the maze from a file.
     * 
     * @param filePath The path to the maze file.
     */
    public Maze(String filePath) throws Exception {
        logger.info("**** Reading the maze from file " + filePath);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        
        //Constructing maze from file
        String line;
        while ((line = reader.readLine()) != null) {
            ArrayList<Boolean> row = new ArrayList<>();

            //Adding maze to 2d ArrayList
            logger.debug("Reading lines of maze");
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    logger.debug("WALL ");
                    row.add(false);
                } else if (line.charAt(idx) == ' ') {
                    logger.debug("PASS ");
                    row.add(true);
                }
            }
            logger.debug(System.lineSeparator());
            this.maze.add(row);
        }
        logger.info("**** Finding entry and exit points");

        this.entry = findEntry();
        this.exit = findExit();
        
        logger.info("**** Found entry and exit points");

        reader.close();
    }

    /**
     * Finds the entry point of the maze.
     * 
     * @return The coordinate of the entry point.
     */
    private Coordinate findEntry() throws Exception{
        for(int i = 0; i < getLength(); i++){
            Coordinate current = new Coordinate(0, i);
            if(isOpen(current)){
                return current;
            }
        }

        throw new Exception("No entry point found");
    }

    /**
     * Gets the entry point of the maze.
     * 
     * @return The coordinate of the entry point.
     */
    public Coordinate getEntry() {
        return this.entry;
    }

    /**
     * Finds the exit point of the maze.
     * 
     * @return The coordinate of the exit point.
     */
    private Coordinate findExit() throws Exception{
        for(int i = 0; i < getLength(); i++){
            Coordinate current = new Coordinate(getWidth() - 1, i);
            if(isOpen(current)){
                return current;
            }
        }

        throw new Exception("No exit point found");
    }

    /**
     * Gets the exit point of the maze.
     * 
     * @return The coordinate of the exit point.
     */
    public Coordinate getExit() {
        return this.exit;
    }

    /**
     * Gets the length of the maze.
     * 
     * @return The length of the maze.
     */
    public int getLength(){
        return maze.size();
    }

    /**
     * Gets the width of the maze.
     * 
     * @return The width of the maze.
     */
    public int getWidth(){
        return maze.get(0).size();
    }

    /**
     * Checks if the coordinate is open.
     * 
     * @param c The coordinate to check.
     * @return True if the coordinate is open, false otherwise.
     */
    public boolean isOpen(Coordinate c) {
        return maze.get(c.getY()).get(c.getX());
    }

    /**
     * Checks if the path given is correct.
     * 
     * @param path The path to check.
     * @return True if the path is correct, false otherwise.
     */
    public boolean checkPath(String path){
        logger.info("***Checking Path");
        return checkPathBoth(path, this.exit, this.entry, Orientation.WEST) || checkPathBoth(path, this.entry, this.exit, Orientation.EAST);
    }

    /**
     * Checks if the path given is correct.
     * 
     * @param path The path to check.
     * @param start The start coordinate.
     * @param end The end coordinate.
     * @param orientation The orientation of the start coordinate.
     * @return True if the path is correct, false otherwise.
     */
    private boolean checkPathBoth(String path, Coordinate start, Coordinate end, Orientation orientation){
        Coordinate check = new Coordinate(start.getX(), start.getY(), orientation);

        return movementCheck(path, check) && (check.getX() == end.getX() && check.getY() == end.getY());
    }

    /**
     * Checks if the movement is valid.
     * 
     * @param c The character to check.
     * @param cords The coordinate to check.
     * @param orientation The orientation to check.
     * @return True if the movement is valid, false otherwise.
     */
    private boolean movementCheck(String path, Coordinate cords){
        for(Character c : path.toCharArray()){
            logger.debug(c);

            if(c == 'R'){
                cords.turnRight();
            }else if(c == 'L'){
                cords.turnLeft();
            }else if(c == 'F'){  
                cords.moveForward();
    
                //Checking if the cords are out of bounds
                if(cords.getX() < 0 || cords.getX() >= getWidth() || cords.getY() < 0 || cords.getY() >= getLength()){
                    logger.warn("Out of bounds");
                    return false;
                }
                
                //Checking if the cords hit a wall
                if(!isOpen(cords)){
                    logger.warn("Hit a wall");
                    return false;
                }
            }         
        }
        return true;
    }
}
