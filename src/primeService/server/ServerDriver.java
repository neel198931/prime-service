package primeService.server;

import primeService.socket.PrimeServerSocket;
import primeService.util.PrimeMenu;
import primeService.util.Debug;

/**
 * Start the server. Register port on localhost and intiate
 * socket connection. Initiate server menu and socket.
 */

public class ServerDriver {
        private Debug debug = Debug.getInstance();

	private PrimeQueriesInterface primeQueries;
	private PrimeServerSocket primeServer;
	private PrimeMenu menu;

        /**
         * Class constructor. Creates server socket and server Menu
	 * @param  args[]  takes arguments entered by user
         */

	public ServerDriver(String args[]) {
		// check length of arguments
		if(args.length < 3) {
                        System.err.println("Enter arguments as follows");
                        System.err.println("-Darg0=server -Darg1=<port> -Darg2=<debug value>");
			System.exit(-1);
		}
		// set debug value
		debug.setDebug_Value(args[2]);
                // create instance of all prime queries
		primeQueries = new AllPrimeQueries();
		// create instance of primeServerSocket
		primeServer = new PrimeServerSocket(args[1], primeQueries);
		// create instance of menu
		menu = new ServerMenu(primeServer, primeQueries);
	}

        /**
         * Initiate server menu and server socket
         */
	public void startServer() {
                debug.printToLog(3, "Server : Method called startServer() in ServerDriver\n");
		// start server and menu
		primeServer.start();
		menu.runMenu();
	}
}

