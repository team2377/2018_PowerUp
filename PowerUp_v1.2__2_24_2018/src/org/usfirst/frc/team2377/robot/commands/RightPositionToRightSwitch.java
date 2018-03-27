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
	private double turn_speed = .5;

	// public RightPositionToRightSwitch() {
	// RightPositionToRightSwitchConfirmActive();
	// }
	public RightPositionToRightSwitch(boolean confirmActive) {
		// logger.init("RightSwitch");

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
			// addSequential(new AutoRotateArmOut());// out
			addSequential(new DriveForward(Robot.R2RSw_Leg_1, .7));
			// addParallel(new AutoMoveElevator(Robot.RaiseElevatorSw, .8, 1));
			addSequential(new AutoMoveElevator(Robot.RaiseElevatorSw, .8, 1));

			addSequential(new AutoRotateLeft(Robot.RotateLeft, .5));
			addSequential(new DriveForward(Robot.R2RSw_Leg_2, .45));
			// addSequential(new AutoOpenCloseGripper(false));// open
			addSequential(new AutoOutputDriveShooterWheels());
		}
		// logger.close();
	}

	private void RightPositionToRightSwitchConfirmActive() {
		if (FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			RightPositionToRightSwitchAlways();
		} else {
			// logger.info("The robot is crossing the auto line.", LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
		}
		// logger.close();
	}
}