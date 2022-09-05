package com.gino.zombie.validation;

import java.util.List;

import com.gino.zombie.exception.ZombieException;
import com.gino.zombie.model.Coordinates;

/**
 * @author Gino
 *
 */
public class Validation {
	
	public static void validateGridAndPosition(int gridSize, List<Coordinates> positions) {
		for (Coordinates position : positions) {
			if (gridSize <= position.getX() || gridSize <= position.getY()) {
				throw new ZombieException("The value of the position " + position + " does not fit in the grid.");
			}
		}
	}
	
}
