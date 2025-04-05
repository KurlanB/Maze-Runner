package ca.mcmaster.se2aa4.mazerunner.Commands;

import java.util.LinkedList;
import java.util.Queue;

public class CommandManager {
    private Queue<Command> commandHistory = new LinkedList<>();

    public void executeCommand(Command command){
        command.execute();
        push(command);
    }

    public void push(Command c){
        this.commandHistory.offer(c);
    }

    public void pop(int count){
        for(int i = 0; i < count; i++){
            if(!this.commandHistory.isEmpty()){
                this.commandHistory.poll();
            }
        }    
    }

    public boolean isEmpty(){
        return this.commandHistory.isEmpty();
    }

    @Override
    public String toString(){
        if (commandHistory.isEmpty()) {
            return "Maze not valid.";
        }

        StringBuilder sb = new StringBuilder();
        for (Command command : commandHistory) {
            sb.append(command.toString());
        }

        return sb.toString();
    }

}
