package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static org.usfirst.frc.team3464.robot.Const.*;


public class BallMechanism {
	String mode;	
	Joystick control;
	CANTalon left;
	CANTalon right;
	public BallMechanism (String m, Joystick c )
	{
		control = c;
		mode = m;
		if(mode.equals("up"))
			setUpDown();
		else
			setLeftRight();
		
	}
	private void setLeftRight()
	{
		left = new CANTalon(LEFT_INTAKE_ID);
		right = new CANTalon(RIGHT_INTAKE_ID);
	}
	
	private void setUpDown()
	{
		left = new CANTalon(UP_INTAKE_ID);
	}
	
	public void run()
	{
		left.set(control.getY());
		if(mode.equals("left"))
			right.set(control.getY());	
	}
	
	
}
