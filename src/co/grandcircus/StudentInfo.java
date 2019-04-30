package co.grandcircus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInfo {

	public static void main(String[] args) {
		// initialize scanner
		Scanner scnr = new Scanner(System.in);
		// initialize arrays
		String studentNames[] = { "Adam", "Laura", "Lillian", "Rohit", "Zane", "Carl" };
		String studentHomeTown[] = { "Charlotte", "Westland", "Eaton Rapids", "Novi", "St Johns", "Lansing" };
		String studentFood[] = { "Pizza", "Pizza", "Pasta", "Pad Thai", "Burgers", "Tacos" };

		// initialize userNum to be used outside of methods
		int userNum;
		String keepPlaying = "yes";
		

		// checks to see if player would like to keep playing
		while (keepPlaying.equalsIgnoreCase("yes")) {

			userNum = getName(studentNames, scnr, "Which student would you like to learn more about? (Enter a number 1-6): ");

			System.out.print(infoDecider(userNum, scnr, "", studentNames, studentHomeTown, studentFood));

			keepPlaying = keepPlaying(scnr, " Would you like to know more? (enter \"yes\" or \"no\"): ");
		}
		System.out.println("");
		System.out.println("Thanks!");

		scnr.close();

	}

	//int methods takes in an array, scanner and prompt
	public static int getName(String arr[], Scanner scnr, String prompt) {
		//initialize boolean to false so you can go into while loop
		boolean boole = false;
		String name = "";
		int userNum = 0;
		System.out.print(prompt);

		while (boole == false) {
			
			//try catch to check for a input mismatch and continue to ask for input until input is correct
			try {
				userNum = scnr.nextInt();
			} catch(InputMismatchException e) {
				System.out.println(" ");
				System.out.println("That is not a number. Please try again. (enter a number 1-6): ");
				//garbage line
				scnr.nextLine();
				continue;
			} 
			
			// try catch to check for number within bounds of index and get input until num is in bounds
			try {

				name = (arr[userNum - 1]);
				boole = true;

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(" ");
				System.out.println("That student does not exist. Please try again. (enter a number 1-6): ");
			} catch (IllegalArgumentException e) {
				System.out.println(" ");
				System.out.println("That is not a number. Please try again. (enter a number 1-6): ");
			} catch (Exception e) {
				System.out.println(" ");
				System.out.println("An unknown error occurred. Please try again. (enter a number 1-6): ");
			}
		}
		System.out.println(" ");
		//sysout results
		System.out.print("Student " + userNum + " is " + name + ".  What would you like to know about " + name
				+ "? (enter \"hometown\" or \"favorite food\"); ");
		
		//return userNum to be used outside of method
		return userNum - 1;
	}

	// method that returns a string taking in user num and all of the arrays to decide appropriate response
	static public String infoDecider(int userNum, Scanner scnr, String prompt, String arr1[], String arr2[],
			String arr3[]) {
		System.out.println(prompt);
		String result = "";
		// garbage line
		scnr.nextLine();
		// initialize boolean to enter while loop
		boolean boole = false;
		// continue checking until meets conditions of hometown or favorite food
		while (boole != true) {

			String answer = scnr.nextLine();
			//  check input until it matches hometown or favorite 
			if (answer.equalsIgnoreCase("hometown")) {
				result = arr1[userNum] + " is from " + arr2[userNum] + ".";
				
				//to escape the while loop
				boole = true;

			} else if (answer.equalsIgnoreCase("favorite food")) {
				result = arr1[userNum] + "'s favorite food is " + arr3[userNum] + ".";
				//to escape the while loop
				boole = true;

			} else {
				System.out.println(" ");
				System.out.println(
						"That data does not exist. Please try again. (enter \"hometown\" or \"favorite food\"): ");
				continue;
			}
		}
		return result;
	}
	
	// method to take in input and return entry for use of keep playing loop
	static public String keepPlaying(Scanner scnr, String prompt) {
		System.out.print(prompt);
		String userEntry = scnr.next();
		return userEntry;
	}

}
