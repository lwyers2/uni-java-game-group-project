/**
 * 
 */
package softwareEngineering;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * @author 
 *
 *
 */
class TestSetupPlayerAmount {

	//test data	
	int validPlayerAmount2, validPlayerAmount3, validPlayerAmount4;
	int invalidPlayerAmountLow, invalidPlayerAmountHigh;
	String validPlayersLow, validPlayersMid,validPlayersHigh;
	String invalidPlayersLow, invalidPlayersMid,invalidPlayersHigh;
	String invalidAmountWhitespace;
	String invalidAmountChars;
	SetupGame setupgame;
		
		
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	validPlayerAmount2=2;
	validPlayerAmount3=3;
	validPlayerAmount4=4;
	validPlayersLow="2";
	invalidPlayersLow="1";
	invalidPlayerAmountLow=1;
	invalidPlayerAmountHigh=5;
	invalidAmountChars="!�$%^&*(),.<>?/|_+";
	invalidAmountWhitespace="  ";
	new SetupGame();	

	}

	@Test
	void testPlayerAmountValid2() {
		
		int expected = 2;
		int actual;
		SetupGame setupgame = new SetupGame();
		actual = setupgame.setUpPlayerAmount();
		assertEquals(expected, actual);
		
		
	}
	
	
	
	@Test
	void testInvalidPlayerAmountLow() {
		
		int expected = 2;
		int actual;
		SetupGame setupgame = new SetupGame();
		actual = setupgame.setUpPlayerAmount();
		assertEquals(expected, actual);
		
		
	}
	
}
	
//	@Test
//	void invalidPlayersLow() {
//		//Unhappy Path test each arg of constructor in turn to ensure exception thrown as expected
//		//verifies that constructor actually linked to setters, not just setting directly
//
//		assertThrows(IllegalArgumentException.class, () -> {
//			new TopTrumpCard(invalidStringLow, validStringMid, validFilename, Category.VILLAIN, validStatMid,
//					validStatMid, validStatMid, validStatMid, validStringMid);
//		});
//
//}
