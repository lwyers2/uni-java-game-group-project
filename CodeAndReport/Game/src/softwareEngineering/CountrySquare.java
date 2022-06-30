package softwareEngineering;

/**
 * @author luke
 *
 */
public class CountrySquare extends BoardSquare implements DisplaySquare, AddResources, SubtractResource 
{
	private Continents continent;
	private Countries country;
	private int costToLand;
	private int costToBuy;
	private int minorDevelopmentCost;
	private int majorDevelopmentCost;
	private String countryDescription;
	private boolean isOwned; 
	private int minorDevelopmentCount;
	private int majorDevelopmentCount;
	
	/**
	 * @param country
	 * @param squareDescription
	 */
	public CountrySquare(Countries country) 
	{
		super(BoardSquareType.COUNTRY, country.toString());
	}
	
	/**
	 * @param continent
	 * @param country
	 * @param costToLand
	 * @param costToBuy
	 * @param minorDevelopmentCost
	 * @param majorDevelopmentCost
	 */
	public CountrySquare(Continents continent, Countries country, int costToLand, int costToBuy,
			int minorDevelopmentCost, int majorDevelopmentCost) 
	{
		//Creates the information for boardsquare with type as country and name being the country
		super(BoardSquareType.COUNTRY, country.toString());
		this.continent = continent;
		this.country = country;
		this.costToLand = costToLand;
		this.costToBuy = costToBuy;
		this.minorDevelopmentCost = minorDevelopmentCost;
		this.majorDevelopmentCost = majorDevelopmentCost;
		this.setMinorDevelopmentCount(0);
		this.setMajorDevelopmentCount(0);
		this.setOwned(false);
	}

	/**
	 * @return the continent
	 */
	public Continents getContinent() 
	{
		return continent;
	}

	/**
	 * @param continent the continent to set
	 */
	public void setContinent(Continents continent) 
	{
		this.continent = continent;
	}

	/**
	 * @return the country
	 */
	public Countries getCountry() 
	{
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Countries country) 
	{
		this.country = country;
	}

	/**
	 * @return the costToLand
	 */
	public int getCostToLand() 
	{
		if (this.getMajorDevelopmentCount()==1) 
		{
			return costToLand * 3;
		} 
		else if(this.getMinorDevelopmentCount()==1) 
		{
			return (int) (costToLand * 1.5);
		} 
		else if (this.getMinorDevelopmentCount()==2) 
		{
			return costToLand * 2;
		}
		else if (this.getMinorDevelopmentCount()==3) 
		{
			return (int) (costToLand * 2.5);
		} 
		else 
		{
			return costToLand;
		}
	}

	/**
	 * @param costToLand the costToLand to set
	 */
	public void setCostToLand(int costToLand) 
	{
		this.costToLand = costToLand;
	}

	/**
	 * @return the costToBuy
	 */
	public int getCostToBuy()
	{
		return costToBuy;
	}

	/**
	 * @param costToBuy the costToBuy to set
	 */
	public void setCostToBuy(int costToBuy) 
	{
		this.costToBuy = costToBuy;
	}

	/**
	 * @return the minorDevelopmentCost
	 */
	public int getMinorDevelopmentCost() 
	{
		return minorDevelopmentCost;
	}

	/**
	 * @param minorDevelopmentCost the minorDevelopmentCost to set
	 */
	public void setMinorDevelopmentCost(int minorDevelopmentCost) 
	{
		this.minorDevelopmentCost = minorDevelopmentCost;
	}

	/**
	 * @return the majorDevelopmentCost
	 */
	public int getMajorDevelopmentCost() 
	{
		return majorDevelopmentCost;
	}

	/**
	 * @param majorDevelopmentCost the majorDevelopmentCost to set
	 */
	public void setMajorDevelopmentCost(int majorDevelopmentCost) 
	{
		this.majorDevelopmentCost = majorDevelopmentCost;
	}

	/**
	 * @return the countryDescription
	 */
	public String getCountryDescription() 
	{
		return countryDescription;
	}

	/**
	 * @param countryDescription the countryDescription to set
	 */
	public void setCountryDescription(String countryDescription) 
	{
		this.countryDescription = countryDescription;
	}
	
	//This will need formatted. Need to decide on a format for displaying to console
	@Override
	public void printSquareDetails() {
		// TODO Auto-generated method stub
		System.out.println("                                                   ");
		System.out.println("***************************************************");
		System.out.println("     --- "+super.getSquareType()+" SQUARE ---      ");
		System.out.println("             "+getContinent()+"                    ");
		System.out.println("             "+super.getSquareName()+"             ");
		System.out.println("    Cost to land on: "+getCostToLand());
		System.out.println("    Cost to buy: "+getCostToBuy());
		System.out.println("    Cost to upgrade minor EcoEnergy: "+getMinorDevelopmentCost());
		System.out.println("    Cost to upgrade major EcoEnergy: "+getMajorDevelopmentCost());
		System.out.println("---------------------------------------------------");
		System.out.println("   Minor Developments: "+getMinorDevelopmentCount()+" | Major Developments: "+getMajorDevelopmentCount());
		System.out.println("---------------------------------------------------");
		System.out.println("                                                   ");
		System.out.println("***************************************************");	
	}

	@Override
	public void subtractResource(PlayerStats player, int ecoPoints) 
	{
		player.removeEcoPoints(ecoPoints);
	}

	@Override
	public void addResources(PlayerStats player, int ecoPoints) 
	{
		player.addEcoPoints(ecoPoints);	
	}

	public boolean isOwned() 
	{
		return isOwned;
	}

	public void setOwned(boolean isOwned) 
	{
		this.isOwned = isOwned;
	}
	
	/*
	 * private as its not necessary for this to be accessed in main game
	 */
	public int getMinorDevelopmentCount() 
	{
		return minorDevelopmentCount;
	}

	/*
	 * private as its not necessary for this to be accessed in main game
	 */
	public void setMinorDevelopmentCount(int minorDevelopmentCount) 
	{
		this.minorDevelopmentCount = minorDevelopmentCount;
	}


	/*
	 * private as its not necessary for this to be accessed in main game
	 */
	public int getMajorDevelopmentCount() 
	{
		return majorDevelopmentCount;
	}


	/*
	 * private as its not necessary for this to be accessed in main game
	 */
	public void setMajorDevelopmentCount(int majorDevelopmentCount) 
	{
		this.majorDevelopmentCount = majorDevelopmentCount;
	}


	/*
	 * Updates minor dev count +1 and removes ecopoints from user
	 */
	public void addMinorDevelopment()
	{	
		this.minorDevelopmentCount++;
	}
			
	/*
	 * Updates major dev count +1 and removes ecopoints from user
	 */
	public void addMajorDevelopment() 
	{
		this.majorDevelopmentCount++;
	}
}
