package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import java.text.DecimalFormat;


import static org.usfirst.frc.team3464.robot.Const.*;

public class Robot extends SampleRobot {
	Drive drive;
	BallMechanism mech;
	Lift lift;
	Autonomous opt;
	SensorUtil sense;
	CANTalon encoded;
	Encoder e;
	DecimalFormat fmt;
	Joystick o = new Joystick(OTHER_STICK);
    public Robot() {
        drive = new Drive(new Joystick(LEFT_STICK), new Joystick(RIGHT_STICK));
        mech = new BallMechanism(o);
        //sense = new SensorUtil();
        lift = new Lift(o);
        opt = new Autonomous(drive, sense, mech);
        e = new Encoder(1,2);
        fmt = new DecimalFormat("0.00");
        encoded = new CANTalon(1);
        e.setDistancePerPulse(1.0/1000);
    }
    
    public void updateDashboard(){
    	/*SmartDashboard.putString("DB/String 0", "X-Axis Acceleration: " + sense.accelerationX());
    	SmartDashboard.putString("DB/String 1", "Y-Axis Acceleration: " + sense.accelerationY());
    	SmartDashboard.putString("DB/String 2", "Z-Axis Acceleration: " + sense.accelerationZ());
    	SmartDashboard.putString("DB/String 3", "Gyro Angle: " + sense.getAngleOffset());
    	SmartDashboard.putString("DB/String 4", "Ultrasonic Distance: " + sense.getDistance());*/
    }
    
    public void autonomous() {
    	
    }

    public void operatorControl() {
        while(isOperatorControl() && isEnabled()){
        	
        	//drive.drive();
        	//mech.run();
        	//lift.move();
        	//updateDashboard();
        	encoded.set(o.getY());
        	SmartDashboard.putString("DB/String 0", o.getY() + " ");
        	SmartDashboard.putString("DB/String 1", fmt.format(e.getRate()));
        	}
        }
    

    public void test() {
    	while(isTest() && isEnabled()){
    		lift.move();
    	}
    }
}
