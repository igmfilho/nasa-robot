package com.github.igmfilho.challenge.nasarobot.checker;

import org.springframework.stereotype.Component;

import com.github.igmfilho.challenge.nasarobot.exception.OutOfBorderLimitException;
import com.github.igmfilho.challenge.nasarobot.model.Coordinate;
import com.github.igmfilho.challenge.nasarobot.model.TargetGround;

@Component
public class BorderLimitChecker {

	public void check(final TargetGround ground, final Coordinate coordinate) {
		Integer coordinateY = coordinate.getY();
		Integer coordinateX = coordinate.getX();
		if(!isCoordinateYInsideBorderLimit(ground, coordinateY) || !isCoordinateXInsideBorderLimit(ground, coordinateX)) {
			throw new OutOfBorderLimitException();
		}
	}
	
	private boolean isCoordinateYInsideBorderLimit(final TargetGround ground, final int y) {
		return ground.getMinCoordinate().getY() <= y && ground.getMaxCoordinate().getY() >= y;
	}
	
	private boolean isCoordinateXInsideBorderLimit(final TargetGround ground, final int x) {
		return ground.getMinCoordinate().getY() <= x && ground.getMaxCoordinate().getY() >= x;
	}

}
