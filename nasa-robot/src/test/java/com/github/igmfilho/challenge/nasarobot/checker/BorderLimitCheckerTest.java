package com.github.igmfilho.challenge.nasarobot.checker;

import org.junit.Before;
import org.junit.Test;

import com.github.igmfilho.challenge.nasarobot.exception.OutOfBorderLimitException;
import com.github.igmfilho.challenge.nasarobot.model.Coordinate;
import com.github.igmfilho.challenge.nasarobot.model.TargetGround;

public class BorderLimitCheckerTest {

	private static final Integer MAX_COORDINATE_X = 5;
	
	private static final Integer MAX_COORDINATE_Y = 5;
	
	private static final Integer INITIAL_COORDINATE_X = 0;
	
	private static final Integer INITIAL_COORDINATE_Y = 0;
	
	private BorderLimitChecker borderChecker;
	
	private Coordinate coordinate;

	private TargetGround ground;

	@Before
	public void setUp() {
		borderChecker = new BorderLimitChecker();
		coordinate = new Coordinate(INITIAL_COORDINATE_X, INITIAL_COORDINATE_Y);

		Coordinate minCoordinate = new Coordinate(INITIAL_COORDINATE_X, INITIAL_COORDINATE_Y);
		Coordinate maxCoordinate = new Coordinate(MAX_COORDINATE_X, MAX_COORDINATE_Y);
		ground = new TargetGround(minCoordinate, maxCoordinate);

	}

	@Test(expected = OutOfBorderLimitException.class)
	public void shouldBeOutOfBorderLimitByMinCoordinateX() {
		coordinate.setY(INITIAL_COORDINATE_Y);
		coordinate.setX(-1);
		borderChecker.check(ground, coordinate);
	}
	
	@Test(expected = OutOfBorderLimitException.class)
	public void shouldBeOutOfBorderLimitByMinCoordinateY() {
		coordinate.setX(INITIAL_COORDINATE_X);
		coordinate.setY(-1);
		borderChecker.check(ground, coordinate);
	}
	
	@Test(expected = OutOfBorderLimitException.class)
	public void shouldBeOutOfBorderLimitByMaxCoordinateX() {
		coordinate.setX(MAX_COORDINATE_X + 1);
		coordinate.setY(INITIAL_COORDINATE_Y);
		borderChecker.check(ground, coordinate);
	}
	
	@Test(expected = OutOfBorderLimitException.class)
	public void OutOfBorderLimitException() {
		coordinate.setX(INITIAL_COORDINATE_X);
		coordinate.setY(MAX_COORDINATE_Y + 1);
		borderChecker.check(ground, coordinate);
	}
}