package com.gino.zombie.core;

import com.gino.zombie.model.Coordinates;

/**
 * @author Gino
 *
 */
public interface Zombie {
	Coordinates moveUp(int gridSize, Coordinates currentPosition);
	Coordinates moveDown(int gridSize, Coordinates currentPosition);
	Coordinates moveLeft(int gridSize, Coordinates currentPosition);
	Coordinates moveRight(int gridSize, Coordinates currentPosition);
}
