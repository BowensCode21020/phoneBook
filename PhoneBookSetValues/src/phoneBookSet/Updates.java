package phoneBookSet;

// remove Scanner

public class Updates {
	private Person[] storage = new Person[0];
	private String searchCityState = "";
	
	public Updates() {}
	
	public Updates(Person[] storage) {
		super();
		this.storage = storage;
	}

	public void addPerson() {

		Person[] temp = new Person[storage.length + 1];
		
		// Call the 'personInp' method
		Person newTemp = new Person();
		newTemp.promptUserInfo();
		
		// Run 
		for(int i = 0; i < storage.length; i++) {
			temp[i] = storage[i];
		}
		
		temp[temp.length - 1] = newTemp;
		
		storage = temp;
		
	}
	// by telephone option, 
	public void removePerson(long phoneNumToRemove) {
		
		//Set index one less than the length of input.
		Person[] tempRemove = new Person[storage.length - 1];

		int count = 0;
		
		for (int i = 0; i < storage.length; i++) {
			if (storage[i].getPhoneNum() != phoneNumToRemove) {
				tempRemove[i - count] = storage[i];
			} else {
				count++;
			}
		}
		
		storage = tempRemove;
	}
	public void updatePerson(long phoneNumToRemove) {
		
		Person updatedPerson = new Person();
		
		int count = -1;
		
		for (int i = 0; i < storage.length; i++) {
			if (storage[i].getPhoneNum() == phoneNumToRemove) {
				count = i;
				break;
			}
		}
		if (count == -1) {
			System.out.println("Name not found");
			return;
		} else {
			System.out.println("The current person information is: ");
			System.out.println(storage[count].toString());
			System.out.println("Please enter new information: ");
			
			// Replace the element of storage with the previous menu, allowing
			// the user to make the necessary changes. Storage at the count index
			// will be replaced by the updated values in 'updatedPerson'.
			updatedPerson.promptUserInfo();
			storage[count] = updatedPerson; 
		}		
		
		
	}
	
	public void setStorage(Person full) {
		Person[] fullDirect = new Person[storage.length + 1];
		for(int i = 0; i < storage.length; i++) {
			fullDirect[i] = storage[i];
			}
		fullDirect[fullDirect.length - 1] = full;
		storage = fullDirect;
	}	

// Begin our search methods;
	public Person searchByPhone(long num) {
		int value = 0;
		for(int i = 0; i < storage.length; i++) {
			if(storage[i].getPhoneNum() == num) {
				value = i;
				break;
			} 
		}
		if (value > 0) {
			return storage[value];
			}
		return null;
	}
	
	public Person searchFirstName(String searchFirst) {
		String tempFirst = "";
		int countFirst = -1;
		// trim the whitespace and account for case sensitivity

		searchFirst = searchFirst.trim().toLowerCase();
		
		for(int i = 0; i < storage.length; i++) {
			
			tempFirst = storage[i].getFirstName().trim().toLowerCase(); 
			// contains allows for any section of a value to be identified
			if(tempFirst.contains(searchFirst)) {
				countFirst = i;
				break;
			} 

		}
		// Set countFirst to -1 to account for the index value in
		// relation.
		if (countFirst == -1) {
			System.out.println("Name not found");
			return null;
		}
		return storage[countFirst];
	}
	
	public Person searchLastName(String searchLast) {
		String tempLast = "";
		int countLast = -1;
		
		searchLast = searchLast.trim().toLowerCase();
		for(int i = 0; i < storage.length; i++) {
			
			tempLast = storage[i].getLastName().trim().toLowerCase(); 
			
			if(tempLast.equals(searchLast)) {
				countLast = i;
				break;
			} 
		}
		if (countLast == -1) {
			System.out.println("Name not found");
			return null;
		}
		return storage[countLast];
	}
	
	public Person searchFullName(String searchFull) {
		String tempFull = "";
		
		// Cannot possibly match the index value
		int countFull = -1;
		// trim the whitespace and account for case sensitivity

		searchFull = searchFull.trim().toLowerCase();
		
		for(int i = 0; i < storage.length; i++) {
			
			
			if (storage[i].getMidName().length() == 0) {
				tempFull = storage[i].getFirstName() + " " + storage[i].getLastName();
			} else {
				tempFull = storage[i].getFirstName() + " " + storage[i].getMidName() + 
						" " + storage[i].getLastName();
			}
			
			tempFull = tempFull.trim().toLowerCase();
			
			// contains allows for any section of a value to be identified
			if(tempFull.contains(searchFull)) {
				countFull = i;
				break;
			} 

		}
		if (countFull == -1) {
			System.out.println("Name not found");
			return null;
		}
		return storage[countFull];
	}
	
	public Person[] getStorage() {
		System.out.println(storage.toString());
		return storage;
	}
	
	// Sort arrays into ascending order
	public void storeSort () {
	
		// when specifying the length, then its the same as '.length'
	
		Person[] tempSort = storage;
		Person result;
		
		for (int i = 0; i < tempSort.length; i++) {
			for (int j = 1; j < tempSort.length; j++) {
				// Begin the bubble sort
				// a negative integer, zero, or a positive integer as the specified String is 
				// greater than, equal to, or 
				// less than this String, ignoring case considerations.
				if (tempSort[j].getLastName().compareToIgnoreCase(tempSort[j - 1].getLastName()) < 0) {

					result = tempSort[j - 1];
					tempSort[j - 1] = tempSort[j];
					tempSort[j] = result;
					
				}
			}
		}
		System.out.println("Names in alphabetical order");
		getInfo();
	}

	public void getInfo() {
		
		for (int i = 0; i < storage.length; i++) {
			System.out.println(storage[i].toString());
		}		
	}


	public String getSearchCityState() {
		return searchCityState;
	}

	public Person setSearchCityState(String searchCityState) {
		
		// Sort options by city and State.
		
		String tempCityState = "";
		
		// add count to record matches 
		int countAdd = 0;
		
		for(int i = 0; i < storage.length; i++) {
			tempCityState = storage[i].getLastName(); 
			if(tempCityState.equals(searchCityState)) {
				countAdd = i;
				break;
			} 
		}
		return storage[countAdd];
	}

}
