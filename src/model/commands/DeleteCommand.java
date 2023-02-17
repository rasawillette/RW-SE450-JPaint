package model.commands;

import model.interfaces.IShape;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

import java.util.ArrayList;

public class DeleteCommand implements ICommand,IUndoable{

    ShapeList shapeList;
    PaintCanvas paintCanvas;
    ArrayList<IShape> deleteList;

    public DeleteCommand(ShapeList shapeList, PaintCanvas paintCanvas) {
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        deleteList = new ArrayList<IShape>();
    }

    @Override
    public void execute() {
        for (IShape shape: shapeList.getSelectedList()){
            shapeList.removeShape(shape);
            deleteList.add(shape);
        }
        CommandHistory.add(this);
        paintCanvas.update();
    }

    @Override
    public void undo() {
        for (IShape shape : deleteList){
            shapeList.addShape(shape);
        }
        paintCanvas.update();
    }

    @Override
    public void redo() {
        for (IShape shape: deleteList){
            shapeList.removeShape(shape);
        }
        paintCanvas.update();
    }
}
