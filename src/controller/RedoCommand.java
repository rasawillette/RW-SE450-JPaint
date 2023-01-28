package controller;

public class RedoCommand implements IAtmCommand {
    @Override
    public void execute() {

        CommandHistory.redo();
    }
}
