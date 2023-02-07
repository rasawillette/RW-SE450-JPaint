package model.commands;

public class UndoCommand implements ICommand {
    @Override
    public void execute() {
        CommandHistory.undo();
        System.out.println("undo command");
    }
}
