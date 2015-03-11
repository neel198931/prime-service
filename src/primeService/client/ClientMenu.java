package primeService.client;

import primeService.socket.PrimeClientSocket;
import java.util.Scanner;
import primeService.util.PrimeMenu;
import primeService.util.Debug;

/**
 * Display menu to user. Take input from user and process request on
 * client. Initiate methods in ClientSocket instance as per user input.
 */

public class ClientMenu implements PrimeMenu {
	private PrimeClientSocket pc;
	private Debug debug = Debug.getInstance();
	private	Scanner in;

        /**
         * Class constructor.
	 * @param  pcIn  instance of PrimeClientSocket
         */
	public ClientMenu(PrimeClientSocket pcIn) {
                debug.printToLog(2, "Client : Constructor called in ClientMenu\n");
		// save instance of PrimeClientSocket
		this.pc = pcIn;
		in = new Scanner(System.in);
	}

        /**
         * Display menu to screen
         */
	public void displayMenu() {
                debug.printToLog(3, "Client : Method called displayMenu() in ClientMenu\n");
		// display menu options
		System.out.println("[1] Set Client Name");
		System.out.println("[2] Enter number to query for prime");
		System.out.println("[3] What is the server response?");
		System.out.println("[4] Quit");
	}

       /**
         * Takes input from user in string format. Converts input to
         * integer and check value. If input is 1 then set name of client
	 * as specified in second argument. If option 2 is entered then
	 * send query in second argument to Server. If option 3 is entered
	 * print last response from server to screen. Quits is 4 is entered.
	 */
	public void getUserInput() {
                debug.printToLog(3, "Client : Method called getUserInput() in ClientMenu\n");

		// take input from user
		String input = in.nextLine();
		input = input + " default";
		String ins[] = input.split(" ");

		if(ins[0].equals("1")) {
			// set client name
			pc.setClientName(ins[1]);
			//System.out.println("Name set done");
		}else if(ins[0].equals("2")) {
			// send message to server
			pc.sendMessage(ins[1]);
			//System.out.println("Input got");
		}else if(ins[0].equals("3")) {
			// print last server response
			System.out.println(pc.getResponse());
		}else if(ins[0].equals("4")) {
			// close socket and exit
			pc.quit();
			System.exit(0);
		}else {
			System.err.println("Incorrect input");
		}
	}

	/**
         * Keeps displaying menu to screen and call getUserInput method.
         */
	public void runMenu() {
                debug.printToLog(3, "Client : Method called runMenu() in ClientMenu\n");
		while(true) {
			displayMenu();
			getUserInput();
		}
	}
}
