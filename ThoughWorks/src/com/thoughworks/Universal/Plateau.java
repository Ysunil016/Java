package com.thoughworks.Universal;

public class Plateau {
	private Coordinate topRightCoordinates = new Coordinate(0, 0);
	private Coordinate bottomLeftCoordinates = new Coordinate(0, 0);

	// Making New Plateau
	public Plateau(final int xCoordinate, final int yCoordinate) {
		this.topRightCoordinates = topRightCoordinates.newCoordinateShift(xCoordinate, yCoordinate);
	}

	// Checking if the Coordinate is Within Plateau.
	public boolean isCoordinateInPlateauBound(Coordinate coordinate) {
		return this.bottomLeftCoordinates.isCoordinateOutsideBound(coordinate)
				&& this.topRightCoordinates.isCoordinateInsideBound(coordinate);
	}

}
