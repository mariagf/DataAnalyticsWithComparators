
/** 
*   <h1>Income Comparator<h1>
*   IncomeComparator class that would help to sort the BankRecord objects by income
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/
import java.util.Comparator;

public class IncomeComparator implements Comparator<BankRecords> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return (int) (o1.getIncome() - o2.getIncome());
	}
}
