package log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author SkyFervor
 */
public class Test {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(Test.class);
		logger.error("1", new Exception("2"));
	}
}
