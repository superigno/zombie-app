package com.gino.zombie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gino.zombie.constant.ZombieConstants;
import com.gino.zombie.exception.DefaultApiErrorResponses;
import com.gino.zombie.model.Zombie;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = ZombieConstants.ZOMBIE_API_TAG)
@DefaultApiErrorResponses
public interface ZombieApi {

  @GetMapping(ZombieConstants.Url.HELLO)
  @Operation(summary = "Say hello", description = "Just a zombie saying hello")
  @ApiResponse(
	      responseCode = "200",
	      description = "The zombie's response.")
  String sayHello();
  
  @Operation(summary = "Wander around", description = "Start wandering and convert any remaining living creatures to zombies")
  @PostMapping(ZombieConstants.Url.WANDER)
  @ApiResponse(
	      responseCode = "200",
	      description = "The zombies and creatures' final positions after wandering around.")
  String wander(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description="Details before the zombies start to infest!") Zombie params);

}
