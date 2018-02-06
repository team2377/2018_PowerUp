package org.usfirst.frc.team2377.robot.commands;
//whyd you touch my spaghett

import java.time.LocalDateTime;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionToRightSwitch extends CommandGroup {
	private Logging logger;
//	 public RightPositionToRightSwitch() {
//		 RightPositionToRightSwitchConfirmActive();
//    }
	 public RightPositionToRightSwitch(boolean confirmActive) {
	 		logger.init("RightSwitch");

		 if(confirmActive) {
			 RightPositionToRightSwitchConfirmActive();
		 }
		 else {
			 RightPositionToRightSwitchAlways();
		 }
	 }
	private void RightPositionToRightSwitchAlways() {
		if(FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
	    	logger.info("The robot is going to the right switch.", LocalDateTime.now());
    		addSequential(new AutoOpenCloseGripper(true));//close
			addSequential(new DriveForward(Robot.R2RSw_Leg_1 , .35));
	    	addSequential(new AutoRotateLeft(Robot.RotateLeft, .6));
	    	//raise elevator
	    	addSequential(new DriveForward(Robot.R2RSw_Leg_2, .35));
    		addSequential(new AutoOpenCloseGripper(false));//open
		}
		logger.close();
	}
	private void RightPositionToRightSwitchConfirmActive() {
		if(FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			RightPositionToRightSwitchAlways();
		}
		else {
	    	logger.info("The robot is crossing the auto line.", LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
		}
		logger.close();
	}
}