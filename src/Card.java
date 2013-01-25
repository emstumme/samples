
public class Card
{
	private int suit; //Clubs, Hearts, etc.
	private int type; //9, 10, J = 11, Q = 12, K = 13, A = 1, etc.
	private boolean showing; //Whether the card is face up
	private boolean soft; //Is this a soft ace?
	
	public Card(int iSuit, int iType)
	{
		suit = iSuit;
		type = iType;
		showing = true;
		soft = false;
		
		if(type == 1)
			soft = true;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	public int getValue()
	{
		if(type == 1)
		{
			if(soft)
				return 11; //Aces are 11
			else
				return 1;
		}
		else if(type > 10)
			return 10; //J, Q, K are 10
		else
			return type; //All others are their type
	}
	
	public int getType()
	{
		return type;
	}
	
	public boolean getSoft()
	{
		return soft;
	}
	
	public boolean isShowing()
	{
		return showing;
	}
	
	public void setShowing(boolean s)
	{
		showing = s;
	}
	
	public void setSoft(boolean s)
	{
		soft = s;
	}
	
	public int getIndex()
	{
		return 13*suit + type;
	}
}
