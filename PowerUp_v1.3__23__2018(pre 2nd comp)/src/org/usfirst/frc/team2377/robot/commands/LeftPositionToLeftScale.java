package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionToLeftScale extends CommandGroup {
	private Logging logger;
	private double elevator_speed = .8;
	private double drive_speed = .8;
	private double accurate_drive_speed = .45;
	private double turn_speed = .65;// was .5
	private boolean cube;

	public LeftPositionToLeftScale(boolean confirmActive, boolean twoCubes) {
		// logger.init("LeftScale");
		cube = twoCubes;
		if (confirmActive) {
			LeftPositionToLeftScaleConfirmActive();
		} else {
			LeftPositionToLeftScaleAlways();
		}
	}

	private void LeftPositionToLeftScaleAlways() {
		if (!FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
			// logger.info("The robot is going to the left scale.", LocalDateTime.now());
			addSequential(new AutoOpenCloseGripper(true));// close
			addSequential(new AutoRotateArmOut());// out

			addSequential(new DriveForward(Robot.L2LSc_Leg_1, drive_speed));
			addSequential(new AutoRotateRight(Robot.RotateRight, turn_speed));

			addSequential(new DriveBackward(Robot.L2LSc_Leg_2, drive_speed));
			addSequential(new AutoMoveElevator(Robot.RaiseElevatorSc, elevator_speed, 2));// close
			// addSequential(new AutoOpenCloseGripper(false));// maybe not needed
			// addSequential(new DriveForward(Robot.L2LSc_Leg_3, drive_speed));
			addSequential(new DriveForward(Robot.L2LSc_Leg_3, drive_speed));//WAS addParrallel
			addSequential(new AutoOutputDriveShooterWheels(.6));

			if (cube == true) {
				// FIXME code for second cube
				addSequential(new DriveBackward(-10, drive_speed));
				addSequential(new AutoRotateRight(Robot.RotateRight, turn_speed));
				addSequential(new DriveForward(Robot.L2LSc_Cube_1, .7));
				addSequential(new AutoRotateLeft(Robot.RotateLeft, turn_speed));
				addSequential(new DriveForward(Robot.L2LSc_Cube_2, .7));
				addParallel(new AutoIntakeDriveShooterWheels());
				// addSequential(new AutoIntakeDriveShooterWheels());
			}
		}
		// logger.close();
	}

	private void LeftPositionToLeftScaleConfirmActive() {
		if (!FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
			LeftPositionToLeftScaleAlways();

		} else {
			// logger.info("The robot is going to cross the auto line.",
			// LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
			addSequential(new AutoRotateArmOut());// out

		}
		// logger.close();

	}

}
