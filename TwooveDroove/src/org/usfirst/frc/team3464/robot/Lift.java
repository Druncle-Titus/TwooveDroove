package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

import static org.usfirst.frc.team3464.robot.Const.*;

public class Lift {
	CANTalon extendMotor;
	CANTalon move1;
	CANTalon move2;
	Joystick stick;
	
	public Lift(Joystick j){
		//extendMotor = new CANTalon(EXTEND_ID);
		move1 = new CANTalon(MOVE1_ID);
		move2 = new CANTalon(MOVE2_ID);
		stick = j;
	}
	
	public void move(){
		if(stick.getRawButton(EXTEND_JOY)) 
		{
			move2.set(EXTEND_SPEED);
			move1.set(EXTEND_SPEED);
		}
		else if (stick.getRawButton(RETRACT_JOY))
		{
			move2.set(-1);
	    	move1.set(-1);
		}
		else
		{
			move2.set(0);
	    	move1.set(0);
		}

	}
	
}