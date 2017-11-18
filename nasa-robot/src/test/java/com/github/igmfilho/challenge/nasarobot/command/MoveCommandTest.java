package com.github.igmfilho.challenge.nasarobot.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.igmfilho.challenge.nasarobot.model.Coordinate;
import com.github.igmfilho.challenge.nasarobot.model.Direction;
import com.github.igmfilho.challenge.nasarobot.model.Robot;

public class MoveCommandTest {

	private MoveCommand moveCmd;
	
	@Before
	public void setUp() {
		moveCmd = new MoveCommand();
	}	

	@Test
	public void shouldIncrementYWhenNorth() {
		Robot robot = createRobot(Direction.NORTH);
		moveCmd.execute(robot);
		assertEquals(Integer.valueOf(1), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getX());
	}
	
	@Test
	public void shouldIncrementXWhenEast() {
		Robot robot = createRobot(Direction.EAST);
		moveCmd.execute(robot);
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(1), robot.getCoordinate().getX());
	}
	
	@Test
	public void shouldDecrementYWhenSouth() {
		Robot robot = createRobot(Direction.SOUTH);
		moveCmd.execute(robot);
		assertEquals(Integer.valueOf(-1), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getX());
	}
	
	@Test
	public void shouldDecrementXWhenWest() {
		Robot robot = createRobot(Direction.WEST);
		moveCmd.execute(robot);
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(-1), robot.getCoordinate().getX());
	}
	
	private Robot createRobot(Direction direction) {
		Coordinate coordinate = new Coordinate(0, 0);
		return new Robot(direction, coordinate);
	}
}