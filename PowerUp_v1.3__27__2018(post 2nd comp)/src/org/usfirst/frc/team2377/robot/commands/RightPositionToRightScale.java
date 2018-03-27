package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionToRightScale extends CommandGroup {
	private Logging logger;
	private double elevator_speed = .8;
	private double drive_speed = .9;
	private double accurate_drive_speed = .45;
	private double turn_speed = .65;// was .5
	private boolean cube;

	// public RightPositionToRightScale() {
	// RightPositionToRightScaleConfirmActive();
	// }
	public RightPositionToRightScale(boolean confirmActive, boolean twoCubes) {
		// logger.init("RightScale");
		cube = twoCubes;
		if (confirmActive) {
			RightPositionToRightScaleConfirmActive();
		} else {
			RightPositionToRightScaleAlways();
		}
	}

	private void RightPositionToRightScaleAlways() {
		if (FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
			// logger.info("The robot is going to the right scale.", LocalDateTime.now());
			// drive speed is .9
			addSequential(new AutoOpenCloseGripper(true));// close
			addSequential(new AutoRotateArmOut());// out

			addSequential(new DriveForward(Robot.R2RSc_Leg_1, drive_speed));
			addSequential(new AutoRotateLeft(Robot.RotateLeft, turn_speed));

			addSequential(new DriveBackward(Robot.R2RSc_Leg_2, drive_speed));
			addSequential(new AutoMoveElevator(Robot.RaiseElevatorSc, elevator_speed, 2));
			// addSequential(new AutoMoveElevator(Robot.RaiseElevatorSc, .7, 2));
			addSequential(new DriveForward(Robot.R2RSc_Leg_3, .8));
			// addSequential(new AutoOpenCloseGripper(false));// open
			addSequential(new AutoOutputDriveShooterWheels(.6));

			if (cube == true) {
				// FIXME code for second cube
				addSequential(new DriveBackward(-10, drive_speed));
				addSequential(new AutoRotateLeft(Robot.RotateLeft, .5));
				addSequential(new DriveForward(Robot.R2RSc_Cube_1, .7));
				addSequential(new AutoRotateRight(Robot.RotateRight, .5));
				addSequential(new DriveForward(Robot.R2RSc_Cube_2, .7));
				addParallel(new AutoIntakeDriveShooterWheels());
				// addSequential(new AutoIntakeDriveShooterWheels());
			}
		}
		// logger.close();
	}

	private void RightPositionToRightScaleConfirmActive() {
		if (FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout) == true) {
			RightPositionToRightScaleAlways();
		} else {
			// logger.info("The robot is crossing the auto line.", LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
			addSequential(new AutoRotateArmOut());// out

		}
		// logger.close();
	}

}
