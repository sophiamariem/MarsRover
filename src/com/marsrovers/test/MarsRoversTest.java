package com.marsrovers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.marsrovers.main.MarsRover;
import com.marsrovers.main.Navigator;
import com.marsrovers.main.Plateau;
import com.marsrovers.main.RoverData;
import com.marsrovers.main.exceptions.InvalidInputException;
import com.marsrovers.main.exceptions.RoverOutOfBoundsException;


public class MarsRoversTest {

	private Plateau plateau = new Plateau("5 5");
	private RoverData firstRoverData;
	private RoverData secondRoverData;

	private MarsRover firstRover;
	private MarsRover secondRover;

	private Navigator navigator;
	private Navigator navigator2;

	String firstInstructionSeries = "LMLMLMLMM";
	String secondInstructionSeries = "MMRMMRMRRM";

	@Test
	public void testPlateauValues(){
		assertTrue(plateau.getMaxBounds().equals("5 5"));
		assertEquals(5, plateau.getMaxXBound());
		assertEquals(5, plateau.getMaxYBound());		
		assertEquals(0, plateau.getLowerX());
		assertEquals(0, plateau.getLowerY());
	}

	@Before
	public void setMarsRoverOne(){
		firstRover = new MarsRover();
		firstRoverData = new RoverData(firstRover);
		navigator = new Navigator(plateau, firstRover);
		firstRoverData.setInitialPosition("1 2 N");
		firstRoverData.setInstructionSeries(firstInstructionSeries);
	}

	@Test
	public void testMarsRoverOne() throws RoverOutOfBoundsException, InvalidInputException{
		assertTrue(firstRoverData.getInitialPosition().equals("1 2 N"));
		assertTrue(firstRoverData.getInstructionSeries().equals(firstInstructionSeries)); 

		assertEquals("1", firstRoverData.getxCoordinate());
		assertEquals("2", firstRoverData.getyCoordinate());
		assertEquals("N", firstRoverData.getOrientation());
		navigator.moveRover(firstInstructionSeries);
		assertEquals(1, firstRover.getxCoordinateValue());
		assertEquals(3, firstRover.getyCoordinateValue());

		assertTrue(navigator.getNewPosition().equals("1 3 N"));
	}

	@Before
	public void setMarsRoverTwo(){	
		secondRover = new MarsRover();
		secondRoverData = new RoverData(secondRover);
		navigator2 = new Navigator(plateau, secondRover);
		secondRoverData.setInitialPosition("3 3 E");
		secondRoverData.setInstructionSeries(secondInstructionSeries);
	}

	@Test
	public void testMarsRoverTwo() throws RoverOutOfBoundsException, InvalidInputException{
		assertTrue(secondRoverData.getInitialPosition().equals("3 3 E"));
		assertTrue(secondRoverData.getInstructionSeries().equals(secondInstructionSeries));

		assertEquals("3", secondRoverData.getxCoordinate());
		assertEquals("3", secondRoverData.getyCoordinate());
		assertEquals("E", secondRoverData.getOrientation());
		navigator2.moveRover(secondInstructionSeries);
		assertEquals(5, secondRover.getxCoordinateValue());
		assertEquals(1, secondRover.getyCoordinateValue());

		assertTrue(navigator2.getNewPosition().equals("5 1 E"));
	}

}