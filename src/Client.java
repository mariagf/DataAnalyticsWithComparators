/**
 * <h1>Client
 * <h1>The Client abstract class contains the three methods that the bank needs
 * to read data from a cvs file, process it and print it. As it is an abstract
 * class, these methods are implemented in the BankRecord class.
 * @author Maria Garcia Fernandez
 * @version 2.0
 * @since 2017-01-31
 */

public abstract class Client {

	/**
	 * Abstract method that would read all the record data from a cvs file in a
	 * path given and place it in an ArrayList
	 */
	public abstract void readData();

	/**
	 * Abstract method that will take all the record data from an ArrayList line
	 * by line and add the data via setters into an array that will contain a
	 * BankRecords object in each position
	 */
	public abstract void processData();

	/**
	 * Abstract method that would print the BankRecords via getters. Only these
	 * fields will be printed: ID, AGE, SEX, REGION, INCOME, and MORTGAGE.
	 * @param nRecords the number of client records that would be printed
	 */
	public abstract void printData(int nRecords);

}
