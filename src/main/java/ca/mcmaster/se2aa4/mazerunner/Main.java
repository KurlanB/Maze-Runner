package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    //Initializing Apache Logger
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        //Start of maze runner
        logger.info("** Starting Maze Runner");

        //Parsing options
        Options options = new Options();
        options.addOption("i", true, "Input file of maze selected");

        CommandLineParser parser = new DefaultParser();

        try {
            //Parsing the command line arguments
            CommandLine cmd = parser.parse(options, args);

            //Reading from maze file
            String filePath = cmd.getOptionValue("i");
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
            logger.error("/!\\ An error has occured /!\\");
        }

        //Continuation of maze runner

        //Computing path
        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED");
        
        //End of maze runner
        logger.info("** End of MazeRunner");
    }
}
