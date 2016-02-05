package org.usfirst.frc.team3464.robot;

import static org.usfirst.frc.team3464.robot.Const.AUTO_GENERIC;

public class Autonomous {
	Drive drive;
	SensorUtil sense;
	
	public Autonomous(Drive d, SensorUtil ut){
		drive = d;
		sense = ut;
	}
	private void driveUpAuto()
	{
		for(int i = 0; i < 500; ++i )
			drive.autoForward();
		drive.autoStop();
	}
	private void driveOverAuto()
	{
		for(int i = 0; i < 1000; ++i ) 
			drive.autoForward();
		drive.autoStop();
	}
	public void orient()
	{
		
	}
}