package org.usfirst.frc.team3464.robot;

import static org.usfirst.frc.team3464.robot.Const.*;

public class Autonomous {
	Drive drive;
	SensorUtil sense;
	BallMechanism shooter;
	public Autonomous(Drive d, BallMechanism b){
		drive = d;	
		shooter = b;
	}
	private void driveUpAuto()
	{
		shooter.holdUp();
		for(int i = 0; i < 300; ++i ) 
			drive.autoForward(AUTO_GENERIC * .75);
		drive.autoStop();
	}
	private void driveOverAuto()
	{
		shooter.holdUp();
		for(int i = 0; i < 300; ++i ) 
			drive.autoForward(AUTO_GENERIC * .75);
		for(int i = 0; i < 600; ++i ) 
			drive.autoForward(AUTO_GENERIC);
		drive.autoStop();
	}
	
	public void genAuto()
	{
		driveUpAuto();
	}
	public void defAuto() 
	{
		driveOverAuto();
	}	
	public void spyBot()
	{
		shooter.holdUp();
		for(int i = 0; i < 300; ++i ) 
			drive.autoForward(AUTO_GENERIC * .75);
		shooter.autoShoot();
	}
}