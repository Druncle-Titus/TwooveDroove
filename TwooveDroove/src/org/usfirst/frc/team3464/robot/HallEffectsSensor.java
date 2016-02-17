package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SensorBase;

public class HallEffectsSensor extends SensorBase{
	PWM pwm;
	
	public HallEffectsSensor(int channel){
		super();
		pwm = new PWM(channel);
	}
	
	public void read(){
		
	}
	
	
}
