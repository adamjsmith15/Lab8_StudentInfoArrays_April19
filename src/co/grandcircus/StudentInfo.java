package co.grandcircus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInfo {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String studentNames[] = { "Adam", "Laura", "Lillian", "Rohit", "Linmei", "Carl" };
		String studentHomeTown[] = { "Charlotte", "Westland", "Eaton Rapids", "Novi", "China", "Lansing" };
		String studentFood[] = { "Pizza", "Pizza", "Pasta", "Pad Thai", "Burgers", "Tacos" };

		int userNum;
		String keepPlaying = "yes";

		while (keepPlaying.equalsIgnoreCase("yes")) {

			// getName(studentNames, scnr, "Which student would you like to learn more
			// about? (Enter a number 1-20): ");
			userNum = getName(studentNames, scnr,
					"Which student would you like to learn more about? (Enter a number 1-6): ");

			System.out.print(infoDecider(userNum, scnr, "", studentNames, studentHomeTown, studentFood));

			keepPlaying = keepPlaying(scnr, " Would you like to know more? (enter \"yes\" or \"no\"): ");
		}
		System.out.println("");
		System.out.println("Thanks!");

		scnr.close();

	}

	public static int getName(String arr[], Scanner scnr, String prompt) {
		boolean boole = false;
		String name = "";
		int userNum = 0;
		System.out.print(prompt);

		while (boole == false) {
			
			try {
				userNum = scnr.nextInt();
			} catch(InputMismatchException e) {
				System.out.println(" ");
				System.out.println("That is not a number. Please try again. (enter a number 1-6): ");
				//garbage line
				scnr.nextLine();
				continue;
			} 
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
		System.out.print("Student " + userNum + " is " + name + ".  What would you like to know about " + name
				+ "? (enter \"hometown\" or \"favorite food\"); ");
		return userNum - 1;
	}

	static public String infoDecider(int userNum, Scanner scnr, String prompt, String arr1[], String arr2[],
			String arr3[]) {
		System.out.println(prompt);
		String result = "";
		// garbage line
		scnr.nextLine();
		boolean boole = false;
		while (boole != true) {

			String answer = scnr.nextLine();
			if (answer.equalsIgnoreCase("hometown")) {
				result = arr1[userNum] + " is from " + arr2[userNum] + ".";
				boole = true;

			} else if (answer.equalsIgnoreCase("favorite food")) {
				result = arr1[userNum] + "'s favorite food is " + arr3[userNum] + ".";
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

	static public String keepPlaying(Scanner scnr, String prompt) {
		System.out.print(prompt);
		String userEntry = scnr.next();
		return userEntry;
	}

}
