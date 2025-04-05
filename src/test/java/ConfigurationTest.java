import ca.mcmaster.se2aa4.mazerunner.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigurationTest {
    
    private Configuration config;

    @BeforeEach
    public void initializeConfiguration() {
        config = new Configuration();
    }

    @Test
    public void testCleanRead() {
        String input = "   F   L   2R   2F  L   2F    ";
        String expectedOutput = "FLRRFFLFF";
        String actualOutput = config.cleanRead(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCleanPrint(){
        String input = "FLRRFFLFF";
        String expectedOutput = "F L 2R 2F L 2F";
        String actualOutput = config.cleanPrint(input);
        assertEquals(expectedOutput, actualOutput);
    }



}
