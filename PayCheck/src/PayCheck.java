/************************************************************
* PayCheck.java
* Nafisa Hussain
* nahussai
* PayCheck 
* Calculating weekly wages 
************************************************************/
import java.util.Scanner;
public class PayCheck {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double wages = 0;
		System.out.println("Please enter the total hours worked Monday through Sunday.");
		double hours = keyboard.nextDouble();
		System.out.println("Please enter your pay rate (in terms of dollars per hour).");
		double rate = keyboard.nextDouble();
		/*if(hours<=40) {
			wages = hours * rate;
		}
		else {
			double overtime = hours - 40;
			wages = (overtime * rate * 1.5) + (40 * rate);
		}*/
		wages = calculateWages(hours, rate);
		System.out.print("Your paycheck for this week is: " + wages);
	}
	
	public static double calculateWages(double h, double r) {
		if(h<=40) {
			return(h * r);
		}
		else {
			double overtime = h - 40;
			return ((overtime * r * 1.5) + (40 * r));
		}
	}
}
