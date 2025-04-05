package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Map.Coordinate;
import ca.mcmaster.se2aa4.mazerunner.Map.Maze;

public class MazeTest {
    private Maze maze;
    private Maze maze2;

    @BeforeEach
    public void intializeMaze() throws Exception{
        maze = new Maze("./examples/rectangle.maz.txt");
        maze2 = new Maze("./examples/direct.maz.txt");
    }

    @Test
    public void testMazeSize() {
        int expectedLength = 21;
        int expectedWidth = 51;
        assertEquals(expectedLength, maze.getLength());
        assertEquals(expectedWidth, maze.getWidth());
    }

    @Test
    public void testMazeEntry() {
        Coordinate entry = maze.getEntry();
        assertEquals(0, entry.getX());
        assertEquals(12, entry.getY());
    }

    @Test
    public void testMazeExit() {
        Coordinate exit = maze.getExit();
        assertEquals(50, exit.getX());
        assertEquals(10, exit.getY());
    }

    @Test
    public void testCheckPath(){
        boolean correctPath = maze2.checkPath("FRFFLFFFRFLFRFLFF");
        assertTrue(correctPath);
    }

    
}
