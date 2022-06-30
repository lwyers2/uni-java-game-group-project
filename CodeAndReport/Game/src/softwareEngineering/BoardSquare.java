/**
 * 
 */
package softwareEngineering;

/**
 * @author luke
 * Make it abstract - can only instantiate a square with a defined type
 *
 */
public abstract class BoardSquare  implements DisplaySquare{
	
	private BoardSquareType squareType;
	private String squareName;
	
	
	
	
	
	

	public BoardSquare() {
		
	}
	
	

	public BoardSquare(BoardSquareType squareType, String squareName) {
			this.squareType = squareType;
			this.setSquareName(squareName);
	
	}

	public BoardSquareType getSquareType() {
		return squareType;
	}

	public void setSquareType(BoardSquareType squareType) {
		this.squareType = squareType;
	}



	public String getSquareName() {
		return squareName;
	}



	public void setSquareName(String squareName) {
		this.squareName = squareName;
	}


	
	



	public void printSquareDetails() {
		
	}

	
	

	
	

}
