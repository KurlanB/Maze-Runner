package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Map.Maze;
import ca.mcmaster.se2aa4.mazerunner.Runner.MazeRunner;
import ca.mcmaster.se2aa4.mazerunner.Runner.RightHandRule;

public class MazeRunnerTest {
    private MazeRunner mazeRunner;
    private Maze maze;

    @BeforeEach
    public void initializeMazeRunner() throws Exception{
        maze = new Maze("./examples/tiny.maz.txt");
        mazeRunner = new RightHandRule();
    }

    @Test
    public void testEscapeMaze() {
        String expectedPath = "FFFFFLLFFRFFRFFLLFFRFFRFFF";
        String actualPath = mazeRunner.escapeMaze(maze);
        assertEquals(expectedPath, actualPath);
    }
}
