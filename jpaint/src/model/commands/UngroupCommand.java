package model.commands;

import model.interfaces.IShape;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

import java.util.ArrayList;

public class UngroupCommand implements ICommand,IUndoable {

    ShapeList shapeList;
    PaintCanvas paintCanvas;

    ArrayList<IShape> ungroupedList = new ArrayList<>();

    GroupCommand group;

    public UngroupCommand(ShapeList shapeList, PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        ungroupedList.clear();
        ungroupedList.addAll(shapeList.getSelectedList());

        for(IShape shape : ungroupedList){
            if(!shape.getShapeGroup().isEmpty()){
                //dict.put(shape,shape.getShapeGroup().get(shape.getShapeGroup().size()-1));
            }
        }

        for(IShape shape: ungroupedList){
            if(!shape.getShapeGroup().isEmpty()) {
                shape.removeGroupShape();
            }
        }
        CommandHistory.add(this);
        paintCanvas.update();
    }

    @Override
    public void undo() {
        for(IShape shape : ungroupedList){
            //shape.addGroupShape(dict.get(shape));
            shapeList.addSelectedShape(shape);
        }
        paintCanvas.update();
    }

    @Override
    public void redo() {
        for(IShape shape : ungroupedList){
            shape.removeGroupShape();
        }
        paintCanvas.update();
    }
}
