package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXL362.AllAxes;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import static org.usfirst.frc.team3464.robot.Const.*;

public class SensorUtil {
	ADXL362 accelerometer;  //There is actually a built-in accelerometer in the roboRio
	ADXRS450_Gyro gyro;
	Ultrasonic ultra;
	
	public double accelerationX;
	public double accelerationY;
	public double accelerationZ;
	
	public double gyroAngle;
	
	public double ultraDistance;
	
	public SensorUtil(){
		accelerometer = new ADXL362(Range.k2G);
		
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		gyroAngle = gyro.getAngle();
		
		ultra = new Ultrasonic(0, 1);
		ultra.setEnabled(true);
		ultra.setAutomaticMode(true);
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
	public double accelerationX(){
		accelerationX = accelerometer.getX();
		
		return accelerationX;
	}
	public double accelerationY(){
		accelerationY = accelerometer.getY();
		
		return accelerationY;
	}
	public double accelerationZ(){
		accelerationZ = accelerometer.getZ();
		
		return accelerationZ;
	}
	
	//Ultrasonic sensor methods
	public double getDistance(){
		if(ultra.isRangeValid()){
			ultraDistance = ultra.getRangeInches();
		}
		return ultraDistance;
	}
	
	//Camera methods
	
}
