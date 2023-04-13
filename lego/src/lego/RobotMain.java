package lego;

import lejos.hardware.Button;

public class RobotMain {

	private static DataExchange DE = new DataExchange();
	private static helloworlds LFObj  = new helloworlds(DE);
	private static ObstacleDetector ODObj = new ObstacleDetector(DE);
	private static ColorSensor CSObj = new ColorSensor (DE);
	
	public static void main(String[] args) {
		
		Button.waitForAnyPress();
		ODObj.start();
		LFObj.start();
		CSObj.start();
		
		 
		
		while(!(Button.getButtons() !=0)) {
			//break when button is pressed
			break;
		}
		
	}

}
