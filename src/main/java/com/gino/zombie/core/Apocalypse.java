package com.gino.zombie.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.gino.zombie.exception.InvalidMovementException;
import com.gino.zombie.exception.ZombieException;
import com.gino.zombie.model.Coordinates;
import com.gino.zombie.model.Movement;
import com.gino.zombie.validation.Validation;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Apocalypse {
	
	private Zombie zombie;
	private List<Coordinates> newZombiesInitialPositions;
	private StringBuilder sb;

	public Apocalypse(Zombie zombie) {
		this.zombie = zombie;
	}
	
	public synchronized String wander(List<Coordinates> initialPositionZombies, List<Coordinates> creaturesPositions, int gridSize, String movements) {
		try {
			Validation.validateGridAndPosition(gridSize, initialPositionZombies);
			Validation.validateGridAndPosition(gridSize, creaturesPositions);
			
			List<Coordinates> finalZombiePositions = new ArrayList<>();
			sb = new StringBuilder();
			int ctr = 0;			
			do {			
				newZombiesInitialPositions = new ArrayList<>();
				for (Coordinates initialPosition : initialPositionZombies) {	
					LinkedList<Coordinates> zombieMovementPositions = trackMovementPositions("Zombie " + ctr, initialPosition, creaturesPositions, gridSize, movements);
					Coordinates finalZombiePosition = trackFinalZombiePosition(zombieMovementPositions);				
					finalZombiePositions.add(finalZombiePosition);	
					ctr++;
				}			
				initialPositionZombies = newZombiesInitialPositions;
			} while (newZombiesInitialPositions != null && !newZombiesInitialPositions.isEmpty());
			
			sb.append("Zombies' Positions: ").append(finalZombiePositions).append(System.lineSeparator());
			sb.append("Creatures' Positions: ").append(CollectionUtils.isEmpty(creaturesPositions) ? "none" : creaturesPositions);
			return sb.toString();
			
		} catch(Exception e) {
			if (e instanceof InvalidMovementException) {
				throw e;
			} else {
				throw new ZombieException(e.getMessage(), e);
			}
		}
	}
	
	private Coordinates trackFinalZombiePosition(LinkedList<Coordinates> zombieMovementPositions) {		
		return zombieMovementPositions.getLast();
	}	
	
	private boolean hasInfectedCreature(String zombieName, List<Coordinates> creaturePositions, Coordinates zombieMovementPosition) {
		boolean infected = false;
		if (creaturePositions.contains(zombieMovementPosition)) {
			log.info(zombieName + " infected creature at {}", zombieMovementPosition);
			sb.append(zombieName + " infected creature at " + zombieMovementPosition).append(System.lineSeparator());
			infected = true;	
			newZombiesInitialPositions.add(zombieMovementPosition);
			creaturePositions.remove(zombieMovementPosition); //Remove creature position that has been infected
		}		
		return infected;
	}
	
	private LinkedList<Coordinates> trackMovementPositions(String zombieName, Coordinates initialPosition, List<Coordinates> creaturesPositions, int gridSize, String movements) {		
		LinkedList<Coordinates> movementPositions = new LinkedList<>();		
		Coordinates currentPos = initialPosition;
		for (int i = 0; i < movements.length(); i++) {
			Movement movement = null;
			try {
				movement = Movement.valueOf(String.valueOf(movements.charAt(i)));
			} catch(Exception e) {			
				throw new InvalidMovementException("Invalid zombie movement was entered: " + movements.charAt(i), e);
			} 
			currentPos = getNewPosition(zombieName, movement, gridSize, currentPos);
			movementPositions.add(currentPos);			
			hasInfectedCreature(zombieName, creaturesPositions, currentPos);			
		}
		return movementPositions;		
	}
	
	private Coordinates getNewPosition(String zombieName, Movement movement, int gridSize, Coordinates currentPosition) {
		log.debug("Movement: {}", movement);
		Coordinates position = null;
		switch (movement) {
		case U:
			position = zombie.moveUp(gridSize, currentPosition);
			break;
		case D:
			position = zombie.moveDown(gridSize, currentPosition);
			break;
		case L:
			position = zombie.moveLeft(gridSize, currentPosition);
			break;
		case R:
			position = zombie.moveRight(gridSize, currentPosition);
			break;
		default:
			return currentPosition;
		}
		log.info(zombieName + " moved to {}", position);
		sb.append(zombieName + " moved to " + position).append(System.lineSeparator());
		return position;
	}
}
