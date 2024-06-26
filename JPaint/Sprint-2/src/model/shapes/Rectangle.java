package model.shapes;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.*;

public class Rectangle implements IShape {

	private Point startPoint;
	private Point endPoint;
	ApplicationState applicationState;

	public Rectangle(Point startPoint, Point endPoint, ApplicationState applicationState) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.setApplicationState(applicationState);
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

	@Override
	public void draw(Graphics2D graphics2d) {

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

	}


	public void selectDraw(Graphics2D g) {
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		g.setStroke(stroke);
		g.setColor(Color.BLACK);
		int width = applicationState.getStop().x - applicationState.getStart().x;
		int height = applicationState.getStop().y - applicationState.getStart().y;
		g.drawRect(applicationState.getStart().x, applicationState.getStart().y, width, height);
	}

	@Override
	public void setStartPoint(int x, int y) {
		this.startPoint.x = x;
		this.startPoint.y = y;
	}

	@Override
	public void setEndPoint(int x, int y) {
		this.endPoint.x = x;
		this.endPoint.y = y;
	}

	@Override
	public void setShapeShadingType(ShapeShadingType shapeShadingType) {
		//this.applicationState.setActiveShadingType() = shapeShadingType;
	}

	// confirm ^ that application state should be passed into Ellipse constructor as parameter

	@Override
	public void setPrimaryColor(ShapeColor color) {

	}

	@Override
	public void setSecondaryColor(ShapeColor color) {

	}

	@Override
	public ApplicationState getApplicationState() {
		return null;
	}

	@Override
	public void setApplicationState(ApplicationState applicationState) {

	}

	@Override
	public int getHeight() {
		return (applicationState.getStop().y - applicationState.getStart().y);
	}

	@Override
	public int getWidth() {
		return (applicationState.getStop().x - applicationState.getStart().x);
	}

	@Override
	public Point getStartPoint() {
		return startPoint;
	}

	@Override
	public Point getEndPoint() {
		return endPoint;
	}

	@Override
	public void setSelected(boolean bool) {

	}

	@Override
	public ShapeType getShape() {
		return (applicationState.getActiveShapeType());
	}

	@Override
	public ShapeColor getPrimaryColor() {
		return null;
	}

	@Override
	public ShapeColor getSecondaryColor() {
		return null;
	}

	@Override
	public ShapeShadingType getShapeShadingType() {
		return null;
	}

	@Override
	public boolean containsPoint(int x, int y) {
		return false;
	}




	/*
	Graphics graphics2d;

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
		else if (applicationState.getActiveShapeShadingType() == ShapeShadingType.FILLED_IN) {
			System.out.println("shading type is filled in");
			graphics2d.fillPolygon(xPoints, yPoints, nPoints);
		}

		// outline and filled in
		else if (applicationState.getActiveShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
			System.out.println("shading type is outlined and filled in");
			graphics2d.fillPolygon(xPoints, yPoints, nPoints);
			graphics2d.setColor(getColor(applicationState.getActiveSecondaryColor()));
			graphics2d.drawPolygon(xPoints, yPoints, nPoints);
		}

	 */

}
