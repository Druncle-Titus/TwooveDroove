package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;


import static org.usfirst.frc.team3464.robot.Const.*;

public class Robot extends SampleRobot {
	Drive drive;
	BallMechanism mech;
	Lift lift;
	Autonomous opt;
	SensorUtil sense;
	EncoderTest enc;
	//CameraServer cam = CameraServer.getInstance();
	Joystick o = new Joystick(OTHER_STICK);
    public Robot() 
    {
    	drive = new Drive(new Joystick(LEFT_STICK), new Joystick(RIGHT_STICK));
    	//drive = new Drive(new CANTalon(1), new CANTalon(3),new Joystick(LEFT_STICK), new Joystick(RIGHT_STICK));
       mech = new BallMechanism(o);
        //sense = new SensorUtil();
       lift = new Lift(o);
        opt = new Autonomous(drive, mech);
        //enc = new EncoderTest(0, 1); 
    	}
    
    public void updateDashboard(){
    	//SmartDashboard.putString("DB/String 0", "X-Axis Acceleration: " + sense.accelerationX());
    	//SmartDashboard.putString("DB/String 1", "Y-Axis Acceleration: " + sense.accelerationY());
    	//SmartDashboard.putString("DB/String 2", "Z-Axis Acceleration: " + sense.accelerationZ());
    	//SmartDashboard.putString("DB/String 3", "Gyro Angle: " + sense.getAngleOffset());
    	//SmartDashboard.putString("DB/String 4", "Ultrasonic Distance: " + sense.getDistance());
    }
    
    public void autonomous() {
    	//opt.defAuto();
    	mech.holdUp();
    	mech.autoShoot();
    }

    public void operatorControl() {
    //	cam.startAutomaticCapture();
        while(isOperatorControl() && isEnabled()){
        	//fL.set(o.getY());
        	drive.drive();
        	mech.run();
        	//enc.readEncoder();
        	lift.move();
        	//updateDashboard();
        }    
    }

    public void test() {
    	while(isTest() && isEnabled()){
    		//tal1.set(o.getY() * -1);
    		//tal2.set(o.getY());
    		//enc.readEncoder((int)(o.getY() * 100));
    		//s.set(j.getY());
    	}
    }
}