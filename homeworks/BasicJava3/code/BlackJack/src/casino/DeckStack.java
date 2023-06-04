package casino;

/**
 * A stack of more than one deck used in a casino game
 *
 */
public class DeckStack {
	
	private Deck[] decks;
	public DeckStack(int numDecks) {
		decks = new Deck[numDecks];
		for(int i=0; i < decks.length; i++){
			decks[i] = new Deck();
		}
	}
	
	public Card dealTopCard() {
		int idx = (int)(Math.random()*decks.length);
		return decks[idx].dealTopCard();
	}
	
	protected void restoreDecks() {
		for(Deck d:decks){
			d.shuffle();
		}
	}
	
	public int cardsLeft() {
		int totalleft = 0;
		for(int i=0; i < decks.length; i++){
			totalleft += decks[i].cardsLeft();
		}
		return totalleft;
	}
	
	
}
