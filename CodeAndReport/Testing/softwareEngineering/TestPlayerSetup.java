package softwareEngineering;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlayerSetup 
{
	int playerAmount, ECOpoints;
	String validName, invalidNameSpace, invalidNameBlank;
	public ArrayList<PlayerStats> playerSetup;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		ECOpoints = 500;
		validName = "TestUser";
	}

	//Test the constructor with the data from void setUp()
	@Test
	public void testPlayerConstructorArgs()
	{
		PlayerStats playerSetup = new PlayerStats(validName, ECOpoints);
		
		assertEquals(validName, playerSetup.getPlayerName());
		assertEquals(ECOpoints, playerSetup.getECOpoints());
	}
	
	//Test that the name being entered is matching the same name in void setUp()
	@Test
	void testSetValidName() 
	{
		PlayerStats playerSetup = new PlayerStats();
		playerSetup.setPlayerName(validName);
		assertEquals(validName, playerSetup.getPlayerName());
	}
	
	//Test that the name being entered is matching the same name in void setUp()
	@Test
	void testSetECOpoints() 
	{
		PlayerStats playerSetup = new PlayerStats();
		playerSetup.setECOpoints(ECOpoints);
		assertEquals(ECOpoints, playerSetup.getECOpoints());
	}
	
	//Test that both sets of data return true
	@Test
	void testName() 
	{
		PlayerStats playerSetup = new PlayerStats(validName, ECOpoints);
		assertEquals("TestUser", validName);
		assertEquals(500, ECOpoints);
	}
}
