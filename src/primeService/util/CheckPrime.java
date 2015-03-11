package primeService.util;

import primeService.util.Debug;

/**
 * Process qery fro client. If number is less than threshold than
 * returns as "Can't say". Otherwise return if a number is even or
 * odd.
 */

public class CheckPrime implements CheckPrimeInterface {
	private int threshold = 3;
        private Debug debug = Debug.getInstance();

	/**
	 * Class constructor.
	 */
	public CheckPrime() {
                debug.printToLog(2, "Server : Constructor called in CheckPrime\n");
	}

	/**
	 * Method to check numer is even or odd
	 * @param  value  number to be checked
	 */
	public String checkNumber(int value) {
                debug.printToLog(3, "Server : Method called checkNumber() in CheckPrime\n");
		// check if value is less than threshold
		if(value < threshold)
			return "Can't say";

		// if even then return yes else no
		if((value % 2) == 0)
			return "Yes";
		return "No";
	}

}
