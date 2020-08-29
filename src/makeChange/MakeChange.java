package makeChange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
				
		System.out.print("Please enter the purchase price of the item: $");
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
		
		input.close();
	}
	
	public static double twenties(double change) {
		
		int twenties = (int)(change / 20.00);
		change = change % 20.00;
		if (twenties == 0) {
			System.out.print("");
		}
		if (twenties == 1) {
			System.out.println("1 twenty-dollar bill");
		}
		if (twenties > 1) {
			System.out.println(twenties + " twenty-dollar bills");
		}
		
		return change;
	}

	public static double tens(double change) {
		
		int tens = (int)(change / 10.00);
		change = change % 10.00;
		if (tens == 0) {
			System.out.print("");
		}
		else if (tens == 1) {
			System.out.println("1 ten-dollar bill");
		}
		else {
			System.out.println(tens + " ten-dollar bills");
		}
		
		return change;
	}
	
	public static double fives(double change) {
		
		int fives = (int)(change / 5.00);
		change = change % 5.00;
		if (fives == 0) {
			System.out.print("");
		}
		else if (fives == 1) {
			System.out.println("1 five-dollar bill");
		}
		else {
			System.out.println(fives + " five-dollar bills");
		}
		
		return change;
	}
	
	public static double ones(double change) {
		
		int ones = (int)(change / 1.00);
		change = change % 1.00;
		if (ones == 0) {
			System.out.print("");
		}
		else if (ones == 1) {
			System.out.println("1 one-dollar bill");
		}
		else {
			System.out.println(ones + " one-dollar bills");
		}
		
		return change;
	}
	
	public static double quarters(double change) {
		
		int quarters = (int)(change / .25);
		change = change % .25;
		if (quarters == 0) {
			System.out.print("");
		}
		else if (quarters == 1) {
			System.out.println("1 quarter");
		}
		else {
			System.out.println(quarters + " quarters");
		}
		
		return change;
	}
	
	public static double dimes(double change) {
		
		int dimes = (int)(change / .10);
		change = change % .10;
		if (dimes == 0) {
			System.out.print("");
		}
		else if (dimes == 1) {
			System.out.println("1 dime");
		}
		else {
			System.out.println(dimes + " dimes");
		}
		
		return change;
	}
	
	public static double nickels(double change) {
		
		int nickels = (int)(change / .05);
		change = change % .05;
		if (nickels == 0) {
			System.out.print("");
		}
		else if (nickels == 1) {
			System.out.println("1 nickel");
		}
		else {
			System.out.println(nickels + " nickels");
		}
		
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
	

