package org.usfirst.frc.team2377.robot.commands;
import java.time.LocalDateTime;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionToLeftSwitch extends CommandGroup {
	private Logging logger;
 	 public LeftPositionToLeftSwitch(boolean confirmActive) {
 		 logger.init("LeftSwitch");
		 if(confirmActive) {
			 LeftPositionToLeftSwitchConfirmActive();
		 }
		 else {
			 LeftPositionToLeftSwitchAlways();
		 }
	 }
	private  void LeftPositionToLeftSwitchAlways() {
		if(!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
	    	logger.info("The robot is going to left switch", LocalDateTime.now());
    		addSequential(new AutoOpenCloseGripper(true));//close
			addSequential(new DriveForward(Robot.L2LSw_Leg_1, .35));
	    	addSequential(new AutoRotateRight(Robot.RotateRight, .6));
	    	//raise elevator
	    	addSequential(new DriveForward(Robot.L2LSw_Leg_2, .35));
    		addSequential(new AutoOpenCloseGripper(false));//open
		}
		logger.close();
	}
	private void LeftPositionToLeftSwitchConfirmActive() {
		if(!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			LeftPositionToLeftSwitchAlways();
		}
		else {
			logger.info("The robot is crossing the auto line.", LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
			logger.info("The robot is crossing the auto line.", LocalDateTime.now());
		}
		logger.close();
	}
}
