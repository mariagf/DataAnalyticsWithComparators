
/** 
*   <h1>Age Comparator<h1>
*   AgeComparator class that would help to sort the BankRecord objects by age
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class AgeComparator implements Comparator<BankRecords> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getAge() - o2.getAge();
	}

}
