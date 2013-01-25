import java.util.ArrayList;


public class Deck
{
	ArrayList<Card> unusedCards;
	ArrayList<Card> usedCards;
	
	public Deck()
	{
		unusedCards = new ArrayList<Card>();
		usedCards = new ArrayList<Card>();
		initializeDeck();
	}
	
	public void initializeDeck()
	{
		for(int i = 0; i < 4; i++) //For each suit
			for(int j = 1; j <= 13; j++) //For each type
				unusedCards.add(new Card(i, j));
	}
	
	public Card dealCard()
	{
		if(unusedCards.isEmpty())
			shuffleInUsedCards();
		
		int randLoc = (int)(Math.random() * unusedCards.size());
		
		return unusedCards.remove(randLoc);
	}
	
	public void shuffleInUsedCards()
	{
		for(Card card: usedCards)
			unusedCards.add(card);
		
		usedCards.clear();
	}
	
	public void addToUsedCards(ArrayList<Card> cards)
	{
		for(Card card: cards)
			usedCards.add(card);
	}
}
