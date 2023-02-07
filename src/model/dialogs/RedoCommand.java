package model.dialogs;

import controller.ICommand;

public class RedoCommand implements ICommand {

    @Override
    public void execute() {
        CommandHistory.redo();
        System.out.println("redo command");
    }

}
