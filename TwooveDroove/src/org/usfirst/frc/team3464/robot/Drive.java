package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

import static org.usfirst.frc.team3464.robot.Const.*;

public class Drive {
	CANTalon[] lMotors = new CANTalon[2];
	CANTalon[] rMotors = new CANTalon[2];
	Joystick l;
	Joystick r;
	CANTalon lMotor;
	CANTalon rMotor;
	
	
	//Constructor for the tank treads
	public Drive(Joystick l, Joystick r){
		for(int i = 0; i < 2 ; ++i){
			lMotors[i] = new CANTalon(LEFT_DRIVE_ID[i]);
			rMotors[i] = new CANTalon(RIGHT_DRIVE_ID[i]);
		}
		this.l = l;
		this.r = r;
	}
	
	//Constructor for the alternate drive train
	public Drive(CANTalon lMotor, CANTalon rMotor, Joystick l, Joystick r){
		this.lMotor = lMotor;
		this.rMotor = rMotor;
		this.l = l;
		this.r = r;
	}
	
	//Constructor for autonomous
	public Drive(){
		for(int i = 0; i < 2 ; ++i){
			lMotors[i] = new CANTalon(LEFT_DRIVE_ID[i]);
			rMotors[i] = new CANTalon(RIGHT_DRIVE_ID[i]);
		}
	}
	
	public void drive(){
		for(int i = 0; i < lMotors.length; ++i){
			lMotors[i].set(l.getY() * -SPEED_MULTIPLIER);
			rMotors[i].set(r.getY() * SPEED_MULTIPLIER);
		}
	}
	public void driveAlternate(){
		lMotor.set(l.getY() * -SPEED_MULTIPLIER);
		rMotor.set(r.getY() * SPEED_MULTIPLIER);
	}
	public void autoForward()
	{
		for(int j = 0; j < lMotors.length; ++j)
			{
				lMotors[j].set(-1 *AUTO_GENERIC);
				rMotors[j].set(AUTO_GENERIC);
			}
	}
	public void driveOverAuto()
	{
			for(int j = 0; j < lMotors.length; ++j)
			{
				lMotors[j].set(-1 *AUTO_GENERIC);
				rMotors[j].set(AUTO_GENERIC);
			}
	}
	public void autoStop()
	{
		for(int j = 0; j < lMotors.length; ++j)
		{
			lMotors[j].set(0);
			rMotors[j].set(0);
		}	
	}
	public void autoLeft()
	{
		for(int i = 0; i < lMotors.length; ++i )
		{
			lMotors[i].set(0.25 * AUTO_GENERIC);
			rMotors[i].set(0.25 * AUTO_GENERIC);
		}
	}
	public void autoRight()
	{
		for(int i = 0; i < lMotors.length; ++i )
		{
			lMotors[i].set(-0.25 * AUTO_GENERIC);
			rMotors[i].set(-0.25 * AUTO_GENERIC);
		}
	}
}