package model.dialogs;

import controller.IAtmCommand;

public class UndoCommand implements IAtmCommand {

    @Override
    public void redoCommand() {}

    @Override
    public void execute() {
        CommandHistory.undo();
    }

    @Override
    public void undoCommand() {}
}
