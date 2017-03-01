
/** 
*   <h1>Children Comparator<h1>
*   ChildrenComparator class that would help to sort the BankRecord objects depending on 
*   the number of children the clients have
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class ChildrenComparator implements Comparator<BankRecords> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getChildren() - o2.getChildren();
	}

}
