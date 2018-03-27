/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class moveClimber extends Command {
	public moveClimber() {
		requires(Robot.climberSystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (Robot.oi.manipulatorJoystick.getRawButton(RobotMap.CONTROLLER_Y))// if Y is pressed
		{
			// RobotMap.driveSubsystemMoveClimber.arcadeDrive(1, 0);//extend
			RobotMap.climberMotor.set(1);
		} else if (Robot.oi.manipulatorJoystick.getRawButton(RobotMap.CONTROLLER_A))// if A is pressed
		{
			// RobotMap.driveSubsystemMoveClimber.arcadeDrive(-1, 0);//raise or pull up
			RobotMap.climberMotor.set(-1);
		} else {

			RobotMap.climberMotor.set(0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
