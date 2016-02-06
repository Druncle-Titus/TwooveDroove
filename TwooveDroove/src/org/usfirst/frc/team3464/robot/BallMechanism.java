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
	CANTalon window;
	Servo s;
	public BallMechanism (Joystick c )
	{
		control = c;
		left = new CANTalon(LEFT_INTAKE_ID);
		right = new CANTalon(RIGHT_INTAKE_ID);
		s = new Servo(0);
		window = new CANTalon(9);
	}
	
	
	public void run()
	{
		s.set(control.getRawButton(SERVO_EXTENDER) ? FINAL_POSITION : INITIAL_POSITION);
		if(control.getY() > DEADZONE)
		   {
			  left.set(control.getY() *-1*  INTAKE_SPEED);
			  right.set(control.getY()  *INTAKE_SPEED);
		   }
		else if (control.getY() < -1 * DEADZONE)
		   {
			   left.set(control.getY() * -1);
			   right.set(control.getY());
		   }
		else
		   {
			   left.set(0);
			   right.set(0);
		   }
		  window.set(control.getRawButton(WINDOW_UP) ? .3 : (control.getRawButton(WINDOW_DOWN) ? -.3 : 0) );
	}
	public void autoShoot()
	{
		for(int i = 0; i < 1000; ++i)
		{
		left.set(1);
		right.set(-1);
		}
		left.set(0);
		right.set(0);
		for(int i = 0; i < 1000; ++i)
		{
			s.set(FINAL_POSITION);
		}				
		s.set(INITIAL_POSITION);
	}
}