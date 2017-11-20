package com.github.igmfilho.challenge.nasarobot.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.github.igmfilho.challenge.nasarobot.model.TargetGround;

public class TargetGroundFactoryTest {

	private TargetGroundFactory groundFactory; 
	
	@Before
	public void setUp() {
		groundFactory = new TargetGroundFactory();
		groundFactory.setMaxCoordinateX(5);
		groundFactory.setMaxCoordinateY(5);
		groundFactory.setMinCoordinateX(0);
		groundFactory.setMinCoordinateY(0);
	}
	
	@Test
	public void shouldGetAnObjectTargetGround() {
		TargetGround object = groundFactory.getObject();
		assertNotNull(object);
		assertEquals(Boolean.TRUE, (object instanceof TargetGround));
	}
	
	@Test
	public void shouldToBeSingletonFactory() {
		assertEquals(Boolean.TRUE, groundFactory.isSingleton());
	}
	
	@Test
	public void shouldGetAnObjectTypeOfTargetGround() {
		Class<?> objectType = groundFactory.getObjectType();
		assertNotNull(objectType);
		assertEquals(Boolean.TRUE, objectType.getName().contains("TargetGround"));
	}
}