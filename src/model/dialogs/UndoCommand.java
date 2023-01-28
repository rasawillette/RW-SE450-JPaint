package model.dialogs;

import model.UndoRedoInterface;

public class UndoCommand implements UndoRedoInterface {
    @Override
    public void redoCommand(){}

    public void execute() {

        CommandHistory.undo();
    }

    @Override
    public void undoCommand() {}
}
