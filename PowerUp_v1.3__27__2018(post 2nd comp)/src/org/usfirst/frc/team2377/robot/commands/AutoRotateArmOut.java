// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRotateArmOut extends Command {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	private int timeCount;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public AutoRotateArmOut() {
		requires(Robot.driveShooterSubsystem);
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		timeCount = 0;
		// timer
		setTimeout(.35);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// TODO Hommie, See if motor is running the right direction
		// RobotMap.driveSubsystemRotateArm.arcadeDrive(1, 0);
		RobotMap.armMotor.set(-1);
		timeCount++;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		// TODO See if limit switch is closed if it returns true or false
		// if (timeCount >= 15) {
		// RobotMap.armMotor.set(0);
		//
		// timeCount = 0;
		// return true;
		// }
		return isTimedOut();
		// return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotMap.armMotor.set(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
