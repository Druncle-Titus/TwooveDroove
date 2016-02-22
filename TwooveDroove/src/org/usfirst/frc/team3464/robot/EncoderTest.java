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
		encoded = new CANTalon(2);
		encoded.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		encoded.enableZeroSensorPositionOnIndex(true, true);
		e = null;
		o = new Joystick(OTHER_STICK);
		control = new PIDController(0.0001, 0.001, 0, encoded, encoded);
		control.enable();
		
		targetAngle = 0;
	}
	
	public EncoderTest(int first, int sec){
		encoded = new CANTalon(2);
		e = new Encoder(first, sec);
		e.reset();
		fmt = new DecimalFormat("0.00");
		o = new Joystick(OTHER_STICK);
		//encoded.setInverted(true);
		/*control = new PIDController(0.0001, 0.001, 0, e, encoded);
		control.enable();
		control.setPercentTolerance(10.0);*/
		targetAngle = 0;
		
		e.setDistancePerPulse(1.0 / 1000);
	}
	
	public void readEncoder(int target){
/*		if(e == null){
			//encoded.set(o.getY());
			adjustAngle();
			SmartDashboard.putString("DB/String 0", "Motor Speed: " + o.getY());
			SmartDashboard.putString("DB/String 1", "Encoder Position: " + encoded.getEncPosition());
			SmartDashboard.putString("DB/String 2", "Encoder Velocity: " + encoded.getEncVelocity());
			SmartDashboard.putString("DB/String 3", "Input Value:" + encoded.pidGet());
		}
		else{
			//encoded.set(o.getY());
			adjustAngle();
			SmartDashboard.putString("DB/String 0", "Motor Speed: " + encoded.get());
			SmartDashboard.putString("DB/String 1", "Encoder Position :" + e.get());
			SmartDashboard.putString("DB/String 2", "Encoder Rate: " + fmt.format(e.getRate()));
			SmartDashboard.putString("DB/String 3", "Input Value:" + e.pidGet());
		}
		*/
		if(Math.abs(target - e.get()) > 10)
		{
			if(e.get() < target)
				encoded.set(-0.1);
			else
				encoded.set(0.1);
			//}
			/*else if (Math.abs((e.get() - target)/target) < 0.1)
			{
				if(e.get() > target)
					encoded.set(-0.1);
				else
					encoded.set(-0.1);
			}*/
		}
		else
			encoded.set(0);
		SmartDashboard.putString("DB/String 1", "Encoder Position :" + e.get());
		SmartDashboard.putString("DB/String 2", "Encoder Rate: " + fmt.format(e.getRate())); 
		SmartDashboard.putString("DB/String 0", "Target: " + (int)(o.getY() * 100)); 

	}
	
	public void adjustAngle(){
		targetAngle = ((-30 * o.getThrottle()) + 30);
		control.setSetpoint(targetAngle);
		SmartDashboard.putString("DB/String 4", "Target Angle: " + targetAngle);
		
	}
}
