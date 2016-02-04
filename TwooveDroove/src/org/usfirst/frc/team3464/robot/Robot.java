package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static org.usfirst.frc.team3464.robot.Const.*;

public class Robot extends SampleRobot {
	//optimum range for vex sensor is 2-18 
	Drive drive;
	CANTalon spin;
	BallMechanism mech;
	Lift lift;
	//Joystick l = new Joystick (1);
	//Joystick r = new Joystick (0);

	SensorUtil sense;
    public Robot() {
     //   drive = new Drive(new Joystick(LEFT_STICK), new Joystick(RIGHT_STICK));
        //mech = new BallMechanism( "up", new Joystick(OTHER_STICK));
    	//spin = new CANTalon(2); 
        sense = new SensorUtil();
        lift = new Lift();
    }
    public void autonomous() {
    	
    }

    public void operatorControl() {
        while(isOperatorControl() && isEnabled()){
        //	drive.drive();
        	}
        }
    

    public void test() {
    	while(isTest() && isEnabled()){
    		lift.extend();
    	}
    }
}
