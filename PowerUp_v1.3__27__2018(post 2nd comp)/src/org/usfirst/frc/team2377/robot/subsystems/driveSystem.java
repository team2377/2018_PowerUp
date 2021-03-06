
// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team2377.robot.subsystems;

import org.usfirst.frc.team2377.robot.RobotMap;
import org.usfirst.frc.team2377.robot.commands.driveWithJoystick;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

public class driveSystem extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	private final TalonSRX leftFrontMotor = RobotMap.driveSystemleftFrontMotor;
	private final TalonSRX leftRearMotor = RobotMap.driveSystemleftRearMotor;
	private final TalonSRX rightFrontMotor = RobotMap.driveSystemrightFrontMotor;
	private final TalonSRX rightRearMotor = RobotMap.driveSystemrightRearMotor;
	private final RobotDrive robotDrive41 = RobotMap.driveSystemRobotDrive41;

	private final TalonSRX leftMiddleMotor = RobotMap.driveSystemleftMiddleMotor;
	private final TalonSRX rightMiddleMotor = RobotMap.driveSystemrightMiddleMotor;
	private final RobotDrive robotDrive21 = RobotMap.driveSystemRobotDrive21;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	@Override
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		setDefaultCommand(new driveWithJoystick());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop

	}

	public void stop() {
		robotDrive21.tankDrive(0, 0);
		robotDrive41.tankDrive(0, 0);

	}

	public void TankDrive(double leftValue, double rightValue) {

		robotDrive21.tankDrive(leftValue, rightValue);
		robotDrive41.tankDrive(leftValue, rightValue);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

}
