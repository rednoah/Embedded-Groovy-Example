package my.groovy.robot;

import java.util.Scanner;

public class RobotMethods {

	public static Robot toRobot(String self) {
		Scanner tokenizer = new Scanner(self).useDelimiter("\\W");
		return new Robot(tokenizer.next(), tokenizer.nextInt(), tokenizer.nextInt());
	}

}
