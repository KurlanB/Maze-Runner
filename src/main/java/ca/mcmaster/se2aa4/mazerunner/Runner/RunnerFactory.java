package ca.mcmaster.se2aa4.mazerunner.Runner;

/*
 * Factory class for creating MazeRunner objects.
 * This class implements the Factory Method Pattern.
 * It provides a method to create different types of maze runners based on the algorithm specified.
 */
public class RunnerFactory {
    public MazeRunner getRunner(String algorithm){
        if(algorithm == null){
            return null;
        }

        if(algorithm.equalsIgnoreCase("RHR")){
            return new RightHandRule(); 
        }

        if(algorithm.equalsIgnoreCase("BFS")){
            return new BFS(); 
        }
        return null;
    }
}
