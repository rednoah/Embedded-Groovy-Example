package my.groovy.robot;

import groovy.lang.GroovyObjectSupport;

public class Robot extends GroovyObjectSupport {

	public static enum Direction {
		UP(0, 1), RIGHT(1, 0), DOWN(0, -1), LEFT(-1, 0);

		final int dx;
		final int dy;

		Direction(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
	}

	private int x;
	private int y;

	public void move(Direction d) {
		x += d.dx;
		y += d.dy;
	}

	private final String name;

	public Robot(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%s [%s, %s]", name, x, y);
	}

	@Override
	public Object getProperty(String property) {
		try {
			return super.getProperty(property);
		} catch (Exception e) {
			System.err.format("%s: '%s' DOES NOT COMPUTE%n", name, property);
			return null;
		}
	}
}
