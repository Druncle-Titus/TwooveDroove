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
		extendMotor = new CANTalon(EXTEND_ID);
		move1 = new CANTalon(MOVE1_ID);
		move2 = new CANTalon(MOVE2_ID);
		stick = j;
	}
	
	public void move(){
		//old lift code
		/*if(stick.getRawButton(RETRACT_JOY))
		   {
			   extendMotor.set(0);
			   retractMotorFront.set(1);
			   retractMotorBack.set(1);
		   }
		   else if(stick.getRawButton(EXTEND_JOY))
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
		   }*/
		if(stick.getRawButton(EXTEND_JOY))
    	{
    	extendMotor.set(-1);
    	move1.set(.25);
    	move2.set(.25);
    	}	
    	else if(stick.getRawButton(RETRACT_JOY))
    	{
    		move1.set(-.5);
        	move2.set(-.5);
        	extendMotor.set(.2);
    	}
    	else
    	{
    		extendMotor.set(0);
        	move1.set(0);
        	move2.set(0);
    	}
	}
	
}