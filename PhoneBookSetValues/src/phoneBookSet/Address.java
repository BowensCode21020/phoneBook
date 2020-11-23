package phoneBookSet;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	public Address(String[] fullArray) 
	{}

	public Address(String street, String city, String state, String zipcode) 
	{
		
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		// separate the values into a string
		
		String[] addTemp = street.split(", ");
		String nameStreet = "";
		
		// put into a different string
		
		for (int i = 1; i < addTemp.length; i++) {
			nameStreet += addTemp[i];
		}
		this.street = nameStreet;
	}
	// getter and setter setup for the values below
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		String[] cityTemp = city.split(", ");
		this.city = cityTemp[1];
		}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		String[] stateTemp = state.split(", ");
		this.state = stateTemp[2];
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zip) {
		String[] temp = zipcode.split(", ");
		this.zipcode = temp[3];
	}
	public void printAddress() {
		System.out.println(this.street + this.city + this.state + this.zipcode);
	}
	@Override
	public String toString() {
		return this.street + ", " + this.city + ", " + 
	this.state + ", " + this.zipcode;
	}



//	public String getValue() {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
	

}
