package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionAllPriority extends CommandGroup {
	private boolean cube;

	public LeftPositionAllPriority(boolean switchOrScale, boolean twoCubes) {
		// first true or false
		// true means switch then scale
		// false means scale then switch
		// second true or false, true is 2cubes and false is 1cube
		cube = twoCubes;
		if (switchOrScale) {
			// if (cube == true) {
			if (!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
				if (cube == true) {
					addSequential(new LeftPositionToLeftSwitch(false, true));
				} else
					addSequential(new LeftPositionToLeftSwitch(false, false));
			} // else {
				// addSequential(new LeftPositionToLeftScale(true, true));
				// }
			else {
				if (!FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
					if (cube == true) {
						addSequential(new LeftPositionToLeftScale(false, true));
					} else
						addSequential(new LeftPositionToLeftScale(false, false));
				} else {
					addSequential(new DrivePastAutonLine());
				}
			}
		} else {
			// if (cube = true) {
			if (!FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
				if (cube == true) {
					addSequential(new LeftPositionToLeftScale(false, true));
				} else
					addSequential(new LeftPositionToLeftScale(false, false));
			} // else {
				// addSequential(new LeftPositionToLeftSwitch(true, true));
				// }
			else {
				if (!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
					if (cube == true) {
						addSequential(new LeftPositionToLeftSwitch(false, true));
					} else
						addSequential(new LeftPositionToLeftSwitch(false, false));
				} else {
					addSequential(new DrivePastAutonLine());
				}
			}
		}
	}
}
