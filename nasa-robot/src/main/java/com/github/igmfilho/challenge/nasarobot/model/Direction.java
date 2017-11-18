package com.github.igmfilho.challenge.nasarobot.model;

public enum Direction {

	NORTH(1,"N", 0, 1), EAST(2,"E", 1, 0), SOUTH(3,"S", 0, -1), WEST(4,"W", -1, 0);

	private final Integer id;
	private final String letter;
	private final Integer addValueCoordinateX;
	private final Integer addValueCoordinateY;

	private Direction(Integer id,String letter, Integer addValueCoordinateX, Integer addValueCoordinateY) {
		this.id = id;
		this.letter = letter;
		this.addValueCoordinateX = addValueCoordinateX;
		this.addValueCoordinateY = addValueCoordinateY;
	}

	public Integer getAddValueCoordinateX() {
		return addValueCoordinateX;
	}

	public Integer getAddValueCoordinateY() {
		return addValueCoordinateY;
	}

	public String getLetter() {
		return letter;
	}

	public Integer getId() {
		return id;
	}
	
	public Direction rotateLeft() {
		Integer nextId = this.getId()-1;
		if(nextId==0){
			nextId = 4;
		} 
		return getById(nextId);
	}

	public Direction rotateRight() {
		Integer nextId = (this.getId()+1)%4;
		if(nextId==0){
			nextId = 4;
		} 
		return getById(nextId);
	}
	
	/**
	 * Gets the {@link Direction} by id.
	 * 
	 * @param id
	 *            The given value.
	 * @return A {@link DeathType} or <code>null</code>.
	 */
	public static Direction getById(final Integer id) {
		for (final Direction direction : values()) {
			if (Integer.compare(id, direction.getId()) == 0) {
				return direction;
			}
		}
		return null;
	}
}