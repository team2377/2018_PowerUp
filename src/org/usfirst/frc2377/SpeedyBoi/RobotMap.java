// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2377.SpeedyBoi;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SD540;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainSubsystemLeftSpeedyBoi;
    public static SpeedController driveTrainSubsystemRightSpeedyBoi;
    public static RobotDrive driveTrainSubsystemRobotDrive21;
    public static Encoder driveEncoder;
    public static final double encoderScaleFactor = 20.0683; 
    public static ADXRS450_Gyro driveADXR450Gyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static void init() {
    	driveADXR450Gyro = new ADXRS450_Gyro();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainSubsystemLeftSpeedyBoi = new Talon(1);
        LiveWindow.addActuator("DriveTrainSubsystem", "LeftSpeedyBoi", (Talon) driveTrainSubsystemLeftSpeedyBoi);
        driveTrainSubsystemLeftSpeedyBoi.setInverted(true);
        driveTrainSubsystemRightSpeedyBoi = new Talon(0);
        LiveWindow.addActuator("DriveTrainSubsystem", "RightSpeedyBoi", (Talon) driveTrainSubsystemRightSpeedyBoi);
        driveTrainSubsystemRightSpeedyBoi.setInverted(true);
        driveTrainSubsystemRobotDrive21 = new RobotDrive(driveTrainSubsystemLeftSpeedyBoi, driveTrainSubsystemRightSpeedyBoi);
        
        driveTrainSubsystemRobotDrive21.setSafetyEnabled(true);
        driveTrainSubsystemRobotDrive21.setExpiration(0.1);
        driveTrainSubsystemRobotDrive21.setSensitivity(0.5);
        driveTrainSubsystemRobotDrive21.setMaxOutput(1.0);
        driveTrainSubsystemRobotDrive21.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveEncoder = new Encoder(0 , 1 , false, EncodingType.k4X);
        driveEncoder.setDistancePerPulse(.0523598776*.945);
        driveEncoder.setPIDSourceType(PIDSourceType.kRate);
    }
}
