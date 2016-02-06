package org.usfirst.frc.team3464.robot;

import static org.usfirst.frc.team3464.robot.Const.*;

public class Autonomous {
	Drive drive;
	SensorUtil sense;
	BallMechanism shooter;
	public Autonomous(Drive d, SensorUtil ut, BallMechanism b){
		drive = d;
		sense = ut;
		shooter = b;
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
	private void orient(double a)
	{
		double angle = sense.updateAngle();
		if(angle - a < 0)
		{
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
	public void genAuto()
	{
		driveUpAuto();
	}
	public void defAuto() {
		driveOverAuto();
		orient(0);}
	public void lowAuto() 
	{
		defAuto();
		orient(90);
		while(sense.getDistance() > 20 && sense.validRange() )
		{
			drive.autoForward();
		}
		drive.autoStop();
		orient(0);
		while(sense.getDistance() > 20 && sense.validRange() )
		{
			drive.autoForward();
		}
		drive.autoStop();
		orient(-90);
		while(sense.getDistance() > 10 && sense.validRange() )
		{
			drive.autoForward();
		}
		drive.autoStop();
		shooter.autoShoot();
	}
	public void spyBox()
	{
		while(sense.getDistance() > 20 && sense.validRange() )
		{
			drive.autoForward();
		}
		drive.autoStop();
		shooter.autoShoot();
	}
}