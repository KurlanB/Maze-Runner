package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.Map.Coordinate;

public abstract class Command {
    protected Coordinate coordinate;

    public Command(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public abstract void execute();

    public abstract String toString();
}
