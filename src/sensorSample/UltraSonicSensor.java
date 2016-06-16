package sensorSample;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

/**
 * 
 */

/**
 * @author t.yoshizawa
 *
 */
public class UltraSonicSensor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Port sensorPort = SensorPort.S2;
		EV3UltrasonicSensor uss =
				new EV3UltrasonicSensor(sensorPort);
		SampleProvider distanceMode = 
				uss.getDistanceMode();
		
		while(Button.ESCAPE.isDown() == false){
			float[] ussDistance = 
					new float[distanceMode.sampleSize()];
			distanceMode.fetchSample(ussDistance, 0);
			float distance = ussDistance[0] * 100;
			LCD.drawString("distance="+distance, 0, 0);
			Delay.msDelay(10);
		}
	}
}
