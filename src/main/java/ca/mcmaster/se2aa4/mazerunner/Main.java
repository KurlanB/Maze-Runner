package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final Options options = new Options();
    private static final CommandLineParser parser = new DefaultParser();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        options.addOption("i", true, "Input file of maze selected");

        try {
            CommandLine cmd = parser.parse(options, args);

            if(!cmd.hasOption("i")){ 
                throw new ParseException("/!\\ Could not find -i flag /!\\", 0);
            }

            String filePath = cmd.getOptionValue("i");

            logger.info("**** Reading the maze from file " + filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
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
        } catch(ParseException e){
            logger.error("/!\\Error during parsing " + e.getMessage() + " /!\\");
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        
        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
