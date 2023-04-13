package lego;

public class DataExchange {
	// ObstacleDetector
	private boolean obstacleDetected = false;

	// saves amount of times obstacle was seen
	private int count = 1;
	
	private float lineChecker;

	// Robot has the following commands: Follow Line, Stop
	private int CMD = 1;

	public DataExchange() {
	}

	/*
	 * Getters & Setters
	 */
	public void setObstacleDetected(boolean status) {
		obstacleDetected = status;
	}

	public boolean getObstacleDetected() {
		return obstacleDetected;
	}

	public void setCMD(int command) {
		CMD = command;
	}

	public int getCMD() {
		return CMD;
	}

	// Getter that return count variable where it counts how many time obstacle was detected
	public int getCountValue() {
		return count;
	}
	
	//Setter that changes value of count and doing so storing the new value
	public void setCountValue(int newCount) {
		this.count = this.count + newCount;
	}
	
	//Getters and Setter for LineChecker
	public float getLineChecker() {
		return lineChecker;
	}
	
	public void setLineChecker(float lineChecker){
		this.lineChecker = lineChecker;
	}
}