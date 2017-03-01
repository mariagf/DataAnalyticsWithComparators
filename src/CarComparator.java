
/** 
*   <h1>Car Comparator<h1>
*   CarComparator class that would help to sort the BankRecord objects by car owners
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class CarComparator implements Comparator<BankRecords> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getCar().compareTo(o2.getCar());
	}
}
