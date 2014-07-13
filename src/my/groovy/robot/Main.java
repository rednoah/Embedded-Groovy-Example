package my.groovy.robot;

import groovy.lang.GroovyClassLoader;

import java.io.FileReader;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl;

public class Main {

	public static void main(String[] args) throws Exception {
		CompilerConfiguration config = new CompilerConfiguration();
		config.setScriptBaseClass("my.groovy.robot.RobotScript");

		// default imports
		ImportCustomizer imports = new ImportCustomizer();
		imports.addStarImports("my.groovy.robot");
		imports.addStaticStars("my.groovy.robot.Robot.Direction");
		config.addCompilationCustomizers(imports);

		GroovyClassLoader classLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader(), config);
		GroovyScriptEngineImpl engine = new GroovyScriptEngineImpl(classLoader);

		// call script
		engine.eval(new FileReader("MyRobotScript.groovy"));

		// get final state
		Map<String, Robot> state = (Map<String, Robot>) engine.invokeFunction("getState", null);
		for (Entry<String, Robot> it : state.entrySet()) {
			System.out.println(it.getValue());
		}
	}
}
