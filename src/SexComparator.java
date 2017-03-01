
/** 
*   <h1>Sex Comparator<h1>
*   SexComparator class that would help to sort the BankRecord objects by sex
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class SexComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getSex().compareTo(o2.getSex());
	}
}
