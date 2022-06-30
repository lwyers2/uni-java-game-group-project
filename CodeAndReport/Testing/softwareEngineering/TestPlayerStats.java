package softwareEngineering;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlayerStats {

	String validPlayerName;
	int validECOpoints;
	int validPlayerBoardPos;
	int validRollDiceLower;
	int validRollDiceUpper;
	int  invalidRollDiceLower;
	int invalidRollDiceUpper;
	ArrayList<CountrySquare> validOwnedSquares;
	ArrayList<CountrySquare> allAfrica;
	ArrayList<CountrySquare> allAmericas;
	ArrayList<CountrySquare> allEurope;
	ArrayList<CountrySquare> allAsia;
	ArrayList<CountrySquare> invalidOwnedSquares;
	ArrayList<CountrySquare> oneInEach;
	PlayerStats p1;
	PlayerStats p2;
	PlayerStats p3;
	PlayerStats p4;
	PlayerStats p5;
	CountrySquare burSqr = new CountrySquare(Continents.AFRICA, Countries.BURUNDI, 5, 50, 5, 10);
	CountrySquare madSqr = new CountrySquare(Continents.AFRICA, Countries.MADAGASCAR, 7, 75, 7, 12);
	CountrySquare canSqr = new CountrySquare(Continents.AMERICAS, Countries.CANADA, 10, 100, 10, 20);
	CountrySquare usaSqr = new CountrySquare(Continents.AMERICAS, Countries.USA, 14, 135, 14, 28);
	CountrySquare argSqr = new CountrySquare(Continents.AMERICAS, Countries.ARGENTINA, 13, 125,13, 26);
	CountrySquare fraSqr = new CountrySquare(Continents.EUROPE, Countries.FRANCE, 11, 110, 11, 22);
	CountrySquare spaSqr = new CountrySquare(Continents.EUROPE, Countries.SPAIN, 14, 135, 14, 28);
	CountrySquare itaSqr = new CountrySquare(Continents.EUROPE, Countries.ITALY, 16, 115, 16, 32);
	CountrySquare japSqr = new CountrySquare(Continents.ASIA, Countries.JAPAN, 20, 200, 20, 40);
	CountrySquare chiSqr = new CountrySquare(Continents.ASIA, Countries.CHINA, 25, 250, 25, 50);
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpValid() throws Exception {
		

		validPlayerName = "Valid";
		validECOpoints = 50;
		validOwnedSquares = new ArrayList<CountrySquare>();
		validOwnedSquares.add(burSqr);
		validOwnedSquares.add(madSqr);
		validOwnedSquares.add(canSqr);
		validOwnedSquares.add(usaSqr);
		validOwnedSquares.add(argSqr);
		validOwnedSquares.add(fraSqr);
		validOwnedSquares.add(spaSqr);
		validOwnedSquares.add(itaSqr);
		validOwnedSquares.add(japSqr);
		validOwnedSquares.add(chiSqr);
		

		
		//only africa countries
		allAfrica = new ArrayList<CountrySquare>();
		allAfrica.add(burSqr);
		allAfrica.add(madSqr);

		//only america countries
		allAmericas = new ArrayList<CountrySquare>();
		allAmericas.add(canSqr);
		allAmericas.add(usaSqr);
		allAmericas.add(argSqr);

		//only european countries
		allEurope = new ArrayList<CountrySquare>();
		allEurope.add(fraSqr);
		allEurope.add(spaSqr);
		allEurope.add(itaSqr);

		//only Asian countries
		allAsia = new ArrayList<CountrySquare>();
		allAsia.add(japSqr);
		allAsia.add(chiSqr);
		
		// one of each continent
		oneInEach = new ArrayList<CountrySquare>();
		oneInEach.add(argSqr);
		oneInEach.add(japSqr);
		oneInEach.add(fraSqr);
		oneInEach.add(madSqr);
		
		
		
		//Empty 
		
		// set up empty players
		p1= new PlayerStats();
		p2= new PlayerStats();
		p3= new PlayerStats();
		p4= new PlayerStats();
		p5 = new PlayerStats();
		
		validRollDiceLower =2;
		validRollDiceUpper =12;
		
		
		
	}
	
	/*
	 * Because dice returns random we can only check that the range of numbers returned is correct
	 */
	@Test
	void testRollDiceValid() {
		
		boolean inRange;
		int result;
		
		result= p1.rollDice();
		
		if (result>=validRollDiceLower && result<=validRollDiceUpper) {
			inRange = true;
		} else {
			inRange=false;
		}
		
		assertEquals(true, inRange);
		
	}
	
	/*
	 * Because dice returns random we can only check that the range of numbers returned is correct
	 */
	@Test
	void testRollDiceInvalid() {
		
		boolean inRange;
		int result;
		
		result= p1.rollDice();
		// will only return true if out of bounds
		if (result<validRollDiceLower || result>validRollDiceUpper) {
			inRange = true;
		} else {
			inRange=false;
		}
		
		assertEquals(false, inRange);
		
	}
	

	
	@Test
void ownsAllInContinent() {
		
		//Owned squares == all continents
		for(CountrySquare country: validOwnedSquares) {
			p1.addOwnedSquare(country);
		}
		// P1 has all continents so need to check all true
		assertEquals(true, p1.ownsAllInContinent(Continents.AFRICA));
		assertEquals(true, p1.ownsAllInContinent(Continents.EUROPE));
		assertEquals(true, p1.ownsAllInContinent(Continents.ASIA));
		assertEquals(true, p1.ownsAllInContinent(Continents.AMERICAS));
		
		//below are for each specific country
		//America Only
		for(CountrySquare country: allAmericas) {
			p2.addOwnedSquare(country);
		}
		
		assertEquals(true, p2.ownsAllInContinent(Continents.AMERICAS));
		
		//Africa Only
				for(CountrySquare country: allAfrica) {
					p3.addOwnedSquare(country);
				}
				
				assertEquals(true, p3.ownsAllInContinent(Continents.AFRICA));
				
				//Asia Only
				for(CountrySquare country: allAsia) {
					p4.addOwnedSquare(country);
				}
				
				assertEquals(true, p4.ownsAllInContinent(Continents.ASIA));
				
				//Europe Only
				for(CountrySquare country: allEurope) {
					p5.addOwnedSquare(country);
				}
				
				assertEquals(true, p5.ownsAllInContinent(Continents.EUROPE));
	
				
	}
	
	
	
	@Test
void doesntOwnAllInContinent() {
		
		//Owned squares == one of each country to check continents
				for(CountrySquare country: oneInEach) {
					p1.addOwnedSquare(country);
				}
				
				assertEquals(false, p1.ownsAllInContinent(Continents.AFRICA));
				assertEquals(false, p1.ownsAllInContinent(Continents.EUROPE));
				assertEquals(false, p1.ownsAllInContinent(Continents.ASIA));
				assertEquals(false, p1.ownsAllInContinent(Continents.AMERICAS));
				
				
				//below are for each specific country
				//America Only
				for(CountrySquare country: allAmericas) {
					p2.addOwnedSquare(country);
				}
				
				// check all == false EXCEPT AMERICA
				
				assertEquals(false, p1.ownsAllInContinent(Continents.AFRICA));
				assertEquals(false, p1.ownsAllInContinent(Continents.EUROPE));
				assertEquals(false, p1.ownsAllInContinent(Continents.ASIA));
				
				
				//Africa Only
						for(CountrySquare country: allAfrica) {
							p3.addOwnedSquare(country);
						}
						
						// check all == false EXCEPT AFRICA
						
						
						assertEquals(false, p1.ownsAllInContinent(Continents.EUROPE));
						assertEquals(false, p1.ownsAllInContinent(Continents.ASIA));
						assertEquals(false, p1.ownsAllInContinent(Continents.AMERICAS));
						
						//Asia Only
						for(CountrySquare country: allAsia) {
							p4.addOwnedSquare(country);
						}
						
						// check all == false EXCEPT ASIA
						
						assertEquals(false, p1.ownsAllInContinent(Continents.AFRICA));
						assertEquals(false, p1.ownsAllInContinent(Continents.EUROPE));
						
						assertEquals(false, p1.ownsAllInContinent(Continents.AMERICAS));
						
						//Europe Only
						for(CountrySquare country: allEurope) {
							p5.addOwnedSquare(country);
						}
						
						// check all == false EXCEPT EUROPE
						
						assertEquals(false, p1.ownsAllInContinent(Continents.AFRICA));
					
						assertEquals(false, p1.ownsAllInContinent(Continents.ASIA));
						assertEquals(false, p1.ownsAllInContinent(Continents.AMERICAS));
	
				
	}
	

	
	@Test 
	void checkOwnedCountry() {
		//adds in all countries
		for(CountrySquare country: validOwnedSquares) {
			p1.addOwnedSquare(country);
		}
		
		assertEquals(true, p1.hasOwnedSquare(Countries.ARGENTINA));
		assertEquals(true, p1.hasOwnedSquare(Countries.BURUNDI));
		assertEquals(true, p1.hasOwnedSquare(Countries.CANADA));
		assertEquals(true, p1.hasOwnedSquare(Countries.CHINA));
		assertEquals(true, p1.hasOwnedSquare(Countries.FRANCE));
		assertEquals(true, p1.hasOwnedSquare(Countries.ITALY));
		assertEquals(true, p1.hasOwnedSquare(Countries.JAPAN));
		assertEquals(true, p1.hasOwnedSquare(Countries.SPAIN));
		assertEquals(true, p1.hasOwnedSquare(Countries.USA));
	}
	
	
	
	@Test 
	void checkNotOwnedCountry() {
		//Don't add any countryies at all in
		assertEquals(false, p1.hasOwnedSquare(Countries.ARGENTINA));
		assertEquals(false, p1.hasOwnedSquare(Countries.BURUNDI));
		assertEquals(false, p1.hasOwnedSquare(Countries.CANADA));
		assertEquals(false, p1.hasOwnedSquare(Countries.CHINA));
		assertEquals(false, p1.hasOwnedSquare(Countries.FRANCE));
		assertEquals(false, p1.hasOwnedSquare(Countries.ITALY));
		assertEquals(false, p1.hasOwnedSquare(Countries.JAPAN));
		assertEquals(false, p1.hasOwnedSquare(Countries.SPAIN));
		assertEquals(false, p1.hasOwnedSquare(Countries.USA));
	}
	
	
	
	
	
}
