/** 
*   <h1>Region Comparator<h1>
*   RegionComparator class that would help to sort the BankRecord objects by region
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class RegionComparator implements Comparator<BankRecords>{
	/**
	  * {@inheritDoc}
	  */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getRegion().compareTo(o2.getRegion());
	}
}
