package softwareEngineering;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCharacterChecker 
{
	String validName, invalidNameSpace, invalidNameNumber, invalidNameBlank;
	Boolean trueFalse;

	@BeforeEach
	void setUp() throws Exception 
	{
		validName = "TestUser";
		invalidNameSpace = " SpaceUser";
		invalidNameNumber = "123";
		invalidNameBlank = "";
	}

	//If a valid username is entered it will match true
	@Test
	public void getValidCharacters()
	{
		SetupGame.getValidCharacters(validName);
		assertEquals(true, SetupGame.characterCheck);
	}

	//If a invalid username with a space as it's first character is entered it will match false
	@Test
	public void getinValidCharactersSpace()
	{
		SetupGame.getValidCharacters(invalidNameSpace);
		assertEquals(false, SetupGame.characterCheck);
	}
	
	//If a invalid username is entered as numbers it will match false
	@Test
	public void getinValidCharactersNumber()
	{
		SetupGame.getValidCharacters(invalidNameNumber);
		assertEquals(false, SetupGame.characterCheck);
	}
	
	//If a username is left blank it will match false
		@Test
		public void getinValidCharactersBlank()
		{
			SetupGame.getValidCharacters(invalidNameBlank);
			assertEquals(false, SetupGame.characterCheck);
		}
}

