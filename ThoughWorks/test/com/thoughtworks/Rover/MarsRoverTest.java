package com.thoughtworks.Rover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughworks.Universal.Coordinate;
import com.thoughworks.Universal.Direction;
import com.thoughworks.Universal.Plateau;

public class MarsRoverTest {

	@Test
	public void testRun() {

		Plateau plateau = new Plateau(5, 5);
		Coordinate startingPoint = new Coordinate(1, 2);
		MarsRover marsRover = new MarsRover(startingPoint, plateau, Direction.N);

		marsRover.turnLeftCommand(); // W
		assertEquals("1 2 W", marsRover.currentLocation());

		marsRover.moveCommand(); // 0,2
		assertEquals("0 2 W", marsRover.currentLocation());

		marsRover.moveCommand(); // 0,2
		assertEquals("0 2 W", marsRover.currentLocation());

		marsRover.turnRightCommand(); // N
		assertEquals("0 2 N", marsRover.currentLocation());

		marsRover.moveCommand(); // 0, 3
		assertEquals("0 3 N", marsRover.currentLocation());

		marsRover.moveCommand(); // 0, 4
		assertEquals("0 4 N", marsRover.currentLocation());
	}

	@Test
	public void testTurnLeftCommand() {
		Plateau plateau = new Plateau(5, 5);
		Coordinate startingPoint = new Coordinate(1, 2);
		MarsRover marsRover = new MarsRover(startingPoint, plateau, Direction.N);

		marsRover.turnLeftCommand();

		assertEquals("1 2 W", marsRover.currentLocation());
	}

	@Test
	public void testTurnRightCommand() {
		Plateau plateau = new Plateau(5, 5);
		Coordinate startingPoint = new Coordinate(1, 2);
		MarsRover marsRover = new MarsRover(startingPoint, plateau, Direction.N);

		marsRover.turnRightCommand();

		assertEquals("1 2 E", marsRover.currentLocation());
	}

	@Test
	public void testMoveCommand() {
		Plateau plateau = new Plateau(5, 5);
		Coordinate startingPoint = new Coordinate(1, 2);
		MarsRover marsRover = new MarsRover(startingPoint, plateau, Direction.N);

		marsRover.moveCommand();

		assertEquals("1 3 N", marsRover.currentLocation());
	}

}
