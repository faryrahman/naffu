import java.util.Scanner;

public class Narges {
	public static void main (String[] args) {
		//setting up arrays to store chars in 'narges' and whatever the input is 
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a input string: ");
		String input = new String(scan.nextLine());
		String[] narges = new String[]{"n","a", "r", "g", "e", "s"};
		boolean contains = false;
		if(input.contains("narges")) {
			contains = true;
			System.out.println(contains);
		}
		else
		{
			contains = checkNarges(input,narges);
			System.out.println(contains);
		}
		scan.close();
	}//End of main
	
	//Check for narges
	public static boolean checkNarges(String input, String[] narges) {
		boolean found=false;
		for(int i=0;i<narges.length; i++) {
			String [] test = input.split(narges[i],2);
			if (test[0].length() == input.length()) {
				return found;
			}
			System.out.println("Remaining string...."+ test[1]);
			input=test[1];
		}
		found=true;
		return found;
	}
    
}
