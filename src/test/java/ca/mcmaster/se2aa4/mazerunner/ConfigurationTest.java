package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Starter.Configuration;

public class ConfigurationTest {
    private Configuration config;

    /**
     * Initializes the Configuration object before each test.
     */
    @BeforeEach
    public void initializeConfiguration() {
        config = new Configuration();
    }

    /**
     * Tests the cleanRead method of the Configuration class.
     * It checks if the method correctly cleans the input string.
     */
    @Test
    public void testCleanRead() {
        String input = "   F   L   2R   2F  L   2F    ";
        String expectedOutput = "FLRRFFLFF";
        String actualOutput = config.cleanRead(input);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests the cleanPrint method of the Configuration class.
     * It checks if the method correctly formats the output string.
     */
    @Test
    public void testCleanPrint(){
        String input = "FLRRFFLFF";
        String expectedOutput = "F L 2R 2F L 2F";
        String actualOutput = config.cleanPrint(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
