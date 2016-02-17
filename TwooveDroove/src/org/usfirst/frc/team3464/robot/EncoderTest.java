package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.text.DecimalFormat;

import static org.usfirst.frc.team3464.robot.Const.*;

public class EncoderTest {
	Encoder e;
	DecimalFormat fmt;
	CANTalon encoded;
	Joystick o;
	PIDController control;
	
	double targetAngle;
	
	public EncoderTest(){
		encoded = new CANTalon(1);
		e = null;
		o = new Joystick(OTHER_STICK);
		control = new PIDController(1, 0, 0, encoded, encoded);
		control.enable();
		
		targetAngle = 0;
	}
	
	public EncoderTest(int first, int sec){
		encoded = new CANTalon(1);
		e = new Encoder(first, sec);
		fmt = new DecimalFormat("0.00");
		o = new Joystick(OTHER_STICK);
		
		targetAngle = 0;
		
		e.setDistancePerPulse(1.0 / 1000);
	}
	
	public void readEncoder(){
		if(e == null){
			//adjustAngle();
			SmartDashboard.putString("DB/String 0", "Motor Speed: " + o.getY());
			SmartDashboard.putString("DB/String 1", "Encoder Position: " + encoded.getEncPosition());
			SmartDashboard.putString("DB/String 2", "Encoder Velocity: " + encoded.getEncVelocity());
		}
		else{
			//encoded.set(o.getY());
			SmartDashboard.putString("DB/String 0", "Motor Speed: " + o.getY());
			SmartDashboard.putString("DB/String 1", "Encoder Rate: " + fmt.format(e.getRate()));
		}
	}
	
	public void adjustAngle(){
		targetAngle = ((-30 * o.getThrottle()) + 30);
		control.setSetpoint(targetAngle);
		SmartDashboard.putString("DB/String 3", "Target Angle: " + targetAngle);
		
	}
}
