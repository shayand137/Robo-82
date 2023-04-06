package lego;
import lejos.hardware.Button;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class motor {
	 //@SuppressWarnings("resource")
    EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S4);

  //   @SuppressWarnings("resource")
    RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
  //   @SuppressWarnings("resource")
    RegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);
     motorA.setSpeed(300);
     motorD.setSpeed(300);
     motorA.forward();
     motorD.forward();
     while (true) {
	   SampleProvider colorProvider = colorSensor.getRedMode();
	   float[] sample = new float[colorProvider.sampleSize()];
       colorProvider.fetchSample(sample, 0);
        float colorId = (sample[0]);
       
       if(colorId <= 45) {
         motorA.setSpeed(150);
         motorD.setSpeed(50);
         motorA.forward();
         motorD.forward();
         
       }else if(colorId > 45){
         motorA.setSpeed(50);
         motorD.setSpeed(150);
         motorA.forward();
         motorD.forward();
         
         Delay.msDelay(1000);
         }
       
       if(Button.getButtons()!=0) {
          break;    }}

}
