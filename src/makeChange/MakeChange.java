package makeChange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		
		boolean keepGoing = true;
		Scanner input = new Scanner(System.in);
		
		while (keepGoing) {
			
				
			System.out.print("\nPlease enter the purchase price of the item: $");
			double price = input.nextDouble();
		
			System.out.print("\nPlease enter the amount tendered by the customer: $");
			double tender = input.nextDouble();
		
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
		
		input.close();
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
	public static void printDenomination(int amount, String type) {
		if (amount == 0) {
			System.out.print("");
		}
		if (amount == 1) {
			System.out.println("1 " + type);
		}
		if (amount > 1) {
			System.out.println(amount + " " + type + "s");
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
	
}