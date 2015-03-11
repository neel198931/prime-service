package primeService.server;

import java.util.Scanner;
import primeService.socket.PrimeServerSocket;
import primeService.util.PrimeMenu;
import primeService.util.Debug;

/**
 * Display menu to user. Take input from user and process request on
 * server. Initiate methods in PrimeQuery instance as per user input.
 */

public class ServerMenu implements PrimeMenu {
	private PrimeServerSocket ps;
	private PrimeQueriesInterface queries;
        private Debug debug = Debug.getInstance();

	private Scanner scanner;

        /**
         * Class constructor.
	 * @param  psIn  instance of PrimeServerSocket
	 * @param  queriesIn  instance of AllPrimeQueries
         */
	public ServerMenu(PrimeServerSocket psIn, PrimeQueriesInterface queriesIn) {
                debug.printToLog(2, "Server : Constructor called in ServerMenu\n");
		// save instance of prime server socket
		this.ps = psIn;
		this.queries =  queriesIn;
		// save instance of all prime queries
                scanner = new Scanner(System.in);
        }

        /**
         * Display menu to screen
         */
        public void displayMenu() {
		// display menu options
                debug.printToLog(3, "Server : Method called displayMenu() in ServerMenu\n");
                System.out.println("[1] Client Name");
                System.out.println("[2] All client queries");
                System.out.println("[3] Quit");
        }

        /**
         * Takes input from user in string format. Converts input to
	 * integer and check value. If input is 1 then send second
	 * argument as client name to AllPrimeQuery instance to print 
	 * queries.
         */
	public void getUserInput() {
                debug.printToLog(3, "Server : Method called getUserInput() in ServerMenu\n");
		// take input from user
                String input = scanner.nextLine();
                input = input + " .";
                String ins[] = input.split(" ");

                if(ins[0].equals("1")) {
			// call query to print response
			queries.printResponse(ins[1]);
                }else if(ins[0].equals("2")) {
			// call query to print all response
			queries.printAllResponse();
                }else if(ins[0].equals("3")) {
			// close socket and exit
                        ps.quit();
                        System.exit(0);
                }else {
                        System.err.println("Incorrect input");
                }
        }

        /**
         * Keeps displaying menu to screen and call getUserInput method.
         */
        public void runMenu() {
                debug.printToLog(3, "Server : Method called run() in ServerMenu\n");
		while(true) {
                        displayMenu();
                        getUserInput();
                }
        }
}
