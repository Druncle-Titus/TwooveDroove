package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

import static org.usfirst.frc.team3464.robot.Const.*;

public class Lift {
	CANTalon extendMotor;
	CANTalon retractMotorFront;
	CANTalon retractMotorBack;
	Joystick stick;
	
	public Lift(){
		extendMotor = new CANTalon(EXTEND_ID);
		retractMotorFront = new CANTalon(RETRACT_FRONT_ID);
		retractMotorBack = new CANTalon(RETRACT_BACK_ID);
		retractMotorBack.setInverted(true);
		stick = new Joystick(OTHER_STICK);
	}
	
	public void extend(){
		if(stick.getRawButton(3))
		   {
			   extendMotor.set(0);
			   retractMotorFront.set(.5);
			   retractMotorBack.set(.5);
		   }
		   else if(stick.getRawButton(4))
		   {
			   extendMotor.set(-.8);
			   retractMotorFront.set(-.4);
			   retractMotorBack.set(-.4);  

		   }   
		   else
		   {
			   extendMotor.set(0);
			   retractMotorFront.set(0);
			   retractMotorBack.set(0);
		   }
	}
	
}
