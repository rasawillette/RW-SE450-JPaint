package model.commands;

import model.interfaces.IShape;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

import java.util.ArrayList;

public class GroupCommand implements ICommand, IUndoable{

    ShapeList shapeList;
    PaintCanvas paintCanvas;

    ArrayList<IShape> groupedList = new ArrayList<>();

    public GroupCommand(ShapeList shapeList,PaintCanvas paintCanvas){
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void execute() {
        groupedList.clear();
        groupedList.addAll(shapeList.getSelectedList());

        for(IShape shape: groupedList) {
            shape.addGroupShape(this);
        }

        CommandHistory.add(this);
        paintCanvas.update();
    }

    @Override
    public void undo() {
        for(IShape shape: groupedList){
            shape.removeGroupShape();
        }
        paintCanvas.update();

    }

    @Override
    public void redo() {
        for(IShape shape : groupedList ){
            shapeList.addSelectedShape(shape);
            shape.addGroupShape(this);
        }
        paintCanvas.update();
    }
}
