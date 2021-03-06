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

public class SwitchOElGearO extends Command {
	private boolean _highGear;
	private int haveDone;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public SwitchOElGearO(boolean highGear) {
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTO
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.driveSystem);
		_highGear = highGear;
		haveDone = 0;
		// System.out.println("Got to the requires in OEI");

		// System.out.println("Got past requires in OEL");

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// TODO hommie, figure out if the limit switch is true or false when closed
		// TODO hommie, figure out which direction is positive and negative
		// left bumper
		System.out.println("How many times has the solenoid run? " + haveDone);
		// if gear is in high gear then switch gear
		if (_highGear == true) {
			// switch gear
			// make solenoid and switch value of it here
			// System.out.println("before solenoid is set to false " +
			// RobotMap.switchGear.get());

			RobotMap.switchGear.set(false);
			haveDone += 1;
			// System.out.println("after solenoid is set to false " +
			// RobotMap.switchGear.get());

		}
		// right bumper
		// if gear is in low gear switch gear
		else if (_highGear == false) {
			// switch gearboi
			// make solenoid and switch value of it here
			// System.out.println("before solenoid is set to true " +
			// RobotMap.switchGear.get());

			RobotMap.switchGear.set(true);
			haveDone += 1;

			// System.out.println("after solenoid is set to true " +
			// RobotMap.switchGear.get());

		}
	}

	// Robot.oi.manipulatorJoystick.getRawButtonPressed(button)
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (haveDone >= 1) {
			return true;
		}
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