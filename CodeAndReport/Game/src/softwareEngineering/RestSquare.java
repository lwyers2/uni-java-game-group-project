/**
 * 
 */
package softwareEngineering;

/**
 * @author luke
 *
 */
public class RestSquare extends BoardSquare implements DisplaySquare {

	
	// in our game we will ony have one rest square, but to extend there may be multiple rest squares

	
	private String restDescription;
	private String restName;
	




	/**
	 * @param squareType
	 * @param squareName
	 * @param squareDescription
	 */
	public RestSquare(String squareName) {
		super(BoardSquareType.REST, squareName);
		// TODO Auto-generated constructor stub
	}








	/**
	 * @return the restDescription
	 */
	public String getRestDescription() {
		return restDescription;
	}




	/**
	 * @param restDescription the restDescription to set
	 */
	public void setRestDescription(String restDescription) {
		this.restDescription = restDescription;
	}




	/**
	 * @return the restName
	 */
	public String getRestName() {
		return restName;
	}




	/**
	 * @param restName the restName to set
	 */
	public void setRestName(String restName) {
		this.restName = restName;
	}




	@Override
	public void printSquareDetails() {
		System.out.println("***********");
		System.out.println(super.getSquareType() +" SQUARE");
		System.out.println(super.getSquareName());
		System.out.println("Nothing to do here, take a break!!");
		
		System.out.println("************");		
	}

}
