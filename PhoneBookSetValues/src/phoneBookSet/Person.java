package phoneBookSet;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Person{
	private String firstName = "";
	private String midName= "";
	private String lastName= "";
	private Address address;
	private long phoneNum;
	
	public Person() {}

	public Person(String firstName, String midName, String lastName, 
			 long phoneNum, Address address) {
		// Create constructor with parameters to pass
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
	
		this.firstName = name;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {

		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	// Hold the add person class in Person, that way I am able to use the
	// method in my Updates class and prompt the user to 
	public void promptUserInfo () {
		
		// implement an exception
		try {
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter the name, address, and phone number, separated by commas: ");
			System.out.println("Ex: John, Doe, 114 Market St, St. Louis, MO, 63403, 6366435698");
			
			String inpInfo = input.nextLine();
			
			//REVISE: splitting the array here will be much more beneficial, due to
			// the fact that the classes will be less inclined, allowing the search 
			// engine to do its thing.
			if (inpInfo != null) {
				String[] fullArray = inpInfo.split(",");
				String name = fullArray[0].trim();
				String street = fullArray[1].trim();
				String city = fullArray[2].trim();
				String state = fullArray[3].trim();
				String zip = fullArray[4].trim();
				
				String[] splitName = name.split(" ");
				String firstName = splitName[0];
				String lastName = splitName[splitName.length - 1];
				String middleName = "";
				// run through the split array
				for(int i = 1; i < splitName.length - 1; i++) {
					middleName += splitName[i] + " ";
				}
				middleName = middleName.trim();
				
				long phoneNum = Long.parseLong(fullArray[5].trim());
				Address addressInp = new Address(street, city, state, zip);
			//	Person personInp = new Person(firstName, middleName, lastName, phoneNum, addressInp);
				this.firstName = firstName;
				this.midName = middleName;
				this.lastName = lastName;
				this.phoneNum = phoneNum;
				this.address = addressInp;
				
				//split at the comma, categorize into respective index values.
				
			} if (inpInfo.contains(" ")){
				System.out.println("please try again");
			}
		} catch (InputMismatchException ex) {
			System.out.println("Exception: " + ex.toString());
		}
	}
	@Override
	public String toString() {
		// format phone number, the string accounts for the values that are
		// left behind, the 'trailing zeros'.
		DecimalFormat phoneFormat = new DecimalFormat("0000000000");
		String phoneNumStr =phoneFormat.format(phoneNum);
		
		// https://stackoverflow.com/questions/5114762/how-do-format-a-phone-number-as-a-string-in-java
		// help with formatting to the proper format
		 
			MessageFormat phoneNewFormat = new MessageFormat("({0})-{1}-{2}");
			String[] phoneArray = {phoneNumStr.substring(0, 3), 
					phoneNumStr.substring(3, 6), phoneNumStr.substring(6)};
			String lastFormat = phoneNewFormat.format(phoneArray);
			
			// Update 11/23/20: Let's make this a bit nicer looking
		String printPersonInfo = "\n************RESULT***********\n" + "NAME: " + this.lastName + ", " + this.firstName + " " + this.midName + 
				" \nCURRENT ADDRESS: " + address.toString() + "\nCURRENT TELEPHONE NUMBER: " + lastFormat + "\n**********THANK YOU!*********\n";
		return printPersonInfo;
	}
}
