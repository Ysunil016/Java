package com.thoughworks.Universal;

public class Coordinate {

	private int xCoordinate;
	private int yCoordinate;

	public Coordinate(int xCoordinate, int yCoordinate) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	@Override
	public String toString() {
		return xCoordinate + " " + yCoordinate;
	}

	// Shifting the X and Y as Required during Plateau Declaration.
	public Coordinate newCoordinateShift(int xCoordinateStep, int yCoordinateStep) {
		return new Coordinate(this.xCoordinate + xCoordinateStep, this.yCoordinate + yCoordinateStep);
	}

	public boolean isCoordinateInsideBound(final Coordinate coordinate) {
		return isXCoordinateInsideBound(coordinate.xCoordinate) && isYCoordinateInsideBound(coordinate.yCoordinate);
	}

	public boolean isCoordinateOutsideBound(final Coordinate coordinate) {
		return isXCoordinateOutsideBound(coordinate.xCoordinate) && isYCoordinateOutsideBound(coordinate.yCoordinate);
	}

	private boolean isYCoordinateInsideBound(final int yCoordinate) {
		return yCoordinate <= this.yCoordinate;
	}

	private boolean isXCoordinateInsideBound(final int xCoordinate) {
		return xCoordinate <= this.xCoordinate;
	}

	private boolean isYCoordinateOutsideBound(final int yCoordinate) {
		return yCoordinate >= this.yCoordinate;
	}

	private boolean isXCoordinateOutsideBound(final int xCoordinate) {
		return xCoordinate >= this.xCoordinate;
	}

	// Additional Required for Before Checking if Rover is in the Bound
	public Coordinate newCoordinateMove(int xStep, int yStep) {
		return new Coordinate(xCoordinate + xStep, yCoordinate + yStep);
	}
}
