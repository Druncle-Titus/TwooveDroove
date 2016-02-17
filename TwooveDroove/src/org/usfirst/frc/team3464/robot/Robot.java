package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static org.usfirst.frc.team3464.robot.Const.*;

public class Robot extends SampleRobot {
	Drive drive;
	BallMechanism mech;
	Lift lift;
	Autonomous opt;
	SensorUtil sense;
	EncoderTest enc;
	Joystick o = new Joystick(OTHER_STICK);
	//CANTalon tal = new CANTalon(6);
	CANTalon extend1,extend2;
	CANTalon rm;
    public Robot() {
    	//lm = new CANTalon(2);
    	
        //drive = new Drive(lm, rm, new Joystick(LEFT_STICK), new Joystick(RIGHT_STICK));
        //mech = new BallMechanism(o);
        //sense = new SensorUtil();
        lift = new Lift(o);
     //   opt = new Autonomous(drive, sense, mech);
        //enc = new EncoderTest();
    }
    
    public void updateDashboard(){
    	SmartDashboard.putString("DB/String 0", "X-Axis Acceleration: " + sense.accelerationX());
    	SmartDashboard.putString("DB/String 1", "Y-Axis Acceleration: " + sense.accelerationY());
    	SmartDashboard.putString("DB/String 2", "Z-Axis Acceleration: " + sense.accelerationZ());
    	SmartDashboard.putString("DB/String 3", "Gyro Angle: " + sense.getAngleOffset());
    	//SmartDashboard.putString("DB/String 4", "Ultrasonic Distance: " + sense.getDistance());
    	


    }
    
    public void autonomous() {
    	
    }

    public void operatorControl() {
        while(isOperatorControl() && isEnabled()){
        	
        	//drive.driveAlternate();
        	//mech.run();
        	//enc.readEncoder();
        	lift.move();
        	//updateDashboard();
        	
        }    
    }
    

    public void test() {
    	while(isTest() && isEnabled()){
    		//enc.readEncoder();
    		//SmartDashboard.putString("DB/String 0", "Throttle Pos: " + o.getThrottle());
    		//SmartDashboard.putString("DB/String 0", "Mode: " + lm.getControlMode());
    	}
    }
}