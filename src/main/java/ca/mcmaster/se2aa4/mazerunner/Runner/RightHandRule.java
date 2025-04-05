package ca.mcmaster.se2aa4.mazerunner.Runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.Map.Coordinate;
import ca.mcmaster.se2aa4.mazerunner.Map.Maze;

/**
 * The RightHandRule class implements the MazeRunner interface and provides
 * an algorithm to escape the maze using the right-hand rule.
 */
public class RightHandRule implements MazeRunner{
    
    private static final Logger logger = LogManager.getLogger();

    /**
     * Escapes the maze using the right-hand rule algorithm.
     * 
     * @param maze The maze to escape from.
     * @return A string representing the path taken to escape the maze.
     */
    public String escapeMaze(Maze maze) {
        /*  Truth Table
         *  Right | Front | ACTION
         *  PASS  | ANY   | TURN RIGHT and MOVE FORWARD
         *  WALL  | PASS  | MOVE FORWARD
         *  WALL  | WALL  | TURN LEFT
         */

        // Initialize the Maze runner
        logger.info("**** Running through maze with the Right Hand Rule algorithm");
        StringBuilder path = new StringBuilder();
        Coordinate current = maze.getEntry();

        // While the runner has not reached the exit
        while (current.getX() != maze.getExit().getX() || current.getY() != maze.getExit().getY()){
            logger.debug("Current: (" + current.getX() + ", " + current.getY() + ")");
            
            // Check the right hand side of the runner
            Coordinate rightHand = new Coordinate(current.getX(), current.getY(), current.getOrientation().turnRight());
            rightHand.moveForward();
            logger.debug("Right: (" + rightHand.getX() + ", " + rightHand.getY() + ")");

            // Check the front of the runner
            Coordinate front = new Coordinate(current.getX(), current.getY(), current.getOrientation());
            front.moveForward();
            logger.debug("Front: (" + front.getX() + ", " + front.getY() + ")");

            // Right Hand algorithm from truth table
            if(!maze.isOpen(rightHand)){
                if(maze.isOpen(front)){
                    logger.debug("Forward");
                    path.append('F');

                    current.moveForward();
                } else {
                    logger.debug("Left");
                    current.turnLeft();

                    path.append('L');
                }
            } else {
                logger.debug("Right and Forward");

                current.turnRight();
                current.moveForward();

                path.append('R');
                path.append('F');
            }

            logger.debug(path.toString());
        }
        
        return path.toString();
    }
}
