
/** 
*   <h1>Save Act Comparator<h1>
*   SaveActComparator class that would help to sort the BankRecord objects by save_act
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class SaveActComparator implements Comparator<BankRecords> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getSave_act().compareTo(o2.getSave_act());
	}
}
