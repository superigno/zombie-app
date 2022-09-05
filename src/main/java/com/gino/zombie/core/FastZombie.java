package com.gino.zombie.core;

import org.springframework.stereotype.Component;

import com.gino.zombie.model.Coordinates;

/**
 * @author Gino
 *
 */

@Component("Fast")
public class FastZombie implements Zombie {

	@Override
	public Coordinates moveUp(int gridSize, Coordinates currentPosition) {
		int y = currentPosition.getY() - 2;
		Coordinates newPosition = new Coordinates();
		newPosition.setY(y == -1 ? gridSize -1 : y == -2 ? gridSize -2 : y);
		newPosition.setX(currentPosition.getX());
		return newPosition;
	}

	@Override
	public Coordinates moveDown(int gridSize, Coordinates currentPosition) {
		int y = currentPosition.getY() + 2;
		Coordinates newPosition = new Coordinates();
		newPosition.setY(y == gridSize ? 0 : y == gridSize + 1 ? 1 : y );
		newPosition.setX(currentPosition.getX());
		return newPosition;
		
	}

	@Override
	public Coordinates moveLeft(int gridSize, Coordinates currentPosition) {
		int x = currentPosition.getX() - 2;
		Coordinates newPosition = new Coordinates();
		newPosition.setY(currentPosition.getY());
		newPosition.setX(x == -1 ? gridSize -1 : x == -2 ? gridSize -2 : x);
		return newPosition;
	}

	@Override
	public Coordinates moveRight(int gridSize, Coordinates currentPosition) {
		int x = currentPosition.getX() + 2;
		Coordinates newPosition = new Coordinates();
		newPosition.setY(currentPosition.getY());
		newPosition.setX(x == gridSize ? 0 : x == gridSize + 1 ? 1 : x );
		return newPosition;
	}
	
}
