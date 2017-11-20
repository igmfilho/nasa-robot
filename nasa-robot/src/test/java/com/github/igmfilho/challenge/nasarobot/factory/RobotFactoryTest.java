package com.github.igmfilho.challenge.nasarobot.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.github.igmfilho.challenge.nasarobot.model.Direction;
import com.github.igmfilho.challenge.nasarobot.model.Robot;

public class RobotFactoryTest {

	private RobotFactory robotFactory;
	
	@Before
	public void setUp() {
		robotFactory = new RobotFactory();
		robotFactory.setInitialCoordinateX(0);
		robotFactory.setInitialCoordinateY(0);
		robotFactory.setInitialDirection(Direction.NORTH);
	}

	@Test
	public void shouldGetAnObjectRobot() throws Exception {
		Robot object = robotFactory.getObject();
		assertNotNull(object);
		assertEquals(Boolean.TRUE, (object instanceof Robot));
	}
	
	@Test 
	public void shouldGetAnObjectRobotWithCoordinateXYAsZero() throws Exception {
		Robot robot = robotFactory.getObject();
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getX());
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getY());
	}

	@Test
	public void shouldGetAnObjectRobotWithDirectioNorth() throws Exception {
		Robot robot = robotFactory.getObject();
		assertEquals(Direction.NORTH, robot.getDirection());
	}

	@Test
	public void shouldBeSingletonFactory() {
		assertEquals(Boolean.TRUE, robotFactory.isSingleton());
	}
	
	@Test
	public void shouldGetAnObjectTypeOfTargetGround() {
		Class<?> objectType = robotFactory.getObjectType();
		assertNotNull(objectType);
		assertEquals(Boolean.TRUE, objectType.getName().contains("Robot"));
	}
}