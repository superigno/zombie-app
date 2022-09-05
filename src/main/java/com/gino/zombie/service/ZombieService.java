package com.gino.zombie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gino.zombie.core.Apocalypse;
import com.gino.zombie.core.Zombie;
import com.gino.zombie.model.Coordinates;

/**
 * @author Gino
 *
 */
@Service
public class ZombieService {
	
	@Autowired
	@Qualifier("Generic")
	private Zombie zombie;
	
	public String wander(List<Coordinates> initialPositionZombies, List<Coordinates> creaturesPositions, int gridSize, String movements) {
		Apocalypse apocalypse = new Apocalypse(this.zombie);
		return apocalypse.wander(initialPositionZombies, creaturesPositions, gridSize, movements); 
	}

	public String sayHello() {
		return "Grar";
	}
}
