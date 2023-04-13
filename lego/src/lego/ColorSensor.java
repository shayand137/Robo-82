package lego;


//import necessary functions for the color sensor
import lejos.robotics.SampleProvider;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;


public class ColorSensor extends Thread {
	
	  //data exchange object 
		private DataExchange DEObj;
		
		// Private access modifier can only be accessed in their own class
		private EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S4);
		
		// Public can be accessed anywhere
		// Passing data through exchange
		public ColorSensor(DataExchange DE){
			DEObj = DE;
			
			//Used to turn on or off the floodlight by color. 
			//If the sensor has multiple light colors, you can 
			//control which color is turned on or off. If the color does not exist, it does nothing and returns false.
			colorSensor.setFloodlight(true);

}
		SensorMode colorProvider = colorSensor.getRedMode();
		float color;
		
	public void run() {
		
		while(true) {
			
			//Robot is constantly checking for the values and storing them in the sample array
			//LineChecker sample provider
			 float[] sample = new float[colorProvider.sampleSize()];
			colorProvider.fetchSample(sample, 0);
			 color = (sample[0] * 100);
			 
			 
			 //use setter on data exchange to set value
			 DEObj.setLineChecker(color);
		}
	}
}

