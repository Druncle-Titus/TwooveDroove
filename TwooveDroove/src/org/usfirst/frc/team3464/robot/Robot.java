package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.image.HSLImage;
import edu.wpi.first.wpilibj.image.NIVisionException;

import static org.usfirst.frc.team3464.robot.Const.*;

public class Robot extends SampleRobot {
	Drive drive;
	BallMechanism mech;
	Lift lift;
	Autonomous opt;
	SensorUtil sense;
	EncoderTest enc;
	CameraServer camServe = CameraServer.getInstance();
	USBCamera cam;
	//HSLImage image;	
	Joystick o = new Joystick(OTHER_STICK);
	
	//Network Stuff
	//NetworkTable table;
	//Aiming Values
	//public static double coordinateX;
	//public static double coordinateY;
	//public static double distanceToTarget;
	
    public Robot() 
    {
    	//drive = new Drive(new Joystick(LEFT_STICK), new Joystick(RIGHT_STICK));
    	//drive = new Drive(new CANTalon(1), new CANTalon(3),new Joystick(LEFT_STICK), new Joystick(RIGHT_STICK));
        mech = new BallMechanism(o);
        sense = new SensorUtil();
        lift = new Lift(o);
        opt = new Autonomous(drive, mech,sense);
        //enc = new EncoderTest(0, 1); 
        cam = new USBCamera();
        camServe.startAutomaticCapture(cam);
        /*try{
        	image = new HSLImage();
        }catch(NIVisionException e){
        	e.printStackTrace();
        }*/
        
        //NetworkTable.setServerMode();
        //NetworkTable.setTeam(3464);
        //table = NetworkTable.getTable("SmartDashboard");
        //table.initialize();
    	}
    
    public void updateDashboard(){
    	SmartDashboard.putString("DB/String 0", "X-Axis Acceleration: " + sense.accelerationX());
    	SmartDashboard.putString("DB/String 1", "Y-Axis Acceleration: " + sense.accelerationY());
    	SmartDashboard.putString("DB/String 2", "Z-Axis Acceleration: " + sense.accelerationZ());
    	SmartDashboard.putString("DB/String 3", "Gyro Angle: " + sense.getAngleOffset());
    	SmartDashboard.putString("DB/String 4", "Ultra Dist: " + sense.getDistance());
    }
    
    public void updateAimingValues(){
    	//coordinateX = table.getNumber("coordinateX", 0);
    	//coordinateY = table.getNumber("coordinateY", 0);
    	//distanceToTarget = table.getNumber("distanceToTarget", 0);
    }
    
    public void autonomous() {
    	//opt.allAuto(false);
    	//opt.defAuto();
    	mech.holdUp();
    	mech.autoLowShoot();
    	
    }

    public void operatorControl() {
        while(isOperatorControl() && isEnabled()){
        	/*cam.getImage(image.image);
        	try{
        		image.write("camImage.jpg");
        	}catch(NIVisionException e){
        		e.printStackTrace();
        	}*/
        	//drive.drive();
        	mech.run();
        	//enc.readEncoder((int)(o.getY()));
        	lift.move();
        	updateDashboard();
        }    
    }

    public void test() {
    	while(isTest() && isEnabled()){
    		//tal1.set(o.getY() * -1);
    		//tal2.set(o.getY());
    		//enc.readEncoder((int)(o.getY() * 100));
    		//s.set(j.getY());
    	}
    }
}