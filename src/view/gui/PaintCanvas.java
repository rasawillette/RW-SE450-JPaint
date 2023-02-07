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
        setSize(300, 200);
    }

    @Override
    public void paint(Graphics g) {
        //ClickHandler clickHandler = (ClickHandler) super.getMouseListeners()[0];
        //System.out.println("paint"  applicationState.getActiveShapeType();
        Graphics2D graphics2d = (Graphics2D) g;
        //System.out.println("accessible children count " + this.getUI().getAccessibleChildrenCount(this));
        // For example purposes only; remove all lines below from your final project.
        // Draw all shapes here

        System.out.println("paint " + Component.activeShapeType);

        if (Component.activeShapeType == null) {
            return;
        }

        switch (Component.activeShapeType) {
            case RECTANGLE:
                drawRectangle(graphics2d);
                selectShapes(graphics2d);
                moveShapes(graphics2d);
                break;

            case ELLIPSE:
                drawEllipse(graphics2d);
                selectShapes(graphics2d);
                moveShapes(graphics2d);
                break;

            case TRIANGLE:
                drawTriangle(graphics2d);
                selectShapes(graphics2d);
                moveShapes(graphics2d);
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
            case OUTLINE: return ShapeShadingType.OUTLINE;
            case FILLED_IN: return ShapeShadingType.FILLED_IN;
            case OUTLINE_AND_FILLED_IN: return ShapeShadingType.OUTLINE_AND_FILLED_IN;
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

            applicationState.getActiveShapeShadingType();

            // outline
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.OUTLINE) {
                System.out.println("shading type is outline");
                graphics2d.drawRect(applicationState.getStart().x, applicationState.getStart().y, width, height);
            }

            // filled in
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.FILLED_IN) {
                System.out.println("shading type is filled in");
                graphics2d.fillRect(applicationState.getStart().x, applicationState.getStart().y, width, height);
            }

            // outline and filled in
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
                System.out.println("shading type is outlined and filled in");
                graphics2d.fillRect(applicationState.getStart().x, applicationState.getStart().y, width, height);
                graphics2d.setColor(getColor(applicationState.getActiveSecondaryColor()));
                graphics2d.drawRect(applicationState.getStart().x, applicationState.getStart().y, width, height);
            }
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

            // outline
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.OUTLINE) {
                System.out.println("shading type is outline");
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

            applicationState.getActiveShapeShadingType();

            // outline
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.OUTLINE) {
                System.out.println("shading type is outline");
                graphics2d.drawPolygon(xPoints, yPoints, nPoints);
            }

            // filled in
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.FILLED_IN) {
                System.out.println("shading type is filled in");
                graphics2d.fillPolygon(xPoints, yPoints, nPoints);
            }

            // outline and filled in
            if (applicationState.getActiveShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
                System.out.println("shading type is outlined and filled in");
                graphics2d.fillPolygon(xPoints, yPoints, nPoints);
                graphics2d.setColor(getColor(applicationState.getActiveSecondaryColor()));
                graphics2d.drawPolygon(xPoints, yPoints, nPoints);
            }
        }
    }

    private void selectShapes(Graphics2D graphics2d) {
        System.out.println("select shapes");

        // collision detection algorithm goes here
        // https://developer.mozilla.org/en-US/docs/Games/Techniques/2D_collision_detection

        /*
        Crafty.init(200, 200);

        const dim1 = { x: 5, y: 5, w: 50, h: 50 };
        const dim2 = { x: 20, y: 10, w: 60, h: 40 };

        const rect1 = Crafty.e("2D, Canvas, Color").attr(dim1).color("red");

        const rect2 = Crafty.e("2D, Canvas, Color, Keyboard, Fourway")
            .fourway(2)
            .attr(dim2)
            .color("blue");

        rect2.bind("EnterFrame", function () {
            if (rect1.x < rect2.x + rect2.w &&
                rect1.x + rect1.w > rect2.x &&
                rect1.y < rect2.y + rect2.h &&
                rect1.h + rect1.y > rect2.y) {

                    // Collision detected!
                    this.color("green");
            }

            else {
                // No collision
                this.color("blue");
            }
        }
         */
    }

    private void moveShapes(Graphics2D graphics2d) {
        System.out.println("move shapes");

    }


    public void addState(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }
}
