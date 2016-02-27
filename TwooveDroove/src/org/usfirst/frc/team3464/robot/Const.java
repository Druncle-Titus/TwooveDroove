package org.usfirst.frc.team3464.robot;

public class Const {
	//Controls drive motor speed
	public static final float SPEED_MULTIPLIER = 1;
	//Auto drive constant
	public static final float AUTO_GENERIC = 1;
	// intake and shooting constants 
	public static final float  INTAKE_SPEED = .6f;
	//extend speed
	public static final float  EXTEND_SPEED = .3f;
	
	//servo positions constants
	public static final float  FINAL_POSITION = 1;
	public static final float  INITIAL_POSITION = 0;
	
	//artificial deadzone
	public static final float  DEADZONE = .15f;	
	//Device IDs for drive motors
	public static final int[] LEFT_DRIVE_ID = {11, 10};
	public static final int[] RIGHT_DRIVE_ID = {4, 3};
	
	//Mechanism IDs
	public static final int LEFT_INTAKE_ID = 2;
	public static final int RIGHT_INTAKE_ID = 4;
	public static final int MOVE1_ID = 7;
	public static final int MOVE2_ID = 2;
	public static final int LIFT_ID = 5;
	public static final int EXTEND_ID = 6;


	//Joystick IDs
	public static final int LEFT_STICK = 0;
	public static final int RIGHT_STICK = 1;
	public static final int OTHER_STICK = 2;
	
	//Joystick button identifications
	public static final int SERVO_EXTENDER = 2;
	public static final int VEX_UP = 3;
	public static final int VEX_DOWN = 4;
	public static final int	RETRACT_JOY = 8;
	public static final int EXTEND_JOY = 7;	
	public static final int INTAKE = 11;
	public static final int SHOOT = 1;
	public static final int ADJUST = 12;
	public static final int ANGLE_UP = 10;
	public static final int ANGLE_DOWN = 9;


}
