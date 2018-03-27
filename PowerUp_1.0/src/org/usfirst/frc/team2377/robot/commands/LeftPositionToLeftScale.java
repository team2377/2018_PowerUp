package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionToLeftScale extends CommandGroup {
	private Logging logger;
	private double elevator_speed = .8;
	private double drive_speed = .7;
	private double turn_speed = .5;

	public LeftPositionToLeftScale(boolean confirmActive) {
		// logger.init("LeftScale");
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
			// addSequential(new AutoRotateArmOut());// out
			addSequential(new DriveForward(Robot.L2LSc_Leg_1, .8));
			addSequential(new AutoRotateRight(Robot.RotateRight, .5));
			// addSequential(new AutoMoveElevator(Robot.RaiseElevatorSc, .6, 2));// close
			addSequential(new DriveBackward(Robot.L2LSc_Leg_2, .8));
			// addSequential(new AutoOpenCloseGripper(false));// maybe not needed
			addSequential(new AutoOutputDriveShooterWheels());
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
		}
		// logger.close();

	}

}
