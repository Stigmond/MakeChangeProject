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
				change = twenties(change);
				change = tens(change);
				change = fives(change);
				change = ones(change);
				change = quarters(change);
				change = dimes(change);
				change = nickels(change);
				change = pennies(change);
			}
		
		}
		
		input.close();
	}
	
	public static void denomination(int amount, String type) {
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
	
	public static double twenties(double change) {
	
		int twenties = (int)(change / 20.00);
		change = change % 20.00;
		denomination(twenties, "twenty-dollar bill");
		return change;
		
	}
	
	public static double tens(double change) {
		int tens = (int)(change / 10.00);
		change = change % 10.00;
		denomination(tens, "ten-dollar bill");
		return change;
	}
	
	public static double fives(double change) {
		
		int fives = (int)(change / 5.00);
		change = change % 5.00;
		denomination(fives, "five-dollar bill");
		return change;
	}
	
	public static double ones(double change) {
		
		int ones = (int)(change / 1.00);
		change = change % 1.00;
		denomination(ones, "one-dollar bill");
		return change;
	}
	
	public static double quarters(double change) {
		
		int quarters = (int)(change / .25);
		change = change % .25;
		denomination(quarters, "quarter");
		return change;
	}
	
	public static double dimes(double change) {
		
		int dimes = (int)(change / .10);
		change = change % .10;
		denomination(dimes, "dime");
		return change;
	}
	
	public static double nickels(double change) {
		
		int nickels = (int)(change / .05);
		change = change % .05;
		denomination(nickels, "nickel");	
		return change;
	}
		
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