package my.groovy.robot;

import groovy.lang.Closure;
import groovy.lang.Script;

import java.util.HashMap;
import java.util.Map;

public abstract class RobotScript extends Script {

	private final Map<String, Robot> robots = new HashMap<>();

	@Override
	public Object getProperty(String name) {
		if (robots.containsKey(name))
			return robots.get(name);

		return super.getProperty(name);
	}

	public void create(String name) {
		register(new Robot(name, 0, 0));
	}

	public void register(Robot robot) {
		robots.put(robot.getName(), robot);
	}

	public void repeat(int n, Closure<?> c) {
		for (int i = 0; i < n; i++) {
			c.call();
		}
	}

	public Map<String, Robot> getState() {
		return robots;
	}

}
