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
 * Do you know da wae? My Queen! REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 */
public class DriveForward extends Command {
	// private double m_distance = 0;
	double currentAngle = 0;
	double distance = 90;
	double speed = .6;
	double change = 0;
	double factor = 0;
	// clapon clapoff
	double currentDistance = 0;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public DriveForward(double distanceIn, double speedIn) {
		distance = distanceIn;
		speed = speedIn;

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR

	}

	public DriveForward(double distanceIn) {
		distance = distanceIn;
	}

	public DriveForward() {

	}

	// Called just before this Command runs the first time oof
	@Override
	protected void initialize() {
		currentAngle = RobotMap.driveADXR450Gyro.getAngle();

		RobotMap.driveEncoder.reset();
		// RobotMap.driveEncoder2.reset();
	}

	// Called repeatedly when this Command is scheduled to run oof
	@Override
	protected void execute() {
		// XXX code for 2 encoders
		// currentDistance = (RobotMap.driveEncoder.getDistance() +
		// RobotMap.driveEncoder2.getDistance()) // 2;
		currentDistance = RobotMap.driveEncoder.getDistance();
		change = currentAngle - RobotMap.driveADXR450Gyro.getAngle();// ex. 0(static) - 1 = -1
		factor = speed + .082;// was .0725, .085

		if (currentDistance < distance) {
			if (change < 0) {
				// Robot.driveSystem.TankDrive(-speed, -factor);
				RobotMap.driveSystemRobotDrive21.tankDrive(-speed, -factor);
				RobotMap.driveSystemRobotDrive41.tankDrive(-speed, -factor);
			}
			if (change > 0) {
				// Robot.driveSystem.TankDrive(-factor, -speed);
				RobotMap.driveSystemRobotDrive21.tankDrive(-factor, -speed);
				RobotMap.driveSystemRobotDrive41.tankDrive(-factor, -speed);
			}
			if (change == 0) {
				// Robot.driveSystem.TankDrive(-speed, -speed);
				RobotMap.driveSystemRobotDrive21.tankDrive(-speed, -speed);
				RobotMap.driveSystemRobotDrive41.tankDrive(-speed, -speed);
			}
		} else {
			// creates a hard stop
			Robot.driveSystem.TankDrive(speed / 100, speed / 100);
			RobotMap.driveSystemRobotDrive21.tankDrive(speed / 100, speed / 100);
			RobotMap.driveSystemRobotDrive41.tankDrive(speed / 100, speed / 100);
		}

		// } else {
		// // creates a hard stop
		// Robot.driveSystem.TankDrive(speed / 100, speed / 100);
		// }

	}

	// Make this return true when this Command no longer needs to run execute() oof
	@Override
	protected boolean isFinished() {
		if (currentDistance >= distance) {
			System.out.println("Distance were encoder stops " + currentDistance);
			Robot.driveSystem.TankDrive(0, 0);
			// RobotMap.driveSystemRobotDrive21.tankDrive(0, 0);
			// RobotMap.driveSystemRobotDrive41.tankDrive(0, 0);
			return true;
		}

		return false;
	}

	// Called once after isFinished returns true oof
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same oof
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}

//
// if (currentDistance < distance) {
// if (change < 0) {
// Robot.driveSystem.TankDrive(-speed, -factor);
// RobotMap.driveSystemRobotDrive21.tankDrive(-speed,-factor);
// RobotMap.driveSystemRobotDrive41.tankDrive(-speed,-factor);
// }
// if (change > 0) {
// Robot.driveSystem.TankDrive(-factor, -speed);
// }
// if (change == 0) {
// Robot.driveSystem.TankDrive(-speed, -speed);
// }
// } else {
// // creates a hard stop
// Robot.driveSystem.TankDrive(speed / 100, speed / 100);
// }
