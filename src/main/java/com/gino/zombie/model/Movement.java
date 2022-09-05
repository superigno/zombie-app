package com.gino.zombie.model;

/**
 * @author Gino
 *
 */
public enum Movement {
	U("Up"), D("Down"), L("Left"), R("Right");

	private String movement;
	
	Movement(String movement) {
		this.movement = movement;
	}
	
	public String getMovement() {
		return this.movement;
	}
}
