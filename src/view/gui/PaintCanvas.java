package view.gui;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.interfaces.IPaintCanvas;

import javax.swing.*;
import java.awt.*;

public class PaintCanvas extends JComponent implements IPaintCanvas {


    ApplicationState applicationState;
    ShapeList shapeList;
    ShapeParams shapeParams;

    public PaintCanvas(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void paint(Graphics g) {
        //ClickHandler clickHandler = (ClickHandler) super.getMouseListeners()[0];
        //System.out.println("paint"  applicationState.getActiveShapeType();
        Graphics2D graphics2d = (Graphics2D) g;

        for (IShape shape : shapeList.getShapeList()) {
//            System.out.println("orig:"+shape);
            shape.draw(graphics2d);
            System.out.println("something");

//            if(shapeList.getSelectedList().contains(shape) && shape.getShapeGroup().isEmpty()){
////                System.out.println("orig in loop:"+shape);
//                shape.selectOutline(g);
//
//            }else if(shapeList.getSelectedList().contains(shape) && !shape.getShapeGroup().isEmpty()){
//
//                System.out.println("get Shape Group :::"+shape+"::::"+shape.getShapeGroup());
//                GroupCommand groupCommand = shape.getShapeGroup().get(shape.getShapeGroup().size()-1);
//                System.out.println("size of group" +shape.getShapeGroup().size());
//                if(!groupOutlineList.contains(groupCommand)){
//                    groupOutlineList.add(groupCommand);
//                }
//            }
        }

        //System.out.println("accessible children count " + this.getUI().getAccessibleChildrenCount(this));
        // For example purposes only; remove all lines below from your final project.
        // Draw all shapes here

        //System.out.println("paint " + applicationState.getActiveShapeType());

//        if (applicationState.getActiveShapeType() == null) {
//            return;
//        }

        /*
        switch (applicationState.getActiveShapeType()) {
            case RECTANGLE:
                DrawMouseState drawMouseState;
                DrawShapeCommand drawShapeCommand;

                //drawRectangle(graphics2d);
                //selectShapes(graphics2d);
                //moveShapes(graphics2d);
                //break;

            case ELLIPSE:
                //DrawMouseState drawMouseState;
                //DrawShapeCommand drawShapeCommand;

                //drawEllipse(graphics2d);
                //selectShapes(graphics2d);
                //moveShapes(graphics2d);
                //break;

            case TRIANGLE:
                //DrawMouseState drawMouseState;
                //DrawShapeCommand drawShapeCommand;

                //drawTriangle(graphics2d);
                //selectShapes(graphics2d);
                //moveShapes(graphics2d);
                //break;
            }
            */

    }

    public void update(){
        System.out.println("update in paint canvas");
        repaint();
    }

    public void addState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
