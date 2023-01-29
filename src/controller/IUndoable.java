package controller;

public interface IUndoable {
    void add();
    void undo();
    void redo();
}
