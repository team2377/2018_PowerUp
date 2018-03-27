package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionAllPriority extends CommandGroup {
	private boolean cube;

	public RightPositionAllPriority(boolean switchOrScale, boolean twoCubes) {
		cube = twoCubes;
		// first true or false, true is switch 1st and false is scale 1st
		if (switchOrScale) {
			// if (cube == true) {
			if (FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
				if (cube == true) {
					addSequential(new RightPositionToRightSwitch(false, true));
				} else
					addSequential(new RightPositionToRightSwitch(false, false));
			} else if (FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
				if (cube == true) {
					addSequential(new RightPositionToRightScale(false, true));
				} else
					addSequential(new RightPositionToRightScale(false, false));
			} else {

				addSequential(new DrivePastAutonLine());

			}
		} else {
			// if (cube == true) {
			if (FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
				if (cube == true) {
					addSequential(new RightPositionToRightScale(false, true));
				} else
					addSequential(new RightPositionToRightScale(false, false));
			} else {
				if (FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
					if (cube == true) {
						addSequential(new RightPositionToRightSwitch(false, true));
					} else
						addSequential(new RightPositionToRightSwitch(false, false));
				} else {
					addSequential(new DrivePastAutonLine());
				}
			}

		}
	}

}
