package ca.mcmaster.se2aa4.mazerunner.Starter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.Map.Maze;
import ca.mcmaster.se2aa4.mazerunner.Runner.MazeRunner;
import ca.mcmaster.se2aa4.mazerunner.Runner.RightHandRule;

public class Configuration {

    private static final Logger logger = LogManager.getLogger();

    // Constructor
    public Configuration() {
    }

    /**
     * Starts the maze runner with the given command line arguments.
     * 
     * @param args The command line arguments.
     */
    public void start(String[] args){
        try {
            //Setting up options
            CommandLine cmd = setupOptions(args);
            
            //Reading from maze file
            String filePath = cmd.getOptionValue("i");
            Maze maze = new Maze(filePath); 

            //Computing path
            if(cmd.hasOption("p") && cmd.getOptionValue("p") != null){
                logger.info("**** Verifying path");
                String path = cmd.getOptionValue("p");

                //Path verification
                boolean isvalid = maze.checkPath(cleanRead(path));

                if(isvalid){
                    logger.info("*** Path is valid");
                    System.out.println("corrrect path");
                } else {
                    logger.info("*** Path is invalid");
                    System.out.println("incorrect path");
                }

            } else if(cmd.hasOption("p") && cmd.getOptionValue("p") == null){
                //No path inputted
                logger.warn("PATH NOT COMPUTED");
                System.out.println("No path inputted");

            } else {
                //Computing path using Right Hand Rule
                logger.info("**** Computing path");
                MazeRunner runner = new RightHandRule();
                String pathFound = runner.escapeMaze(maze);

                //Printing path
                logger.info("**** Path found");
                System.out.println(cleanPrint(pathFound));
            }
            
        } catch(Exception e) {
            logger.error("Error: " + e.getMessage());
            System.out.println("Maze not valid");
        }
    }

    /**
     * Sets up the command line options for the maze runner.
     * 
     * @param args The command line arguments.
     * @return The command line object.
     * @throws Exception If an error occurs while parsing the command line arguments.
     */
    private CommandLine setupOptions(String[] args) throws Exception{
        //Parsing options
        Options options = new Options();
        options.addOption("i", true, "Input file of maze selected");
        Option optionP = Option.builder("p")
                .optionalArg(true)
                .desc("Path input")
                .numberOfArgs(1)
                .build();
        options.addOption(optionP);
    
        CommandLineParser parser = new DefaultParser();

        //Parsing the command line arguments
        CommandLine cmd = parser.parse(options, args);

        return cmd;
    }

    /**
     * Cleans the path read from the command line.
     * 
     * @param path The path read from the command line.
     * @return The cleaned path.
     */
    public String cleanRead(String path){
        logger.info("**** Cleaning path input");

        StringBuilder cleanPath = new StringBuilder();
        char[] charPath = path.toUpperCase().replaceAll(" ", "").toCharArray(); // Remove spaces and convert to uppercase
        
        for(int i = 0; i < charPath.length; i++){
            logger.debug(charPath[i]);

            //Last character
            if(i == charPath.length - 1){
                cleanPath.append(charPath[i]);

            } else if(Character.isDigit(charPath[i]) && Character.isDigit(charPath[i+1])){
                //Numbers over one digit
                StringBuilder number = new StringBuilder();

                //Counting the number of digits
                while(Character.isDigit(charPath[i])){
                    number.append(charPath[i]);
                    i++;
                }

                //Appending the character the number of times
                for(int j = 0; j < Integer.parseInt(number.toString()); j++){
                    cleanPath.append(charPath[i]);
                }

            } else if(Character.isLetter(charPath[i+1]) && Character.isDigit(charPath[i])){ //Single digit number
                //Append character number of times
                for(int j = 0; j < Character.getNumericValue(charPath[i]); j++){
                    cleanPath.append(charPath[i+1]);
                }
                i++;

            } else {
                cleanPath.append(charPath[i]);
            }
            logger.debug(cleanPath.toString());
        }
        
        logger.debug(cleanPath.toString());
        return cleanPath.toString();
    }

    /**
     * Cleans the path to be printed.
     * 
     * @param solvedPath The path to be cleaned.
     * @return The cleaned path.
     */
    public String cleanPrint(String solvedPath){
        logger.info("**** Cleaning path output");

        StringBuilder cleanPath = new StringBuilder();
        char[] charPath = solvedPath.toCharArray();

        for(int i = 0; i < charPath.length; i++){
            logger.debug(charPath[i]);

            //Last character
            if(i == charPath.length - 1){
                cleanPath.append(charPath[i]);

            } else {
                //Checking for repeating characters
                if(charPath[i] == charPath[i+1]){
                    int count = 1;
                    char commonChar = charPath[i];

                    //Counting the number of repeating characters
                    while(i < charPath.length - 1){
                        if(charPath[i+1] != commonChar){
                            break;

                        } else if(charPath[i+1] == commonChar){
                            count++;
                            i++;
                        }
                    }
                    
                    cleanPath.append(count + "" + commonChar + " ");

                } else {
                    cleanPath.append(charPath[i] + " ");
                }
            } 
            logger.debug(cleanPath.toString());
            logger.debug(i);
        }
        
        return cleanPath.toString().trim();
    }
}