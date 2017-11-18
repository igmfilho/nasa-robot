package com.github.igmfilho.challenge.nasarobot.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.igmfilho.challenge.nasarobot.model.Coordinate;
import com.github.igmfilho.challenge.nasarobot.model.Direction;
import com.github.igmfilho.challenge.nasarobot.model.Robot;

public class RotateLeftCommandTest {

	private RotateLeftCommand rotateLeftCmd;
	
	@Before
	public void setUp() {
		rotateLeftCmd = new RotateLeftCommand();
	}
	
	@Test
	public void shouldReturnWestWhenNorth() {
		Robot robot = createRobot(Direction.NORTH);
		rotateLeftCmd.execute(robot);
		assertEquals(Direction.WEST, robot.getDirection());
	}

	@Test
	public void shouldReturnEastWhenSouth() {
		Robot robot = createRobot(Direction.SOUTH);
		rotateLeftCmd.execute(robot);
		assertEquals(Direction.EAST, robot.getDirection());
	}

	@Test
	public void shouldReturnNorthWhenEast() {
		Robot robot = createRobot(Direction.EAST);
		rotateLeftCmd.execute(robot);
		assertEquals(Direction.NORTH, robot.getDirection());
	}

	@Test
	public void shouldReturnSouthWhenWest() {
		Robot robot = createRobot(Direction.WEST);
		rotateLeftCmd.execute(robot);
		assertEquals(Direction.SOUTH, robot.getDirection());
	}
	
	private Robot createRobot(Direction direction) {
		Coordinate coordinate = new Coordinate(0, 0);
		return new Robot(direction, coordinate);
	}
}