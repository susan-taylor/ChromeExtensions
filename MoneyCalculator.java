/**
 * An application that prompts for and reads a double value representing a
 * monetary amount. Then determines the fewest number of each bill and coin
 * needed to represent that amount, starting with the highest bill, assuming
 * $10 bill is the maximum amount needed. For example, amount of 47.63 is
 * processed as follows:
 *
 * Enter monetary amount: 47.63
 * That's equivalent to:
 * 4 ten dollar bills
 * 1 five dollar bills
 * 2 one dollar bills
 * 2 quarters
 * 1 dimes
 * 0 nickels
 * 3 pennies
 *
 * @author Susan Taylor
 * @version 1.0
 */

 import java.util.Scanner;

 public class MoneyCalculator
 {
	/**
	 * An application that prompts for and reads a double value representing a
 	 * monetary amount. Then determines the fewest number of each bill and coin
 	 * needed to represent that amount, starting with the highest bill. Assuming
 	 * $10 bill is the maximum amount needed.
 	 *
	 * Inputs:
	 *   Read a monetary amount entered via keyboard.
	 *
	 * Processing:
	 *   Divide the monetary amount by $10 to get the number of $10
	 *   Calculate the remaining amount
	 *   Divide the remaining amount by $5 to get the number of $5
	 *   Calculate the remaining amount
	 *   Divide the remaining amount by $1 to get the number of $1
	 *   Calculate the remaining amount
	 *   Divide the remaining amount by $0.25 to get the number of $0.25
	 *   Calculate the remaining amount
	 *   Divide the remaining amount by $0.10 to get the number of $0.10
	 *   Calculate the remaining amount
	 *   Divide the remaining amount by $0.05 to get the number of $0.05
	 *   Calculate the remaining amount
	 *   The remaining amount is the number of $0.01
	 *
	 * Outputs:
	 *   Display the number of $10
	 *   Display the number of $5
	 *   Display the number of $1
	 *   Display the number of $0.25
	 *   Display the number of $0.10
	 *   Display the number of $0.05
	 *   Display the number of $0.01
	 *
	 * @param args A String array containingcommand-line parameters
	 */
	 public static void main(String[] args)
	 {
		//Reserve memory - Declare local variables to store values
		double originalAmount;
		int amountInPennies, remainingAmount, tenDollar, fiveDollar, oneDollar, quarter, dime, nickel, penny;

		Scanner input = new Scanner(System.in);

		//Read a monetary value entered via keyboard.
		System.out.print("Enter monetary amount: ");
		originalAmount = input.nextDouble();

		//Uses a cast for double to integer conversion
		amountInPennies = (int)(originalAmount * 100);

		//Divide the monetary amount by 1000 to get the number of $10
		//Calculate the remaining amount
		tenDollar = amountInPennies / 1000;
		remainingAmount = amountInPennies % 1000;

		//Divide the monetary amount by 500 to get the number of $5
		//Calculate the remaining amount
		fiveDollar = remainingAmount / 500;
		remainingAmount = remainingAmount % 500;

		//Divide the monetary amount by 100 to get the number of $1
		//Calculate the remaining amount
		oneDollar = remainingAmount / 100;
		remainingAmount = remainingAmount % 100;

		//Divide the monetary amount by 25 to get the number of $0.25
		//Calculate the remaining amount
		quarter = remainingAmount / 25;
		remainingAmount = remainingAmount % 25;

		//Divide the monetary amount by 10 to get the number of $0.10
		//Calculate the remaining amount
		dime = remainingAmount / 10;
		remainingAmount = remainingAmount % 10;

		//Divide the monetary amount by 5 to get the number of $0.05
		//Calculate the remaining amount
		//Remaining amount is the number of $0.01
		nickel = remainingAmount / 5;
		remainingAmount = remainingAmount % 5;
		penny = remainingAmount;

		//Displays message to user on standard output device
		//Displays amount specified to user on standard output device
		System.out.println("That's equivalent to:");
		System.out.println(tenDollar + " ten dollar bills");
		System.out.println(fiveDollar + " five dollar bills");
		System.out.println(oneDollar + " one dollar bills");
		System.out.println(quarter + " quarters");
		System.out.println(dime + " dimes");
		System.out.println(nickel + " nickels");
		System.out.println(penny + " pennies");
 	 }
 }
