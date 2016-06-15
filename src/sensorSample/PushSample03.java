/**
 * 
 */
package sensorSample;

import common.TouchSensor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;

/**
 * @author yoshzawa
 *
 */
public class PushSample03 {

	public static void main(String[] args) {

		RegulatedMotor motorA = Motor.A;

		Port sensorPort = SensorPort.S1;
		TouchSensor sensor = new TouchSensor(sensorPort);

		while (!Button.ESCAPE.isDown()) {
			float touch = sensor.getStatus();

			if (sensor.isPushed() == false) {
				motorA.rotateTo(30);
			} else {
				motorA.rotateTo(60);
			}
			LCD.drawString("touch:" + touch, 0, 0);
		}
		motorA.rotateTo(0);
	}

}
