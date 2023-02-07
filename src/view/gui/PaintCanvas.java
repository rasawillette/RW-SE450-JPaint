package view.gui;

import controller.Component;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;

import javax.swing.*;
import java.awt.*;

public class PaintCanvas extends JPanel {
    //IGuiWindow guiWindow;

    IApplicationState applicationState;
    public PaintCanvas() {
        setSize(300,200);
    }
    @Override
    public void paint(Graphics g) {
        //ClickHandler clickHandler = (ClickHandler) super.getMouseListeners()[0];
        //System.out.println("paint"  applicationState.getActiveShapeType();
        Graphics2D graphics2d = (Graphics2D)g;
        //System.out.println("accessible children count " + this.getUI().getAccessibleChildrenCount(this));
        // For example purposes only; remove all lines below from your final project.
        // Draw all shapes here

        System.out.println("paint " + Component.activeShapeType);

        if (Component.activeShapeType == null) {
            return;
        }

        switch (Component.activeShapeType){
            case RECTANGLE : drawRectangle(graphics2d);
            break;

            case ELLIPSE : drawEllipse(graphics2d);
            break;

            case TRIANGLE : drawTriangle(graphics2d);
            break;
        }

    }

    public Color getColor(ShapeColor shapeColor) {
        switch (shapeColor) {
            case BLACK: return Color.black;
            case BLUE: return Color.blue;
            case CYAN: return Color.cyan;
            case DARK_GRAY: return Color.darkGray;
            case GRAY: return Color.gray;
            case GREEN: return Color.green;
            case LIGHT_GRAY: return Color.lightGray;
            case MAGENTA: return Color.magenta;
            case ORANGE: return Color.orange;
            case PINK: return Color.pink;
            case RED: return Color.red;
            case WHITE: return Color.white;
            case YELLOW: return Color.yellow;
            default: return Color.black;
        }
    }

    public ShapeShadingType getShading(ShapeShadingType shapeShadingType) {
        switch (shapeShadingType) {
            case OUTLINE : return ShapeShadingType.OUTLINE;
            case FILLED_IN : return ShapeShadingType.FILLED_IN;
            case OUTLINE_AND_FILLED_IN : return ShapeShadingType.OUTLINE_AND_FILLED_IN;
            default: return ShapeShadingType.FILLED_IN;
        }
    }

    private void drawRectangle(Graphics2D graphics2d) {
        System.out.println("draw rectangle " + applicationState.getStart() + applicationState.getStop());

        if (applicationState.getStart() != null && applicationState.getStop() != null) {
            applicationState.getActivePrimaryColor();
            graphics2d.setColor(getColor(applicationState.getActivePrimaryColor()));

            int width = applicationState.getStop().x - applicationState.getStart().x;
            int height = applicationState.getStop().y - applicationState.getStart().y;

            // outline
            graphics2d.setStroke(new BasicStroke(5));
            //graphics2d.setColor(getColor(applicationState.getActiveSecondaryColor()));
            graphics2d.drawRect(applicationState.getStart().x, applicationState.getStart().y, width, height);

            // filled in
            graphics2d.fillRect(applicationState.getStart().x, applicationState.getStart().y, width, height);

            // outline and filled in

        }


        // Outlined rectangle
        //graphics2d.setStroke(new BasicStroke(5));
        /*graphics2d.setColor(Color.BLUE);
        graphics2d.drawRect(12, 13, 200, 400);

        // Selected Shape
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(7, 8, 210, 410);*/
    }

    private void drawEllipse(Graphics2D graphics2d) {
        System.out.println("draw ellipse " + applicationState.getStart() + applicationState.getStop());

        if (applicationState.getStart() != null && applicationState.getStop() != null) {
            applicationState.getActivePrimaryColor();
            graphics2d.setColor(getColor(applicationState.getActivePrimaryColor()));

            int width = applicationState.getStop().x - applicationState.getStart().x;
            int height = applicationState.getStop().y - applicationState.getStart().y;

            applicationState.getActiveShapeShadingType();
            //graphics2d.setActiveShadingType(getShading(applicationState.getActiveShapeShadingType()));

            // outline
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.OUTLINE) {
                System.out.println("shading type is outline");
                //graphics2d.setStroke(new BasicStroke(5));
                //graphics2d.setColor(getColor(applicationState.getActiveSecondaryColor()));
                graphics2d.drawOval(applicationState.getStart().x, applicationState.getStart().y, width, height);
            }

            // filled in
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.FILLED_IN) {
                System.out.println("shading type is filled in");
                graphics2d.fillOval(applicationState.getStart().x, applicationState.getStart().y, width, height);
            }

            // outline and filled in
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
                System.out.println("shading type is outlined and filled in");
                graphics2d.fillOval(applicationState.getStart().x, applicationState.getStart().y, width, height);

                //graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(getColor(applicationState.getActiveSecondaryColor()));
                graphics2d.drawOval(applicationState.getStart().x, applicationState.getStart().y, width, height);
            }


        }

    }

    private void drawTriangle(Graphics2D graphics2d) {
        System.out.println("draw triangle " + applicationState.getStart() + applicationState.getStop());

        if (applicationState.getStart() != null && applicationState.getStop() != null) {
            applicationState.getActivePrimaryColor();
            graphics2d.setColor(getColor(applicationState.getActivePrimaryColor()));

            int width = applicationState.getStop().x - applicationState.getStart().x;
            int height = applicationState.getStop().y - applicationState.getStart().y;

            int[] xPoints = {applicationState.getStart().x, applicationState.getStop().x, applicationState.getStart().x};
            int[] yPoints = {applicationState.getStart().y, applicationState.getStop().y, applicationState.getStop().y};
            int nPoints = 3;

            //graphics2d.drawPolygon(xPoints, yPoints,nPoints);
            graphics2d.fillPolygon(xPoints, yPoints,nPoints);
        }

    }

    public void addState(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }
}
