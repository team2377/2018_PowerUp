package org.usfirst.frc.team2377.robot.commands;
import java.time.LocalDateTime;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionAllPriority extends CommandGroup {
	 public LeftPositionAllPriority(boolean switchOrScale) {
		 if(switchOrScale) {
	addSequential(new LeftPositionToLeftSwitch(false));
	addSequential(new LeftPositionToLeftScale(true));
		 }
		 if(!switchOrScale) {
			addSequential(new LeftPositionToLeftScale(false)); 
			addSequential(new LeftPositionToLeftSwitch(true));
			
		 }
		 }
	
	
}
