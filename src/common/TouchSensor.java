package common;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

public class TouchSensor {
	SampleProvider touchMode;

	public TouchSensor(Port sensorPort) {
		EV3TouchSensor touchSensor = new EV3TouchSensor(sensorPort);
		touchMode = touchSensor.getTouchMode();
	}

	public float getStatus() {
		float[] touchDistance = new float[touchMode.sampleSize()];
		touchMode.fetchSample(touchDistance, 0);
		float touch = touchDistance[0];
		return touch;
	}

	public boolean isPushed() {
		if (getStatus() == 0) {
			return false;
		} else {
			return true;
		}
	}
}