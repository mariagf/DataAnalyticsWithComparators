/** 
*   <h1>Mortage Comparator<h1>
*   MortageComparator class that would help to sort the BankRecord objects depending on whether the clients have or not mortgage  
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class MortgageComparator implements Comparator<BankRecords>{
	/**
	  * {@inheritDoc}
	  */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getMortgage().compareTo(o2.getMortgage());
	}

}
