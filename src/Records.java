/** 
*   <h1>Records<h1>
*   This class will help the bank to perfom data analytics from the data stored by the bank 
*   and filter it
*   @author Maria Garcia Fernandez
*   @version 1.0
*   @since 2017-02-18
*/

/**
 * Imported libraries
 */
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

//The class extends to BankRecords class so we can use its methods
public class Records extends BankRecords {
	/**
	 * Class private static variables
	 */
	private static FileWriter fw = null;

	/**
	 * Constructor method, it create a bankrecords file in the settled
	 * directory. It throws an exception in case is any error.
	 */
	public Records() {
		try {
			fw = new FileWriter("/Users/Maria/Desktop/bankrecords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method calculate the overall average income of the bank records
	 * passed as a parameter
	 * @param bR BankRecords array
	 * @return the final average income
	 */
	public String overallAverageIncome(BankRecords[] bR) {
		// To start we sort the bankrecords array in order to be more efficient
		sortBy(bR, "income");
		// Needed variables
		int i;
		double averageIncome = 0;
		// We calculate the average adding all the customers incomes
		for (i = 0; i < bR.length; i++) {
			averageIncome += bR[i].getIncome();
		}
		// Then we divide for the number of clients and format the output
		return String.format("$%,.2f", averageIncome / i);
	}

	/**
	 * This method sorts the BankRecords contained in the array
	 * @param bRec the bankrecords array
	 * @param filterType the type of filter that the bank wants to apply
	 */
	public void sortBy(BankRecords[] bRec, String filterType) {
		// Depending on the filter type we call a different comparator and sort
		// the array
		if (filterType.equals("sex")) {
			Arrays.sort(bRec, new SexComparator());
		} else if (filterType.equals("region")) {
			Arrays.sort(bRec, new RegionComparator());
		} else if (filterType.equals("id")) {
			Arrays.sort(bRec, new IdComparator());
		} else if (filterType.equals("married")) {
			Arrays.sort(bRec, new MarriedComparator());
		} else if (filterType.equals("car")) {
			Arrays.sort(bRec, new CarComparator());
		} else if (filterType.equals("mortgage")) {
			Arrays.sort(bRec, new MortgageComparator());
		} else if (filterType.equals("children")) {
			Arrays.sort(bRec, new ChildrenComparator());
		} else if (filterType.equals("save_act")) {
			Arrays.sort(bRec, new SaveActComparator());
		} else if (filterType.equals("current_act")) {
			Arrays.sort(bRec, new CurrentActComparator());
		} else if (filterType.equals("pep")) {
			Arrays.sort(bRec, new PepComparator());
		}
	}

	/**
	 * This method filters the bank records from the array depending on the
	 * parameters
	 * @param bankRecords the BankRecords array
	 * @param filterType  the field that is required to be filtered
	 * @param filter the specific thing that would like to be filtered
	 * @return a BankRecords array that contains the BankRecords filtered
	 */
	public BankRecords[] filter(BankRecords[] bankRecords, String filterType, String filter) {
		// To start we sort the bankrecords array in order to be more efficient
		sortBy(bankRecords, filterType);
		// Needed variables
		ArrayList<BankRecords> dataFiltered = new ArrayList<BankRecords>();
		String bankRecord = "";
		// Depending on the filterType we store the bankRecord data in a string
		for (int i = 0; i < bankRecords.length; i++) {
			if (filterType.equals("sex")) {
				bankRecord = bankRecords[i].getSex();
			} else if (filterType.equals("region")) {
				bankRecord = bankRecords[i].getRegion();
			} else if (filterType.equals("married")) {
				bankRecord = bankRecords[i].getMarried();
			} else if (filterType.equals("car")) {
				bankRecord = bankRecords[i].getCar();
			} else if (filterType.equals("mortgage")) {
				bankRecord = bankRecords[i].getMortgage();
			} else if (filterType.equals("children")) {
				bankRecord = String.valueOf(bankRecords[i].getChildren());
			} else if (filterType.equals("save_act")) {
				bankRecord = bankRecords[i].getSave_act();
			} else if (filterType.equals("current_act")) {
				bankRecord = bankRecords[i].getCurrent_act();
			} else if (filterType.equals("pep")) {
				bankRecord = bankRecords[i].getPep();
			}
			// If it coincide with the filter applied
			if ((bankRecord.equals(filter))) {
				// We add the bankRecord in the arrayList
				dataFiltered.add(bankRecords[i]);
			}
		}
		// We convert the arrayList into an array
		return dataFiltered.toArray(new BankRecords[dataFiltered.size()]);
	}

	/**
	 * This method calculate the maximum and minimum ages of the BankRecords
	 * clients by area of residence
	 * @param bR the BankRecords array
	 * @param region  the region where the clients reside
	 * @param age if we want to show the maximum age or the minimum one
	 * @return the max or min ages
	 */
	public int agePerLocation(BankRecords[] bR, String region, String age) {
		// To start we sort the BankRecords array by region in order to be more
		// efficient
		sortBy(bR, "region");
		// We create an arrayList that will contain the ages of all the clients
		// of a determined region
		ArrayList<Integer> ages = new ArrayList<Integer>();
		// We compare the regions of the BankRecords and add the ages in the
		// arrayList created before
		for (int i = 0; i < bR.length; i++) {
			if (bR[i].getRegion().equals(region)) {
				ages.add(bR[i].getAge());
			}
		}
		// Needed variables
		int min = Integer.parseInt(ages.get(0).toString());
		int max = min;
		// We look for the minimum and maximum values in the arrayList
		for (int j = 0; j < ages.size(); j++) {
			int value = Integer.parseInt(ages.get(j).toString());
			if (min > value) {
				min = value;
			}
			if (max < value) {
				max = value;
			}
		}

		// Depending on what age do we want to show, we return the minimum or
		// the maximum one
		if (age.equals("maximum")) {
			return max;
		} else if (age.equals("minimum")) {
			return min;
		} else {
			return 0;
		}
	}

	/**
	 * This is the main method with which the bank will be able to filter data
	 * and analyze it
	 * @param args unused
	 */
	public static void main(String[] args) {
		// We create a class object in order to call the filtering functions
		Records records = new Records();

		// We call first to the readData function and then to the processData
		// one
		records.readData();
		records.processData();

		// It will show in the console the overall average income of all the
		// bankRecords
		System.out
				.println("The overall average income is " + records.overallAverageIncome(BankRecords.bRecords) + ".\n");
		// And also for splitted for women and men
		// First, we create two arrays one with the male records and another one
		// for the female ones
		BankRecords[] bRMale = records.filter(BankRecords.bRecords, "sex", "MALE");
		BankRecords[] bRFemale = records.filter(BankRecords.bRecords, "sex", "FEMALE");
		System.out.println("The male average income is " + records.overallAverageIncome(bRMale) + ".");
		System.out.println("The female average income is " + records.overallAverageIncome(bRFemale) + ".\n");

		// This will print the maximum and minimum age per location also
		// differentiating the sex
		// We print the max and min ages in the 4 regions for males
		System.out.println("The maximum age of INNER_CITY male resident clients is "
				+ records.agePerLocation(bRMale, "INNER_CITY", "maximum") + " years and "
				+ records.agePerLocation(bRMale, "INNER_CITY", "minimum") + " years for the minimum age.");
		System.out.println("The maximum age of SUBURBAN male resident clients is "
				+ records.agePerLocation(bRMale, "SUBURBAN", "maximum") + " years and "
				+ records.agePerLocation(bRMale, "SUBURBAN", "minimum") + " years for the minimum age.");
		System.out.println("The maximum age of RURAL male resident clients is "
				+ records.agePerLocation(bRMale, "RURAL", "maximum") + " years and "
				+ records.agePerLocation(bRMale, "RURAL", "minimum") + " years for the minimum age.");
		System.out.println("The maximum age of TOWN male resident clients is "
				+ records.agePerLocation(bRMale, "TOWN", "maximum") + " years and "
				+ records.agePerLocation(bRMale, "TOWN", "minimum") + " years for the minimum age.\n");
		// And the max and min ages in the 4 regions for females
		System.out.println("The maximum age of INNER_CITY female resident clients is "
				+ records.agePerLocation(bRFemale, "INNER_CITY", "maximum") + " years and "
				+ records.agePerLocation(bRFemale, "INNER_CITY", "minimum") + " years for the minimum age.");
		System.out.println("The maximum age of SUBURBAN female resident clients is "
				+ records.agePerLocation(bRFemale, "SUBURBAN", "maximum") + " years and "
				+ records.agePerLocation(bRFemale, "SUBURBAN", "minimum") + " years for the minimum age.");
		System.out.println("The maximum age of RURAL female resident clients is "
				+ records.agePerLocation(bRFemale, "RURAL", "maximum") + " years and "
				+ records.agePerLocation(bRFemale, "RURAL", "minimum") + " years for the minimum age.");
		System.out.println("The maximum age of TOWN female resident clients is "
				+ records.agePerLocation(bRFemale, "TOWN", "maximum") + " years and "
				+ records.agePerLocation(bRFemale, "TOWN", "minimum") + " years for the minimum age.\n");

		// Now we are going to show the number of females with mortgages
		System.out.println("There are " + records.filter(bRFemale, "mortgage", "YES").length
				+ " women with mortgages in our records.");
		// And the number of males with mortgages
		System.out.println("There are " + records.filter(bRMale, "mortgage", "YES").length
				+ " men with mortgages in our records.\n");

		// We filter number of men with car and the women with car
		BankRecords[] bRMaleCar = records.filter(bRMale, "car", "YES");
		BankRecords[] bRFemaleCar = records.filter(bRFemale, "car", "YES");
		// We print the number of men with car and 1 children and the number of
		// women with car and 1 children
		System.out.println("The number of men with car and one children is "
				+ records.filter(bRMaleCar, "children", "1").length + ".");
		System.out.println("The number of women with car and one children is "
				+ records.filter(bRFemaleCar, "children", "1").length + ".");
		// We get the current date
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

		try {
			// We add in the file created the information that we need including
			// a header
			fw.write("Data analysis on February 18th\n\n" + "The overall average income is "
					+ records.overallAverageIncome(BankRecords.bRecords) + ".\n\n" + "The male average income is "
					+ records.overallAverageIncome(bRMale) + ".\n" + "The female average income is "
					+ records.overallAverageIncome(bRFemale) + ".\n\n"
					+ "The maximum age of INNER_CITY male resident clients is "
					+ records.agePerLocation(bRMale, "INNER_CITY", "maximum") + " years and "
					+ records.agePerLocation(bRMale, "INNER_CITY", "minimum") + " years for the minimum age.\n"
					+ "The maximum age of SUBURBAN male resident clients is "
					+ records.agePerLocation(bRMale, "SUBURBAN", "maximum") + " years and "
					+ records.agePerLocation(bRMale, "SUBURBAN", "minimum") + " years for the minimum age.\n"
					+ "The maximum age of RURAL male resident clients is "
					+ records.agePerLocation(bRMale, "RURAL", "maximum") + " years and "
					+ records.agePerLocation(bRMale, "RURAL", "minimum") + " years for the minimum age.\n"
					+ "The maximum age of TOWN male resident clients is "
					+ records.agePerLocation(bRMale, "TOWN", "maximum") + " years and "
					+ records.agePerLocation(bRMale, "TOWN", "minimum") + " years for the minimum age.\n\n"
					+ "The maximum age of INNER_CITY female resident clients is "
					+ records.agePerLocation(bRFemale, "INNER_CITY", "maximum") + " years and "
					+ records.agePerLocation(bRFemale, "INNER_CITY", "minimum") + " years for the minimum age.\n"
					+ "The maximum age of SUBURBAN female resident clients is "
					+ records.agePerLocation(bRFemale, "SUBURBAN", "maximum") + " years and "
					+ records.agePerLocation(bRFemale, "SUBURBAN", "minimum") + " years for the minimum age.\n"
					+ "The maximum age of RURAL female resident clients is "
					+ records.agePerLocation(bRFemale, "RURAL", "maximum") + " years and "
					+ records.agePerLocation(bRFemale, "RURAL", "minimum") + " years for the minimum age.\n"
					+ "The maximum age of TOWN female resident clients is "
					+ records.agePerLocation(bRFemale, "TOWN", "maximum") + " years and "
					+ records.agePerLocation(bRFemale, "TOWN", "minimum") + " years for the minimum age.\n\n"
					+ "There are " + records.filter(bRFemale, "mortgage", "YES").length
					+ " women with mortgages in our records.\n" + "There are "
					+ records.filter(bRMale, "mortgage", "YES").length + " men with mortgages in our records.\n\n"
					+ "The number of men with car and one children is "
					+ records.filter(bRMaleCar, "children", "1").length + ".\n"
					+ "The number of women with car and one children is "
					+ records.filter(bRFemaleCar, "children", "1").length + ".\n\n" + "\nCur dt=" + timeStamp
					+ "\nProgrammed by Maria Garcia Fernandez\n");
			// And we close the document
			fw.close();
			// It needs to be done in a try catch structure in case some
			// exception is thrown
		} catch (IOException e) {
			e.printStackTrace();
		}

		// We print the current day, time and programmer's name
		System.out.println("\nCur dt=" + timeStamp + "\nProgrammed by Maria Garcia Fernandez\n");
	}
}
