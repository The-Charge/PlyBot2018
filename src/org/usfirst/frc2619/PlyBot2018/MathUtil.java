package org.usfirst.frc2619.PlyBot2018;

public class MathUtil {
	public static double calcDirection(double current, double desired) {
		current = Math.toRadians(current);
		desired = Math.toRadians(desired);
		double current_x = Math.cos(current);
		double current_y = Math.sin(current);
		double desired_x = Math.cos(desired);
		double desired_y = Math.sin(desired);
		double direction = Math.signum(current_x * desired_y - desired_x * current_y);
		return direction;
		// 1 clockwise, -1 counterclockwise
	}
}
