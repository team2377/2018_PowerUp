package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command. You can replace me with your own command.
 */
public class AutoOpenCloseGripper extends Command {
	public static boolean gripperClose;
	private int haveDone;

	public AutoOpenCloseGripper(boolean closeGripper) {
		// Use requires() here to declare subsystem dependencies
		gripperClose = closeGripper;
		haveDone = 0;
		// requires(Robot.driveShooterSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		System.out.println("In execute of auto open or close");

		// TODO check to see if solenoid states match correctly
		if (gripperClose) {
			// close
			RobotMap.openCloseGripper.set(false);
		}
		if (!gripperClose) {
			// open
			RobotMap.openCloseGripper.set(true);

		}
		haveDone += 1;

	}

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
