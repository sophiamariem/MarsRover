package com.marsrovers.main;

import com.marsrovers.main.exceptions.InvalidInputException;
import com.marsrovers.main.exceptions.RoverOutOfBoundsException;

public class Navigator {

	private static final char LEFT = 'L';
	private static final char RIGHT = 'R';
	private static final char MOVE = 'M';

	private String newPosition;

	private MarsRover marsRover;
	private Plateau plateau;

	public Navigator(Plateau plateau, MarsRover marsRover){
		this.plateau = plateau;
		this.marsRover = marsRover;
	}

	public void moveRover(String instructionSeries) throws RoverOutOfBoundsException, InvalidInputException{	
		int thisDirection = instructionSeries.length();

		for (int i = 0; i < thisDirection; i++) {
			char instruction = instructionSeries.charAt(i);
			switch (instruction) {
			case LEFT:
				marsRover.retrieveNewDirectionFromLeft();
				break;
			case RIGHT:
				marsRover.retrieveNewDirectionFromRight();
				break;
			case MOVE:
				if (isWithinBounds()){
					marsRover.retrieveNewForwardDirection();
				} else {
					throw new RoverOutOfBoundsException("Out Of Bounds!");
				}
				break;
			default:
				throw new InvalidInputException("Invalid Argument!");
			}
			String finalPosition = marsRover.getxCoordinateValue() + " " + marsRover.getyCoordinateValue() + " " +  marsRover.getOrientation();
			setNewPosition(finalPosition);
		}
	}

	private  boolean isWithinBounds() {
		if (marsRover.isNorth()){
			return marsRover.getyCoordinateValue()<plateau.getMaxYBound();
		}
		if (marsRover.isEast()){
			return marsRover.getxCoordinateValue()<plateau.getMaxXBound();
		}
		if (marsRover.isSouth()){
			return marsRover.getyCoordinateValue()>plateau.getLowerY();
		}
		if (marsRover.isWest()){
			return marsRover.getxCoordinateValue()>plateau.getLowerX();
		}
		return false;
	}

	public String getNewPosition() {
		return newPosition;
	}

	public void setNewPosition(String newPosition) {
		this.newPosition = newPosition;
	}
}
