package com.gino.zombie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gino.zombie.model.Zombie;
import com.gino.zombie.service.ZombieService;

/**
 * @author Gino
 *
 */
@RestController
public class ZombieController implements ZombieApi {

	@Autowired
	private ZombieService zombieService;
	
	public String sayHello() {
		return zombieService.sayHello();
	}
	
	public String wander(Zombie params) {		
		return zombieService.wander(params.getInitialPositions(), params.getCreaturesPositions(), params.getGridSize(), params.getMovements());
	}
}
