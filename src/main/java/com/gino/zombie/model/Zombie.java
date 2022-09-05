package com.gino.zombie.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Gino
 *
 */
@Data
public class Zombie {
	
	@Schema(description = "Zombies' initial positions", required = true) 
	private List<Coordinates> initialPositions;	
	
	@Schema(description = "Creatures' initial positions", required = true)
	private List<Coordinates> creaturesPositions;
	
	@Schema(description = "The grid size", required = true, example = "4")
	private int gridSize;
	
	@Schema(description = "A string of characters of movements the zombies will do. Valid values can contain concatenated characters of the ff: 'U' for up, 'D' for 'Down', 'L' for 'Left', 'R' for 'Right'", required = true,
			example = "RDRU")
	private String movements;	
}
