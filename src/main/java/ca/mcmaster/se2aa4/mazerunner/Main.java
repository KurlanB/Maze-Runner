package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    //Initializing Apache Logger
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        //Start of maze runner
        logger.info("** Starting Maze Runner");
        
        //Starting the maze runner
        Configuration config = new Configuration();
        config.start(args);
        
        //End of maze runner
        logger.info("** End of MazeRunner");
    }
}