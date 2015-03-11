package primeService.socket;

import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import primeService.util.Debug;

/**
 * Register connection on specified host name and port. Sends user
 * query to server. Reads and save last response from server.
 * Mantains client name.
 */

public class PrimeClientSocket {
	private String clientName, responseString;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private Debug debug = Debug.getInstance();

	/**
	 * Class Constructor
	 * @param  hostName  sever host on connection is to be made
	 * @param  port	     port number on server to be connected
	 */
	public PrimeClientSocket(String hostName, String port) {
		debug.printToLog(2, "Client : Constructor caller PrimeClientSocket\n");
		// initialise socket and connect to server
		try {
			int portNumber = Integer.parseInt(port);
			socket = new Socket(hostName, portNumber);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("Cannot connect to " + hostName + " at port " + port);
			System.exit(-1);
                } catch (NumberFormatException e) {
                        System.err.println("Enter port number as integer");
                        System.exit(-1);
                }

		// client name is set to default
		clientName = "default";
	}

	/**
	 * Returns last response recieved from server
	 * @return  last response from server
	 */
	public String getResponse() {
		debug.printToLog(3, "Client : Method called getResponse() in PrimeClientSocket\n");
		return responseString;
	}

	/**
	 * Change client name to given parameter
	 * @param  name  cleint name to be set
	 */
	public void setClientName(String name) {
                debug.printToLog(3, "Client : Method called setClientName() in PrimeClientSocket\n");
		this.clientName = name;
	}

	/**
	 * Quit client and exits the program
	 */
	public void quit() {
                debug.printToLog(3, "Client : Method called quit() in PrimeClientSocket\n");
		// send quit message to notify server
		sendMessage("quit");
		try {
			socket.close();
		} catch (IOException e) {
			System.err.println("Unable to close Socket");
			System.exit(-1);
		}
	}

	/**
	 * Send message to server along with client name
	 * @param  msg  message to be sent to server
	 */
	public void sendMessage(String msg) {
                debug.printToLog(3, "Client : Method called sendMessage() in PrimeClientSocket\n");
		try {
			// concats client name with message
			out.println(clientName + " " + msg);
			if(msg.equals("quit"))
				return;
			responseString = in.readLine();
			if(responseString == null) {
				socket.close();
				System.out.println("Server is not longer available");
				System.exit(0);
			}
		} catch (IOException e) {
			System.err.println("Unable to read from server");
			System.exit(-1);
		}
	}
}
