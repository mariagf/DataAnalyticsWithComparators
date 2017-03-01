/** 
*   <h1>Pep Comparator<h1>
*  	PepComparator class that would help to sort the BankRecord objects depending on whether they have Pep
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class PepComparator implements Comparator<BankRecords>{
	/**
	  * {@inheritDoc}
	  */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getPep().compareTo(o2.getPep());
	}
}
