/** 
*   <h1>Bank Records<h1>
*   The BankRecords class is extended from an abstract class. 
*   This class allows to the bank to print the 25 first clients records from a cvs file.  
*   @author Maria Garcia Fernandez
*   @version 2.0
*   @since 2017-01-31
*/

/**
 * Imported libraries
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// The class extends to Client an abstract class, this way it will inherit all the methods
// and will be able to overwrite them 
public class BankRecords extends Client {

	/**
	 * Class static variables
	 */
	static BankRecords[] bRecords;
	static List<List<String>> dataList = new ArrayList<List<String>>();

	/**
	 * Class private variables
	 */
	private String id;
	private int age;
	private String sex;
	private String region;
	private double income;
	private String married;
	private int children;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void readData() {
		// Path to the cvs file
		String csvFile = "files/bank-Detail.csv";
		// Declaration of needed variables
		String line = "";
		// Try to read the file placed in the path, it could throw an exception
		// if the file is not there
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			// If there is any problem read line by line till the document is
			// completely read
			while ((line = br.readLine()) != null) {
				// Split each line by the commas and add the resultant array as
				// a list to the dataList list created
				dataList.add(Arrays.asList(line.split(",")));
			}
			// Initialization of the bRecords array
			bRecords = new BankRecords[dataList.size()];
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processData() {
		// For loop to get through all the dataList with the bankRecords
		// information
		for (int i = 0; i < BankRecords.dataList.size(); i++) {
			// Declaration and initialization of each object of the dataList
			List<String> dataRow = dataList.get(i);
			// Create a new BankRecords for every object of the dataList
			bRecords[i] = new BankRecords();
			// Set all the information in the array into the BankRecors object
			// created, if needed parse the variables to fit to its type
			bRecords[i].setId(dataRow.get(0));
			bRecords[i].setAge(Integer.parseInt(dataRow.get(1)));
			bRecords[i].setSex(dataRow.get(2));
			bRecords[i].setRegion(dataRow.get(3));
			bRecords[i].setIncome(Double.parseDouble(dataRow.get(4)));
			bRecords[i].setMarried(dataRow.get(5));
			bRecords[i].setChildren(Integer.parseInt(dataRow.get(6)));
			bRecords[i].setCar(dataRow.get(7));
			bRecords[i].setSave_act(dataRow.get(8));
			bRecords[i].setCurrent_act(dataRow.get(9));
			bRecords[i].setMortgage(dataRow.get(10));
			bRecords[i].setPep(dataRow.get(11));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printData(int nRecords) {
		// Heading of what are we going to print with its labels
		System.out.println(
				"Below there are shown the most important fields of the first " + nRecords + " client records:\n");
		System.out.printf("%-8s %-6s %-15s %-10s %-5s\n", " Client ID", "  AGE", "   REGION", "INCOME ", "MORTAGE");
		System.out.println("-----------------------------------------------------");
		// For loop for printing the nRecords first records of the cvs file
		for (int i = 0; i < nRecords; i++) {
			try {
				// Obtain the BankRecord for the BankRecords array
				BankRecords b = bRecords[i];
				// Print its data
				System.out.printf("%-8s %-6s %-15s %-10s %5s\n", "  " + b.getId(), "   " + b.getAge(),
						"  " + b.getRegion(), b.getIncome(), b.getMortgage());
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Id setter method
	 * @param answer the client's id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Age setter method
	 * @param age the client's age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Sex setter method
	 * @param sex the client's sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Region setter method
	 * @param region the region where the client is from
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Income setter method
	 * @param income amount of money that the client received usually monthly
	 */
	public void setIncome(double income) {
		this.income = income;
	}

	/**
	 * Married setter method
	 * @param married if the user is married or not
	 */
	public void setMarried(String married) {
		this.married = married;
	}

	/**
	 * Children setter method
	 * @param children the number of children that the client has
	 */
	public void setChildren(int children) {
		this.children = children;
	}

	/**
	 * Car setter method
	 * @param car if the user has a car
	 */
	public void setCar(String car) {
		this.car = car;
	}

	/**
	 * Savings account getter method
	 * @param save_act if the client has a savings account
	 */
	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}

	/**
	 * Current account setter method
	 * @param current_act if the client has already a current account
	 */
	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}

	/**
	 * Mortgage setter method
	 * @param mortgage indicates if the client has a loan or not
	 */
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	/**
	 * Politically exposed person setter method
	 * @param pep indicates if the user works as a politician so he or she may
	 * be involved in corruption scams
	 */
	public void setPep(String pep) {
		this.pep = pep;
	}

	/**
	 * Id getter method
	 * @return id the client's id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Age getter method
	 * @return age the client's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sex getter method
	 * @return sex the client's sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Region getter method
	 * @return region indicates where does the user live
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Income getter method
	 * @return income amount of money received by the client
	 */
	public double getIncome() {
		return income;
	}

	/**
	 * Married getter method
	 * @return married indicates if the client is married
	 */
	public String getMarried() {
		return married;
	}

	/**
	 * Children getter method
	 * @return children the number of children that the user has
	 */
	public int getChildren() {
		return children;
	}

	/**
	 * Car getter method
	 * @return car indicates if the client has or has not car
	 */
	public String getCar() {
		return car;
	}

	/**
	 * Save account getter method
	 * @return save_act if the client has a savings account
	 */
	public String getSave_act() {
		return save_act;
	}

	/**
	 * Current account getter method
	 * @return current_act if the client has already a current account
	 */
	public String getCurrent_act() {
		return current_act;
	}

	/**
	 * Mortgage getter method
	 * @return mortgage indicates if the client has a loan or not
	 */
	public String getMortgage() {
		return mortgage;
	}

	/**
	 * Politically exposed person getter method
	 * @return pep indicates if the user works as a politician so he or she may
	 * be involved in corruption scams
	 */
	public String getPep() {
		return pep;
	}
}
