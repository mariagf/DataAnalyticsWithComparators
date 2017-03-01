
/** 
*   <h1>Current Act Comparator<h1>
*   CurrentActComparator class that would help to sort the BankRecord objects by 
*   current_act
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class CurrentActComparator implements Comparator<BankRecords> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getCurrent_act().compareTo(o2.getCurrent_act());
	}
}
