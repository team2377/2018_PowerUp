/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2377.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
// "You miss 100% of the shots you don't take
// --Wayne Gretsky
// --Micheal Scott
public class RobotMap {
	// PID
	public static AnalogInput m_potentiometer;
	// public static SpeedController m_elevatorMotor;

	// 6 wheel drive
	public static WPI_TalonSRX driveSystemleftFrontMotor;
	public static WPI_TalonSRX driveSystemleftRearMotor;
	public static WPI_TalonSRX driveSystemrightFrontMotor;
	public static WPI_TalonSRX driveSystemrightRearMotor;
	public static RobotDrive driveSystemRobotDrive41;
	public static WPI_TalonSRX driveSystemleftMiddleMotor;
	public static WPI_TalonSRX driveSystemrightMiddleMotor;
	public static RobotDrive driveSystemRobotDrive21;

	// gripper and arm rotator drive
	public static WPI_VictorSPX rightShooterWheelMotor;
	public static WPI_VictorSPX leftShooterWheelMotor;
	public static WPI_VictorSPX armMotor;
	public static RobotDrive driveSubsystemShooterWheels21;
	public static RobotDrive driveSubsystemRotateArm;

	// elevator drive subsystem
	public static WPI_VictorSPX elevatorMotor;
	public static RobotDrive driveSubsystemMoveElevator;

	// climber drive subsystem
	public static WPI_TalonSRX climberMotor;
	public static RobotDrive driveSubsystemMoveClimber;

	// sensors
	public static Encoder driveEncoder;
	// public static Encoder driveEncoder2;
	// FIXME
	public static final double encoderScaleFactor = 20.0683;
	public static ADXRS450_Gyro driveADXR450Gyro;
	public static Solenoid openCloseGripper;

	public static Solenoid switchGear;

	public static DigitalInput gripperDeployedLimitSwitch; // gripper
	public static DigitalInput gripperStoredLimitSwitch; // gripper
	public static DigitalInput elevatorTopLimitSwitch; // elevator
	public static DigitalInput elevatorBottomLimitSwitch; // elevator

	// buttons
	public static final int CONTROLLER_A = 1;// A
	public static final int CONTROLLER_B = 2;// B
	public static final int CONTROLLER_X = 3;// X
	public static final int CONTROLLER_Y = 4;// Y
	public static final int MANIPULATOR_LEFTBUMPER = 5;// left bump
	public static final int MANIPULATOR_RIGHTBUMPER = 6;// right bump
	public static final int DRIVE_LEFTBUMPER = 2;// left bump
	public static final int DRIVE_RIGHTBUMPER = 2;// right bump

	// joysticks
	public static final int AXIS_D_LEFTDRIVE = 1;// left joystick left side drive
	public static final int AXIS_D_RIGHTDRIVE = 5;// right joystick right side drive
	public static final int AXIS_M_RIGHTDRIVE = 5;// right joystick elevator
	public static final int AXIS_M_LEFTTRIGGER_INTAKE = 2;// left trigger
	public static final int AXIS_M_RIGHTTRIGGER_OUTTAKE = 3;// right trigger

	public static final int AXIS_D_LEFTTRIGGER_HALFSPEED = 1;// left trigger

	// CAN IDs
	public static final int FRONTLEFT = 1;
	public static final int FRONTRIGHT = 4;
	public static final int MIDDLELEFT = 2;
	public static final int MIDDLERIGHT = 5;
	public static final int REARLEFT = 3;
	public static final int REARRIGHT = 6;
	public static final int ARM = 7;
	public static final int CLIMBER = 11;
	public static final int ELEVATOR = 10;
	public static final int LEFTSHOOTER = 8;
	public static final int RIGHTSHOOTER = 9;

	// PID
	public static void init() {
		// m_potentiometer = new AnalogInput();
		// CAN IDs
		// 1 to 6 is drive base
		// 7 and 8 is shooter
		// 9 is arm rotator
		driveADXR450Gyro = new ADXRS450_Gyro();
		driveSystemleftFrontMotor = new WPI_TalonSRX(FRONTLEFT);
		LiveWindow.addActuator("driveSystem", "leftFrontMotor", (WPI_TalonSRX) driveSystemleftFrontMotor);
		driveSystemleftFrontMotor.setInverted(false);

		driveSystemleftRearMotor = new WPI_TalonSRX(REARLEFT);
		LiveWindow.addActuator("driveSystem", "leftRearMotor", (WPI_TalonSRX) driveSystemleftRearMotor);
		driveSystemleftRearMotor.setInverted(false);

		driveSystemrightFrontMotor = new WPI_TalonSRX(FRONTRIGHT);
		LiveWindow.addActuator("driveSystem", "rightFrontMotor", (WPI_TalonSRX) driveSystemrightFrontMotor);
		driveSystemrightFrontMotor.setInverted(true);

		driveSystemrightRearMotor = new WPI_TalonSRX(REARRIGHT);
		LiveWindow.addActuator("driveSystem", "rightRearMotor", (WPI_TalonSRX) driveSystemrightRearMotor);
		driveSystemrightRearMotor.setInverted(true);

		driveSystemRobotDrive41 = new RobotDrive(driveSystemleftFrontMotor, driveSystemleftRearMotor,
				driveSystemrightFrontMotor, driveSystemrightRearMotor);

		driveSystemRobotDrive41.setSafetyEnabled(true);
		driveSystemRobotDrive41.setExpiration(0.1);
		driveSystemRobotDrive41.setSensitivity(0.5);
		driveSystemRobotDrive41.setMaxOutput(1.0);
		driveSystemRobotDrive41.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		driveSystemRobotDrive41.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

		driveSystemleftMiddleMotor = new WPI_TalonSRX(MIDDLELEFT);
		LiveWindow.addActuator("driveSystem", "leftMiddleMotor", (WPI_TalonSRX) driveSystemleftMiddleMotor);
		driveSystemleftMiddleMotor.setInverted(false);

		driveSystemrightMiddleMotor = new WPI_TalonSRX(MIDDLERIGHT);
		LiveWindow.addActuator("driveSystem", "rightMiddleMotor", (WPI_TalonSRX) driveSystemrightMiddleMotor);
		driveSystemrightMiddleMotor.setInverted(false);

		driveSystemRobotDrive21 = new RobotDrive(driveSystemleftMiddleMotor, driveSystemrightMiddleMotor);
		driveSystemRobotDrive21.setSafetyEnabled(true);
		driveSystemRobotDrive21.setExpiration(0.1);
		driveSystemRobotDrive21.setSensitivity(0.5);
		driveSystemRobotDrive21.setMaxOutput(1.0);
		// driveSystemRobotDrive21.setInvertedMotor(RobotDrive.MotorType.kRearRight,
		// true);

		// wheel shooter and rotator
		rightShooterWheelMotor = new WPI_VictorSPX(RIGHTSHOOTER);
		LiveWindow.addActuator("driveShooterSubsystem", "rightMotor", (WPI_VictorSPX) rightShooterWheelMotor);
		rightShooterWheelMotor.setInverted(false);
		leftShooterWheelMotor = new WPI_VictorSPX(LEFTSHOOTER);
		LiveWindow.addActuator("driveShooterSubsystem", "leftMotor", (WPI_VictorSPX) leftShooterWheelMotor);
		leftShooterWheelMotor.setInverted(true);
		driveSubsystemShooterWheels21 = new RobotDrive(leftShooterWheelMotor, rightShooterWheelMotor);
		driveSubsystemShooterWheels21.setSafetyEnabled(true);
		driveSubsystemShooterWheels21.setExpiration(0.1);
		driveSubsystemShooterWheels21.setSensitivity(0.5);
		driveSubsystemShooterWheels21.setMaxOutput(1.0);
		// driveSubsystemShooterWheels21.setInvertedMotor(RobotDrive.MotorType.kRearLeft,
		// true);

		// deploy and retract
		armMotor = new WPI_VictorSPX(ARM);
		LiveWindow.addActuator("driveSubsystemrotatearm", "arm", (WPI_VictorSPX) armMotor);
		armMotor.setInverted(false);

		// climber
		climberMotor = new WPI_TalonSRX(CLIMBER);
		LiveWindow.addActuator("driveSubsystemMoveClimber", "climber", (WPI_TalonSRX) climberMotor);
		climberMotor.setInverted(true);

		elevatorMotor = new WPI_VictorSPX(ELEVATOR);
		LiveWindow.addActuator("driveSubsystemMoveElevator", "elevator", (WPI_VictorSPX) elevatorMotor);
		elevatorMotor.setInverted(false);

		// FIXME check solenoid requirements
		openCloseGripper = new Solenoid(0, 5);

		switchGear = new Solenoid(0, 4);
		// TODO Check Ports off limit switches
		// limit switches
		elevatorTopLimitSwitch = new DigitalInput(0);
		elevatorBottomLimitSwitch = new DigitalInput(1);
		gripperDeployedLimitSwitch = new DigitalInput(3);
		gripperStoredLimitSwitch = new DigitalInput(2);

		// encoder1
		driveEncoder = new Encoder(4, 5, false, EncodingType.k4X);
		// driveEncoder.setDistancePerPulse(.0523598776*.945);// mobo encoder factor
		// driveEncoder.setDistancePerPulse(.034906585);// encoder factor
		driveEncoder.setDistancePerPulse(.0523598776);// encoder factor

		driveEncoder.setPIDSourceType(PIDSourceType.kRate);
		// encoder2
		// driveEncoder2 = new Encoder(6 , 7 , false, EncodingType.k4X);
		//
		// driveEncoder2.setDistancePerPulse(.034906585);//encoder factor
		// driveEncoder2.setPIDSourceType(PIDSourceType.kRate);
		// FIXME

	}
}
