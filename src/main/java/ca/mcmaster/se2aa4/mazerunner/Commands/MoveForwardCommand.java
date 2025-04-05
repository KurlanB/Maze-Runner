package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.Map.Coordinate;

public class MoveForwardCommand extends Command {

    public MoveForwardCommand(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public void execute(){
        this.coordinate.moveForward(); 
    }

    @Override
    public String toString(){
        return "F";
    }
}