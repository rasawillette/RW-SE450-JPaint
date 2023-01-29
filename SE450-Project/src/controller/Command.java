package controller;

interface Command {
    void execute();
    void undo();
}