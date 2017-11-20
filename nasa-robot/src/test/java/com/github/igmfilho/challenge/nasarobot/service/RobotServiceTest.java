package com.github.igmfilho.challenge.nasarobot.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.igmfilho.challenge.nasarobot.checker.BorderLimitChecker;
import com.github.igmfilho.challenge.nasarobot.exception.InvalidCommandException;
import com.github.igmfilho.challenge.nasarobot.exception.OutOfBorderLimitException;
import com.github.igmfilho.challenge.nasarobot.factory.CommandFactory;
import com.github.igmfilho.challenge.nasarobot.factory.RobotFactory;
import com.github.igmfilho.challenge.nasarobot.factory.TargetGroundFactory;
import com.github.igmfilho.challenge.nasarobot.model.Direction;
import com.github.igmfilho.challenge.nasarobot.model.Robot;
import com.github.igmfilho.challenge.nasarobot.parser.CommandParser;

public class RobotServiceTest {

	private static final Integer MAX_COORDINATE_X = 5;
	
	private static final Integer MAX_COORDINATE_Y = 5;
	
	private static final Integer INITIAL_COORDINATE_X = 0;
	
	private static final Integer INITIAL_COORDINATE_Y = 0;

	private RobotService robotService;
	
	@Before
	public void setUp() {
		robotService = new RobotService();
		setCommandParser();
		setBorderLimitChecker();
		setTargetGroundFactory();
		setRobotFactory();
	}
	
	@Test
	public void shouldMoveTo20SouthDirection() {
		String command = "MMRMMRMM";
		Robot robot = robotService.execute(command);
		assertEquals("(2, 0, S)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo02WestDirection() {
		String command = "MML";
		Robot robot = robotService.execute(command);
		assertEquals("(0, 2, W)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo13NorthDirection() {
		String command = "MMRMLM";
		Robot robot = robotService.execute(command);
		assertEquals("(1, 3, N)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo53SouthDirection() {
		String command = "MMRMLMMMRMMMMRMM";
		Robot robot = robotService.execute(command);
		assertEquals("(5, 3, S)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo50SouthDirection() {
		String command = "MMRMLMMMRMMMMRMMMMM";
		Robot robot = robotService.execute(command);
		assertEquals("(5, 0, S)", robot.toString());
	}
	
	@Test(expected = OutOfBorderLimitException.class)
	public void shouldThrowOutOfBorderLimitExceptionOnlyMoving() {
		String command = "MMMMMMMMMMMMMMMMMMMMMMMM";
		robotService.execute(command);
	}
	
	@Test(expected = OutOfBorderLimitException.class)
	public void shouldThrowOutOfBorderLimitException() {
		String command = "MMRMLMMMLMM";
		robotService.execute(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void shouldThrowInvalidCommandException() {
		String command = "AAA";
		robotService.execute(command);
	}

	private void setRobotFactory() {
		RobotFactory robotFactory = new RobotFactory();
		robotFactory.setInitialCoordinateX(INITIAL_COORDINATE_X);
		robotFactory.setInitialCoordinateY(INITIAL_COORDINATE_Y);
		robotFactory.setInitialDirection(Direction.NORTH);
		robotService.setRobotFactory(robotFactory);
	}

	private void setTargetGroundFactory() {
		TargetGroundFactory groundFactory = new TargetGroundFactory();
		groundFactory.setMaxCoordinateX(MAX_COORDINATE_X);
		groundFactory.setMaxCoordinateY(MAX_COORDINATE_Y);
		groundFactory.setMinCoordinateX(INITIAL_COORDINATE_X);
		groundFactory.setMinCoordinateY(INITIAL_COORDINATE_Y);
		robotService.setGroundFactory(groundFactory);
	}

	private void setBorderLimitChecker() {
		BorderLimitChecker borderChecker = new BorderLimitChecker();
		robotService.setBorderLimit(borderChecker);
	}

	private void setCommandParser() {
		CommandParser cmdParser = new CommandParser();
		CommandFactory cmdFactory= new CommandFactory();
		cmdParser.setCommandFactory(cmdFactory);
		robotService.setCmdParser(cmdParser);
	}
}