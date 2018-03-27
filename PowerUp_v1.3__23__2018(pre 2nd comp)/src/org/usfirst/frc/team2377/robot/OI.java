/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2377.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick driveJoystick;
	public Joystick driveJoystick2;
	public Joystick manipulatorJoystick;
	public JoystickButton extendClimber;
	public JoystickButton raiseClimber;
	// FIXME added for 2 cube
	public JoystickButton rotateArms;

	public JoystickButton deployGripper;
	public JoystickButton openGripper;
	public JoystickButton closeGripper;
	public JoystickButton lowerElevator;

	public JoystickButton leftTrigger;
	public JoystickButton rightTrigger;
	public JoystickButton leftDrive;
	public JoystickButton rightDrive;
	public JoystickButton gearLeftTrigger;
	public JoystickButton gearRightTrigger;

	public JoystickButton halfSpeed;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		driveJoystick = new Joystick(0);
		manipulatorJoystick = new Joystick(1);
		driveJoystick2 = new Joystick(2);

		raiseClimber = new JoystickButton(manipulatorJoystick, RobotMap.CONTROLLER_A);// A
		lowerElevator = new JoystickButton(manipulatorJoystick, RobotMap.CONTROLLER_B);// B
		extendClimber = new JoystickButton(manipulatorJoystick, RobotMap.CONTROLLER_Y);// Y
		// FIXME added
		rotateArms = new JoystickButton(manipulatorJoystick, RobotMap.CONTROLLER_X);// X

		openGripper = new JoystickButton(manipulatorJoystick, RobotMap.MANIPULATOR_LEFTBUMPER);// manipulator LeftBumper
		closeGripper = new JoystickButton(manipulatorJoystick, RobotMap.MANIPULATOR_RIGHTBUMPER);// manipulator
																									// RightBumper
		gearLeftTrigger = new JoystickButton(driveJoystick, 2);// drive RightBumper
		gearRightTrigger = new JoystickButton(driveJoystick2, 2);// drive RightBumper

		leftTrigger = new JoystickButton(manipulatorJoystick, RobotMap.AXIS_M_LEFTTRIGGER_INTAKE);
		rightTrigger = new JoystickButton(manipulatorJoystick, RobotMap.AXIS_M_RIGHTTRIGGER_OUTTAKE);
		leftDrive = new JoystickButton(manipulatorJoystick, RobotMap.AXIS_D_LEFTDRIVE);
		rightDrive = new JoystickButton(manipulatorJoystick, RobotMap.AXIS_D_RIGHTDRIVE);

		halfSpeed = new JoystickButton(driveJoystick, 1);
		System.out.println("Got all buttons in OI");
		// Where all the buttons are assigned to initialize the tele-op commands
		// leftTrigger.whenActive(new IntakeDriveShooterWheels());
		// rightTrigger.whenActive(new OutputDriveShooterWheels());

		System.out.println("After command initialization for buttons");
		// SmartDashboard Buttons
		// SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
		// SmartDashboard.putData("driveWithJoystick", new driveWithJoystick());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}

	// TODO public JoystickButton getDeployGripper() {
	// return deployGripper.get();
	// }
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	public Joystick getdriveJoystick() {
		return driveJoystick;
	}

	public Joystick getmanipulatorJoystick() {
		return manipulatorJoystick;
	}

	public static double getAxisValue(Joystick joystick, int axis) {

		return joystick.getRawAxis(axis);
	}

	public double getDriverRightDriveValue() {

		return getAxisValue(driveJoystick2, 1);
	}

	public double getDriverLeftDriveValue() {

		return getAxisValue(driveJoystick, 1);
	}

	public double getManipulatorOuttakeValue() {

		return getAxisValue(manipulatorJoystick, RobotMap.AXIS_M_RIGHTTRIGGER_OUTTAKE);
	}

	public double getManipulatorIntakeValue() {

		return getAxisValue(manipulatorJoystick, RobotMap.AXIS_M_LEFTTRIGGER_INTAKE);
	}

	public double getManipulatorElevatorValue() {

		return getAxisValue(manipulatorJoystick, RobotMap.AXIS_M_RIGHTDRIVE);
	}

	public double getManipulatorRotatorValue() {

		return getAxisValue(manipulatorJoystick, RobotMap.AXIS_M_LEFTDRIVE);
	}
	// public double getDriverHalfSpeed() {
	//
	// return getAxisValue(driveJoystick, RobotMap.AXIS_D_LEFTTRIGGER_HALFSPEED);
	// }
}
