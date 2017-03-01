
/** 
*   <h1>Id Comparator<h1>
*   IdComparator class that would help to sort the BankRecord objects by id
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class IdComparator implements Comparator<BankRecords> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getId().compareTo(o2.getId());
	}
}