package com.github.igmfilho.challenge.nasarobot.model;

import java.io.Serializable;


public class TargetGround implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Coordinate minCoordinate;

	private Coordinate maxCoordinate;

	/**
	 * @param minCoordinate
	 * @param maxCoordinate
	 */
	public TargetGround(Coordinate minCoordinate, Coordinate maxCoordinate) {
		super();
		this.minCoordinate = minCoordinate;
		this.maxCoordinate = maxCoordinate;
	}

	/**
	 * @return the minCoordinate
	 */
	public Coordinate getMinCoordinate() {
		return minCoordinate;
	}

	/**
	 * @param minCoordinate the minCoordinate to set
	 */
	public void setMinCoordinate(Coordinate minCoordinate) {
		this.minCoordinate = minCoordinate;
	}

	/**
	 * @return the maxCoordinate
	 */
	public Coordinate getMaxCoordinate() {
		return maxCoordinate;
	}

	/**
	 * @param maxCoordinate the maxCoordinate to set
	 */
	public void setMaxCoordinate(Coordinate maxCoordinate) {
		this.maxCoordinate = maxCoordinate;
	}
}
