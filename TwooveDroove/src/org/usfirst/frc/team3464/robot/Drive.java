package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

import static org.usfirst.frc.team3464.robot.Const.*;

public class Drive {
	CANTalon[] lMotors;
	CANTalon[] rMotors;
	Joystick l;
	Joystick r;
	
	CANTalon lMotor;
	CANTalon rMotor;
	
	public Drive(CANTalon[] lMotors, CANTalon[] rMotors, Joystick l, Joystick r){
		lMotors = this.lMotors;
		rMotors = this.rMotors;
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
}
