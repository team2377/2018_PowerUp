package org.usfirst.frc.team2377.robot.commands;
import java.time.LocalDateTime;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionAllPriority extends CommandGroup {
	 public RightPositionAllPriority(boolean switchOrScale) {
		 if(switchOrScale) {
	addSequential(new RightPositionToRightSwitch(false));
	addSequential(new RightPositionToRightScale(true));
		 }
		 if(!switchOrScale) {
			addSequential(new RightPositionToRightScale(false)); 
			addSequential(new RightPositionToRightSwitch(true));
			
		 }
		 }
	
	
}
