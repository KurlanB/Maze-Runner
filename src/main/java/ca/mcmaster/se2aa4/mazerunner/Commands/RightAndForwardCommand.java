package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.Map.Coordinate;

public class RightAndForwardCommand extends Command {

    public RightAndForwardCommand(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public void execute() {
        this.coordinate.turnRight();
        this.coordinate.moveForward();
    }

    @Override
    public String toString() {
        return "RF";
    }
}