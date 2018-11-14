import java.util.Scanner;
public class ClockTest {

	/*
     * Test 1
     * Should print the following
     * Creating clock with hour = 0 and minute = 0
     * Printing the time
     * 12:00 AM
     */
    private static String test1 = "0 print q"; 
    /*
     * Test 2
     * Should print the following
     * Please enter 1 integer to create a Clock object
     * Creating clock with hour = 13
     * Printing the time
     * 01:00 PM
     */
    private static String test2 = "1 13 print q";
    
    /*
     * Test 3
     * Should print the following
     * Please enter 2 integers to create a Clock object
     * Creating clock with hour = 14 and minute = 6
     * Printing the time
     * 02:06 PM
     */
    private static String test3 = "2 14 6 print q";
    
    /*
     * Test 4
     * Should print the following
     * Please enter 2 integers to create a Clock object
     * Creating clock with hour = 14 and minute = 58
     * Incrementing timer with 1 minute
     * New Time: 14 59
     * hour: 14
     * minute: 59

     */
    private static String test4 = "2 14 58 incrementOne getHour getMinute q";
    /*
     * Test 5
     * Should print the following
     * Please enter 2 integers to create a Clock object
     * Creating clock with hour = 14 and minute = 58
     * Please enter how many minutes you want to increment the timer
     * New Time: 15 1
     * hour: 15
     * minute: 1
     */
    private static String test5 = "2 14 58 incrementMult 3 getHour getMinute q";
    
    /*
     * Test 6
     * Should print the following
     * Please enter 2 integers to create a Clock object
     * Creating clock with hour = 0 and minute = 24
     * Incrementing timer with 1 minute
     * New Time: 0 25
     * Please enter 2 integers to set the time of the Clock
     * Invalid Input
     * New Time: 0 25
     * Printing the time
     * 12:25 AM
     */
    private static String test6 = "2 0 24 incrementOne setTime 34 12 print q";
    
    
   
    public static void main(String[] args) {
        // To run one of the above tests You can replace System.in with the test variable ie:
        // Scanner scan = new Scanner(test1);
        // Be sure to only have one scanner object at a time

        // Otherwise you can still use the console to enter data
        Scanner scan = new Scanner(test6);

        Clock c1 = new Clock();
        String command = "";
        while (command != "q") {
          command = scan.next();
          switch(command) {
          	case "0":
                System.out.println("Creating clock with hour = 0 and minute = 0");
          		c1 = new Clock();
          		break;
          	case "1":
          		System.out.println("Please enter 1 integer to create a Clock object");
                int hour1 = scan.nextInt();
                System.out.println("Creating clock with hour = " + hour1);
          		c1 = new Clock(hour1);
                break;
            case "2":
            		System.out.println("Please enter 2 integers to create a Clock object");
            		int hour2 = scan.nextInt(), minute = scan.nextInt();
                System.out.println("Creating clock with hour = " + hour2 + " and minute = "+minute);
            		c1 = new Clock(hour2, minute);
            		break;
            case "incrementMult":
            		System.out.println("Please enter how many minutes you want to increment the timer");
            		c1.incrementTimer(scan.nextInt());
            		System.out.println("New Time: " + c1.getHour() +" "+ c1.getMinute());
            		break;
            case "incrementOne":
            		System.out.println("Incrementing timer with 1 minute");
            		c1.incrementTimer();
                System.out.println("New Time: " + c1.getHour() +" "+ c1.getMinute());
                break;
            case "print":
            		System.out.println("Printing the time");
            		System.out.println(c1.toString());
            		break;
            case "setTime":
                System.out.println("Please enter 2 integers to set the time of the Clock");
                c1.setTime(scan.nextInt(), scan.nextInt());
                System.out.println("New Time: " + c1.getHour() +" "+ c1.getMinute());
                break;
            case "getHour":
                System.out.println("hour: " + c1.getHour());
                break;
            case "getMinute":
                System.out.println("minute: " + c1.getMinute());
                break;
            case "q":
            		System.exit(0);
            		break;
          }
        }
        scan.close();
      }
}


