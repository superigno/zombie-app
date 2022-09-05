package com.gino.zombie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gino.zombie.core.FastZombie;
import com.gino.zombie.core.GenericZombie;
import com.gino.zombie.core.Zombie;
import com.gino.zombie.exception.ZombieException;
import com.gino.zombie.model.Coordinates;
import com.gino.zombie.validation.Validation;

class ZombieMovementTest {
	
	private Zombie genericZombie = new GenericZombie();
	private Zombie fastZombie = new FastZombie();
	private int gridSize = 4;
	
	@Test
	void moveUp() {		
		Coordinates newPosition = genericZombie.moveUp(gridSize, new Coordinates(3,1));
		assertEquals(new Coordinates(3,0), newPosition);
		
		newPosition = genericZombie.moveUp(gridSize, new Coordinates(3,2));
		assertEquals(new Coordinates(3,1), newPosition);
		
		newPosition = fastZombie.moveUp(gridSize, new Coordinates(3,3));
		assertEquals(new Coordinates(3,1), newPosition);
		
		newPosition = fastZombie.moveUp(gridSize, new Coordinates(3,0));
		assertEquals(new Coordinates(3,2), newPosition);
		
		newPosition = fastZombie.moveUp(gridSize, new Coordinates(3,1));
		assertEquals(new Coordinates(3,3), newPosition);
	}
	
	@Test
	void moveDown() {		
		Coordinates newPosition = genericZombie.moveDown(gridSize, new Coordinates(3,1));
		assertEquals(new Coordinates(3,2), newPosition);
		
		newPosition = genericZombie.moveDown(gridSize, new Coordinates(3,2));
		assertEquals(new Coordinates(3,3), newPosition);
		
		newPosition = fastZombie.moveDown(gridSize, new Coordinates(3,3));
		assertEquals(new Coordinates(3,1), newPosition);
		
		newPosition = fastZombie.moveDown(gridSize, new Coordinates(3,2));
		assertEquals(new Coordinates(3,0), newPosition);		
		
	}
	
	@Test
	void moveLeft() {		
		Coordinates newPosition = genericZombie.moveLeft(gridSize, new Coordinates(3,1));
		assertEquals(new Coordinates(2,1), newPosition);
		
		newPosition = genericZombie.moveLeft(gridSize, new Coordinates(3,2));
		assertEquals(new Coordinates(2,2), newPosition);
		
		newPosition = genericZombie.moveLeft(gridSize, new Coordinates(0,0));
		assertEquals(new Coordinates(3,0), newPosition);
		
		newPosition = fastZombie.moveLeft(gridSize, new Coordinates(3,3));
		assertEquals(new Coordinates(1,3), newPosition);
		
		newPosition = fastZombie.moveLeft(gridSize, new Coordinates(2,3));
		assertEquals(new Coordinates(0,3), newPosition);
		
		newPosition = fastZombie.moveLeft(gridSize, new Coordinates(0,0));
		assertEquals(new Coordinates(2,0), newPosition);
		
		newPosition = fastZombie.moveLeft(gridSize, new Coordinates(1,0));
		assertEquals(new Coordinates(3,0), newPosition);
	}
	
	@Test
	void moveRight() {		
		Coordinates newPosition = genericZombie.moveRight(gridSize, new Coordinates(3,1));
		assertEquals(new Coordinates(0,1), newPosition);
		
		newPosition = genericZombie.moveRight(gridSize, new Coordinates(3,2));
		assertEquals(new Coordinates(0,2), newPosition);
		
		newPosition = genericZombie.moveRight(gridSize, new Coordinates(0,0));
		assertEquals(new Coordinates(1,0), newPosition);
		
		newPosition = genericZombie.moveRight(gridSize, new Coordinates(3,3));
		assertEquals(new Coordinates(0,3), newPosition);
		
		newPosition = fastZombie.moveRight(gridSize, new Coordinates(3,3));
		assertEquals(new Coordinates(1,3), newPosition);
		
		newPosition = fastZombie.moveRight(gridSize, new Coordinates(2,3));
		assertEquals(new Coordinates(0,3), newPosition);
		
		newPosition = fastZombie.moveRight(gridSize, new Coordinates(0,0));
		assertEquals(new Coordinates(2,0), newPosition);
		
		newPosition = fastZombie.moveRight(gridSize, new Coordinates(1,0));
		assertEquals(new Coordinates(3,0), newPosition);
	}
	
	@Test
	void validateGridAndPosition() {
		Assertions.assertThrows(ZombieException.class, () -> {
			Validation.validateGridAndPosition(gridSize, List.of(new Coordinates(4,4)));
		}, "ZombieException was expected");	
	}

}
