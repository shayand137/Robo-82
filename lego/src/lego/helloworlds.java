package lego;
import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
public class helloworlds extends Thread{

 
	 
	  private  static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S4);

	   private static  RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
	   private static  RegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);
	   public static void main(String[] args) {
		 
		  //linefollower
		   //this is just some comment
		   
		   
	    while(true){
			  
	    	  final SampleProvider colorProvider = colorSensor.getRedMode();
			  float color;
			   float[] sample = new float[colorProvider.sampleSize()];
		       colorProvider.fetchSample(sample, 0);
		        color = (sample[0]);
		        
			       
		         if(color <= 0.15) {
		         motorA.setSpeed(150);
		         motorD.setSpeed(50);
		         motorA.forward();
		         motorD.forward();
		          }
		         else if(color > 0.15){
		         
		         motorD.setSpeed(150);
		         motorA.setSpeed(50);
		         
		         motorD.forward();
		         motorA.forward();
		       
		             }
		       // System.out.println(color);
		        // Delay.msDelay(1000);
			        if(Button.getButtons()!=0) {
			          break;}
	   }
	}
}