package com.gino.zombie.model;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gino
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {
	
	@Schema(description = "The horizontal coordinate.", example = "3")
	private int x;
	
	@Schema(description = "The vertical coordinate.", example = "1")
	private int y;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		return x == other.x && y == other.y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
