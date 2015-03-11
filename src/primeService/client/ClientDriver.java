package primeService.client;

import primeService.socket.PrimeClientSocket;
import primeService.util.PrimeMenu;
import primeService.util.Debug;

/**
 * Start the Client. Connect to port on specified host name. Initate
 * client menu and socket.
 */
public class ClientDriver {
	private Debug debug = Debug.getInstance();

	private PrimeMenu menu;
	private PrimeClientSocket pc;

        /**
         * Class constructor. Create instance of Menu and PrimeClientSocket
	 * @param  args[]  arguments entered by user as String array
         */
	public ClientDriver (String args[]) {
                // check length of arguments
                if(args.length < 4) {
			System.err.println("Enter arguments as follows");
                        System.err.println("-Darg0=client -Darg1=<hostname> -Darg2=<port> -Darg3=<debug value>");
                        System.exit(-1);
                }
                // set debug value
                debug.setDebug_Value(args[3]);
                // create instance of primeClientSocket
                pc = new PrimeClientSocket(args[1], args[2]);
                // create instance of menu
                menu = new ClientMenu(pc);

	}

        /**
         * Initiate client menu
         */
	public void startClient() {
                debug.printToLog(3, "Client : Method called startClient() in ClientDriver\n");
		menu.runMenu();
	}
}
