package primeService.server;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.LinkedList;
import primeService.util.Debug;

/**
 * Saves queries recieved from clients and displays as per user request
 * from menu. If no client request is present, then print black line.
 */

public class AllPrimeQueries implements PrimeQueriesInterface {
	// concurrent hash map to store client queries
	private ConcurrentMap<String, List<Integer>> queryTable;
	private Debug debug = Debug.getInstance();

        /**
         * Class constructor.
         */
	public AllPrimeQueries() {
                debug.printToLog(2, "Server : Constructor called in AllPrimeQueries\n");
		// create instance of data structure
		queryTable = new ConcurrentHashMap<String, List<Integer>>();
	}

        /**
         * Prints queries made by specific client name to screen
	 * @param  name  client name for which queries to be printed
         */
	public void printResponse(String name) {
                debug.printToLog(3, "Server : Method called printResponse() in AllPrimeQueries\n");
		// check if cleint is already present
		List<Integer> queries = queryTable.get(name);
		if(queries == null) {
			System.err.println("Client name not found\n");
			return;
		}
		// print cleint queries
		System.out.print(name + " : ");
		for(Integer q : queries)
			System.out.print(q + " ");
		System.out.println();
	}

        /**
         * Prints queries made by all the clients to screen
         */
	public void printAllResponse() {
                debug.printToLog(3, "Server : Method called printAllResponse() in AllPrimeQueries\n");

		List<Integer> queries;
		// iterate to all keys
		for(String name : queryTable.keySet()) {
			queries = queryTable.get(name);
			// print query list
			System.out.print(name + " : ");
			for(Integer q : queries)
				System.out.print(q + " ");
			System.out.println();
		}
	}

        /**
         * Add query made by client to data structure
	 * @param   name  name of the client
	 * @param   query query made by client
         */
	public void addQuery(String name, Integer query) {
                debug.printToLog(3, "Server : Method called addQuery() in AllPrimeQueries\n");
                debug.printToLog(1, "Server : Query added in AllPrimeQueries\n");
		// check if client name is present in queryTable
		List<Integer> queries = queryTable.get(name);
		if(queries == null) {
			// add new list if not present
			queries = new LinkedList<Integer>();
			queryTable.put(name, queries);
		}
		// add recent query
		queries.add(query);
	}
}
