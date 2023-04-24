package lego;

import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class helloworlds extends Thread {

	// DataExchange object
	DataExchange DEObj;

	// wheels connect to ports
	public static RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
	public static RegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

	// constructor
	public helloworlds(DataExchange DE) {
		DEObj = DE;
	}

	private final int lineColor = 15; // Value of the black line to be followed against a white background

	public void run() {

		while (true) {

			// access method inside data exchange
			// Get the line value from the ColorSensor Thread
			float colorDetected = DEObj.getLineChecker();

			// get the count value from setter
			int count = DEObj.getCountValue();

			if (DEObj.getCMD() == 1) {

				if (colorDetected < lineColor) {
					motorA.setSpeed(150);
					motorD.setSpeed(50);
					motorA.forward();
					motorD.forward();
				} else if (colorDetected > lineColor) {

					motorD.setSpeed(150);
					motorA.setSpeed(50);

					motorD.forward();
					motorA.forward();

				}
			} else {

				// if obstacle is detected use setter to save this value to count on
				// dataExchange

				DEObj.setCountValue(1);

				if (count <= 1) {
					motorA.stop();
					motorD.stop();

					// turn right 
					motorA.setSpeed(280);
					motorD.setSpeed(180);
					motorA.forward();
					motorD.forward();

					Delay.msDelay(1800);

					// turn left 
					motorA.setSpeed(120);
					motorD.setSpeed(250);
					motorA.forward();
					motorD.forward();

					Delay.msDelay(2400);

					// turn left and move forward for 1 second
					//motorA.setSpeed(150);
					//motorD.setSpeed(50);
					//motorA.forward();
					//motorD.forward();

					//Delay.msDelay(2000);

					// turn right 
					motorA.setSpeed(250);
					motorD.setSpeed(90);
					motorA.forward();
					motorD.forward();
					
					Delay.msDelay(770);

				}

				if (count > 1) {
					motorA.stop();
					motorD.stop();

					System.out.println("Obstacle " + count +" detected");

					Delay.msDelay(2000);
				}
			}
			if (Button.getButtons() != 0) {
				// break when button is pressed
				break;

			}
		}
	}
}