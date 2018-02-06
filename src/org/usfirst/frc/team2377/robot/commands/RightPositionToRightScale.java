package org.usfirst.frc.team2377.robot.commands;
import java.time.LocalDateTime;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionToRightScale extends CommandGroup {
	private Logging logger;

//	 public RightPositionToRightScale() {
//		 RightPositionToRightScaleConfirmActive();
//    }
	 public RightPositionToRightScale(boolean confirmActive) {
	 		logger.init("RightScale");

		 if(confirmActive) {
			 RightPositionToRightScaleConfirmActive();
		 }
		 else {
			 RightPositionToRightScaleAlways();
		 }
	 }
	private void RightPositionToRightScaleAlways() {
		if(FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
	    	logger.info("The robot is going to the right scale.", LocalDateTime.now());
    		addSequential(new AutoOpenCloseGripper(true));//close
			addSequential(new DriveForward(Robot.R2RSc_Leg_1 , .35));
	    	addSequential(new AutoRotateLeft(Robot.RotateLeft, .6));
	    	//raise elevator
	    	addSequential(new DriveForward(Robot.R2RSc_Leg_2, .35));
    		addSequential(new AutoOpenCloseGripper(false));//open
		}
		logger.close();
	}
	private void RightPositionToRightScaleConfirmActive() {
		if(FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout) == true) {
			RightPositionToRightScaleAlways();
		}
		else {
	    	logger.info("The robot is crossing the auto line.", LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
		}
		logger.close();
	}
}
