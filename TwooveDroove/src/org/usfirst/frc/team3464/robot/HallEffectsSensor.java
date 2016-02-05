package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.PWM;

public class HallEffectsSensor {
	PWM pwm;
	
	public HallEffectsSensor(int channel){
		pwm = new PWM(channel);
	}
	
	
}
