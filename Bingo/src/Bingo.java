
public class Bingo {
	Player[] players;
	
	public Bingo(Player[] players) {
		this.players = players;
		
	}
	
	public String play(int number) {
		String winners="";
		//marks the numbers in all of the players cards
		for(int p=0; p<players.length;p++) {			
			players[p].markNumber(number);
		}
		//check for winners & return names
		for(int p=0; p<players.length;p++) {
			boolean win = false;
			win = players[p].isWinner();
			if(win) {
				winners = winners + " "+players[p].getName();
				//Remove first space   
				if(winners.charAt(0)==' '){
					//System.out.println("Winners...."+winners);
					winners = winners.substring(1);
				}	
			}
			/*
			if(win &&(p==0)){
				System.out.println("Winners...."+winners);
				winners = winners.substring(1);
			}	*/
		}
		
		
		return winners;		
	}
}
