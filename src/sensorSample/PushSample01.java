/**
 * 
 */
package sensorSample;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;

/**
 * @author yoshzawa
 *
 */
public class PushSample01 {

	public static void main(String[] args) {
		
		RegulatedMotor motorA = Motor.A;

		Port sensorPort = SensorPort.S1;
		EV3TouchSensor touchSensor = new EV3TouchSensor(sensorPort);
	    SampleProvider touchMode=touchSensor.getTouchMode();
	    
	    while(!Button.ESCAPE.isDown()){
		    float[] touchDistance = new float[touchMode.sampleSize()];
		    touchMode.fetchSample(touchDistance, 0);
		    float touch = touchDistance[0];
	    	if(touch==0){
	    		motorA.rotateTo(30);
	    	}else{
	    		motorA.rotateTo(60);
	    	}
	    	LCD.drawString("touch:"+touch, 0, 0);
	    }
		motorA.rotateTo(0);
	}

}
