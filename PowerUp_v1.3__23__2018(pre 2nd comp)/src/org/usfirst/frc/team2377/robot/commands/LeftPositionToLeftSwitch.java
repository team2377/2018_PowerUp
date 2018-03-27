package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionToLeftSwitch extends CommandGroup {
	private Logging logger;
	private double elevator_speed = .6;
	private double drive_speed = .7;
	private double accurate_drive_speed = .45;
	private double turn_speed = .5;
	private boolean cube;

	public LeftPositionToLeftSwitch(boolean confirmActive, boolean twoCubes) {
		// logger.init("LeftSwitch");
		cube = twoCubes;
		if (confirmActive) {
			LeftPositionToLeftSwitchConfirmActive();
		} else {
			LeftPositionToLeftSwitchAlways();
		}
	}

	private void LeftPositionToLeftSwitchAlways() {
		if (!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			// logger.info("The robot is going to left switch", LocalDateTime.now());
			addSequential(new AutoOpenCloseGripper(true));// close
			addSequential(new AutoRotateArmOut());// out

			addSequential(new DriveForward(Robot.L2LSw_Leg_1, drive_speed));
			addParallel(new AutoMoveElevator(Robot.RaiseElevatorSw, elevator_speed, 1));
			addSequential(new AutoRotateRight(Robot.RotateRight, turn_speed));
			addSequential(new DriveForward(Robot.L2LSw_Leg_2, accurate_drive_speed));
			// addSequential(new AutoOpenCloseGripper(false));// maybe not needed
			addSequential(new AutoOutputDriveShooterWheels(.6));// open

			if (cube == true) {
				// FIXME code for second cube
				addSequential(new DriveBackward(-10, drive_speed));
				addSequential(new AutoRotateLeft(Robot.RotateLeft, .5));
				addSequential(new DriveForward(Robot.L2LSw_Cube_1, .7));
				addSequential(new AutoRotateRight(Robot.RotateRight, .5));
				addSequential(new DriveForward(Robot.L2LSw_Cube_2, .7));
				addParallel(new AutoIntakeDriveShooterWheels());
				// addSequential(new AutoIntakeDriveShooterWheels());
			}
		}
		// logger.close();
	}

	private void LeftPositionToLeftSwitchConfirmActive() {
		if (!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			LeftPositionToLeftSwitchAlways();
		} else {
			// logger.info("The robot is crossing the auto line.", LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
			addSequential(new AutoRotateArmOut());// out

			// logger.info("The robot is crossing the auto line.", LocalDateTime.now());
		}
		// logger.close();
	}
}
