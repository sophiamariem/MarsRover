package com.marsrovers.main;

public class RoverData {

	private String initialPosition;
	private String instructionSeries;

	private String xCoordinate;
	private String yCoordinate;
	private String orientation;

	private MarsRover marsRover;

	public RoverData(MarsRover marsRover){
		this.marsRover = marsRover;
	}

	public String getInitialPosition() {
		return initialPosition;
	}
	public void setInitialPosition(String initialPosition) {
		String[] roverPosition = initialPosition.split(" ");
		setxCoordinate(roverPosition[0]);
		setyCoordinate(roverPosition[1]);
		setOrientation(roverPosition[2]);
		this.initialPosition = initialPosition;
	}
	public String getInstructionSeries() {
		return instructionSeries;
	}
	public void setInstructionSeries(String instructionSeries) {
		this.instructionSeries = instructionSeries;
	}

	public String getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(String xCoordinate) {
		marsRover.setxCoordinateValue(Integer.parseInt(xCoordinate));	
		this.xCoordinate = xCoordinate;
	}
	public String getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(String yCoordinate) {
		marsRover.setyCoordinateValue(Integer.parseInt(yCoordinate));	
		this.yCoordinate = yCoordinate;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		marsRover.setOrientation(orientation);
		this.orientation = orientation;
	}
}