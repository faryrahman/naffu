import java.lang.Math;
import java.util.Scanner; 
import java.io.*;

public class Player {
	String name;
	Card[] cards;
	boolean[][] isMarkedArray = new boolean[5][5];

	
	public Player(String person, Card[] cards) {
		name = person;
		this.cards = cards;
	}
	
	public String getName() {
		return name;
	}
	
	public Card[] getCards() {		
		return cards;
	}
	
	public boolean isWinner() {
		boolean wnl = false;
		//System.out.println("In isWinner.....");
		for(int c = 0; c < cards.length; c++) {
            for(int i = 0; i < isMarkedArray.length; i++) {
            	int j=0;
                if(isMarkedArray[i][j] &&  isMarkedArray[i][j+1] && isMarkedArray[i][j+2] && isMarkedArray[i][j+3] && isMarkedArray[i][j+4]) {
                	wnl = true;
                	return wnl;
                } 
                else {
                	wnl = false;
                }
            }
		}
		return wnl;
	}
	//need to change the getNumbers and replace with this. 
	public void markNumber(int number) {
		for(int c = 0; c < cards.length; c++) {
			int [][]numbers =cards[c].numbers;
			//printMatrix(numbers);
	        for(int i = 0; i < 5; i++) {
	           for(int j = 0; j < 5; j++) {
	        	   if(numbers[i][j]==number) {
	        		   isMarkedArray[i][j]=true;
	        	   }
	           }
	        }
		}
		//printBooleanMatrix(isMarkedArray);
	}
	
	public void printMatrix(int[][] num) {
		for(int i = 0; i < num.length; i++) {
            for(int j = 0; j < num[i].length; j++) {
              System.out.print(num[i][j] +" ");
            }
            System.out.println();
          }
	}
	
	public void printBooleanMatrix(boolean[][] num) {
		for(int i = 0; i < num.length; i++) {
            for(int j = 0; j < num[i].length; j++) {
              System.out.print(num[i][j] +" ");
            }
            System.out.println();
          }
	}
	
}
