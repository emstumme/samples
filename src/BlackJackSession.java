
public class BlackJackSession
{
	Deck deck;
	Hand playerHand;
	Hand splitHand;
	Hand dealerHand;
	
	boolean split; //Indicates whether the player has split or not.
	boolean playerActive; //Indicates whether player is still playing their hand.
	boolean splitHandActive; //Indicates whether player is playing their split hand.
	
	//Player Info
	String name;
	int balance;
	int bet;
	
	//Statistics
	int handsWon;
	int handsLost;
	int handsPlayed;
	int biggestWin;
	int biggestLoss;
	
	//Constants
	final static int MIN_BET = 20;
	final static int STARTING_BALANCE = 500;
	
	BlackJackSession()
	{
		startNewSession();
	} 
	
	public void startNewSession()
	{
		deck = new Deck();
		playerHand = new Hand();
		splitHand = new Hand();
		dealerHand = new Hand();
		split = false;
		
		playerActive = false;
		splitHandActive = false;
		
		handsWon = 0;
		handsLost = 0;
		handsPlayed = 0;
		biggestWin = 0;
		biggestLoss = 0;
		
		name = "Player 1";
		balance = STARTING_BALANCE;
		bet = 0;
	}
	
	public void startHand()
	{
		//Give Player two cards
		playerHand.add(deck.dealCard());
		playerHand.add(deck.dealCard());
		
		//Give dealer two cards, on face down.
		Card faceDown = deck.dealCard();
		faceDown.setShowing(false);
		dealerHand.add(faceDown);
		dealerHand.add(deck.dealCard());
		
		playerActive = true;
		splitHandActive = false;
	}
	
	public void playerHit()
	{
		if(splitHandActive)
		{
			splitHand.add(deck.dealCard());
			if(splitHand.busted() || splitHand.getTotal() == 21)
				splitHandActive = false;
		}
		else
		{
			playerHand.add(deck.dealCard());
			if(playerHand.busted() || playerHand.getTotal() == 21)
				playerActive = false;
		}
	}

	public void playerStand()
	{
		if(splitHandActive)
			splitHandActive = false;
		else
			playerActive = false;
	}
	
	public void playerSplit()
	{
		split = true;
		splitHandActive = true;
		
		Card card = playerHand.getCards().remove(1);
		splitHand.add(card);
		
		playerHand.add(deck.dealCard());
		splitHand.add(deck.dealCard());
		
		balance -= bet;
	}
	
	public void playDealerHand()
	{
		//Reveal the dealer's cards
		for(Card card: dealerHand.getCards())
			card.setShowing(true);
		
		//Dealer hits until he gets to 17 or more
		while(dealerHand.getTotal() < 17)
			dealerHand.add(deck.dealCard());
	}
	
	public void revealDealerHand()
	{
		for(Card card: dealerHand.getCards())
			card.setShowing(true);
	}
	public void updateValues()
	{
		int result = handResult(playerHand, dealerHand);
		
		if(result > 0) //Player Won
		{
			handsWon++;
			handsPlayed++;
			
			if(bet > biggestWin)
				biggestWin = bet;
			
			balance += 2*bet;
		}
		else if(result < 0) //Dealer Won
		{
			handsLost++;
			handsPlayed++;
			
			if(bet > biggestLoss)
				biggestLoss = bet;
			
			balance += 0;
		}
		else // Tie
		{
			handsPlayed++;
			balance += bet;
		}
		
		if(split)
		{
			result = handResult(splitHand, dealerHand);
			
			if(result > 0) //Player Won
			{
				handsWon++;
				handsPlayed++;
				
				if(bet > biggestWin)
					biggestWin = bet;
				
				balance += 2*bet;
			}
			else if(result < 0) //Dealer Won
			{
				handsLost++;
				handsPlayed++;
				
				if(bet > biggestLoss)
					biggestLoss = bet;
				
				balance += 0;
			}
			else // Tie
			{
				handsPlayed++;
				balance += bet;
			}
		}
		
		bet = 0;
	}
	
	public void cleanUpHand()
	{
		deck.addToUsedCards(playerHand.getCards());
		playerHand.clear();
		deck.addToUsedCards(dealerHand.getCards());
		dealerHand.clear();
		deck.addToUsedCards(splitHand.getCards());
		splitHand.clear();
		
		split = false;
	}
	
	public int handResult(Hand player, Hand dealer)
	{
		//Handle any hands where someone busts
		if(dealer.busted() && player.busted()) 
			return 0; //Both bust, tie
		else if(dealer.busted())
			return 1; // Just dealer busts, win
		else if(player.busted())
			return -1; //Just player busts, lose
		
		//Handle any hands where someone has blackjack
		if(dealer.hasBlackJack() && player.hasBlackJack())
			return 0; //Both have blackjack, tie
		else if(dealer.hasBlackJack())
			return -1; //Dealer has blackjack, lose
		else if(player.hasBlackJack())
			return 1; //Player has blackjack, win
		
		//If both players stood with non-blackjack, larger hand wins
		return player.getTotal() - dealer.getTotal();
	}

	public String resultsMessage()
	{
		String resultMessage = "";
		
		int result = handResult(playerHand, dealerHand);
		
		if(result > 0)
			resultMessage += "You Won";
		else if(result < 0)
			resultMessage += "You Lost";
		else
			resultMessage += "You Tied";
		
		if(split)
		{
			resultMessage += " Your Second Hand";
			
			String splitMessage = "";
			
			result = handResult(splitHand, dealerHand);
			
			if(result > 0)
				splitMessage += "You Won";
			else if(result < 0)
				splitMessage += "You Lost";
			else
				splitMessage += "You Tied";
			
			splitMessage += " Your First Hand and \n";
			
			resultMessage = splitMessage + resultMessage;
		}
		
		return resultMessage;
	}
	
	public String statsMessage()
	{
		return 	"Hands Won: " + handsWon + "\n" +
				"Hands Lost: " + handsLost + "\n" +
				"Hands Played: " + handsPlayed + "\n" +
				"Biggest Win: " + biggestWin + "\n" +
				"Biggest Loss: " + biggestLoss + "\n";
	}

	public boolean validBet(String betString)
	{
		try
		{
			int betValue = new Integer(betString);
			
			return (betValue >= MIN_BET && betValue <= balance);
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean playerHasControl()
	{
		if(playerHand.busted() || playerHand.getTotal() == 21)
			playerActive = false;
		if(splitHand.busted() || splitHand.getTotal() == 21)
			splitHandActive = false;
		
		return playerActive || splitHandActive;
	}

	public boolean canPlayAgain()
	{
		return balance >= MIN_BET;
	}
	
	public boolean canSplit()
	{
		if(split)
			return false;
		else
		{
			Card card1 = playerHand.getCards().get(0);
			Card card2 = playerHand.getCards().get(1);
			
			boolean canSplit = card1.getType() == card2.getType();
			
			return canSplit && playerHand.getCards().size() == 2 && balance >= bet;
		}
	}
	
	public void setName(String iName)
	{
		name = iName;
	}

	public void setBet(String betString)
	{
		bet = new Integer(betString);
		
		balance -= bet;
	}

	public Hand playerHand()
	{
		return playerHand;
	}
	
	public Hand dealerHand()
	{
		return dealerHand;
	}
	
	public Hand splitHand()
	{
		return splitHand;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getBalance()
	{
		return balance;
	}
	
	public int getBet()
	{
		return bet;
	}
	
	public boolean isSplitHand()
	{
		return split;
	}
}


