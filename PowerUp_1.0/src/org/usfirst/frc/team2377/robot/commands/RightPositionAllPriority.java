package org.usfirst.frc.team2377.robot.commands;
import java.time.LocalDateTime;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionAllPriority extends CommandGroup {
	 public RightPositionAllPriority(boolean switchOrScale) {
		 if(switchOrScale) {
			 if(FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout))
			 {
				 addSequential(new RightPositionToRightSwitch(false));
			 }
			 else
			 {
				 addSequential(new RightPositionToRightScale(true));
			 }
		 }
		 if(!switchOrScale) {
			 if(FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout))
			 {
				 addSequential(new RightPositionToRightScale(false)); 
			 }
			 else
			 {
				 addSequential(new RightPositionToRightSwitch(true));
			 }
			
		 }
	}
	
	
}
