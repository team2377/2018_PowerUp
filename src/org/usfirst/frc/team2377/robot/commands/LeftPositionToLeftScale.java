package org.usfirst.frc.team2377.robot.commands;
import java.time.LocalDateTime;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.Logging;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionToLeftScale extends CommandGroup {
	private Logging logger;
 	 public LeftPositionToLeftScale(boolean confirmActive) {
 		logger.init("LeftScale");
		 if(confirmActive) {
			 LeftPositionToLeftScaleConfirmActive();
		 }
		 else {
			 LeftPositionToLeftScaleAlways();
		 }
	 }
	private void LeftPositionToLeftScaleAlways() {
		if(!FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
    	logger.info("The robot is going to the left scale.", LocalDateTime.now());
		addSequential(new AutoOpenCloseGripper(true));//close
		addSequential(new DriveForward(Robot.L2LSc_Leg_1 , .35));
    	addSequential(new AutoRotateRight(Robot.RotateRight, .6));
    	//raise elevator
    	addSequential(new DriveForward(Robot.L2LSc_Leg_2, .35));
		addSequential(new AutoOpenCloseGripper(false));//open
		}
		logger.close();
	}
	private void LeftPositionToLeftScaleConfirmActive() {
		if(!FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
			LeftPositionToLeftScaleAlways();
			
		}
		else {
			logger.info("The robot is going to cross the auto line.", LocalDateTime.now());
			addSequential(new DrivePastAutonLine());
		}
		logger.close();


	}
	
}
