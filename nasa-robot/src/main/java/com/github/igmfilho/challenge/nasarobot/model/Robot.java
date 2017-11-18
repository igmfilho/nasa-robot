package com.github.igmfilho.challenge.nasarobot.model;

import java.io.Serializable;

public class Robot implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Direction direction;
	
	private Coordinate coordinate;
	
	public Robot() {
	}
	
	/**
	 * @param direction
	 * @param coordinate
	 */
	public Robot(Direction direction, Coordinate coordinate) {
		super();
		this.direction = direction;
		this.coordinate = coordinate;
	}
	
	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * @param coordinate the coordinate to set
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public void rotateLeft() {
		this.setDirection(this.getDirection().rotateLeft());
	}

	public void rotateRight() {
		this.setDirection(this.getDirection().rotateRight());
	}
	
	public void move() {
		Integer currentCoordinateX = this.getCoordinate().getX();
		Integer currentCoordinateY = this.getCoordinate().getY();
		Integer nextCoordinateX = currentCoordinateX + this.getDirection().getAddValueCoordinateX();
		Integer nextCoordinateY = currentCoordinateY + this.getDirection().getAddValueCoordinateY();

		this.getCoordinate().setX(nextCoordinateX);
		this.getCoordinate().setY(nextCoordinateY);
	}
	
	@Override
	public String toString() {
		StringBuilder textBuilder = new StringBuilder();
		textBuilder.append("(")
				.append(this.coordinate.getX())
				.append(", ")
				.append(this.coordinate.getY())
				.append(", ")
				.append(this.direction.getLetter())
				.append(")");
		
		return textBuilder.toString();
	}
}