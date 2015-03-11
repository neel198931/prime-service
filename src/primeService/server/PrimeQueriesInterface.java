package primeService.server;
/**
 * Interface to define PrimeQuery class
 */
public interface PrimeQueriesInterface {
	public void printResponse(String name);
	public void printAllResponse();
	public void addQuery(String name, Integer query);
}
