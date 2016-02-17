package org.usfirst.frc.team3464.robot;

public class Const {
	//Controls drive motor speed
	public static final float SPEED_MULTIPLIER = .5f;
	//Auto drive constant
	public static final float AUTO_GENERIC = .5f;
	// intake and shooting constants 
	public static final float  INTAKE_SPEED = .4f;
	
	//servo positions constants
	public static final float  FINAL_POSITION = .3f;
	public static final float  INITIAL_POSITION = 1;
	
	//artificial deadzone
	public static final float  DEADZONE = .15f;	
	//Device IDs for drive motors
	/*
	 * Front Left = 1
	 * Back Left = 2
	 * Front Right = 3
	 * Back Right = 4
	 */
	public static final int[] LEFT_DRIVE_ID = {6, 2};
	public static final int[] RIGHT_DRIVE_ID = {3, 4};
	
	//Mechanism IDs
	public static final int LEFT_INTAKE_ID = 1;
	public static final int RIGHT_INTAKE_ID = 8;
	public static final int MOVE1_ID = 1;
	public static final int MOVE2_ID = 2;
	public static final int EXTEND_ID = 3;
	public static final int WINDOW_ID = 1;

	
	//Joystick IDs
	public static final int LEFT_STICK = 0;
	public static final int RIGHT_STICK = 1;
	public static final int OTHER_STICK = 2;
	
	//Joystick button identifications
	public static final int SERVO_EXTENDER = 1;
	public static final int WINDOW_UP = 12;
	public static final int WINDOW_DOWN = 11;
	public static final int	RETRACT_JOY = 4;
	public static final int EXTEND_JOY = 3;	
}
