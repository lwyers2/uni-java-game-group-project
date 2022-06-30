package softwareEngineering;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EcoGameDriver 
{
	static Scanner scanPlayer;
	static String name = "";
	static String yesOrNo = "";
	static boolean characterCheck = false;
	static int playerOrder;
	static ArrayList<BoardSquare> boardSquare;
	static ArrayList<PlayerStats> allPlayers;
	
	public static void main(String[] args) 
	{
		//Create game object
		SetupGame game1 = new SetupGame();
		//create a board object
		Board board = new Board();
		//generate squares using method from board
		boardSquare = board.createBoardSquares();
		
		// get the amont of players for the game to be played
		int totalPlayers = game1.setUpPlayerAmount();
		
		//Populate an arraylist with all the players
		allPlayers = game1.playerSetup(totalPlayers);

		//play the main game
		gamePlay(allPlayers);
		
		
	}// End of main
	
	// Method to display board to users
	static void printBoard()
	{
		System.out.println("---------------------------------------------------");
		System.out.println("->> Start>> - Airport    -Burundi     -Madagascar -");
		System.out.println("- GO GREEN! - Lounge     -            -           -");
		System.out.println("-   Have    -            -            -           -");
		System.out.println("- +75 ECO   -            -            -           -");
		System.out.println("---------------------------------------------------");
		System.out.println("- Japan     -                         -Argentina  -");
		System.out.println("-           -                         -           -");
		System.out.println("-           -                         -           -");
		System.out.println("-           -                         -           -");
		System.out.println("-------------                         -------------");
		System.out.println("- China     -                         -Canada     -");
		System.out.println("-           -                         -           -");
		System.out.println("-           -                         -           -");
		System.out.println("-           -                         -           -");
		System.out.println("---------------------------------------------------");
		System.out.println("- Italy     -France      -Spain       -USA        -");
		System.out.println("-           -            -            -           -");
		System.out.println("-           -            -            -           -");
		System.out.println("-           -            -            -           -");
		System.out.println("---------------------------------------------------");
	}

	// Method to roll the dice and return the amount of squares the player should move
	public static int rollDice() 
	{
		// create random
		Random random = new Random();
		int total;
		//two separate to create two separate dice rolls
		int dice1 = random.nextInt(6) + 1;
		int dice2 = random.nextInt(6) + 1;
		//Print statements to show how many places a player will move
		System.out.println("\nYou rolled a " + dice1 + " and a " + dice2);
		total = dice1 + dice2;
		System.out.println("\nYou will move " + total + " squares.");
		
		// return the total of both random generators so that we can use it to move the player
		return total;
	}
	
	// Method to process what happens when its a players turn.
	public static void processPlayerTurn(PlayerStats players) 
		{
			//Set up scanner
		Scanner scan= new Scanner(System.in);
		// allow player to roll	
		System.out.println(players.getPlayerName() + " press X to roll");
			yesOrNo = scan.next();
			//game only continues if user presses 'x'.
			while(!(yesOrNo.equalsIgnoreCase("x")))
			{
				System.out.println(players.getPlayerName() + " press X to roll");
				yesOrNo = scan.next();
			}
			
			//retrieve the square the player is currently on. All players strt on '0' or the Start square.
			int currentSquare = players.getPlayerBoardPos();
			// get the value of the dice roll and store it
			int tempRoll = rollDice();
			
			// Show player the result of the dice roll
			System.out.println("Your dice roll is: " + tempRoll);
			// Show where the player was originally.
			System.out.println("Leaving: " + boardSquare.get(currentSquare).getSquareName());
			
			//use updateCurrentSquare to ensure that if a player's roll result plus their current position isn't greater than the number of squares on the board. Once it hits 11 it will start again at 0. player at pos =5 roll=8 newPos=1. 
			int updatedSquare = updateCurrentSquare(currentSquare + tempRoll, players);
			//Show where the player has landed
			System.out.println("You've landed on: " + boardSquare.get(updatedSquare).getSquareName());
			boardSquare.get(updatedSquare).printSquareDetails();
			// update the players position on the board
			players.setPlayerBoardPos(updatedSquare);
			
			// conditional for each square type - land on start collect pointds, rest square do nothing, country square do somethings
			if(boardSquare.get(updatedSquare).getSquareType() == BoardSquareType.START)
			{
				players.addEcoPoints(200);
			}
			else if(boardSquare.get(updatedSquare).getSquareType() == BoardSquareType.REST)
			{
				System.out.println("Resting");
			}
			else if(boardSquare.get(updatedSquare).getSquareType() == BoardSquareType.COUNTRY)
			{		
				//Reminds players which countries they own so that they can decide if they want to buy a country or which country they want to develop
				System.out.println("--------------------------");
				System.out.println("Player: "+players.getPlayerName()+" | Owns: ");
				players.displayOwnedSquares();
				System.out.println("--------------------------");
				// conditional to find if a square is owned, if it is owned who has it and where do the ecopoints go to.
				if(((CountrySquare) boardSquare.get(updatedSquare)).isOwned() && (players.checkOwnedCountry(((CountrySquare) boardSquare.get(updatedSquare)).getCountry()))) 
				{
					//User owns this square, message reminding them off this then follows to reguular options menu
					System.out.println("You already own "+((CountrySquare) boardSquare.get(updatedSquare)).getCountry().toString()+". You don't have to pay any extra to stay here!!");
					squareOptions(players, updatedSquare);
				} 
				else if(((CountrySquare) boardSquare.get(updatedSquare)).isOwned()) 
				{	
					// need to find which player owns this particular country so that the current player can send them the correct amount of money. 
					// cost to land is calculated within the country square class
					for (PlayerStats player : allPlayers )  
					{
						if(player.checkOwnedCountry(((CountrySquare) boardSquare.get(updatedSquare)).getCountry())) 
						{
							player.addEcoPoints(((CountrySquare) boardSquare.get(updatedSquare)).getCostToLand());
							System.out.println(player.getPlayerName()+" owns this square, you give them  "+((CountrySquare) boardSquare.get(updatedSquare)).getCostToLand() + " EcoPoints to land here");
							System.out.println(player.getPlayerName()+" now has: "+player.getECOpoints()+" EcoPoints");
							//removes points from current player
							players.removeEcoPoints(((CountrySquare) boardSquare.get(updatedSquare)).getCostToLand());
							//shows cost to land and eco point deduction
							System.out.println("You have been deducted : "+((CountrySquare) boardSquare.get(updatedSquare)).getCostToLand()+" EcoPoints. You now have: "+players.getECOpoints()+" EcoPoints");
							squareOptions(players, updatedSquare);
						}
					} //for end 
				}
				else 
				{
					// If no one owns, then can follow the below. EcoPoints still removed from user
					players.removeEcoPoints(((CountrySquare) boardSquare.get(updatedSquare)).getCostToLand());
					System.out.println("No one owns "+(((CountrySquare) boardSquare.get(updatedSquare)).getCountry())+", but it still costs to land here. You have been deducted : "+((CountrySquare) boardSquare.get(updatedSquare)).getCostToLand()+" EcoPoints. You now have: "+players.getECOpoints()+" EcoPoints");
					squareOptions(players, updatedSquare);
				}
				
			}	
			//adding to show end of player turn for clarity on console display
			System.out.println("---------------------------");
			System.out.println("        END OF TURN        ");
			System.out.println("---------------------------");
			} 

	// Method to update the current square after dice roll and player moves
	public static int updateCurrentSquare(int currentSquare, PlayerStats player) 
	{
		if(currentSquare > 11)
		{
			// add start square ecoPoints
			System.out.println(">>-------------->>>>-------------->>>>-------------->>>>-------------->>>>-------------->>>>-------------->>");
			System.out.println("     GO GREEN when you GO FLY! - Have 75 EcoPoints to help you on your travels. Fasten your seatbelts!!"     );
			System.out.println(">>-------------->>>>-------------->>>>-------------->>>>-------------->>>>-------------->>>>-------------->>");
			player.addEcoPoints(75);
			
			return currentSquare - 12;
		}
		return currentSquare;
	}
	
	// Method to allow players to buy a square 
	public static void buySquare(CountrySquare cSq, PlayerStats player)  
	{
		Scanner sc = new Scanner(System.in);
		//chrck if user has enough resources
		if(player.getECOpoints()>cSq.getCostToBuy()) 
		{
			// ask player if they wstill wish to buy
			System.out.println("Are you sure you want to buy: "+cSq.getCountry().toString()+" for: "+cSq.getCostToBuy()+"? Y/N");
			yesOrNo = sc.nextLine();
			
			if (yesOrNo.equalsIgnoreCase("y")) 
			{
				// add the square to arralist of countrysquares in playerstats class
				player.addOwnedSquare(cSq);
				//deduct the amount to buy
				player.removeEcoPoints(cSq.getCostToBuy());
				// Country square becomes unavailable to buy
				cSq.setOwned(true);
				//print statements to show updates
				System.out.println("You have bought "+(cSq.getCountry())+". Your EcoPoints are now: "+player.getECOpoints()); 
				
				System.out.println("--------------------------");
				System.out.println("Player: "+player.getPlayerName()+" Now Owns: ");
				System.out.println("        "+cSq.getCountry());
				System.out.println("--------------------------");
				System.out.println("List of "+player.getPlayerName()+"'s owned countries:");
				player.displayOwnedSquares();
			} 
			else 
			{
				System.out.println("Returning to menu");
			}
		} 
		else 
		{
			System.out.println("Insufficient funds to purchase");
		}
	}
	
	/*
	 * Returns Id of user that wants to buy square
	 */
	public static int getUserBuySquare() {
		
		//used to get the player position in the array
		int count=0;
		Scanner sc = new Scanner(System.in);
		// choose which player wants to buy as per requirements
		System.out.println("Select player ID that wishes to buy this country. If no players now want to buy this country please enter '9' to cancel this request!");
		for (PlayerStats player: allPlayers) {
		System.out.println("Player ID: "+count+" Player Name: "+player.getPlayerName());
		count++;
		}
		// cancel to ensure the game does not lock a player out if they do not wish to buy a square after contemplation
		System.out.println("Cancel: 9");
		
		
		String selectFrom = sc.nextLine();
		  // checks that only the amount of players or number 9 can be chosen
		while(!(selectFrom.matches("\\d+") && Integer.parseInt(selectFrom) >= 0 && Integer.parseInt(selectFrom) <= count || Integer.parseInt(selectFrom)==9))
		{
			System.out.println("\nPlease only select within range or 9 to return");
			 selectFrom = sc.nextLine();	 
		}
		
		return Integer.parseInt(selectFrom);
	}
	
	// Method to allow players to sell their square if they own it
	public static void sellSquare(CountrySquare cSq, PlayerStats player)
	{
		Scanner sc = new Scanner(System.in);
		int id;
		
		//check if player owns any countries
		if (player.getOwnedSquares().isEmpty()) 
		{
			System.out.println("No countries to sell");
		}
		else
		{
			// choose which country to sell
			System.out.println("You own these countries. Select ID to sell and hit enter:");
			player.displayOwnedSquares();
			String selectFrom = sc.nextLine();
				  
			//check that they can only enter an ID of a country that exists in their owned country arraylist
			while(!(selectFrom.matches("\\d+") && Integer.parseInt(selectFrom) >= 0 && Integer.parseInt(selectFrom) <= player.getOwnedSquares().size()))
			{
				System.out.println("\nPlease only select within range");
				 selectFrom = sc.nextLine();	 
			}
			
			id = Integer.parseInt(selectFrom);
			//deposit the ecopoints to the user, then remove it from ther owned countries
			player.addEcoPoints(player.getOwnedSquares().get(id).getCostToBuy());
			player.removeOwnedSquare(id);
		}	
	}
	
	// Method to upgrade the square which will only render if the player owns a continent 
	public static void upgradeSquare(CountrySquare cSq, PlayerStats player)
	{
			Scanner scan = new Scanner(System.in);
			int id;
			Boolean done = false;
	
			while(done != true)
			{
				System.out.println("You own these countries. Select country ID to upgrade and hit enter:");
				player.displayOwnedSquaresToDevelop();
				String selectFrom = scan.nextLine();
				  
				while(!(selectFrom.matches("\\d+") && Integer.parseInt(selectFrom) >= 0 && Integer.parseInt(selectFrom) <= player.getOwnedSquares().size()))
				{
					System.out.println("\nPlease only select within range");
					 selectFrom = scan.nextLine();	 
				}
				id = Integer.parseInt(selectFrom);

				//Choose minor or major development
				//can only upgrade major if 3x minor owned 
				System.out.println("To choose minor EcoDevelopment press 'x', to choose major EcoDevelopment press 'y', to exit press 'z' ");
				String minormajor = scan.next();
					
				//if 'x' choose minor
				if (minormajor.equalsIgnoreCase("x")) 
				{
					if(player.getOwnedSquares().get(id).getMinorDevelopmentCount() < 3)
					{
						System.out.println("You have chosen to add a minor EcoEnergy development to " + (player.getOwnedSquares().get(id).getCountry().toString()));
						player.getOwnedSquares().get(id).addMinorDevelopment();
						player.removeEcoPoints(player.getOwnedSquares().get(id).getMinorDevelopmentCost());
						cSq.subtractResource(player, id);
						done = true;
					}
					else
					{
						System.out.println("You cannot add any more minor EcoEnergy developments to " + (player.getOwnedSquares().get(id).getCountry().toString()) );
						System.out.println("Either select it for a major EcoEnergy development or select another country to minor EcoEnergy develop.");
						done = false;
					}
				} 
					
				// if 'y' choose major
				else if (minormajor.equalsIgnoreCase("y")) 
				{
					if((player.getOwnedSquares().get(id).getMajorDevelopmentCount() < 1) && (player.getOwnedSquares().get(id).getMinorDevelopmentCount() == 3) )
					{
						System.out.println("You have chosen to upgrade " + (player.getOwnedSquares().get(id).getCountry().toString()) + " to Nuclear EcoEnergy");
						player.getOwnedSquares().get(id).addMajorDevelopment();
						player.removeEcoPoints(player.getOwnedSquares().get(id).getMajorDevelopmentCost());
						cSq.subtractResource(player, id);
						done = true;
					}
					else if((player.getOwnedSquares().get(id).getMinorDevelopmentCount() < 3)) {
						System.out.println(player.getOwnedSquares().get(id).getCountry().toString() + " cannot be developed! 3 Minor Developments are needed before a Major Development");
						done = false;
					}
					else if (player.getOwnedSquares().get(id).getMajorDevelopmentCount() >= 1) {
						System.out.println(player.getOwnedSquares().get(id).getCountry().toString() + " cannot be developed any further!");
						done = false;

					}
				} else if (minormajor.equalsIgnoreCase("z")) {
					
					done =true;
				}

	
						
					
				
				// entry error - choose again
				else if (!(minormajor.equalsIgnoreCase("x") || minormajor.equalsIgnoreCase("y") || minormajor.equalsIgnoreCase("z"))) 
				{

					System.out.println("\nPlease enter either x, y, or z ");
					minormajor = scan.next();
				}
			}
		}
	
	// Method to keep the game flowing while there has been no winner
	public static void gamePlay(ArrayList<PlayerStats> players)
	{		
		boolean won =false;
		
		// keep looping while the game has not been won
		while(!won) 
		{
			
			//loop through the arraylist of players and give them a turn
			for (PlayerStats player : players) 
			{
				won = checkWinner(players);
				processPlayerTurn(player);
			}
		}
	}
	
	// This should be called at the end of each player turn
	public static boolean checkWinner(ArrayList<PlayerStats> players)
	{		
		boolean won = false;
		// check all players scores to see if anybody has won the game..
		for (PlayerStats player : players) 
		{
			if(player.getECOpoints() >= 1000) 
			{
				won = true;
				endGame(player);
			}		
		}		
		return won;
	}
	
	// Method to end the game only if a player has won
	public static void endGame(PlayerStats player)
	{				
		System.out.println("***********************************************************************************************************");
		System.out.println("                                                                                                           ");
		System.out.println("                       Congratulations " + player.getPlayerName()+ "                                       ");
		System.out.println("             You have Won the Game with a score of: " + player.getECOpoints() + "!                         ");
		System.out.println("                                                                                                           ");
		System.out.println("***********************************************************************************************************");
				
		printBoard();
			try 
			{
				Thread.sleep(10000);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		quitGame();
	}
	
	
	public static int getPlayerId(PlayerStats selectedPlayer) {
		int count=0;
		
		for (PlayerStats player: allPlayers) {
		if(player.getPlayerName().equalsIgnoreCase(selectedPlayer.getPlayerName())) {
			return count;
		}
			count++;
			}
		return 0;
	}
	
	// Method to quit the game, can be called at any time
	public static void quitGame() 
	{	
		System.out.println("Goodbye");
		System.exit(1);
	}
	
	// Method to give players options after landing on squares. 
	//Only the relevant options will be displayed depending on what the player owns
	public static void squareOptions(PlayerStats player, int  updatedSquare) {
		//Remind player of how many eco points they have
		
		System.out.println("You have: "+player.getECOpoints()+" EcoPoints. Spend Wisely...!");
		
		Scanner scan = new Scanner(System.in);
		String getOption = "";
		int option;
	
		if(!checkWinner(allPlayers)) 
		{
			do 
			{
				System.out.println("1. Buy Square");
				System.out.println("2. Sell Square");
				System.out.println("3. Develop Owned Square");
				System.out.println("4. Nothing to do, Move on!");
				System.out.println("5. Quit Game");
				System.out.println("Enter option ...");
				getOption = scan.nextLine();
				System.out.println();
				
				while(!(getOption.matches("\\d+") && (Integer.parseInt(getOption)  >=1 && Integer.parseInt(getOption) <= 5)))
				{
					System.out.println("\nPlease only select between: 1 - 5");
					getOption = scan.nextLine();	
				}
				
				option = Integer.parseInt(getOption);
				
				switch (option) 
				{
					case 1:
						option = 1;
						if(((CountrySquare) boardSquare.get(updatedSquare)).isOwned()) 
						{
							System.out.println("This country has already been bought!");
						}
						else 	
						{
							int playerToBuy = getUserBuySquare();
							if(playerToBuy == 9) {
								
							} else if(playerToBuy == getPlayerId(player)) {
								buySquare((CountrySquare) boardSquare.get(updatedSquare), player);
								 option = 4;
							} else {
								buySquare((CountrySquare) boardSquare.get(updatedSquare), allPlayers.get(playerToBuy));
								System.out.println(player.getPlayerName()+" You can still choose to develop owned square, or move on");
							}
							 
						}		
					break;
					case 2:
						option = 2;
						if((player.ownedSquares.contains((CountrySquare) boardSquare.get(updatedSquare)))) 
						{
							sellSquare((CountrySquare) boardSquare.get(updatedSquare), player);
							option = 4;
						}
						else 
						{
							System.out.println("You need to own this country before you can sell!");
						}	
					break;
					case 3: 
						option = 3;
						if(player.canDevelop()) 
						{ 
							upgradeSquare((CountrySquare) boardSquare.get(updatedSquare), player);
							option = 4;
						}
						else 
						{
							System.out.println("You need to own all countries in a continent before you can upgrade!");
						}
					break;
					case 4:
						System.out.println("Moving on.....");
						option = 4;
						break;
					case 5:
						quitGame();
						break;
					default:
						System.out.println("Try options again...");
				}
			} 
			while (option != 4);
		} 
	}	
}// end of class
