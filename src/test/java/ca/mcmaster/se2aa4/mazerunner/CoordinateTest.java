package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Map.Coordinate;
import ca.mcmaster.se2aa4.mazerunner.Map.Orientation;

public class CoordinateTest {
    private Coordinate coordinate;

    @BeforeEach
    public void initializeCoordinate() {
        coordinate = new Coordinate(5, 10);    
    }

    @Test
    public void testGetOrientation() {
        assertEquals(Orientation.EAST, coordinate.getOrientation());
    }

    @Test
    public void testGetX() {
        assertEquals(5, coordinate.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(10, coordinate.getY());
    }

    @Test
    public void testMoveForward(){
        coordinate.moveForward();
        assertEquals(6, coordinate.getX());
        assertEquals(10, coordinate.getY());
    }

    @Test
    public void testTurnLeft(){
        coordinate.turnLeft();
        assertEquals(Orientation.NORTH, coordinate.getOrientation());
    }

    @Test
    public void testTurnRight(){
        coordinate.turnRight();
        assertEquals(Orientation.SOUTH, coordinate.getOrientation());
    }
    
}
