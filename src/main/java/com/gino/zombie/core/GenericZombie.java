package com.gino.zombie.core;

import org.springframework.stereotype.Component;

import com.gino.zombie.model.Coordinates;

/**
 * @author Gino
 *
 */

@Component("Generic")
public class GenericZombie implements Zombie {

	@Override
	public Coordinates moveUp(int gridSize, Coordinates currentPosition) {
		int y = currentPosition.getY() - 1;
		Coordinates newPosition = new Coordinates();
		newPosition.setY(y < 0 ? y + gridSize : y);
		newPosition.setX(currentPosition.getX());
		return newPosition;
	}

	@Override
	public Coordinates moveDown(int gridSize, Coordinates currentPosition) {
		int y = currentPosition.getY() + 1;
		Coordinates newPosition = new Coordinates();
		newPosition.setY(y == gridSize ? y - gridSize : y);
		newPosition.setX(currentPosition.getX());
		return newPosition;
		
	}

	@Override
	public Coordinates moveLeft(int gridSize, Coordinates currentPosition) {
		int x = currentPosition.getX() - 1;
		Coordinates newPosition = new Coordinates();
		newPosition.setY(currentPosition.getY());
		newPosition.setX(x < 0 ? x + gridSize : x);
		return newPosition;
	}

	@Override
	public Coordinates moveRight(int gridSize, Coordinates currentPosition) {
		int x = currentPosition.getX() + 1;
		Coordinates newPosition = new Coordinates();
		newPosition.setY(currentPosition.getY());
		newPosition.setX(x == gridSize ? x - gridSize : x);
		return newPosition;
	}
}
