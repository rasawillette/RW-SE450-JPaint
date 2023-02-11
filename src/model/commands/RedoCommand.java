package model.commands;

public class RedoCommand implements ICommand {

    @Override
    public void execute() {
        CommandHistory.redo();
        System.out.println("redo command");
    }
}
