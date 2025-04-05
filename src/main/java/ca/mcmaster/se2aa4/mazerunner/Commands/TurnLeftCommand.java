package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.Map.Coordinate;

public class TurnLeftCommand extends Command {

    public TurnLeftCommand(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public void execute() {
        this.coordinate.turnLeft();
    }
    
    @Override
    public String toString() {
        return "L";
    }
}
