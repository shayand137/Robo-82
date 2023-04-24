package app;

import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class ObstacleDetector extends Thread {
	  //data exchange object 
		private DataExchange DEObj;
		private EV3UltrasonicSensor obstacleSensor;
		//Sample provider method that receives values from the sensor
		// We are using this to get values for the distance from the ultrasonic sensor
<<<<<<< HEAD
	
		
=======
>>>>>>> 50c081a208d067b5a40cd7c91a64086587b30a46
		int distanceValue;
		private final int safeDistance = 7; 
		// how distant the obstacle has to be for the robot to avoid it
		public ObstacleDetector(DataExchange DE){
			DEObj = DE;
			obstacleSensor = new EV3UltrasonicSensor(SensorPort.S2);
}
	public void run() {
		
		while(true) {
			
			final SampleProvider distance = obstacleSensor.getDistanceMode();
			
			float[] sample = new float[distance.sampleSize()];
			distance.fetchSample(sample, 0);
			float distanceValue = (int)(sample[0] * 100);
			
			if(distanceValue > safeDistance) {
				
				//when obstacle is detected this value changes
				DEObj.setCMD(1);
			} else {
				
				DEObj.setCMD(0);
				Sound.buzz();
				DEObj.setMDM(0);
			}
		}
	}
}

