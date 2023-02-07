package model.dialogs;

import controller.ICommand;

public class UndoCommand implements ICommand {
    @Override
    public void execute() {
        CommandHistory.undo();
        System.out.println("undo command");
    }
}
