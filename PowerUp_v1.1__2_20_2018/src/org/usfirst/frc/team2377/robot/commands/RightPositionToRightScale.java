package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionToRightScale extends CommandGroup {
	private Logging logger;
	private double elevator_speed = .8;
	private double drive_speed = .7;
	private double turn_speed = .5;

	// public RightPositionToRightScale() {
	// RightPositionToRightScaleConfirmActive();
	// }
	public RightPositionToRightScale(boolean confirmActive) {
		// logger.init("RightScale");

		if (confirmActive) {
			RightPositionToRightScaleConfirmActive();
		} else {
			RightPositionToRightScaleAlways();
		}
	}

	private void RightPositionToRightScaleAlways() {
		if (FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
			// logger.info("The robot is going to the right scale.", LocalDateTime.now());
			addSequential(new AutoOpenCloseGripper(true));// close
			// addSequential(new AutoRotateArmOut());// out
			addSequential(new DriveForward(Robot.R2RSc_Leg_1, .8));
			// addParallel(new AutoMoveElevator(Robot.RaiseElevatorSc, .7, 2))
			addSequential(new AutoRotateLeft(Robot.RotateLeft, .5));
			addSequential(new DriveBackward(Robot.R2RSc_Leg_2, .8));
			addSequential(new AutoMoveElevator(Robot.RaiseElevatorSc, .7, 2));
			// addSequential(new DriveForward(Robot.R2RSc_Leg_2, .7));
			// addSequential(new AutoOpenCloseGripper(false));// open
			addSequential(new AutoOutputDriveShooterWheels());
		}
		// logger.close();
	}

	private void RightPositionToRightScaleConfirmActive() {
		if (FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout) == true) {
			RightPositionToRightScaleAlways();
		} else {
			// logger.info("The robot is crossing the auto line.", LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
		}
		// logger.close();
	}
}
