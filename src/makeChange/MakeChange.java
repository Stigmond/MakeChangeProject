package makeChange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		
		boolean keepGoing = true;
		Scanner userInput = new Scanner(System.in);
		while (keepGoing) {
			
			menuScreen();
			menu();
			int userChoice = userInput.nextInt();
			switch (userChoice) {
				
				case 1:
					
					double price;
					double tender;
					
					do {
						System.out.print("\nPlease enter the purchase price of the item: $");
						price = userInput.nextDouble();
						if (price < 0) {
							System.out.println("\nPlease enter a price greater than zero.");
						}
					} while (price < 0);
					
					do {
						System.out.print("\nPlease enter the amount tendered by the customer: $");
						tender = userInput.nextDouble();
						if (tender < 0) {
							System.out.println("\nPlease enter an amount greater than zero.");
						}
					} while (tender < 0);
					
					makeChange(tender, price);
					break;
					
				case 2:
					System.out.println("\nStigWare BETA v.1.0");
					break;
					
				case 3:
					System.out.println("Goodbye!");
					keepGoing = false;
					break;
					
				default:
					System.out.println("Goodbye!");
					keepGoing = false;
					break;
					
			}
			
		}
		userInput.close();	
	}
	
	public static void makeChange(double tender, double price) {
			
		double change = tender - price;
	
		if (change < 0) {
			System.out.println("\nCustomer has tendered an insufficient amount and cannot make the purchase.");
		} 
		else if (change == 0) {
			System.out.println("\nCustomer has tendered the exact amount and is due no change.");
		}
		else {
			System.out.println("\nCustomer recieves back:\n");
			change = findDenomination(change, 20.00, "twenty-dollar bill");
			change = findDenomination(change, 10.00, "ten-dollar bill");
			change = findDenomination(change, 5.00, "five-dollar bill");
			change = findDenomination(change, 1.00, "one-dollar bill");
			change = findDenomination(change, .25, "quarter");
			change = findDenomination(change, .10, "dime");
			change = findDenomination(change, .05, "nickel");
			change = pennies(change);
		}
		
	}
	
	//method that determines how many of a particular denomination there is, then returns the remaining change for further parsing.
	//Before returning, this method passes to a sub-method that prints out the type and amount of denomination.
	public static double findDenomination(double change, double denomNum, String denomType) {
		int amountOfDenom = (int)(change / denomNum);
		change = change % denomNum;
		printDenomination(amountOfDenom, denomType);
		return change;
	}
	
	//method that prints out the quantity of the denomination, as calculated by the findDenomination();
	public static void printDenomination(int amount, String denomType) {
		if (amount == 0) {
			System.out.print("");
		}
		if (amount == 1) {
			System.out.println("1 " + denomType);
		}
		if (amount > 1) {
			System.out.println(amount + " " + denomType + "s");
		}
	}
	
	//created a separate penny method because "penny" does not follow the naming singular/plural constructions of the other denominations.
	public static double pennies(double change) {
		
		int pennies = (int)((change / .01) + .01);
		change = change % .01;
		if (pennies == 0) {
			System.out.print("");
		}
		else if (pennies == 1) {
			System.out.println("1 penny");
		}
		else {
			System.out.println(pennies + " pennies");
		}
		
		return change;
	}

	public static void menuScreen() {
		
		System.out.println("\nShop Smart, Shop...");
		System.out.println("");
		System.out.println("**************************************************");
		System.out.println("**************************************************");
		System.out.println("****                                     ***      ");
		System.out.println("**********     ******* ******* ******* 	 ***      ");
		System.out.println("********** *** ******* *** *** **   **   ***      ");
		System.out.println("     ***** *** ** * ** **   ** **  **    ***      ");
		System.out.println("**********     ** * ** ******* **   **   ***      ");
		System.out.println("**********     ** * ** **   ** **   **   ***      ");
		System.out.println("");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.println(" 1. Make Change");
		System.out.println(" 2. Version Information");
		System.out.println(" 3. Exit Program\n");
	}
	public static void menu() {
		
		System.out.print("Please make a selection: ");
	}
}
