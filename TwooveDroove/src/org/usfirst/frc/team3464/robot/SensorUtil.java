package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXL362.AllAxes;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import static org.usfirst.frc.team3464.robot.Const.*;

public class SensorUtil {
	ADXL362 accelerometer;
	ADXRS450_Gyro gyro;
	
	public AllAxes acceleration;
	public double gyroAngle;
	
	public SensorUtil(){
		accelerometer = new ADXL362(Range.k2G);
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		gyroAngle = gyro.getAngle();
	}
	
	//Gyro methods
	public void recalibrate(){
		gyro.calibrate();
		gyroAngle = gyro.getAngle();
	}
	
	public double getAngleOffset(){
		return gyro.getAngle() - gyroAngle;
	}
	
	//Accelerometer methods
	public void accelerationUpdate(){
		acceleration = accelerometer.getAccelerations();
	}
}
