import java.util.Scanner;
public class Minesweeper {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number rows");
		int m = scan.nextInt();
		System.out.println("Enter the number of columns");
		int n = scan.nextInt();
		System.out.println("Enter the number of bombs");
		int b = scan.nextInt();
		char[][] board = new char[m][n];
		
		//asking users for locations to put the bombs
		int[] rowLocationInput = new int[b];
		int[] colLocationInput = new int[b];
		//Getting mine locations from user
		for(int i=0; i<b; i++) {
			System.out.println("Enter the row to place bomb# " +(i+1));
			//Check if user is entering rows greater than m
			int row=scan.nextInt();
			if (row<m)
				rowLocationInput[i]=row;
		    while(row>(m-1)) {
		 		System.out.println("Enter a row less than " + m + " to place the mine: " );
		 		row=scan.nextInt();
				if(row<m) {
					rowLocationInput[i]=row;
					break;
				}
			}
			
			System.out.println("Enter the column to place the bomb# " +(i+1));
			//Check if user is entering column greater than n
			int col=scan.nextInt();
			if (col<n)
				colLocationInput[i]=col;
			while(col>(n-1)) {
				System.out.println("Enter the column less than " + n + " to place the mine: " );
				col=scan.nextInt();
				if(col<n) {
					colLocationInput[i]=col;
					break;
				}
			}
			//colLocationInput[i]=col;
			System.out.println(rowLocationInput[i] + " " + colLocationInput[i]);
		}
		
		
		//setting up the initial board with locations of the mines
		initialBoard(rowLocationInput,colLocationInput,board);
		System.out.println("\nInitial Board.........");
		printBoard(board);
		System.out.println();
		
		//Add the information on nearby mines
		makeMineMap(rowLocationInput, colLocationInput, board);
		System.out.println("\nBoard with the mine map.........");
		printBoard(board);
	}//End of Main
	
	//Initial Board
	public static void initialBoard(int[] rowLocationInput, int[] colLocationInput, char[][] board) {
		int b = rowLocationInput.length;
		//Put 0 in all places
		for(int i=0; i<board.length;i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j]='0';
			}
		}
		//Put the mines in the spots provided
		for(int k=0;k<b; k++) {
			int i=rowLocationInput[k];
			int j=colLocationInput[k];
			board[i][j]='*';
		}
	}
	
	//Placing the # of mines nearby into the array
	public static void makeMineMap(int[] rowLocationInput, int[] colLocationInput, char[][] board) {		
			//Go thru entire matrix
			for(int i=0; i<board.length;i++) {
				for(int j=0; j<board[i].length; j++) {
					if (board[i][j]=='*'){
						//update all locations around mine by 1
						
						//location (0,0)
						if(i==0 && j==0) {
							if(board[i][j+1] !='*')
								board[i][j+1]=(char)(((int)board[i][j+1])+1);
							
							if(board[i+1][j] != '*')
								board[i+1][j]=(char)(((int)board[i+1][j])+1);
							
							if(board[i+1][j+1] != '*')
								board[i+1][j+1]=(char)(((int)board[i+1][j+1])+1);
						}
						//location (m,n)
						else if(i==board.length-1 && j==board[i].length-1) {
							if(board[i][j-1] != '*')
								board[i][j-1]=(char)(((int)board[i][j-1])+1);
							if(board[i-1][j] != '*')
								board[i-1][j]=(char)(((int)board[i-1][j])+1);
							if(board[i-1][j-1] != '*')
								board[i-1][j-1]=(char)(((int)board[i-1][j-1])+1);
						}
						//location (0,n)
						else if(i==0 && j==board[i].length-1) {
							if(board[i][j-1] != '*')
								board[i][j-1]=(char)(((int)board[i][j-1])+1);
							if(board[i+1][j] != '*')
								board[i+1][j]=(char)(((int)board[i+1][j])+1);
							if(board[i+1][j-1] != '*')
								board[i+1][j-1]=(char)(((int)board[i+1][j-1])+1);
						}
						//location (m,0)
						else if(i==board.length-1 && j==0) {
							if(board[i][j+1] != '*')
								board[i][j+1]=(char)(((int)board[i][j+1])+1);
							if(board[i-1][j] != '*')
								board[i-1][j]=(char)(((int)board[i-1][j])+1);
							if(board[i-1][j+1] != '*')
								board[i-1][j+1]=(char)(((int)board[i-1][j+1])+1);
							
						}
						//first row middle items
						else if(i==0 && (j!=0 && j!=board[i].length-1)){
							if(board[i][j-1] != '*')
								board[i][j-1]=(char)(((int)board[i][j-1])+1);
							if(board[i][j+1] != '*')
								board[i][j+1]=(char)(((int)board[i][j+1])+1);
							if(board[i+1][j-1] != '*')
								board[i+1][j-1]=(char)(((int)board[i+1][j-1])+1);
							if(board[i+1][j] != '*')
								board[i+1][j]=(char)(((int)board[i+1][j])+1);
							if(board[i+1][j+1] != '*')
								board[i+1][j+1]=(char)(((int)board[i+1][j+1])+1);
					    }
						
						//last row middle items
						else if(i==board.length-1 && (j!=0 && j!=board[i].length-1)) {
							if(board[i][j-1] != '*')
								board[i][j-1]=(char)(((int)board[i][j-1])+1);
							if(board[i][j+1] != '*')
								board[i][j+1]=(char)(((int)board[i][j+1])+1);
							if(board[i-1][j-1] != '*')
								board[i-1][j-1]=(char)(((int)board[i-1][j-1])+1);
							if(board[i-1][j] != '*')
								board[i-1][j]=(char)(((int)board[i-1][j])+1);
							if(board[i-1][j+1] != '*')
								board[i-1][j+1]=(char)(((int)board[i-1][j+1])+1);
						}
						
						
						//first column middle items
						else if((i!=0 && i!=board.length-1) && j==0 ) {
							if(board[i-1][j] != '*')
								board[i-1][j]=(char)(((int)board[i-1][j])+1);
							if(board[i-1][j+1] != '*')
								board[i-1][j+1]=(char)(((int)board[i-1][j+1])+1);
							if(board[i][j+1] != '*')
								board[i][j+1]=(char)(((int)board[i][j+1])+1);
							if(board[i+1][j+1] != '*')
								board[i+1][j+1]=(char)(((int)board[i+1][j+1])+1);
							if(board[i+1][j] != '*')
								board[i+1][j]=(char)(((int)board[i+1][j])+1);
						}
						//last column middle items
						else if((i!=0 && i!=board.length-1) && (j==board[i].length-1)) {
							if(board[i-1][j] != '*')
								board[i-1][j]=(char)(((int)board[i-1][j])+1);
							if(board[i-1][j-1] != '*')
								board[i-1][j-1]=(char)(((int)board[i-1][j-1])+1);
							if(board[i][j-1] != '*')
								board[i][j-1]=(char)(((int)board[i][j-1])+1);
							if(board[i+1][j-1] != '*')
								board[i+1][j-1]=(char)(((int)board[i+1][j-1])+1);
							if(board[i+1][j] != '*')
								board[i+1][j]=(char)(((int)board[i+1][j])+1);
						}
						
						//All other items
						else {
							
							if(board[i-1][j-1] != '*')
								board[i-1][j-1]=(char)(((int)board[i-1][j-1])+1);
							if(board[i-1][j] != '*')
								board[i-1][j]=(char)(((int)board[i-1][j])+1);
							if(board[i-1][j+1] != '*')
								board[i-1][j+1]=(char)(((int)board[i-1][j+1])+1);
							if(board[i][j-1] != '*')
								board[i][j-1]=(char)(((int)board[i][j-1])+1);
							if(board[i][j+1] != '*')
								board[i][j+1]=(char)(((int)board[i][j+1])+1);
							if(board[i+1][j-1] != '*')
								board[i+1][j-1]=(char)(((int)board[i+1][j-1])+1);
							if(board[i+1][j] != '*')
								board[i+1][j]=(char)(((int)board[i+1][j])+1);
							if(board[i+1][j+1] != '*')
								board[i+1][j+1]=(char)(((int)board[i+1][j+1])+1);
						}
						
					}
						
				}
			}
		//}
	}
			
	//Printing the board
	public static void printBoard(char[][] board) {
		for(int i=0; i<board.length;i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
