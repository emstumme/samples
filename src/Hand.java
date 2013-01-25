import java.util.ArrayList;


public class Hand
{
	ArrayList<Card> cards;
	
	public Hand()
	{
		cards = new ArrayList<Card>();
	}
	
	public int getTotal()
	{
		int total = 0;
		
		for(Card card: cards)
		{
			total += card.getValue();
			
			if(total > 21 && hasSoftAce())
			{
				hardenAce();
				total -= 10;
			}
		}
		
		return total;
	}
	
	public boolean hasSoftAce()
	{
		for(Card card: cards)
			if(card.getSoft())
				return true;
		return false;
	}
	
	public void hardenAce()
	{
		boolean aceHardened = false;
		
		for(Card card: cards)
			if(card.getSoft() && !aceHardened)
			{
				card.setSoft(false);
				aceHardened = true;
			}
	}
	
	public void add(Card card)
	{
		cards.add(card);
	}
	
	public ArrayList<Card> getCards()
	{
		return cards;
	}
	
	public void clear()
	{
		cards.clear();
	}
	
	public boolean busted()
	{
		return getTotal() > 21;
	}
	
	public boolean hasBlackJack()
	{
		return (getTotal() == 21 && cards.size() == 2);
	}
}
