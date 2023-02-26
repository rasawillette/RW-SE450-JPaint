package model.commands;

import model.interfaces.IShape;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

import java.util.ArrayList;

public class DeleteCommand implements ICommand,IUndoable{

    ShapeList shapeList;
    PaintCanvas paintCanvas;
    ArrayList<IShape> deletedList;

    public DeleteCommand(ShapeList shapeList, PaintCanvas paintCanvas) {
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        deletedList = new ArrayList<IShape>();
    }

    @Override
    public void execute() {
        for (IShape shape: shapeList.getSelectedList()){
            shapeList.removeShape(shape);
            deletedList.add(shape);
        }
        CommandHistory.add(this);
        paintCanvas.update();
    }

    @Override
    public void undo() {
        for (IShape shape : deletedList){
            shapeList.addShape(shape);
        }
        paintCanvas.update();
    }

    @Override
    public void redo() {
        for (IShape shape: deletedList){
            shapeList.removeShape(shape);
        }
        paintCanvas.update();
    }
}
