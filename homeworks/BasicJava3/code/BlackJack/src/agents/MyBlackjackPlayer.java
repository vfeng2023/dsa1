package agents;

import casino.BlackjackPlayer;
import casino.Card;
import casino.Move;

public class MyBlackjackPlayer extends BlackjackPlayer{

	@Override
	public int getBet() {
		//return 10; //always bet 10
		if(getChips() < 0){
			return 0;
		}else{
			return 1;
		}
	}

	@Override
	public Move getMove() {
		//implement simplified versio nof basic strategy
		/* Hits until we get a score of 16 or better */
		// if(this.handScore() <= 16) return Move.HIT;
		// return Move.STAY;
		// double r = Math.random();
		// if(r < 0.5){
		// 	return Move.HIT;
		// }
		// return Move.STAY;

		int mytotal = this.handScore();
		Card dealerhand = this.dealer.getVisibleCard();
		int dealerval = dealerhand.getRank();
		//return Move.STAY;
		boolean hasace=false;
		//boolean haspair;
		boolean lessthannine = false;
		for(Card c: cards){
			if(c.getRank()==1){
				hasace = true;
			}
			if(c.getRank() <= 9 && c.getRank() >= 7){
				lessthannine = true;
			}
		}
		if(hasace){
			if(lessthannine) return Move.STAY;
			return Move.HIT;
		}else{
			if(mytotal <= 21 && mytotal >=15){
				return Move.STAY;
			}else if(12< mytotal){
				if(dealerval < 6){
					return Move.STAY;
				}else{
					return Move.HIT;
				}
			}else if(9 < mytotal){
				return Move.DOUBLE;
			}else{
				return Move.HIT;
			}
		}
		//return Move.DOUBLE;
	}

	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process.
		 */
		
		
	}

	
}
