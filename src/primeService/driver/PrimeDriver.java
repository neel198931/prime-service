package primeService.driver;

import primeService.server.ServerDriver;
import primeService.client.ClientDriver;
import primeService.util.Debug;

public class PrimeDriver {
	public static void main(String args[]) {

		if(args[0].equals("server")) {
			ServerDriver server = new ServerDriver(args);
			server.startServer();
		} else if(args[0].equals("client")) {
			ClientDriver client = new ClientDriver(args);
			client.startClient();
		} else {
			System.err.println("Run program as one of follows");
			System.err.println("-Darg0=server -Darg1=<port> -Darg2=<debug value>");
                        System.err.println("-Darg0=client -Darg1=<host> -Darg2=<port> -Darg3=<debug value>");
			System.exit(-1);
		}
	}
}
