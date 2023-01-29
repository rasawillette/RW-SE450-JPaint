package model.dialogs;

import controller.IAtmCommand;

public class RedoCommand implements IAtmCommand {
    @Override
    public void redoCommand() {}

    @Override
    public void execute() {
        CommandHistory.redo();
    }

    @Override
    public void undoCommand() {}
}
