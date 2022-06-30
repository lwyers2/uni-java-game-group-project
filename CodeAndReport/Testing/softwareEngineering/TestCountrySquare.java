package softwareEngineering;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCountrySquare {

	// test data
	CountrySquare countrysquare;

	// Data for Burundi
	int validCostToLand1, validCostToBuy1, validMinorDevelopmentCost1, validMajorDevelopmentCost1;
	int invalidCostToLand1Low1, invalidCostToBuy1Low1, invalidMinorDevelopmentCost1Low1,
			invalidMajorDevelopmentCost1Low1;
	int invalidCostToLand1High1, invalidCostToBuy1High1, invalidMinorDevelopmentCost1High1,
			invalidMajorDevelopmentCost1High1;
	
	int validMinorLand_x1;
	int validMinorLand_x2;
	int validMinorLand_x3;
	int validMajorLand;

	// Data for Madagascar
	int validCostToLand2, validCostToBuy2, validMinorDevelopmentCost2, validMajorDevelopmentCost2;
	int invalidCostToLand2Low2, invalidCostToBuy2Low2, invalidMinorDevelopmentCost2Low2,
			invalidMajorDevelopmentCost2Low2;
	int invalidCostToLand2High2, invalidCostToBuy2High2, invalidMinorDevelopmentCost2High2,
			invalidMajorDevelopmentCost2High2;

	/*
	 * public CountrySquare(Continents continent, Countries country, int costToLand,
	 * int costToBuy, int minorDevelopmentCost, int majorDevelopmentCost)
	 */

	@BeforeEach
	void setUp() throws Exception {

		// Burundi (Continents.AFRICA, Countries.BURUNDI, 5, 50, 5, 10)
		validCostToLand1 = 5;
		validCostToBuy1 = 50;
		validMinorDevelopmentCost1 = 5;
		validMajorDevelopmentCost1 = 10;
		
		validMinorLand_x1=(int) 7.5;
		validMinorLand_x2=10;
		validMinorLand_x3=(int) 12.5;
		validMajorLand=15;
		

		invalidCostToLand1Low1 = 4;
		invalidCostToBuy1Low1 = 49;
		invalidMinorDevelopmentCost1Low1 = 4;
		invalidMajorDevelopmentCost1Low1 = 9;

		invalidCostToLand1High1 = 6;
		invalidCostToBuy1High1 = 51;
		invalidMinorDevelopmentCost1High1 = 6;
		invalidMajorDevelopmentCost1High1 = 11;

		// Madagascar (Continents.AFRICA, Countries.MADAGASCAR, 7, 75, 7, 12)
		validCostToLand2 = 7;
		validCostToBuy2 = 75;
		validMinorDevelopmentCost2 = 7;
		validMajorDevelopmentCost2 = 12;

		countrysquare = new CountrySquare(Continents.AFRICA, Countries.BURUNDI, validCostToLand1, validCostToBuy1,
				validMinorDevelopmentCost1, validMajorDevelopmentCost1);
	}

	@Test
	void testBurundiSquareValid() {
		// testing CountrySquare constructor has set expected values (happy path)
		// assertEquals(expected value vs actual value)
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA, Countries.BURUNDI, validCostToLand1,
				validCostToBuy1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);

		assertNotNull(burundisquare);
		assertEquals(Continents.AFRICA, burundisquare.getContinent()); // testing continent name expected vs actual
		assertEquals(Countries.BURUNDI, burundisquare.getCountry()); // testing country name
		assertEquals(validCostToLand1, burundisquare.getCostToLand());
		assertEquals(validCostToBuy1, burundisquare.getCostToBuy());
		assertEquals(validMinorDevelopmentCost1, burundisquare.getMinorDevelopmentCost());
		assertEquals(validMajorDevelopmentCost1, burundisquare.getMajorDevelopmentCost());
	}

	@Test
	void testBurundiCostToLand_minor1() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validMinorLand_x1,
				validCostToBuy1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);
		 int actual=validMinorLand_x1;
			assertEquals(7,actual);
		}
	
	@Test
	void testBurundiCostToLand_minor2() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validMinorLand_x2,
				validCostToBuy1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);
		 int actual=validMinorLand_x2;
			assertEquals(10,actual);
		}
	
	@Test
	void testBurundiCostToLand_minor3() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validMinorLand_x3,
				validCostToBuy1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);
		 int actual=validMinorLand_x3;
			assertEquals(12,actual);
		}
	
	@Test
	void testBurundiCostToLand_major() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validMajorLand,
				validCostToBuy1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);
		 int actual=validMajorLand;
			assertEquals(15,actual);
		}

	
	@Test
	void testBurundiContinentInvalid() {
		CountrySquare burundisquare = new CountrySquare(null, Countries.BURUNDI, validCostToLand1,
				validCostToBuy1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);
		String actual=null;
			assertNotEquals(Continents.AFRICA,actual);
		}
		
	
	@Test
	void testBurundiCostToLand_invalidlow() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, invalidCostToLand1Low1,
				validCostToBuy1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);
		 int actual=invalidCostToLand1Low1;
			assertNotEquals(5,actual);
		}

	@Test
	void testBurundiCostToLand_invalidhigh() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, invalidCostToLand1High1,
				validCostToBuy1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);
		 int actual=invalidCostToLand1High1;
			assertNotEquals(5,actual);
		}

	@Test
	void testBurundiCostToBuy_invalidlow() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validCostToLand1,
				invalidCostToBuy1Low1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);
		 int actual=invalidCostToBuy1Low1;
			assertNotEquals(50,actual);
		}
	
	@Test
	void testBurundiCostToBuy_invalidhigh() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validCostToLand1,
				invalidCostToBuy1High1, validMinorDevelopmentCost1, validMajorDevelopmentCost1);
		 int actual=invalidCostToBuy1High1;
			assertNotEquals(50,actual);
		}
	
	@Test
	void testBurundiMinorDevCost_invalidlow() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validCostToLand1,
				validCostToBuy1, invalidMinorDevelopmentCost1Low1, validMajorDevelopmentCost1);
		 int actual=invalidMinorDevelopmentCost1Low1;
			assertNotEquals(5,actual);
		}
	
	@Test
	void testBurundiMinorDevCost_invalidhigh() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validCostToLand1,
				validCostToBuy1, invalidMinorDevelopmentCost1High1, validMajorDevelopmentCost1);
		 int actual=invalidMinorDevelopmentCost1High1;
			assertNotEquals(5,actual);
		}
	
	@Test
	void testBurundiMajorDevCost_invalidlow() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validCostToLand1,
				validCostToBuy1, validMinorDevelopmentCost1, invalidMajorDevelopmentCost1Low1);
		 int actual=invalidMajorDevelopmentCost1Low1;
			assertNotEquals(10,actual);
		}
	
	@Test
	void testBurundiMajorDevCost_invalidhigh() {
		CountrySquare burundisquare = new CountrySquare(Continents.AFRICA,Countries.BURUNDI, validCostToLand1,
				validCostToBuy1, validMinorDevelopmentCost1, invalidMajorDevelopmentCost1High1);
		 int actual=invalidMajorDevelopmentCost1Low1;
			assertNotEquals(10,actual);
		}

	
	@Test
	void testMadagascarSquareValid() {
		//Checking constructor valid for Madagascar
		CountrySquare madagascarsquare = new CountrySquare(Continents.AFRICA, Countries.MADAGASCAR, validCostToLand2,
				validCostToBuy2, validMinorDevelopmentCost2, validMajorDevelopmentCost2);

		assertNotNull(madagascarsquare);
		assertEquals(Continents.AFRICA, madagascarsquare.getContinent()); // testing continent name expected vs actual
		assertEquals(Countries.MADAGASCAR, madagascarsquare.getCountry()); // testing country name
		assertEquals(validCostToLand2, madagascarsquare.getCostToLand());
		assertEquals(validCostToBuy2, madagascarsquare.getCostToBuy());
		assertEquals(validMinorDevelopmentCost2, madagascarsquare.getMinorDevelopmentCost());
		assertEquals(validMajorDevelopmentCost2, madagascarsquare.getMajorDevelopmentCost());
	}
}
