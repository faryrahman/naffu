import java.lang.Math;
public class Card {
	int [][] numbers = new int[5][5];
	//not sure if next should be declared here 
	boolean[][] isMarkedArray = new boolean[5][5];
	
	
	public Card(int[][]numbers) {
		this.numbers = numbers;
	}
	
	public int getNumber(int Row, int Column) {
		return numbers[Row][Column];
	}
	

	//not sure if allowed to pass boolean[][] isMarkedArray below
	public boolean isMarked(int row, int column) {
		int i;
		int j;
		boolean marked = false;
		for(i=0; i<isMarkedArray.length;i++) {
			for(j=0;j<isMarkedArray[i].length;j++) {
				if(isMarkedArray[i][j] == true) {
					marked = true;
				}
				else {
					marked = false;
				}
			}
		}
		return marked;
	}
	
	public void markNumber(int number) {
		int i;
		int j;
		for(i=0; i<numbers.length;i++) {
			for(j=0;j<numbers[i].length;j++) {
				if(numbers[i][j]==number) {
					isMarkedArray[i][j]=true;
				}
				else {
					isMarkedArray[i][j]=false;
				}
			}
		}
	}
}
