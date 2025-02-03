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
    public Coordinate findEntry() throws Exception{
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
    public Coordinate findExit() throws Exception{
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
        return checkPathEast(path) || checkPathWest(path);
    }

    /**
     * Checks if the path given is correct from the east.
     * 
     * @param path The path to check.
     * @return True if the path is correct, false otherwise.
     */
    public boolean checkPathEast(String path){
        logger.debug("East Check");
        Coordinate check = new Coordinate(exit.getX(), exit.getY(), Orientation.WEST);
        
        for(Character c : path.toCharArray()){
            logger.debug(c);
            
            if(!movementCheck(c, check)){
                return false;
            }          
        }

        return check.getX() == entry.getX() && check.getY() == entry.getY();
    }

    /**
     * Checks if the path given is correct from the west.
     * 
     * @param path The path to check.
     * @return True if the path is correct, false otherwise.
     */
    public boolean checkPathWest(String path){
        logger.debug("West Check");
        Coordinate check = new Coordinate(entry.getX(), entry.getY(), Orientation.EAST);

        for(Character c : path.toCharArray()){
            logger.info(c);

            if(!movementCheck(c, check)){
                return false;
            }                 
        }

        return check.getX() == exit.getX() && check.getY() == exit.getY();
    }

    /**
     * Checks if the movement is valid.
     * 
     * @param c The character to check.
     * @param cords The coordinate to check.
     * @param orientation The orientation to check.
     * @return True if the movement is valid, false otherwise.
     */
    public boolean movementCheck(char c, Coordinate cords){
        if(c == 'R'){
            cords.turnRight();
        }else if(c == 'L'){
            cords.turnLeft();
        }else if(c == 'F'){  
            cords.moveForward();

            if(cords.getX() < 0 || cords.getX() >= getWidth() || cords.getY() < 0 || cords.getY() >= getLength()){
                System.out.println("Out of bounds");
                return false;
            }

            if(!isOpen(cords)){
                System.out.println(cords.getX() + " " + cords.getY());
                return false;
            }
        }
        return true;
    }
}
