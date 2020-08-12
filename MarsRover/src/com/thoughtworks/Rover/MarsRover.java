package com.thoughtworks.Rover;

import java.util.List;

import com.thoughtworks.Parser.CommanParser;
import com.thoughworks.Commands.CommandInterface;
import com.thoughworks.Universal.Coordinate;
import com.thoughworks.Universal.Direction;
import com.thoughworks.Universal.Plateau;

public class MarsRover {

	private Coordinate currentCoordinate;
	private Direction currentDirection;
	private Plateau plateau;

	public MarsRover(final Coordinate curCoordinate, final Plateau platue, final Direction direction) {
		this.currentCoordinate = curCoordinate;
		this.plateau = platue;
		this.currentDirection = direction;
	}

	public void run(final String command) {
		List<CommandInterface> commandsList = new CommanParser(command).getCommand();
		for (CommandInterface action : commandsList) {
			action.execute(this);
		}
	}

	public String currentLocation() {
		return this.currentCoordinate.toString() + " " + currentDirection.toString();
	}

	public void turnLeftCommand() {
		this.currentDirection = this.currentDirection.left();
	}

	public void turnRightCommand() {
		this.currentDirection = this.currentDirection.right();
	}

	public void moveCommand() {
		Coordinate positionAfterMove = this.currentCoordinate.newCoordinateMove(currentDirection.getStepSizeOnXAxis(),
				currentDirection.getStepSizeOnYAxis());
		if (plateau.isCoordinateInPlateauBound(positionAfterMove)) {
			this.currentCoordinate = this.currentCoordinate.newCoordinateShift(currentDirection.getStepSizeOnXAxis(),
					currentDirection.getStepSizeOnYAxis());
		}
	}
}
