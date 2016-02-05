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
    public Robot() {
        drive = new Drive(new Joystick(LEFT_STICK), new Joystick(RIGHT_STICK));
        mech = new BallMechanism(new Joystick(OTHER_STICK));
        sense = new SensorUtil();
        lift = new Lift();
        opt =new Autonomous(drive, sense);
    }
    
    public void updateDashboard(){
    	SmartDashboard.putString("DB/String ", "");
    }
    
    public void autonomous() {
    	
    }

    public void operatorControl() {
        while(isOperatorControl() && isEnabled()){
        	drive.drive();
        	mech.run();
        	lift.move();
        	updateDashboard();
        	}
        }
    

    public void test() {
    	while(isTest() && isEnabled()){
    		lift.move();
    	}
    }
}
