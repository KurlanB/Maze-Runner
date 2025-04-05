package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.Map.Coordinate;

public class TurnRightCommand extends Command {

    public TurnRightCommand(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public void execute() {
        this.coordinate.turnRight();
    }

    @Override
    public String toString() {
        return "R";
    }
}
