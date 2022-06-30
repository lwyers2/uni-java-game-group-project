/**
 * 
 */
package softwareEngineering;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author garys
 *
 */
class BoardTest {

	// Test Data 
	int totalValid;
	int totalInvalid;
	private ArrayList<BoardSquare> squares;
	Board b1;
	Board b3;
	Board b4;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpValid() throws Exception {
		
		totalValid = 2;
		totalInvalid = 50;
		squares = new ArrayList<>();
		b1 = new Board();
	}

	

	/**
	 * To test the expected values from the create board square method
	 * s
	 * Test method for {@link softwareEngineering.Board#setTotalPlayers(int)}.
	 */
	@Test
	void createBoardSquaresTestValid() {
	
		// create board squares method test that should return an array list of board squares which should be of size 12
		
		int expected = 12;
		int actual = b1.createBoardSquares().size();
		squares = b1.createBoardSquares();
		
		String squareOneName = "Beginning Journey";
		
		Countries lastSquareName = Countries.CHINA;
		
		assertEquals(expected, actual);
		assertEquals(squareOneName, squares.get(0).getSquareName());
		assertEquals(lastSquareName, Countries.valueOf(squares.get(11).getSquareName()));
			
	}

	/**
	 * To test invalid values for the create board square method
	 * 
	 * Test method for {@link softwareEngineering.Board#setTotalPlayers(int)}.
	 */
	@Test
	void createBoardSquaresTestInvalid() {
	
	// Testing that the array size should only be set at 12.
		int invalidSizeUpper = 13;
		int invalidSizeMid = 6;
		int invalidSizeLow = 0;
		
		int actual = b1.createBoardSquares().size();
		
		assertNotEquals(invalidSizeUpper, actual);
		assertNotEquals(invalidSizeMid, actual);
		assertNotEquals(invalidSizeLow, actual);

	}
	

}

