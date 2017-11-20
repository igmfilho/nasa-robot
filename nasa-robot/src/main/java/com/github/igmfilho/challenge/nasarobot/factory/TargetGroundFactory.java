package com.github.igmfilho.challenge.nasarobot.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.igmfilho.challenge.nasarobot.model.Coordinate;
import com.github.igmfilho.challenge.nasarobot.model.TargetGround;

@Component
public class TargetGroundFactory implements FactoryBean<TargetGround> {

	private Integer maxCoordinateY;
	
	private Integer maxCoordinateX;
	
	private Integer minCoordinateY;
	
	private Integer minCoordinateX;

	@Override
	public TargetGround getObject() {
		Coordinate maxCoordinate = new Coordinate(maxCoordinateX, maxCoordinateY);
		Coordinate minCoordinate = new Coordinate(minCoordinateX, minCoordinateY);
		return new TargetGround(minCoordinate, maxCoordinate);
	}

	@Override
	public Class<?> getObjectType() {
		return TargetGround.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Value("${ground.max_coordinate_y}")
	public void setMaxCoordinateY(Integer maxCoordinateY) {
		this.maxCoordinateY = maxCoordinateY;
	}

	@Value("${ground.max_coordinate_x}")
	public void setMaxCoordinateX(Integer maxCoordinateX) {
		this.maxCoordinateX = maxCoordinateX;
	}

	@Value("${ground.min_coordinate_y}")
	public void setMinCoordinateY(Integer minCoordinateY) {
		this.minCoordinateY = minCoordinateY;
	}

	@Value("${ground.min_coordinate_x}")
	public void setMinCoordinateX(Integer minCoordinateX) {
		this.minCoordinateX = minCoordinateX;
	}
}