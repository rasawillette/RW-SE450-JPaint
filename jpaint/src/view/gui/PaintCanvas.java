package view.gui;

import model.commands.GroupCommand;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.interfaces.IPaintCanvas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaintCanvas extends JComponent implements IPaintCanvas {

    ApplicationState applicationState;
    ShapeList shapeList;
    ShapeParams shapeParams;
    Graphics2D graphics2D;

    public PaintCanvas(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
        ArrayList<GroupCommand> groupOutlineList = new ArrayList<>();

        for (IShape shape : shapeList.getShapeList()) {
            shape.draw(graphics2d);
//            System.out.println("something");

            if (shapeList.getSelectedList().contains(shape)) {
                shape.selectOutline(graphics2d);
            }

            else if (shapeList.getSelectedList().contains(shape) && !shape.getShapeGroup().isEmpty()) {
                GroupCommand groupCommand = shape.getShapeGroup().get(shape.getShapeGroup().size()-1);

                if(!groupOutlineList.contains(groupCommand)){
                    groupOutlineList.add(groupCommand);
                }

            }
        }

        for (GroupCommand group : groupOutlineList) {
            ArrayList<IShape> finalGroups = new ArrayList<>();

            for (IShape shape: shapeList.getShapeList()) {

                if (!shape.getShapeGroup().isEmpty()) {
                    GroupCommand groupCommand1 = shape.getShapeGroup().get(shape.getShapeGroup().size()-1);

                    if (group.equals(groupCommand1)) {
                        finalGroups.add(shape);
                    }
                }
            }
            groupOutline(graphics2d,finalGroups);

        }
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

    public void groupOutline(Graphics2D g, List<IShape> groupList){
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        int xMin = 0;
        int xMax = 0;
        int yMin = 0;
        int yMax = 0;

        for(IShape shape : groupList){
            x.add(shape.getShapeParams().getStartPoint().getX());
            x.add(shape.getShapeParams().getEndPoint().getX());
            y.add(shape.getShapeParams().getStartPoint().getY());
            y.add(shape.getShapeParams().getEndPoint().getY());

            xMin = Collections.min(x);
            xMax = Collections.max(x);
            yMin = Collections.min(y);
            yMax = Collections.max(y);
        }

        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);

        g.drawRect(xMin - 5,yMin - 5,xMax - xMin + 10,yMax - yMin + 10);

    }
}
