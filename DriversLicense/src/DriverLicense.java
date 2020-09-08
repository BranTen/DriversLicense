
/*
* Class: CMSC201
* Instructor: Monshi
* Description: this program grades answers given by a student and compares it to a set of correct answers
* Due: 02/08/2016 
* I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Brandon Tennyson
*/



import java.util.Scanner;

public class DriverLicense {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Answer key
		char[] answerKey = { 
				'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D',
				'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'
		};
		// Initialization
		int numRight = 0;
		int numAns = 20;
		boolean pass;
		char[] studentAns = new char[numAns];
		int[] missed = new int[numAns];
		
		// method call to get answers passing the empty array
		getAnswers(studentAns);
		
		// passing the correct answers and student answers and returning the number of questions
		//answered correctly
		numRight = totalCorrect(answerKey, studentAns);
		
		//passing both student and correct answers to determine which questions where missed in its own array
		missed = questionsMissed(answerKey, studentAns);
		//returns bool true for pass and false for fail
		pass = passed(numAns, numRight);

		// GRADING
		int numWrong = numAns - numRight;
		
		//if the method returned true it will say you passed 
		//along with what questions you missed
		if (pass == true) {
			System.out.println("Total correct answers: " + numRight + "\n");
			System.out.println("Total incorrect answers: " + numWrong + "\n");
			System.out.println("Question(s) you missed:");
			System.out.println("you passed!");

			// Incrementing for loop to display what was questions where wrong
			for (int i = 0; i < missed.length; i++) {

				if (missed[i] == 0) {
					int qNum = i + 1;
					System.out.print("Q" + qNum + " ");
				}
			}
			//if the method returned false then it will tell user that they failed 
			//along with what questions you missed
		} else {
			System.out.println("Total correct answers: " + numRight + "\n");
			System.out.println("Total incorrect answers: " + numWrong + "\n");
			System.out.println("Question(s) you missed:");
			System.out.println("you failed!");
			
			for (int i = 0; i < missed.length; i++) {
				if (missed[i] == 0) {
					int qNum = i + 1;
					System.out.print("Q" + qNum + " ");
				}
			}
		}
		input.close();
	}
/**
 * This method gets the user input answers
 * 
 * @param studentAns
 * @return
 */
	public static char[] getAnswers(char studentAns[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter only answers A-D");

		for (int i = 0; i < studentAns.length; i++) {
			int qNum;
			qNum = i + 1;
			System.out.println("Enter student answer for question #" + qNum);
			
			do { // loop for input validation
				String s = input.nextLine();

				if (s.length() == 1) { // if the string is any longer than one character

					String upper = s.toUpperCase(); // convert to upper

					if (upper.matches("[ABCD]")) { // if the string matches any of the following 
						studentAns[i] = upper.charAt(0); // take the char value 
						break;
					}
				}
				System.out.println("Enter A, B, C or D"); // if not a valid answer was entered 
				// if (Character.isLowerCase(studentAns[i]) == true) {
				// studentAns[i] = Character.toUpperCase(studentAns[i]);
				// }

			} while (true);// end loop
		}
		input.close();
		return studentAns; // return filled array
	}

	public static int totalCorrect(char[] answerKey, char[] studentAns) {
		int numRight = 0;
		for (int i = 0; i < answerKey.length; i++) {

			if (studentAns[i] == answerKey[i]) { // if the student answer matches

				numRight += 1; // add one to number right
			}
		}
		return numRight;// return the number
	}

	public static int[] questionsMissed(char[] answerKey, char[] studentAns) {
		int[] wrong = new int[20]; // array for wrong answer
		for (int i = 0; i < answerKey.length; i++) {
			if (studentAns[i] != answerKey[i]) { // if the student answer doesn't match the answer key
				wrong[i] = 0; // place a zero in the place of the wrong array
			} else {
				wrong[i] = 1; // if the answer does match place a 1 in the array
			}
		}
		return wrong;//return array 
	}

	public static boolean passed(int numOfCorrectAnswers, int minimumCorrectAnswers) {

		int grade = numOfCorrectAnswers - minimumCorrectAnswers;

		if (grade <= 5) {// if student scored higher than 15/20 it is true that they passed
			return true;

		} else {
			return false;
		}
	}
}
