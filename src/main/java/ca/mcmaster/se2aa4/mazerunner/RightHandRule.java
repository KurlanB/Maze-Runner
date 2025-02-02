package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
        /*  Right | Front | ACTION
         *  PASS  | ANY   | TURN RIGHT and MOVE FORWARD
         *  WALL  | PASS  | MOVE FORWARD
         *  WALL  | WALL  | TURN LEFT
         */

        StringBuilder path = new StringBuilder();
        Coordinate current = maze.getEntry();
        Orientation orientation = Orientation.EAST;

        while (current.getX() != maze.getExit().getX() || current.getY() != maze.getExit().getY()){
            logger.debug("Current: (" + current.getX() + ", " + current.getY() + ")");
            Coordinate rightHand = new Coordinate(current.getX(), current.getY());
            rightHand.move(orientation.turnRight());
            logger.debug("Right: (" + rightHand.getX() + ", " + rightHand.getY() + ")");


            Coordinate front = new Coordinate(current.getX(), current.getY());
            front.move(orientation);
            logger.debug("Front: (" + front.getX() + ", " + front.getY() + ")");

            if(!maze.isOpen(rightHand)){
                if(maze.isOpen(front)){
                    path.append('F');
                    current.move(orientation);
                } else {
                    orientation = orientation.turnLeft();
                    path.append('L');
                }
            } else {
                orientation = orientation.turnRight();
                current.move(orientation);
                path.append('R');
                path.append('F');
            }

            logger.debug(path.toString());
        }
        
        return path.toString();
    }
}
