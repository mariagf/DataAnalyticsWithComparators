/** 
*   <h1>Married Comparator<h1>
*   MarriedComparator class that would help to sort the BankRecord objects depending on the client status
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class MarriedComparator implements Comparator<BankRecords>{
	/**
	  * {@inheritDoc}
	  */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getMarried().compareTo(o2.getMarried());
	}
}
