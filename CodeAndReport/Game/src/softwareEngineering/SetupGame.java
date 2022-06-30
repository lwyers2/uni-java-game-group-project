package softwareEngineering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SetupGame 
{
	static boolean characterCheck = false;
	
	public SetupGame()
	{

	}
	
	public int setUpPlayerAmount() 
	{
		int playerAmount;
		Scanner scan = new Scanner(System.in);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("------------------------------   Welcome to the ECO-game!   ------------------------------");
		System.out.println("-------                                                                            -------");
		System.out.println("            This is a game where global travel can change the environment.                ");
		System.out.println("                              Players, as 'Green Energy Ambassadors'                      ");
		System.out.println("     must race against each other across four continents, comprising ten countries,       ");
		System.out.println("                                  to collect Eco Points                                   ");
		System.out.println("                    by upgrading their chosen countries to green energy.                  ");
		System.out.println("      The carbon neutral trailblazer who gains 1000 Eco Points first, wins the game!      ");
		System.out.println("                                                                                          ");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Let's get started ....");
		System.out.println();
		System.out.println("So tell me... how many players are there today?");
		System.out.println("Select a player amount ranging from, and including 2 - 4:");
		
		String players = scan.nextLine();	  
		String yesOrNo = "";
		
		while(!(players.matches("\\d+") && (Integer.parseInt(players) >= 2 && Integer.parseInt(players) <= 4)))
		{
			System.out.println("\nPlease only press numbers in the range of 2 - 4");
			 players = scan.nextLine();	 
		}
		 
		playerAmount = Integer.parseInt(players);
		System.out.println("\nAre you sure the amount of players is: " + playerAmount);
		System.out.println("Y or N?");
		yesOrNo = scan.next();
		
		while(!(yesOrNo.equalsIgnoreCase("y") || yesOrNo.equalsIgnoreCase("n")))
		{
			System.out.println("\nPlease enter either Y or N ");
			yesOrNo = scan.next();
		}
		
		if(yesOrNo.equalsIgnoreCase("n"))
		{
			System.out.println("Please try running the game again for now.");
		}
		return playerAmount;
	}
	
	
	public ArrayList<PlayerStats> playerSetup(int setPlayerAmount)
	{
		Scanner scanPlayer = new Scanner(System.in);
		
		//Add 1 to this value so the array doesn't start at 0 just so that when or if it gets displayed the game doesn't say Player 0
		int playerAmount = setPlayerAmount + 1;
		ArrayList<PlayerStats> allPlayers= new ArrayList<PlayerStats>(playerAmount);
		
		for(int x = 1; x < playerAmount; x++)
		{
			System.out.printf("\nPlayer " + x + " please enter your player name: ");
			System.out.println("(Please only use letters)");
			String name = scanPlayer.nextLine();
			getValidCharacters(name);
			System.out.println();
			
			while(characterCheck != true)
			{
				System.out.println("Please use only letters: ");
				name = scanPlayer.nextLine();
				getValidCharacters(name);
				System.out.println();
			}
			
			PlayerStats newPlayer = new PlayerStats(name, 500);
			allPlayers.add(newPlayer);
		}
		
		Collections.shuffle(allPlayers);
		
		//Runs the printDetails in the OOP thing
				for(PlayerStats player : allPlayers) 
				{
					player.printDetails();
				}
		return allPlayers;	
	}
	
	public static boolean getValidCharacters(String input) 
	{
		//Checks the name entered is longer than 1 character
		if (input.length() <= 1) 
		{
			characterCheck = false;
			return characterCheck;
		}
		
		//checks there's no space at the start
		if (input.charAt(0) == ' ') 
		{
			characterCheck = false;
			return characterCheck;
		}
		
		// check string is only letters and spaces
		String validChars = "abcdefghijklmnopqrstuvwxyz ";
		String lower = input.toLowerCase();
		
		for (int i = 0; i < input.length(); i++) 
		{
			if(lower.matches("\\d+")) 
			{
				characterCheck = false;
				return characterCheck;
			}
			else if (validChars.indexOf(lower.charAt(i)) == -1) 
			{
				characterCheck = false;
				return characterCheck;
			}
		}
		characterCheck = true;
		return characterCheck;
	}
	
}
