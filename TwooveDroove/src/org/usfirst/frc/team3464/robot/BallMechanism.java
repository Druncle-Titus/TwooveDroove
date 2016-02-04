package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

import static org.usfirst.frc.team3464.robot.Const.*;


public class BallMechanism {
	String mode;	
	Joystick control;
	CANTalon left;
	CANTalon right;
	Servo s;
	public BallMechanism (Joystick c )
	{
		control = c;
		left = new CANTalon(LEFT_INTAKE_ID);
		right = new CANTalon(RIGHT_INTAKE_ID);
		s = new Servo(0);
	}
	
	
	public void run()
	{
		
		 if(control.getRawButton(1))
		   {
		    s.set(FINAL_POSITION);
		   }
		   else
		   {
			   s.set(INITIAL_POSITION);
		   }
			   
		  if(control.getY() < -1 * DEADZONE)
		   {
		   left.set(control.getY() * INTAKE_SPEED);
		   right.set(control.getY() *-1 *INTAKE_SPEED);
		   }
		   else if (control.getY() > DEADZONE)
		   {
			   left.set(control.getY() );
			   right.set(control.getY() * -1);
		   }
		   else
		   {
			   left.set(0);
			   right.set(0);
		   }}
	
	
}
