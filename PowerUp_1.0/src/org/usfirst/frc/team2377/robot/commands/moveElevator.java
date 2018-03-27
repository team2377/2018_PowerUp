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

public class moveElevator extends Command {
	boolean AutoLowerPlease;

	public moveElevator() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevatorSystem);
		AutoLowerPlease = false;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println("Running Elevator drive with Joysticks");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double direction = Robot.oi.getManipulatorElevatorValue() * .75;
		// down Button B
		if (Robot.elevatorSystem.getButton()) {
			AutoLowerPlease = true;
		}

		if (AutoLowerPlease) {
			// Robot.elevatorDrive.ArcadeDrive(-1,-1);
			RobotMap.elevatorMotor.set(-1);
			if (RobotMap.elevatorBottomLimitSwitch.get() == false) {
				AutoLowerPlease = false;
				RobotMap.elevatorMotor.set(0);
			}

		} else {
			if (direction < 0) {
				// look at top limit switch

				if (Robot.elevatorSystem.getTopLimitSwitch() == false) {
					// Robot.elevatorDrive.ArcadeDrive(0, 0);
					RobotMap.elevatorMotor.set(0);
				} else {
					RobotMap.elevatorMotor.set(direction);
				}
			} else if (direction > 0) {
				// look at bottom limit switch
				if (Robot.elevatorSystem.getBottomLimitSwitch() == false) {
					// Robot.elevatorDrive.ArcadeDrive(0, 0);
					RobotMap.elevatorMotor.set(0);
				} else {
					RobotMap.elevatorMotor.set(direction);
				}
			} else {
				RobotMap.elevatorMotor.set(0);

			}

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
