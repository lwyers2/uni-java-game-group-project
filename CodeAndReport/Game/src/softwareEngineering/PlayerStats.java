package softwareEngineering;

import java.util.ArrayList;
import java.util.Random;

public class PlayerStats 
{
	private String playerName;
	private int ECOpoints;
	private int playerBoardPos;
	public ArrayList<CountrySquare> ownedSquares;
	
	
	public PlayerStats(){
		this.setPlayerBoardPos(0);
		this.ownedSquares = new ArrayList<CountrySquare>();
	}
	
	public PlayerStats(String playerName, int eCOpoints) 
	{
		this.playerName = playerName;
		this.ECOpoints = eCOpoints;
		this.setPlayerBoardPos(0);
		this.ownedSquares = new ArrayList<CountrySquare>();
		
		
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}

	public int getECOpoints() 
	{
		return ECOpoints;
	}

	public void setECOpoints(int eCOpoints) 
	{
		ECOpoints = eCOpoints;
	}


	public void printDetails()
	{
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("Player Name = " + playerName +"!");
		System.out.println("Your starting ECO points are = " + ECOpoints);
		System.out.println("-------------------------------------------------------------");
	}	
	
	public void addEcoPoints(int ecoPoints) {
		//set the ecopoints to new value of added eco points
		setECOpoints(this.ECOpoints+ecoPoints);
	}
	
	public void removeEcoPoints(int ecoPoints) {
		
		//remove points from user
		setECOpoints(this.ECOpoints-ecoPoints);
	}
	
	
	// Method to roll the dice and return the amount of squares the player should move
		public  int rollDice() {
			
			Random random = new Random();
			int total;
			int dice1 = random.nextInt(6) + 1;
			int dice2 = random.nextInt(6) + 1;
			
			System.out.println("\nYou rolled a " + dice1 + " and a " + dice2);
			total = dice1 + dice2;
			System.out.println("\nYou will move " + total + " squares.");
			
			// return the total so that we can use it to move the player
			return total;
			
		}

	
	public void addOwnedSquare(CountrySquare country) {
		
		this.ownedSquares.add(country);
		
	}
	
	public boolean hasOwnedSquare(Countries country) {
		
		for(CountrySquare owned: this.ownedSquares ) {
			if (owned.getCountry() == country) {
				return true;
			}
			
		}
return false;
	}

	
	public void removeOwnedSquare(int position) {
		System.out.println("Selling..... "+this.ownedSquares.get(position).getCountry().toString());
		this.ownedSquares.remove(position);
	}

	/**
	 * @return the playerBoardPos
	 */
	public int getPlayerBoardPos() {
		return playerBoardPos;
	}

	/**
	 * @param playerBoardPos the playerBoardPos to set
	 */
	public void setPlayerBoardPos(int playerBoardPos) {
		this.playerBoardPos = playerBoardPos;
	}

	/**
	 * @return the ownedSquares
	 */
	public ArrayList<CountrySquare> getOwnedSquares() {
		return ownedSquares;
	}
	
	/*
	 * Loops through owned squares and displays country name
	 */
	public void displayOwnedSquares() {
		int id=0;
		for (CountrySquare owned : this.ownedSquares) {
			
			System.out.println("ID: "+id+" Country Name: "+owned.getCountry().toString());
		id++;
		}
	}
	
	
	/*
	 * Checks if a user owns a specific country
	 */
	public boolean checkOwnedCountry(Countries country) {
		
		for(CountrySquare owned : this.ownedSquares) {
			if (owned.getCountry()==country) {
				return true;
			}
		}
		return false;
		
	}
	
	
	// Checks if a player owns all countries in a continent checks all 
	public boolean ownsAllInContinent(Continents continent) {
		
		int afrCount=0;
		int ameCount=0; 
		int eurCount=0; 
		int asiCount=0;
				
		
		if (continent == Continents.AFRICA) {
			for (CountrySquare owned : this.ownedSquares) {
				if (owned.getContinent() == Continents.AFRICA) {
					afrCount++;
				}
			}
			
			if(afrCount==2) {
				return true;
			} 
				return false;
			
			
		} else if (continent == Continents.AMERICAS) {
			for (CountrySquare owned : this.ownedSquares) {
				if (owned.getContinent() == Continents.AMERICAS) {
					ameCount++;
				}
			}
			
			if(ameCount==3) {
				return true;
			} 
				return false;
			
			
		} else if (continent == Continents.EUROPE) {
			for (CountrySquare owned : this.ownedSquares) {
				if (owned.getContinent() == Continents.EUROPE) {
					eurCount++;
				}
			}
			
			if(eurCount==3) {
				return true;
			} 
				return false;
			
			
		} else if (continent == Continents.ASIA) {
			for (CountrySquare owned : this.ownedSquares) {
				if (owned.getContinent() == Continents.ASIA) {
					asiCount++;
				}
			}
			
			if(asiCount==2) {
				return true;
			} 
				return false;
			
			
		} else {
			return false;
		}
	}
	
	/*
	 * This will check all continents to allow for the menu to display OwnsallInContienent will only display true/false for specific country
	 */
	public boolean canDevelop() {
		if (ownsAllInContinent(Continents.ASIA)) {
			return true;	
		} else if (ownsAllInContinent(Continents.EUROPE)) {
			return true;	
		} else if (ownsAllInContinent(Continents.AFRICA)) {
			return true;	
		} else if (ownsAllInContinent(Continents.AMERICAS)) {
			return true;	
		} else {
			return false;
		}
		
	}
	
	
	/*
	 * Loops through owned squares and displays country name
	 */
	public void displayOwnedSquaresToDevelop() {
		int id=0;
		for (CountrySquare owned : this.ownedSquares) {
			if(ownsAllInContinent(owned.getContinent())) {
				System.out.println("ID: "+id+" Country Name: "+owned.getCountry().toString()+" Min Dev: "+owned.getMinorDevelopmentCount()+" Maj Dev: "+owned.getMajorDevelopmentCount());
			}

			id++;
		}
	}
	
	
	
	
	
}// end of class
