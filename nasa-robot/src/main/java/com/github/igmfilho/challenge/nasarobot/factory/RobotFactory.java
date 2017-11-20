package com.github.igmfilho.challenge.nasarobot.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.igmfilho.challenge.nasarobot.model.Coordinate;
import com.github.igmfilho.challenge.nasarobot.model.Direction;
import com.github.igmfilho.challenge.nasarobot.model.Robot;

@Component
public class RobotFactory implements FactoryBean<Robot> {

	private Integer initialCoordinateX;
	
	private Integer initialCoordinateY;
	
	private Direction initialDirection;

	@Override
	public Robot getObject() {
		Coordinate coordinate = new  Coordinate(initialCoordinateX, initialCoordinateY);
		return new Robot(initialDirection, coordinate);
	}

	@Override
	public Class<?> getObjectType() {
		return Robot.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Value("${robot.initial_coordinate_x}")
	public void setInitialCoordinateX(Integer initialCoordinateX) {
		this.initialCoordinateX = initialCoordinateX;
	}

	@Value("${robot.initial_coordinate_y}")
	public void setInitialCoordinateY(Integer initialCoordinateY) {
		this.initialCoordinateY = initialCoordinateY;
	}

	@Value("${robot.initial_direction}")
	public void setInitialDirection(Direction initialDirection) {
		this.initialDirection = initialDirection;
	}
}