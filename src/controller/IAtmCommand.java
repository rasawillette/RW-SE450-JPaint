package controller;

public interface IAtmCommand {
    void redoCommand();

    void execute();


    void undoCommand();
}
