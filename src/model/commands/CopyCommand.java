package model.commands;

import model.interfaces.IShape;
import model.shapes.ShapeList;

public class CopyCommand implements ICommand{

    ShapeList shapeList;

    public CopyCommand(ShapeList shapeList){
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        shapeList.removeCopiedList();

        for (IShape shape : shapeList.getSelectedList()){
            shapeList.addCopiedShape(shape);
        }

    }
}
