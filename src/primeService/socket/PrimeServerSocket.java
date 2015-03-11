package primeService.socket;

import java.net.ServerSocket;
import java.io.IOException;
import primeService.server.PrimeQueriesInterface;
import primeService.util.Debug;

/**
 * Register server socket at specified port on localhost. Creates
 * multiple threads when a client connection is accepted.
 */
public class PrimeServerSocket extends Thread {

	private ServerSocket serverSocket;
	private PrimeQueriesInterface primeQueries;
	private boolean listening;
	private Debug debug = Debug.getInstance();

	 /**
         * Class Constructor
	 * @param  port  port number on which server socket to be created
	 * @param  primreQueriesIn  instance of AllPrimeQueries
         */
	public PrimeServerSocket(String port, PrimeQueriesInterface primeQueriesIn) {
                debug.printToLog(2, "Server : Constructor called in PrimeServerSocket\n");

		try {
                        int portNumber = Integer.parseInt(port);
			serverSocket = new ServerSocket(portNumber);
			primeQueries = primeQueriesIn;
			listening = true;
		} catch (IOException e) {
			System.err.println("Cannot initialise server socket");
			System.exit(-1);
                } catch (NumberFormatException e) {
                        System.err.println("Enter port number as integer");
                        System.exit(-1);
                }

	}

	/**
	 * Listen to connection from client. Creates a new PrimeServerWorker
	 * when a new client thread tries to connect.
	 */
	public void run() {
                debug.printToLog(3, "Server : Method called run() in PrimeServerSocket\n");
		try {
			while (listening) {
				new PrimeServerWorker(serverSocket.accept(), primeQueries).start();
			}
		} catch (IOException e) {
			System.exit(-1);
		}
	}

	/**
	 * Close the server socket and exits the program
	 */
	public void quit() {
                debug.printToLog(3, "Server : Method called quit() in PrimeServerSocket\n");
		try {
			listening = false;
			serverSocket.close();
		} catch (IOException e) {
			System.err.println("Cannot close socket ");
			System.exit(-1);
		} finally {
			System.exit(0);
		}
	}
}
