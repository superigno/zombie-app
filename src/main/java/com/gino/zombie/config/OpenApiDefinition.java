package com.gino.zombie.config;

import static lombok.AccessLevel.PRIVATE;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.NoArgsConstructor;

@OpenAPIDefinition(info = @Info(title = "Zombie Apocalypse", version = "4.6.1", description = OpenApiDefinition.DESCRIPTION))
@NoArgsConstructor(access = PRIVATE)
public class OpenApiDefinition {

	static final String DESCRIPTION = "## Overview\r\n\r\n"
			+ "After the nuclear war, a strange and deadly virus has infected the planet producing mindless "
			+ "zombies. These zombies now wander the world converting any remaining living creatures they find to zombies as well.\r\n\r\n"

			+ "The world is represented by an *n* x *n* grid on which **zombies** and **creatures** live. "
			+ "The location of zombies and creatures can be addressed using zero-indexed *x-y* coordinates. "
			+ "The top left corner of the world is *(x: 0, y: 0)*. The horizontal coordinate is represented by *x*, "
			+ "and the vertical coordinate is represented by *y*.\r\n\r\n"

			+ "At the beginning of the program, a single zombie awakes and begins to move around the grid following a sequence of movements. "
			+ "Valid movements are **U**p, **D**own, **L**eft, **R**ight. The movement sequence is represented by a string of single "
			+ "character movements, e.g. *RDRU* (**R**ight, **D**own, **R**ight, **Up**).\r\n\r\n"

			+ "Zombies can move through the edge of the grid, appearing on the directly opposite side. "
			+ "For a 10x10 grid, a zombie moving left from (0, 4) will move to (9, 4); a zombie moving down from (3, 9) will move to (3, 0).\r\n\r\n"

			+ "Each time a zombie takes a step, the new location should be logged, eg:\r\n\r\n"
			+ "*zombie 0 moved to (2,3)*.\r\n\r\n"

			+ "If a zombie occupies the same square as a creature, the creature is transformed into another zombie.\r\n\r\n"

			+ "Each time a zombie infects a creature this should be logged, eg:\r\n\r\n"
			+ "*zombie 0 infected creature at (3,3)*.\r\n\r\n"

			+ "The creatures are aware of the zombie’s presence but are so frightened that they never move.\r\n\r\n"

			+ "Once a zombie has completed its movement, the first newly created zombie moves using the same sequence "
			+ "as the original zombie, then the second newly created zombie moves, and so on, in order of infection. "
			+ "Each zombie performs the same sequence of moves. Once all zombies have completed moving, the final positions of all "
			+ "zombies and creatures should be output, then the program ends.";
}
