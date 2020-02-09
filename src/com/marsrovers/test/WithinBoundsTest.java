package com.marsrovers.test;

import org.junit.Before;
import org.junit.Test;

import com.marsrovers.main.MarsRover;
import com.marsrovers.main.Navigator;
import com.marsrovers.main.Plateau;
import com.marsrovers.main.RoverData;
import com.marsrovers.main.exceptions.InvalidInputException;
import com.marsrovers.main.exceptions.RoverOutOfBoundsException;


public class WithinBoundsTest {

	private Plateau plateau = new Plateau("5 5");

	private RoverData thirdRoverData;
	private RoverData fourthRoverData;
	private RoverData fifthRoverData;
	private RoverData sixthRoverData;

	private MarsRover thirdRover;
	private MarsRover fourthRover;
	private MarsRover fifthRover;
	private MarsRover sixthRover;

	private Navigator navigator3;
	private Navigator navigator4;
	private Navigator navigator5;
	private Navigator navigator6;

	String failInstructionSeries = "M";

	@Before
	public void setMarsRoverIllegalArgument(){	
		thirdRover = new MarsRover();
		thirdRoverData = new RoverData(thirdRover);
		navigator3 = new Navigator(plateau, thirdRover);
		thirdRoverData.setInitialPosition("3 5 N");
		thirdRoverData.setInstructionSeries(failInstructionSeries);

		fourthRover = new MarsRover();
		fourthRoverData = new RoverData(fourthRover);
		navigator4 = new Navigator(plateau, fourthRover);
		fourthRoverData.setInitialPosition("5 3 E");
		fourthRoverData.setInstructionSeries(failInstructionSeries);

		fifthRover = new MarsRover();
		fifthRoverData = new RoverData(fifthRover);
		navigator5 = new Navigator(plateau, fifthRover);
		fifthRoverData.setInitialPosition("3 0 S");
		fifthRoverData.setInstructionSeries(failInstructionSeries);

		sixthRover = new MarsRover();
		sixthRoverData = new RoverData(sixthRover);
		navigator6 = new Navigator(plateau, sixthRover);
		sixthRoverData.setInitialPosition("0 3 W");
		sixthRoverData.setInstructionSeries(failInstructionSeries);
	}

	@Test(expected=RoverOutOfBoundsException.class)
	public void testMarsRoverIllegalArgumentNav3() throws RoverOutOfBoundsException, InvalidInputException{
		navigator3.moveRover(failInstructionSeries);
	}

	@Test(expected=RoverOutOfBoundsException.class)
	public void testMarsRoverIllegalArgumentNav4() throws RoverOutOfBoundsException, InvalidInputException{;
	navigator4.moveRover(failInstructionSeries);
	}

	@Test(expected=RoverOutOfBoundsException.class)
	public void testMarsRoverIllegalArgumentNav5() throws RoverOutOfBoundsException, InvalidInputException{
		navigator5.moveRover(failInstructionSeries);
	}

	@Test(expected=RoverOutOfBoundsException.class)
	public void testMarsRoverIllegalArgumentNav6() throws RoverOutOfBoundsException, InvalidInputException{
		navigator6.moveRover(failInstructionSeries);
	}

}
