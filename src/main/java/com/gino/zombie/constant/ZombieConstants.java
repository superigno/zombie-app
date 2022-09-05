package com.gino.zombie.constant;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class ZombieConstants {

	public static final String ZOMBIE_API_TAG = "Zombie API";
	
	public static final class Url {
		public static final String HELLO = "/hello";
		public static final String WANDER = "/wander";
	}	

}
