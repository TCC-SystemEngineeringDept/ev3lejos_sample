package motorSample;

import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

/**
 * @author yoshzawa
 *
 */
public class MotorSample01 {

	public static void main(String[] args) {
		//L motor(port A)
		RegulatedMotor motorA = Motor.A;

		// rotate
		motorA.rotate(30);
		motorA.rotate(60);
		motorA.rotate(90);

		// rotateTo
		motorA.rotateTo(30);
		motorA.rotateTo(60);
		motorA.rotateTo(90);
	}
}
