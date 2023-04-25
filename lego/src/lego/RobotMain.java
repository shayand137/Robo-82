package lego;

import lejos.hardware.Button;

public class RobotMain {

	private static DataExchange DE = new DataExchange();
	private static helloworlds LFObj  = new helloworlds(DE);
	private static ObstacleDetector ODObj = new ObstacleDetector(DE);
	private static ColorSensor CSObj = new ColorSensor (DE);
	//commit for Deepak task!
	public static void main(String[] args) {
//		System.out.println("Hello It's Robo82");
//		System.out.println("Veronika ");
//		System.out.println("Mohammadreza");
//		System.out.println("Aryan ");
//		System.out.println("Welcome ... ");
		
		Button.waitForAnyPress();
		ODObj.start();
		LFObj.start();
		CSObj.start();
		
		 //random comment
		
		while(!(Button.getButtons() !=0)) {
			//break when button is pressed
			break;
		}
		
	}

}
