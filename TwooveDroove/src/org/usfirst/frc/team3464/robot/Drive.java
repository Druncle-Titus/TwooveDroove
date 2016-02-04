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
	
	public Drive(Joystick l, Joystick r){
		for(int i = 0; i < 2 ; ++i){
			lMotors[i] = new CANTalon(LEFT_DRIVE_ID[i]);
			rMotors[i] = new CANTalon(RIGHT_DRIVE_ID[i]);
		}
		l = this.l;
		r = this.r;
	}
	public Drive(CANTalon lMotor, CANTalon rMotor, Joystick l, Joystick r){
		lMotor = this.lMotor;
		rMotor = this.rMotor;
		l = this.l;
		r = this.r;
	}
	
	public void drive(){
		for(int i = 0; i < lMotors.length; ++i){
			lMotors[i].set(l.getY() * -SPEED_MULTIPLIER);
			rMotors[i].set(r.getY() * SPEED_MULTIPLIER);
		}
	}
	public void driveUpAuto()
	{
		for(int i = 0; i < 500; ++i )
			for(int j = 0; j < lMotors.length; ++j)
			{
				lMotors[i].set(-1 *AUTO_GENERIC);
				rMotors[i].set(AUTO_GENERIC);
			}
	}
	public void driveOverAuto()
	{
		for(int i = 0; i < 1000; ++i ) {
			for(int j = 0; j < lMotors.length; ++j)
			{
				lMotors[i].set(-1 *AUTO_GENERIC);
				rMotors[i].set(AUTO_GENERIC);
			}
		}
	}
}
