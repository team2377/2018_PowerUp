package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionBothScales extends CommandGroup {
	// private double m_distance = 0;
	private Logging logger;
	private double elevator_speed = .8;
	private double drive_speed = .7;
	private double turn_speed = .5;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	// FIXME add a few inches to the 1ast drive forward

	public RightPositionBothScales() {
		// logger.init("Only Scale");
		System.out.println("Entering scale only code, " + FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout));
		if (FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
			addSequential(new RightPositionToRightScale(false, false));
		} else {
			// TODO make new preferences
			// logger.info("The robot is going to the left scale", LocalDateTime.now());
			addSequential(new SwitchOElGearO(false));
			addSequential(new AutoOpenCloseGripper(true));// close
			addSequential(new AutoRotateArmOut());// out
			addSequential(new DriveForward(Robot.R2LSc_Leg_1, .8));
			addSequential(new AutoRotateLeft(Robot.RotateLeft, .6));
			addSequential(new DriveForward(Robot.R2LSc_Leg_2, .8));
			addSequential(new AutoRotateRight(Robot.RotateRight, .6));
			addSequential(new AutoMoveElevator(Robot.RaiseElevatorSc, .8, 2));
			addSequential(new DriveForward(Robot.R2LSc_Leg_3, .8));
			// addSequential(new AutoRotateRight(Robot.RotateRight, .6));
			// addSequential(new DriveForward(Robot.R2LSc_Leg_4, .6));
			// addSequential(new AutoOpenCloseGripper(false));// open
			addSequential(new AutoOutputDriveShooterWheels(.40));
		}
		// logger.close();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}
}
