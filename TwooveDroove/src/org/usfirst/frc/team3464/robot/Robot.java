package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static org.usfirst.frc.team3464.robot.Const.*;

public class Robot extends SampleRobot {
	
	Drive drive;
	CANTalon spin;
	BallMechanism intake;
Joystick l = new Joystick (1);
Joystick r = new Joystick (0);
    public Robot() {
        drive = new Drive(new Joystick(LEFT_STICK), new Joystick(RIGHT_STICK));
        //intake = new BallMechanism( "up", new Joystick(OTHER_STICK));
    	//spin = new CANTalon(2); 
    }
    public void autonomous() {
    	
    }

    public void operatorControl() {
        while(isOperatorControl() && isEnabled()){
        	drive.drive();
        	}
        	//spin.set(s.getRawButton(3) ? 0.3: 0);
        	/*SmartDashboard.putString("DB/String 0 ", "vroom vroom");
        	try{
        		Thread.sleep(10);
        	}catch(Exception e){
        		e.printStackTrace();
        	}*/
        }
    

    public void test() {
    	
    }
}
