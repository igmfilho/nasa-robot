package com.github.igmfilho.challenge.nasarobot.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.igmfilho.challenge.nasarobot.model.Coordinate;
import com.github.igmfilho.challenge.nasarobot.model.Direction;
import com.github.igmfilho.challenge.nasarobot.model.Robot;

public class RotateRightCommandTest {
	
	private RotateRightCommand rotateRightCmd;
	
	@Before
	public void setUp() {
		rotateRightCmd = new RotateRightCommand();
	}
	
	@Test
	public void shouldReturnEastWhenNorth() {
		Robot robot = createRobot(Direction.NORTH);
		rotateRightCmd.execute(robot);
		assertEquals(Direction.EAST, robot.getDirection());
	}

	@Test
	public void shouldReturnWestWhenSouth() {
		Robot robot = createRobot(Direction.SOUTH);
		rotateRightCmd.execute(robot);
		assertEquals(Direction.WEST, robot.getDirection());
	}

	@Test
	public void shouldReturnSouthWhenEast() {
		Robot robot = createRobot(Direction.EAST);
		rotateRightCmd.execute(robot);
		assertEquals(Direction.SOUTH, robot.getDirection());
	}

	@Test
	public void shouldReturNorthWhenWest() {
		Robot robot = createRobot(Direction.WEST);
		rotateRightCmd.execute(robot);
		assertEquals(Direction.NORTH, robot.getDirection());
	}

	private Robot createRobot(Direction direction) {
		Coordinate coordinate = new Coordinate(0, 0);
		return new Robot(direction, coordinate);
	}
}