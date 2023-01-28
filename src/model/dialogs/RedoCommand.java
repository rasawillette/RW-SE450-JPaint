package model.dialogs;

import controller.IAtmCommand;

public class RedoCommand implements IAtmCommand {
    @Override
    public void execute() {

        CommandHistory.redo();
    }
}
