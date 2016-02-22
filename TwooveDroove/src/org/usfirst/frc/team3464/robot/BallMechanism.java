package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

import static org.usfirst.frc.team3464.robot.Const.*;


public class BallMechanism {
	Joystick control;
	CANTalon left;
	CANTalon right;
	CANTalon mover;
	Servo s;
	public BallMechanism (Joystick c)
	{
		control = c;
		left = new CANTalon(LEFT_INTAKE_ID);
		right = new CANTalon(RIGHT_INTAKE_ID);
		s = new Servo(0);
		mover = new CANTalon(LIFT_ID);
	}
	
	
	public void run()
	{
		s.set(control.getRawButton(SERVO_EXTENDER) ? FINAL_POSITION : INITIAL_POSITION);
		if(control.getRawButton(INTAKE))
		   {
			  left.set(INTAKE_SPEED);
			  right.set(INTAKE_SPEED);
		   }
		else if (control.getRawButton(SHOOT))
		   {
			   left.set(-1);
			   right.set(-1);
		   }
		else if (control.getRawButton(ADJUST))
		{
			left.set(INTAKE_SPEED*-.25);
			 right.set(INTAKE_SPEED*.25);
		}
		else
		   {
			   left.set(0);
			   right.set(0);
		   }
	  mover.set(control.getRawButton(VEX_UP) ? .45 : (control.getRawButton(VEX_DOWN) ? 0 : .2) );
	  //SmartDashboard.putString("DB/String 4", window.get() + " ");
	}
	public void runAlternate(CANTalon tal1, CANTalon tal2){
		tal1.set(control.getY());
    	tal2.set(-1 *control.getY());
	}
	public void autoShoot()
	{
		for(int i = 0; i < 1500; ++i)
		{
			left.set(-1);
			right.set(-1);
		}
		
		for(int i = 0; i < 1000000; ++i)
		{
			s.set(FINAL_POSITION);
		}				
		s.set(INITIAL_POSITION); 
		left.set(0);
		right.set(0);
	}
	public void holdUp()
	{
		for(int i = 0; i < 10000; ++i)
		{
			s.set(INITIAL_POSITION);
		}		
		for(int i = 0; i < 1000; ++i)
		{
			mover.set(.45);
		}
		mover.set(.2);
		try
		{
			Thread.sleep(500);
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
	}
}