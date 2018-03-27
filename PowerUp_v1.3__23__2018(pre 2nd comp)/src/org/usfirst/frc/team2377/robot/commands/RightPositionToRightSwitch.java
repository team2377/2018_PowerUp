package org.usfirst.frc.team2377.robot.commands;
//whyd you touch my spaghett

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionToRightSwitch extends CommandGroup {
	private Logging logger;
	private double elevator_speed = .8;
	private double drive_speed = .7;
	private double accurate_drive_speed = .45;
	private double turn_speed = .6;
	private boolean cube;

	// public RightPositionToRightSwitch() {
	// RightPositionToRightSwitchConfirmActive();
	// }
	public RightPositionToRightSwitch(boolean confirmActive, boolean twoCubes) {
		// logger.init("RightSwitch");
		cube = twoCubes;
		if (confirmActive) {
			RightPositionToRightSwitchConfirmActive();
		} else {
			RightPositionToRightSwitchAlways();
		}
	}

	private void RightPositionToRightSwitchAlways() {
		if (FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			// logger.info("The robot is going to the right switch.", LocalDateTime.now());
			System.out.println("Start auto mode right sw");
			addSequential(new AutoOpenCloseGripper(true));// close
			addSequential(new AutoRotateArmOut());// out

			addSequential(new DriveForward(Robot.R2RSw_Leg_1, drive_speed));
			// addParallel(new AutoMoveElevator(Robot.RaiseElevatorSw, .8, 1));
			// addSequential(new AutoMoveElevator(Robot.RaiseElevatorSw, elevator_speed,
			// 1));
			addParallel(new AutoMoveElevator(Robot.RaiseElevatorSw, elevator_speed, 1));
			addSequential(new AutoRotateLeft(Robot.RotateLeft, turn_speed));
			addSequential(new DriveForward(Robot.R2RSw_Leg_2, accurate_drive_speed));
			// addSequential(new AutoOpenCloseGripper(false));// open
			addSequential(new AutoOutputDriveShooterWheels(.6));

			if (cube == true) {
				// FIXME code for second cube
				addSequential(new DriveBackward(-10, drive_speed));
				addSequential(new AutoRotateRight(Robot.RotateRight, .5));
				addSequential(new DriveForward(Robot.R2RSw_Cube_1, .7));
				addSequential(new AutoRotateLeft(Robot.RotateLeft, .5));
				addSequential(new DriveForward(Robot.R2RSw_Cube_2, .7));
				addParallel(new AutoIntakeDriveShooterWheels());
				// addSequential(new AutoIntakeDriveShooterWheels());
			}
		}
		// logger.close();
	}

	private void RightPositionToRightSwitchConfirmActive() {
		if (FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			RightPositionToRightSwitchAlways();
		} else {
			// logger.info("The robot is crossing the auto line.", LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
			addSequential(new AutoRotateArmOut());// out

		}
		// logger.close();
	}
}