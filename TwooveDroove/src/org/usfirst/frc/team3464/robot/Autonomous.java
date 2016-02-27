package org.usfirst.frc.team3464.robot;

import static org.usfirst.frc.team3464.robot.Const.*;

public class Autonomous {
	Drive drive;
	SensorUtil sense;
	BallMechanism shooter;
	public Autonomous(Drive d, BallMechanism b, SensorUtil ut){
		drive = d;	
		shooter = b;
		sense = ut;
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
		for(int i = 0; i < 600; ++i) 
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
		//for(int i = 0; i < 300; ++i ) 
		while(sense.getDistance() > 50 && sense.validRange() )
		{
			drive.autoForward(AUTO_GENERIC * .75);
		}
		shooter.autoLowShoot();
	}
	private void orient(double a)
	{
		double angle = sense.updateAngle();
		if(angle - a < 0) {
			while (sense.updateAngle() - a < 1)
		{
				drive.autoLeft();
		}
			}
		else if (angle - a > 0)
		{
			while (sense.updateAngle() - a > -1)
				drive.autoRight();
		}
		drive.autoStop();
		}
	public void allAuto(boolean high)
	{
		defAuto();
		orient(90);
		while(sense.getDistance() > 28 && sense.validRange() )
		{
			drive.autoForward(AUTO_GENERIC * .75);
		}
		drive.autoStop();
		orient(0);
		while(sense.getDistance() > 18 && sense.validRange() )
		{
			drive.autoForward(AUTO_GENERIC * .75);
		}
		drive.autoStop();
		orient(-90);
		while(sense.getDistance() > (high ? 56 : 15) && sense.validRange() )
		{
			drive.autoForward(AUTO_GENERIC * .75);
		}
		drive.autoStop();
		if(high)
			shooter.autoShoot();
		else
			shooter.autoLowShoot();
	}
}