import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*; 

public class BlackJackGUIHandler extends JFrame implements ActionListener 
{
	BlackJackSession session;
	HashMap<Integer, JLabel> cardToLabelMap;
	
	//Constants
	final static int X_OFFSET = 400;
	final static int Y_OFFSET = 200;
	final static int FRAME_HEIGHT = 600;
	final static int FRAME_WIDTH = 1100;
	
	final static Color BACKGROUND_COLOR = new Color(11, 97, 11);
	final static int CARD_WIDTH = 71;
	final static int CARD_HEIGHT = 96;
	final static int DEALER_HEIGHT_OFFSET = 50;
	final static int SPLIT_HEIGHT_OFFSET = 250;
	final static int PLAYER_HEIGHT_OFFSET = 350;
	final static int LEFT_OFFSET = 0;
	
	final static String HTML_PREPEND = "<b><font size=\"5\" color=\"black\">";
	final static String HTML_POSTPEND = "</font></b>";
	//GUI Elements
	Container contentPane;
	
	JMenuBar menuBar;
		JMenu fileMenu;
			JMenuItem stats;
			JMenuItem reset;
			JMenuItem quit;
		JMenu helpMenu;
			JMenuItem about;
	JPanel buttons;
		JButton hit;
		JButton st;
		JButton split;
	JPanel cardPanel;
	JPanel textPanel;
		JEditorPane namePane;
		JEditorPane balancePane;  
		JEditorPane betPane;
	
	//Art Assets
	ImageIcon faceDownCard;
	JLabel faceDownCardLabel;
	ImageIcon deck;
	JLabel deckLabel;
	
	ImageIcon twoOfClubs;
	ImageIcon threeOfClubs;
	ImageIcon fourOfClubs;
	ImageIcon fiveOfClubs;
	ImageIcon sixOfClubs;
	ImageIcon sevenOfClubs;
	ImageIcon eightOfClubs;
	ImageIcon nineOfClubs;
	ImageIcon tenOfClubs;
	ImageIcon jackOfClubs;
	ImageIcon queenOfClubs;
	ImageIcon kingOfClubs;
	ImageIcon aceOfClubs;
	ImageIcon twoOfDiamonds;
	ImageIcon threeOfDiamonds;
	ImageIcon fourOfDiamonds;
	ImageIcon fiveOfDiamonds;
	ImageIcon sixOfDiamonds;
	ImageIcon sevenOfDiamonds;
	ImageIcon eightOfDiamonds;
	ImageIcon nineOfDiamonds;
	ImageIcon tenOfDiamonds;
	ImageIcon jackOfDiamonds;
	ImageIcon queenOfDiamonds;
	ImageIcon kingOfDiamonds;
	ImageIcon aceOfDiamonds;
	ImageIcon twoOfHearts;
	ImageIcon threeOfHearts;
	ImageIcon fourOfHearts;
	ImageIcon fiveOfHearts;
	ImageIcon sixOfHearts;
	ImageIcon sevenOfHearts;
	ImageIcon eightOfHearts;
	ImageIcon nineOfHearts;
	ImageIcon tenOfHearts;
	ImageIcon jackOfHearts;
	ImageIcon queenOfHearts;
	ImageIcon kingOfHearts;
	ImageIcon aceOfHearts;
	ImageIcon twoOfSpades;
	ImageIcon threeOfSpades;
	ImageIcon fourOfSpades;
	ImageIcon fiveOfSpades;
	ImageIcon sixOfSpades;
	ImageIcon sevenOfSpades;
	ImageIcon eightOfSpades;
	ImageIcon nineOfSpades;
	ImageIcon tenOfSpades;
	ImageIcon jackOfSpades;
	ImageIcon queenOfSpades;
	ImageIcon kingOfSpades;
	ImageIcon aceOfSpades;
	
	JLabel twoOfClubsLabel;
	JLabel threeOfClubsLabel;
	JLabel fourOfClubsLabel;
	JLabel fiveOfClubsLabel;
	JLabel sixOfClubsLabel;
	JLabel sevenOfClubsLabel;
	JLabel eightOfClubsLabel;
	JLabel nineOfClubsLabel;
	JLabel tenOfClubsLabel;
	JLabel jackOfClubsLabel;
	JLabel queenOfClubsLabel;
	JLabel kingOfClubsLabel;
	JLabel aceOfClubsLabel;
	JLabel twoOfDiamondsLabel;
	JLabel threeOfDiamondsLabel;
	JLabel fourOfDiamondsLabel;
	JLabel fiveOfDiamondsLabel;
	JLabel sixOfDiamondsLabel;
	JLabel sevenOfDiamondsLabel;
	JLabel eightOfDiamondsLabel;
	JLabel nineOfDiamondsLabel;
	JLabel tenOfDiamondsLabel;
	JLabel jackOfDiamondsLabel;
	JLabel queenOfDiamondsLabel;
	JLabel kingOfDiamondsLabel;
	JLabel aceOfDiamondsLabel;
	JLabel twoOfHeartsLabel;
	JLabel threeOfHeartsLabel;
	JLabel fourOfHeartsLabel;
	JLabel fiveOfHeartsLabel;
	JLabel sixOfHeartsLabel;
	JLabel sevenOfHeartsLabel;
	JLabel eightOfHeartsLabel;
	JLabel nineOfHeartsLabel;
	JLabel tenOfHeartsLabel;
	JLabel jackOfHeartsLabel;
	JLabel queenOfHeartsLabel;
	JLabel kingOfHeartsLabel;
	JLabel aceOfHeartsLabel;
	JLabel twoOfSpadesLabel;
	JLabel threeOfSpadesLabel;
	JLabel fourOfSpadesLabel;
	JLabel fiveOfSpadesLabel;
	JLabel sixOfSpadesLabel;
	JLabel sevenOfSpadesLabel;
	JLabel eightOfSpadesLabel;
	JLabel nineOfSpadesLabel;
	JLabel tenOfSpadesLabel;
	JLabel jackOfSpadesLabel;
	JLabel queenOfSpadesLabel;
	JLabel kingOfSpadesLabel;
	JLabel aceOfSpadesLabel;
		
	public BlackJackGUIHandler()
	{
		super("Black Jack");
		
		loadArtAssets();
		
		//Set frame position and dimensions
		setBounds(X_OFFSET, Y_OFFSET, FRAME_WIDTH, FRAME_HEIGHT);
		
		//Set container
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		//Initialize Menu Bar
		menuBar = new JMenuBar();
			fileMenu = new JMenu("File");
				stats = new JMenuItem("Statistics");
				reset = new JMenuItem("Reset");
				quit = new JMenuItem("Quit");
				stats.addActionListener(this);
				reset.addActionListener(this);
				quit.addActionListener(this);
				fileMenu.add(stats);
				fileMenu.add(reset);
				fileMenu.add(quit);
			helpMenu = new JMenu("Help");
				about = new JMenuItem("About");
				about.addActionListener(this);
				helpMenu.add(about);
				
			menuBar.add(fileMenu);
			menuBar.add(helpMenu);
		
		//Initialize Buttons
		buttons = new JPanel();
			hit = new JButton("Hit");
			st = new JButton("Stand");
			split = new JButton("Split");
			hit.addActionListener(this);
			st.addActionListener(this);
			split.addActionListener(this);
			buttons.add(hit);
			buttons.add(st);
			buttons.add(split);
		
		//Art Assets
		cardPanel = new JPanel();
		cardPanel.setBackground(BACKGROUND_COLOR);
		cardPanel.setLayout(null);
		cardPanel.setLocation(0,0);
		cardPanel.setSize(this.HEIGHT, this.WIDTH);
		
		//Initialize Text Panel
		textPanel = new JPanel();
		textPanel.setBackground(BACKGROUND_COLOR);
		textPanel.setLayout(new GridLayout(3, 1, 0, 10));
			namePane = new JEditorPane();
			balancePane = new JEditorPane();
			betPane = new JEditorPane();
			namePane.setContentType("text/html");
			balancePane.setContentType("text/html");
			betPane.setContentType("text/html");
			namePane.setText(HTML_PREPEND + "Player Name" + HTML_POSTPEND);
			balancePane.setText(HTML_PREPEND + "Available Funds" + HTML_POSTPEND);
			betPane.setText(HTML_PREPEND + "Bet" + HTML_POSTPEND);
			namePane.setEditable(false);
			balancePane.setEditable(false);
			betPane.setEditable(false);
			namePane.setBackground(BACKGROUND_COLOR);
			balancePane.setBackground(BACKGROUND_COLOR);
			betPane.setBackground(BACKGROUND_COLOR);
			textPanel.add(namePane);
			textPanel.add(balancePane);
			textPanel.add(betPane);
		textPanel.setLocation(FRAME_WIDTH - 50, 0);
		
		//Add Elements to Panel
		contentPane.add(menuBar, BorderLayout.NORTH);
		contentPane.add(buttons, BorderLayout.SOUTH);
		contentPane.add(textPanel, BorderLayout.EAST);
		contentPane.add(cardPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // make frame visible
		
		//Start Playing BlackJack
		startNewSession();
		
		drawScreen();
	}

	public void startNewSession()
	{
		session = new BlackJackSession();
		String name = JOptionPane.showInputDialog ("Please Enter your Name:");
		session.setName(name);
		
		startHand();
		drawScreen();
		
		if(!session.playerHasControl())
			finishHand();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();

		boolean playerActive = session.playerHasControl();
		
		if(playerActive)
		{
			if(source == quit)
			{
				System.exit(0);
			}
			else if(source == stats)
			{
				JOptionPane.showMessageDialog(this, 
						session.statsMessage(),
						"Statistics",
						JOptionPane.PLAIN_MESSAGE);
			}
			else if(source == reset)
			{
				startNewSession();
			}
			else if(source == about)
			{
				JOptionPane.showMessageDialog(this, 
						"BlackJack v. 1.0 \nBy Team Clean",
						"About",
						JOptionPane.PLAIN_MESSAGE);
			}
			else if(source == hit)
			{
				session.playerHit();
			}
			else if(source == st)
			{
				session.playerStand();
			}
			else if(source == split)
			{
				if(session.canSplit())
					session.playerSplit();
			}
		
			drawScreen();
		}
		
		if(!session.playerHasControl())
			finishHand();
		}

	public void startHand()
	{
		//Get bet input and ensure it is valid
		Object value = JOptionPane.showInputDialog("Please Enter a Bet:");
		
		while(!validBetInput(value))
		{
			value = JOptionPane.showInputDialog("Please Enter a Valid Bet:");
			
			if(value == null)
				System.exit(0);
		}
		
		String betString = (String)value;
		
		session.setBet(betString);
		
		//Begin the hand
		session.startHand();
		
		drawScreen();
	}
	
	public void finishHand()
	{
		//If the player didn't bust, let the dealer play their hand
		if(!session.playerHand().busted() || (session.isSplitHand() && !session.splitHand().busted())) //If stood on first hand, or was a split hand and stood on split
			session.playDealerHand();
		else
			session.revealDealerHand();
		
		//Update stats and funds
		session.updateValues();
		
		drawScreen();
		
		//Show results
		JOptionPane.showMessageDialog(this, 
				session.resultsMessage(),
				"Results",
				JOptionPane.PLAIN_MESSAGE);
		
		//Put player cards back in deck, reset boolean flags, etc.
		session.cleanUpHand();
		
		//See if they can play again
		if(!session.canPlayAgain())
		{
			int continueReply = JOptionPane.showConfirmDialog(this, "You do not have enough money to \n" +
																	"play another hand. Would you like to \n" + 
																	"start over?");

			if(continueReply == JOptionPane.YES_OPTION)
				startNewSession();
			else
				System.exit(0);
		}
		//See if they want to play again
		else
		{
			int continueReply = JOptionPane.showConfirmDialog(this, "Play Another Hand?");
			
			if(continueReply == JOptionPane.YES_OPTION)
				startHand();
			else
				System.exit(0);
		}
	}
	
	public boolean validBetInput(Object input)
	{
		if(input == null)
			return false;
		try
		{
			String betString = (String)input;
			
			return session.validBet(betString);
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public void drawScreen()
	{
		//Draw text info
		textPanel.removeAll();
		namePane.setText(HTML_PREPEND + session.getName() + HTML_POSTPEND);
		balancePane.setText(HTML_PREPEND + session.getBalance() + HTML_POSTPEND);
		
		if(session.isSplitHand())
			betPane.setText(HTML_PREPEND + 2 * session.getBet() + HTML_POSTPEND);
		else
			betPane.setText(HTML_PREPEND + session.getBet() + HTML_POSTPEND);
		
		textPanel.add(namePane);
		textPanel.add(balancePane);
		textPanel.add(betPane);
		
		
		//Draw Cards
		cardPanel.removeAll();
		
		//Draw picture of deck
		deckLabel.setLocation(FRAME_WIDTH - 200, PLAYER_HEIGHT_OFFSET);
		cardPanel.add(deckLabel);
		
		//Draw Hands
		int dealer_x = LEFT_OFFSET;
		int split_x = LEFT_OFFSET;
		int player_x = LEFT_OFFSET;
		
		JLabel currLabel;
		
		//Draw Dealer's Cards
		for(Card card: session.dealerHand().getCards())
		{
			if(card.isShowing() || session.dealerHand.hasBlackJack())
			{
				currLabel = cardToLabelMap.get(card.getIndex());
				currLabel.setLocation(dealer_x, DEALER_HEIGHT_OFFSET);
				dealer_x += CARD_WIDTH + 5;
				cardPanel.add(currLabel);
			}
			else
			{
				currLabel = faceDownCardLabel;
				currLabel.setLocation(dealer_x, DEALER_HEIGHT_OFFSET);
				dealer_x += CARD_WIDTH + 5;
				cardPanel.add(currLabel);
			}
		}
		
		//Draw Split Cards
		for(Card card: session.splitHand().getCards())
		{
			currLabel = cardToLabelMap.get(card.getIndex());
			currLabel.setLocation(split_x, SPLIT_HEIGHT_OFFSET);
			split_x += CARD_WIDTH + 5;
			cardPanel.add(currLabel);
		}
		
		//Draw Player's Cards
		for(Card card: session.playerHand().getCards())
		{
			currLabel = cardToLabelMap.get(card.getIndex());
			currLabel.setLocation(player_x, PLAYER_HEIGHT_OFFSET);
			player_x += CARD_WIDTH + 5;
			cardPanel.add(currLabel);
		}
		
		repaint();
		validate();
	}
	
	public void loadArtAssets()
	{
		faceDownCard = new ImageIcon(getClass().getResource("faceDownCard.gif"));
		faceDownCardLabel = new JLabel(faceDownCard);
		faceDownCardLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		faceDownCardLabel.setHorizontalAlignment(0);
		
		deck = new ImageIcon(getClass().getResource("faceDownCard.gif"));
		deckLabel = new JLabel(faceDownCard);
		deckLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		deckLabel.setHorizontalAlignment(0);
		
		// Commented out for now. Uncomment when art assets are in place.
		aceOfClubs = new ImageIcon(getClass().getResource("c1.gif"));
		twoOfClubs = new ImageIcon(getClass().getResource("c2.gif"));
		threeOfClubs = new ImageIcon(getClass().getResource("c3.gif"));
		fourOfClubs = new ImageIcon(getClass().getResource("c4.gif"));
		fiveOfClubs = new ImageIcon(getClass().getResource("c5.gif"));
		sixOfClubs = new ImageIcon(getClass().getResource("c6.gif"));
		sevenOfClubs = new ImageIcon(getClass().getResource("c7.gif"));
		eightOfClubs = new ImageIcon(getClass().getResource("c8.gif"));
		nineOfClubs = new ImageIcon(getClass().getResource("c9.gif"));
		tenOfClubs = new ImageIcon(getClass().getResource("c10.gif"));
		jackOfClubs = new ImageIcon(getClass().getResource("cj.gif"));
		queenOfClubs = new ImageIcon(getClass().getResource("cq.gif"));
		kingOfClubs = new ImageIcon(getClass().getResource("ck.gif"));
		aceOfDiamonds = new ImageIcon(getClass().getResource("d1.gif"));
		twoOfDiamonds = new ImageIcon(getClass().getResource("d2.gif"));
		threeOfDiamonds = new ImageIcon(getClass().getResource("d3.gif"));
		fourOfDiamonds = new ImageIcon(getClass().getResource("d4.gif"));
		fiveOfDiamonds = new ImageIcon(getClass().getResource("d5.gif"));
		sixOfDiamonds = new ImageIcon(getClass().getResource("d6.gif"));
		sevenOfDiamonds = new ImageIcon(getClass().getResource("d7.gif"));
		eightOfDiamonds = new ImageIcon(getClass().getResource("d8.gif"));
		nineOfDiamonds = new ImageIcon(getClass().getResource("d9.gif"));
		tenOfDiamonds = new ImageIcon(getClass().getResource("d10.gif"));
		jackOfDiamonds = new ImageIcon(getClass().getResource("dj.gif"));
		queenOfDiamonds = new ImageIcon(getClass().getResource("dq.gif"));
		kingOfDiamonds = new ImageIcon(getClass().getResource("dk.gif"));
		aceOfHearts = new ImageIcon(getClass().getResource("h1.gif"));
		twoOfHearts = new ImageIcon(getClass().getResource("h2.gif"));
		threeOfHearts = new ImageIcon(getClass().getResource("h3.gif"));
		fourOfHearts = new ImageIcon(getClass().getResource("h4.gif"));
		fiveOfHearts = new ImageIcon(getClass().getResource("h5.gif"));
		sixOfHearts = new ImageIcon(getClass().getResource("h6.gif"));
		sevenOfHearts = new ImageIcon(getClass().getResource("h7.gif"));
		eightOfHearts = new ImageIcon(getClass().getResource("h8.gif"));
		nineOfHearts = new ImageIcon(getClass().getResource("h9.gif"));
		tenOfHearts = new ImageIcon(getClass().getResource("h10.gif"));
		jackOfHearts = new ImageIcon(getClass().getResource("hj.gif"));
		queenOfHearts = new ImageIcon(getClass().getResource("hq.gif"));
		kingOfHearts = new ImageIcon(getClass().getResource("hk.gif"));
		aceOfSpades = new ImageIcon(getClass().getResource("s1.gif"));
		twoOfSpades = new ImageIcon(getClass().getResource("s2.gif"));
		threeOfSpades = new ImageIcon(getClass().getResource("s3.gif"));
		fourOfSpades = new ImageIcon(getClass().getResource("s4.gif"));
		fiveOfSpades = new ImageIcon(getClass().getResource("s5.gif"));
		sixOfSpades = new ImageIcon(getClass().getResource("s6.gif"));
		sevenOfSpades = new ImageIcon(getClass().getResource("s7.gif"));
		eightOfSpades = new ImageIcon(getClass().getResource("s8.gif"));
		nineOfSpades = new ImageIcon(getClass().getResource("s9.gif"));
		tenOfSpades = new ImageIcon(getClass().getResource("s10.gif"));
		jackOfSpades = new ImageIcon(getClass().getResource("sj.gif"));
		queenOfSpades = new ImageIcon(getClass().getResource("sq.gif"));
		kingOfSpades = new ImageIcon(getClass().getResource("sk.gif"));
		
		twoOfClubsLabel = new JLabel(twoOfClubs);
		threeOfClubsLabel = new JLabel(threeOfClubs);
		fourOfClubsLabel = new JLabel(fourOfClubs);
		fiveOfClubsLabel = new JLabel(fiveOfClubs);
		sixOfClubsLabel = new JLabel(sixOfClubs);
		sevenOfClubsLabel = new JLabel(sevenOfClubs);
		eightOfClubsLabel = new JLabel(eightOfClubs);
		nineOfClubsLabel = new JLabel(nineOfClubs);
		tenOfClubsLabel = new JLabel(tenOfClubs);
		jackOfClubsLabel = new JLabel(jackOfClubs);
		queenOfClubsLabel = new JLabel(queenOfClubs);
		kingOfClubsLabel = new JLabel(kingOfClubs);
		aceOfClubsLabel = new JLabel(aceOfClubs);
		twoOfDiamondsLabel = new JLabel(twoOfDiamonds);
		threeOfDiamondsLabel = new JLabel(threeOfDiamonds);
		fourOfDiamondsLabel = new JLabel(fourOfDiamonds);
		fiveOfDiamondsLabel = new JLabel(fiveOfDiamonds);
		sixOfDiamondsLabel = new JLabel(sixOfDiamonds);
		sevenOfDiamondsLabel = new JLabel(sevenOfDiamonds);
		eightOfDiamondsLabel = new JLabel(eightOfDiamonds);
		nineOfDiamondsLabel = new JLabel(nineOfDiamonds);
		tenOfDiamondsLabel = new JLabel(tenOfDiamonds);
		jackOfDiamondsLabel = new JLabel(jackOfDiamonds);
		queenOfDiamondsLabel = new JLabel(queenOfDiamonds);
		kingOfDiamondsLabel = new JLabel(kingOfDiamonds);
		aceOfDiamondsLabel = new JLabel(aceOfDiamonds);
		twoOfHeartsLabel = new JLabel(twoOfHearts);
		threeOfHeartsLabel = new JLabel(threeOfHearts);
		fourOfHeartsLabel = new JLabel(fourOfHearts);
		fiveOfHeartsLabel = new JLabel(fiveOfHearts);
		sixOfHeartsLabel = new JLabel(sixOfHearts);
		sevenOfHeartsLabel = new JLabel(sevenOfHearts);
		eightOfHeartsLabel = new JLabel(eightOfHearts);
		nineOfHeartsLabel = new JLabel(nineOfHearts);
		tenOfHeartsLabel = new JLabel(tenOfHearts);
		jackOfHeartsLabel = new JLabel(jackOfHearts);
		queenOfHeartsLabel = new JLabel(queenOfHearts);
		kingOfHeartsLabel = new JLabel(kingOfHearts);
		aceOfHeartsLabel = new JLabel(aceOfHearts);
		twoOfSpadesLabel = new JLabel(twoOfSpades);
		threeOfSpadesLabel = new JLabel(threeOfSpades);
		fourOfSpadesLabel = new JLabel(fourOfSpades);
		fiveOfSpadesLabel = new JLabel(fiveOfSpades);
		sixOfSpadesLabel = new JLabel(sixOfSpades);
		sevenOfSpadesLabel = new JLabel(sevenOfSpades);
		eightOfSpadesLabel = new JLabel(eightOfSpades);
		nineOfSpadesLabel = new JLabel(nineOfSpades);
		tenOfSpadesLabel = new JLabel(tenOfSpades);
		jackOfSpadesLabel = new JLabel(jackOfSpades);
		queenOfSpadesLabel = new JLabel(queenOfSpades);
		kingOfSpadesLabel = new JLabel(kingOfSpades);
		aceOfSpadesLabel = new JLabel(aceOfSpades);
		
		twoOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		threeOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		fourOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		fiveOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		sixOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		sevenOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		eightOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		nineOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		tenOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		jackOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		queenOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		kingOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		aceOfClubsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		twoOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		threeOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		fourOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		fiveOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		sixOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		sevenOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		eightOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		nineOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		tenOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		jackOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		queenOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		kingOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		aceOfDiamondsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		twoOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		threeOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		fourOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		fiveOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		sixOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		sevenOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		eightOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		nineOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		tenOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		jackOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		queenOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		kingOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		aceOfHeartsLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		twoOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		threeOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		fourOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		fiveOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		sixOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		sevenOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		eightOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		nineOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		tenOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		jackOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		queenOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		kingOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		aceOfSpadesLabel.setSize(CARD_WIDTH, CARD_HEIGHT);
		
		twoOfClubsLabel.setHorizontalAlignment(0);
		threeOfClubsLabel.setHorizontalAlignment(0);
		fourOfClubsLabel.setHorizontalAlignment(0);
		fiveOfClubsLabel.setHorizontalAlignment(0);
		sixOfClubsLabel.setHorizontalAlignment(0);
		sevenOfClubsLabel.setHorizontalAlignment(0);
		eightOfClubsLabel.setHorizontalAlignment(0);
		nineOfClubsLabel.setHorizontalAlignment(0);
		tenOfClubsLabel.setHorizontalAlignment(0);
		jackOfClubsLabel.setHorizontalAlignment(0);
		queenOfClubsLabel.setHorizontalAlignment(0);
		kingOfClubsLabel.setHorizontalAlignment(0);
		aceOfClubsLabel.setHorizontalAlignment(0);
		twoOfDiamondsLabel.setHorizontalAlignment(0);
		threeOfDiamondsLabel.setHorizontalAlignment(0);
		fourOfDiamondsLabel.setHorizontalAlignment(0);
		fiveOfDiamondsLabel.setHorizontalAlignment(0);
		sixOfDiamondsLabel.setHorizontalAlignment(0);
		sevenOfDiamondsLabel.setHorizontalAlignment(0);
		eightOfDiamondsLabel.setHorizontalAlignment(0);
		nineOfDiamondsLabel.setHorizontalAlignment(0);
		tenOfDiamondsLabel.setHorizontalAlignment(0);
		jackOfDiamondsLabel.setHorizontalAlignment(0);
		queenOfDiamondsLabel.setHorizontalAlignment(0);
		kingOfDiamondsLabel.setHorizontalAlignment(0);
		aceOfDiamondsLabel.setHorizontalAlignment(0);
		twoOfHeartsLabel.setHorizontalAlignment(0);
		threeOfHeartsLabel.setHorizontalAlignment(0);
		fourOfHeartsLabel.setHorizontalAlignment(0);
		fiveOfHeartsLabel.setHorizontalAlignment(0);
		sixOfHeartsLabel.setHorizontalAlignment(0);
		sevenOfHeartsLabel.setHorizontalAlignment(0);
		eightOfHeartsLabel.setHorizontalAlignment(0);
		nineOfHeartsLabel.setHorizontalAlignment(0);
		tenOfHeartsLabel.setHorizontalAlignment(0);
		jackOfHeartsLabel.setHorizontalAlignment(0);
		queenOfHeartsLabel.setHorizontalAlignment(0);
		kingOfHeartsLabel.setHorizontalAlignment(0);
		aceOfHeartsLabel.setHorizontalAlignment(0);
		twoOfSpadesLabel.setHorizontalAlignment(0);
		threeOfSpadesLabel.setHorizontalAlignment(0);
		fourOfSpadesLabel.setHorizontalAlignment(0);
		fiveOfSpadesLabel.setHorizontalAlignment(0);
		sixOfSpadesLabel.setHorizontalAlignment(0);
		sevenOfSpadesLabel.setHorizontalAlignment(0);
		eightOfSpadesLabel.setHorizontalAlignment(0);
		nineOfSpadesLabel.setHorizontalAlignment(0);
		tenOfSpadesLabel.setHorizontalAlignment(0);
		jackOfSpadesLabel.setHorizontalAlignment(0);
		queenOfSpadesLabel.setHorizontalAlignment(0);
		kingOfSpadesLabel.setHorizontalAlignment(0);
		aceOfSpadesLabel.setHorizontalAlignment(0);
		
		//Initialize and populate cardToLabelMap
		cardToLabelMap = new HashMap<Integer, JLabel>();
		
		cardToLabelMap.put(1, aceOfClubsLabel);
		cardToLabelMap.put(2, twoOfClubsLabel);
		cardToLabelMap.put(3, threeOfClubsLabel);
		cardToLabelMap.put(4, fourOfClubsLabel);
		cardToLabelMap.put(5, fiveOfClubsLabel);
		cardToLabelMap.put(6, sixOfClubsLabel);
		cardToLabelMap.put(7, sevenOfClubsLabel);
		cardToLabelMap.put(8, eightOfClubsLabel);
		cardToLabelMap.put(9, nineOfClubsLabel);
		cardToLabelMap.put(10, tenOfClubsLabel);
		cardToLabelMap.put(11, jackOfClubsLabel);
		cardToLabelMap.put(12, queenOfClubsLabel);
		cardToLabelMap.put(13, kingOfClubsLabel);
		cardToLabelMap.put(14, aceOfDiamondsLabel);
		cardToLabelMap.put(15, twoOfDiamondsLabel);
		cardToLabelMap.put(16, threeOfDiamondsLabel);
		cardToLabelMap.put(17, fourOfDiamondsLabel);
		cardToLabelMap.put(18, fiveOfDiamondsLabel);
		cardToLabelMap.put(19, sixOfDiamondsLabel);
		cardToLabelMap.put(20, sevenOfDiamondsLabel);
		cardToLabelMap.put(21, eightOfDiamondsLabel);
		cardToLabelMap.put(22, nineOfDiamondsLabel);
		cardToLabelMap.put(23, tenOfDiamondsLabel);
		cardToLabelMap.put(24, jackOfDiamondsLabel);
		cardToLabelMap.put(25, queenOfDiamondsLabel);
		cardToLabelMap.put(26, kingOfDiamondsLabel);
		cardToLabelMap.put(27, aceOfHeartsLabel);
		cardToLabelMap.put(28, twoOfHeartsLabel);
		cardToLabelMap.put(29, threeOfHeartsLabel);
		cardToLabelMap.put(30, fourOfHeartsLabel);
		cardToLabelMap.put(31, fiveOfHeartsLabel);
		cardToLabelMap.put(32, sixOfHeartsLabel);
		cardToLabelMap.put(33, sevenOfHeartsLabel);
		cardToLabelMap.put(34, eightOfHeartsLabel);
		cardToLabelMap.put(35, nineOfHeartsLabel);
		cardToLabelMap.put(36, tenOfHeartsLabel);
		cardToLabelMap.put(37, jackOfHeartsLabel);
		cardToLabelMap.put(38, queenOfHeartsLabel);
		cardToLabelMap.put(39, kingOfHeartsLabel);
		cardToLabelMap.put(40, aceOfSpadesLabel);
		cardToLabelMap.put(41, twoOfSpadesLabel);
		cardToLabelMap.put(42, threeOfSpadesLabel);
		cardToLabelMap.put(43, fourOfSpadesLabel);
		cardToLabelMap.put(44, fiveOfSpadesLabel);
		cardToLabelMap.put(45, sixOfSpadesLabel);
		cardToLabelMap.put(46, sevenOfSpadesLabel);
		cardToLabelMap.put(47, eightOfSpadesLabel);
		cardToLabelMap.put(48, nineOfSpadesLabel);
		cardToLabelMap.put(49, tenOfSpadesLabel);
		cardToLabelMap.put(50, jackOfSpadesLabel);
		cardToLabelMap.put(51, queenOfSpadesLabel);
		cardToLabelMap.put(52, kingOfSpadesLabel);
	}
}
