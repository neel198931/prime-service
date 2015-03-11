package primeService.util;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.lang.NumberFormatException;

/**
 * Logs messages in debug log file as per debug value.
 */

public class Debug{
	/**
	 * Designed as Singleton pattern which
	 * create instance as soon as class is loaded
	 */
	private static Debug debug = new Debug();
	private static String fileName = "debugLog.txt";
	private FileWriter writer = null;
	private static int DEBUG_VALUE = 0;

        /**
         * Class constructor.
         */
	private Debug() { }

        /**
         * Retuns instance of Debug object
	 * @return	object of Debug class
         */
	public static Debug getInstance() {
		// return instance of debug
		return debug;
	}

        /**
         * Set debug value
	 * @param  value  a value specified by user
         */
	public void setDebug_Value(String value) {
		// set debug value
		try {
			// check if debug value is integer
			int v = Integer.parseInt(value);
			// value should be between 0 and 3
			if(v < 4 && v >= 0)
				DEBUG_VALUE = v;
			else {
				System.err.println("Debug value should be entered as number between 0 and 3");
				System.exit(-1);
			}
		} catch (NumberFormatException e) {
			System.err.println("Debug value should be entered as number between 0 and 3");
			System.exit(-1);
		}
	}

        /**
         * Print message to log file
	 * @param  level  debug value
	 * @param  debugMessage  message to be printed in log
         */
	public void printToLog(int level, String debugMessage) {
		if(level != DEBUG_VALUE)
			return;
		try {
			//print message in debug log file
			writer = new FileWriter(fileName, true);
			if(level == DEBUG_VALUE)
				writer.write(debugMessage);
			writer.close();
		} catch (IOException e) {
			System.err.println("Not able to write to file " + fileName);
			System.exit(-1);
		}
	}
}
