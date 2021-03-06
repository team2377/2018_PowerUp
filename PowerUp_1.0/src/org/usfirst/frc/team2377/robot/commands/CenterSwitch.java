package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSwitch extends CommandGroup {
	private double elevator_speed = .8;
	private double drive_speed = .7;
	private double turn_speed = .5;

	// private Logging logger;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATION

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public CenterSwitch() {
		// logger.init("CenterSwitch");
		System.out
				.println("Entering center switch code, " + FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout));
		if (FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			// addSequential(new SwitchOElGearO(true));

			// logger.info("The robot is going to the right switch", LocalDateTime.now());
			addSequential(new AutoOpenCloseGripper(true));// close
			// addSequential(new AutoRotateArmOut());// out
			addParallel(new AutoMoveElevator(Robot.RaiseElevatorSw, .7, 1));
			// addSequential(new AutoMoveElevator(Robot.RaiseElevatorSw, .7, 1));
			addSequential(new DriveForward(Robot.autonLine, drive_speed));
			addParallel(new DriveForward(10, drive_speed));
			// addSequential(new DriveForward(20, drive_speed));
			// addSequential(new AutoOpenCloseGripper(false));// open
			addSequential(new AutoOutputDriveShooterWheels());
			addSequential(new DriveBackward(10, -drive_speed));

		} else {
			// logger.info("The robot is going to the left switch", LocalDateTime.now());
			// addSequential(new SwitchOElGearO(true));

			addSequential(new AutoOpenCloseGripper(true));// close
			// addSequential(new AutoRotateArmOut());// out
			addSequential(new DriveForward(Robot.C2LSw_Leg_1, drive_speed));
			addSequential(new AutoRotateLeft(Robot.RotateLeft, turn_speed));
			addSequential(new DriveForward(Robot.C2LSw_Leg_2, drive_speed));
			addParallel(new AutoMoveElevator(Robot.RaiseElevatorSw, .7, 1));
			// addSequential(new AutoMoveElevator(Robot.RaiseElevatorSw, .7, 1));

			addSequential(new AutoRotateRight(Robot.RotateRight, turn_speed));
			// addParallel(new AutoMoveElevator(Robot.RaiseElevatorSw, .70, 1));

			addSequential(new DriveForward(Robot.C2LSw_Leg_3, drive_speed));

			// addSequential(new AutoOpenCloseGripper(false));// open
			addSequential(new AutoOutputDriveShooterWheels());
		}
		// logger.close();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}
}
