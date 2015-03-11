package primeService.socket;

import java.net.Socket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import primeService.util.CheckPrimeInterface;
import primeService.util.CheckPrime;
import primeService.server.PrimeQueriesInterface;
import primeService.util.Debug;

/**
 * Reads query recieved from client. Process the query using CheckPrime
 * and send processed result to client.
 */

public class PrimeServerWorker extends Thread {
	private Socket socket = null;
	private String inputLine;
	private String outputLine;
	private CheckPrimeInterface check;
	private PrimeQueriesInterface primeQueries;
        private Debug debug = Debug.getInstance();

	public PrimeServerWorker(Socket socket, PrimeQueriesInterface primeQueriesIn) {
		// create thread
		super("PrimeServerWorker");
                debug.printToLog(2, "Server : Constructor called in PrimeServerWorker\n");

		primeQueries = primeQueriesIn;
		// all queries will be sent to checkPrime to check response
		check = new CheckPrime();
		this.socket = socket;
	}

	/**
         * Listen to queries from client and process them using CheckPrime.
	 * Sends processed response to client.
         */
        public void run() {
                debug.printToLog(3, "Server : Method called run() in PrimeServerWorker\n");
		try {
			// create input and output stream
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			int number;

			while ((inputLine = in.readLine()) != null) {
				// close connection if client quits
                                if (inputLine.contains("quit"))
                                        break;
				String inputs[] = inputLine.split(" ");
				try {
					number = Integer.parseInt(inputs[1]);
					// process number request from client
					outputLine = check.checkNumber(number);
					// add query in data structure
					primeQueries.addQuery(inputs[0], number);
				} catch (NumberFormatException e) {
					outputLine = "Not a number";
				}
				out.println(outputLine);
			}
			socket.close();
		} catch (IOException e) {
			System.err.println("SocketWroker not able to initiate");
		}
	}
}
