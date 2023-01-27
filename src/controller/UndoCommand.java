package controller;

import model.UndoRedoInterface;

public class UndoCommand implements UndoRedoInterface {

    @Override
    public void execute() {
        CommandHistory.undo();
    }

    @Override
    public void undoCommand() {

    }
}
