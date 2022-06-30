package softwareEngineering;

public class StartSquare extends BoardSquare implements DisplaySquare, AddResources {

	
	
	
	// in our game we will ony have one start square, but to extend there may be multiple start squares

	
	private String startDescription;
	private String startName;
	
	private int ecoPoints;
	
	
	
	
	
	
	public StartSquare(String startName, int ecoPoints) {
		super(BoardSquareType.START, startName);
		setEcoPoints(ecoPoints);
	}
	
	/**
	 * @return the startDescription
	 */
	public String getStartDescription() {
		return startDescription;
	}

	/**
	 * @param startDescription the startDescription to set
	 */
	public void setStartDescription(String startDescription) {
		this.startDescription = startDescription;
	}

	/**
	 * @return the startName
	 */
	public String getStartName() {
		return startName;
	}

	/**
	 * @param startName the startName to set
	 */
	public void setStartName(String startName) {
		this.startName = startName;
	}

	/**
	 * @param ecoPoints the ecoPoints to set
	 */
	public void setEcoPoints(int ecoPoints) {
		this.ecoPoints = ecoPoints;
	}
	
	public int getEcoPoints() {
		return ecoPoints;
	}


	

	@Override
	public void printSquareDetails() {
		// TODO Auto-generated method stub
		System.out.println("***********");
		System.out.println(super.getSquareType()+ " SQUARE");
		System.out.println(super.getSquareName());
		
		System.out.println("Add "+getEcoPoints()+" to player");
		System.out.println("************");
		
		
		
	}



	@Override
	public void addResources(PlayerStats player, int ecoPoints) {
		
		player.addEcoPoints(ecoPoints);
		
	}





}
