package softwareEngineering;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author garys
 *
 */
public class Board 
{
	private int totalSquares;
	private int totalPlayers;
	private ArrayList<BoardSquare> squares;
	
	public Board() 
	{
	
	}
	
	public Board(int totalSquares, int totalPlayers, ArrayList<BoardSquare> squares) 
	{
		this.totalSquares = totalSquares;
		this.totalPlayers = totalPlayers;
		this.squares= squares;
	}


	public int getTotalSquares() 
	{
		return totalSquares;
	}

	public void setTotalSquares(int totalSquares) 
	{
		this.totalSquares = totalSquares;
	}

	public int getTotalPlayers() 
	{
		return totalPlayers;
	}

	public void setTotalPlayers(int totalPlayers) 
	{
		this.totalPlayers = totalPlayers;
	}

	/**
	 * @return the squares
	 */
	public ArrayList<BoardSquare> getSquares() 
	{
		return squares;
	}

	/**
	 * @param squares the squares to set
	 */
	public void setSquares(ArrayList<BoardSquare> squares) 
	{
		this.squares = squares;
	}

	public void printDetails()
	{
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("Total Squares = " + totalSquares +"!");
		System.out.println("Total Players = " + totalPlayers);
		System.out.println("Selected cards = " + squares);
		System.out.println("-------------------------------------------------------------");
	}
	

	public ArrayList<BoardSquare> createBoardSquares() 
	{
		
			// Arraylist to hold all squares
			ArrayList<BoardSquare> allSquares = new ArrayList<BoardSquare>();
			
			// Create squares
			StartSquare strSq = new StartSquare("Beginning Journey", 250);
			allSquares.add(strSq);
			RestSquare rstSqr = new RestSquare("Airport Lounge");
			allSquares.add(rstSqr);
			
			CountrySquare burSqr = new CountrySquare(Continents.AFRICA, Countries.BURUNDI, 5, 50, 5, 10);
			allSquares.add(burSqr);
			CountrySquare madSqr = new CountrySquare(Continents.AFRICA, Countries.MADAGASCAR, 7, 75, 7, 12);
			allSquares.add(madSqr);
			CountrySquare canSqr = new CountrySquare(Continents.AMERICAS, Countries.CANADA, 10, 100, 10, 20);
			allSquares.add(canSqr);
			CountrySquare usaSqr = new CountrySquare(Continents.AMERICAS, Countries.USA, 14, 135, 14, 28);
			allSquares.add(usaSqr);
			CountrySquare argSqr = new CountrySquare(Continents.AMERICAS, Countries.ARGENTINA, 13, 125,13, 26);
			allSquares.add(argSqr);
			CountrySquare fraSqr = new CountrySquare(Continents.EUROPE, Countries.FRANCE, 11, 110, 11, 22);
			allSquares.add(fraSqr);
			CountrySquare spaSqr = new CountrySquare(Continents.EUROPE, Countries.SPAIN, 14, 135, 14, 28);
			allSquares.add(spaSqr);
			CountrySquare itaSqr = new CountrySquare(Continents.EUROPE, Countries.ITALY, 16, 115, 16, 32);
			allSquares.add(itaSqr);
			CountrySquare japSqr = new CountrySquare(Continents.ASIA, Countries.JAPAN, 20, 200, 20, 40);
			allSquares.add(japSqr);
			CountrySquare chiSqr = new CountrySquare(Continents.ASIA, Countries.CHINA, 25, 250, 25, 50);
			allSquares.add(chiSqr);
			
			if(allSquares.size() > 5 && allSquares.size() <= 12) {	
				
				return allSquares;	
				
			}else {
			throw new IllegalArgumentException("You must select a board size between 6-12!");
			}
		
		
	}
}
