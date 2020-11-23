package phoneBookSet;

import java.util.Scanner;

public class PhoneHomeAgain {
	
	
	public static void main(String[] args) {
		
		// Add current list into storage;
		
		// Long was converted to be used in sorting
		
		long n1 = 16185709876L;
		long n2 = 13145678916L;
		long n3 = 97798413068L;
		
		// Create a list of people to search for.
		
		Address add1 = new Address("101 Hilldale Dr.", "Belleville", "IL", "62239");
		Address add2 = new Address("623 Neosho Ln.", "St. Louis", "Mo", "63123");
		Address add3 = new Address("4A Jayabagashwari Marg", "Siphal", "NP", "N/A");
		
		Person pers1 = new Person("Breanna", "Faye", "Ackermann", n1, add1);
		Person pers2 = new Person("Jesse", "D", "Webb", n2, add2);
		Person pers3 = new Person("Dipak", "", "Galami", n3, add3);
		
		Person[] currentList = new Person[3];
		
		currentList[0] = pers1;
		currentList[1] = pers2;
		currentList[2] = pers3;
		
		Updates current = new Updates(currentList);

		PhoneMenu(current);
	}
	public static void PhoneMenu (Updates storeInfo) {
		
		
		Scanner input = new Scanner(System.in);
		boolean userExit = false;
		while (!userExit) {
			
			// Make a menu
			
			System.out.println("*********PHONE BOOK**********");
			System.out.println("1. Add a new entry");
			System.out.println("2. Delete an existing entry");
			System.out.println("3. Search Options");
			System.out.println("4. Sort and show current records");
			System.out.println("5. Update records by telephone number");
			System.out.println("6. Exit program");
			System.out.print("Make your selection: ");
			
			int choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
			case 1:
				// store info goes in and makes makes a new person, then it prompt the user
				// It takes the values to the updates section.
				storeInfo.addPerson();
				storeInfo.getInfo();
				
				break;
			case 2:
				System.out.print("Enter the telephone number of the person you wish to delete: ");
				
				long phoneInp = input.nextLong();
				storeInfo.removePerson(phoneInp);
				
				
				break;
			case 3:
				System.out.println("Search options");
				System.out.println("1. Search by First Name");
				System.out.println("2. Search by Last Name");
				System.out.println("3. Search by Full Name");
				System.out.println("4. Search by Telephone Number");
				System.out.println("5. Search by City and State");
				System.out.print("Make your selection: ");
				
				int choice2 = input.nextInt();
				input.nextLine();
				
				switch (choice2) {
				
				case 1:
					System.out.println("Enter the person's first name");
					String searchFirst = input.next();
					Person foundFirst = storeInfo.searchFirstName(searchFirst);
					if (foundFirst != null) {
						System.out.println(foundFirst.toString());
					}
					break;
					
				case 2:
					System.out.println("Enter the person's last name");
					String searchLast = input.nextLine();
					storeInfo.searchLastName(searchLast);
					break;
					
				case 3:
					System.out.println("Enter the person's full name");
					String searchFull = input.nextLine();
					Person foundFull = storeInfo.searchFullName(searchFull);
					if (foundFull != null) {
						System.out.println(foundFull.toString());
					}
					break;	
					
				case 4:
					System.out.println("Enter the person's telephone");
					long searchNum = input.nextLong();
					Person foundPhone = storeInfo.searchByPhone(searchNum);
					
					if (foundPhone != null) {
						System.out.println(foundPhone.toString());
					} else {
						System.out.println("Number not found");
					}
					break;
					
				case 5:
					System.out.println("Enter the person's city and state"
							+ " separated by a comma (Ex: St. Louis, MO): ");
					String searchCityandState = input.nextLine();
					Person foundCityState = storeInfo.setSearchCityState(searchCityandState);
					
					// Print city and state with exception/conditional statements.
					if (foundCityState != null) {
						System.out.println(foundCityState.toString());
					} else {
						System.out.println("Number not found");
					}
					break;
				};
				
				break;
	
			case 4:
				System.out.println("Show Records");
				System.out.println("Please press '1' to show the current list");
				System.out.println("Please press '2' to sort the current list "
						+ "into ascending order (A B C...etc.)");
				Scanner showInp = new Scanner(System.in);
				
				int selection = showInp.nextInt();
				
				if (selection == 1) {
					storeInfo.getInfo();
				}
				
				else if (selection == 2) {
					storeInfo.storeSort();
				}
				else
					System.out.println("Wrong button");
				
				break;
			
			case 5:
				System.out.println("Update Records");
				System.out.print("Please enter the number of the person you wish to update: ");
				Scanner update = new Scanner(System.in);
				long updateByPhone = update.nextLong();
				storeInfo.updatePerson(updateByPhone);
				break;
				
			case 6:
				userExit = true;
				System.out.println("Later gator");
				break;
				
			default:
				
				break;
			}
		}
	}

}

