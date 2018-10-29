/************************************************************
* GuessingGame.java
* Nafisa Hussain
* nahussai
* GuessingGame 
* Prompts you to play a guessing game in which you guess the number
* the program generates
************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class GuessingGame {
	public static void main (String[] args) {
		Scanner nameInput = new Scanner(System.in);
		System.out.println("Welcome to the number guessing game. What is your name?");
		String name = nameInput.nextLine();
		System.out.println();
		int rand = getRandomInt();
		System.out.println("I’m thinking of an integer between 1 and 10. You have 4 guesses.");
		System.out.println();
		for(int i=1; i<=4; i++) {
			Scanner guess = new Scanner(System.in);
			if(i==1)	
				System.out.print("Your first guess: ");
			else if(i==2)
				System.out.print("Your second guess: ");
			else if(i==3)
				System.out.print("Your third guess: ");
			else
				System.out.print("Your fourth guesses: ");
			int yourGuess = guess.nextInt();
			if(rand< yourGuess) {
				if(i==4) {
					System.out.println();
					System.out.println("Game over " + name + ", you lose.");
					break;
				}
					
				System.out.println("Too high, guess lower.");
				System.out.println();
			}
			else if(rand> yourGuess) {
				if(i==4) {
					System.out.println();
					System.out.println("Game over " + name + ", you lose.");
					break;
				}
				System.out.println("Too low, guess higher.");
				System.out.println();
			}
			else {
				System.out.println();
				System.out.println("Congratulations " + name + "! " + "You won in " + i + " guesses.");
				break;
			}
			
		}
		
	}
	public static int getRandomInt() {
		int max = 10;
	    int min = 1;
	    int range = max - min + 1;
	    int rand = (int)(Math.random() * range) + min;
	    return rand;
	}
	 
}
