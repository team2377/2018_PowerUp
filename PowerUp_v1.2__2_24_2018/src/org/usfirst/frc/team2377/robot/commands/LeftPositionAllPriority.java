package org.usfirst.frc.team2377.robot.commands;
import java.time.LocalDateTime;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionAllPriority extends CommandGroup {
	 public LeftPositionAllPriority(boolean switchOrScale) {
		 //true means switch then scale
		 //false means scale then switch
		 if(switchOrScale) {
			 if(!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout))
			 {
			 addSequential(new LeftPositionToLeftSwitch(false));
			 }
			 else
			 {
			 addSequential(new LeftPositionToLeftScale(true));
			 }
		 }
		 if(!switchOrScale) {
			 if(!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout))
			 {
			addSequential(new LeftPositionToLeftScale(false)); 
			 }
			else
			{
			addSequential(new LeftPositionToLeftSwitch(true));
			}
			
		 }
	}
}
