package org.usfirst.frc2377.SpeedyBoi.commands;
import org.usfirst.frc2377.SpeedyBoi.Robot;
import org.usfirst.frc2377.SpeedyBoi.subsystems.FmsSubSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionToRightScale extends CommandGroup {
//	 public RightPositionToRightScale() {
//		 RightPositionToRightScaleConfirmActive();
//    }
	 public RightPositionToRightScale(boolean confirmActive) {
		 if(confirmActive) {
			 RightPositionToRightScaleConfirmActive();
		 }
		 else {
			 RightPositionToRightScaleAlways();
		 }
	
	
	 }
	private void RightPositionToRightScaleAlways() {
		if(FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
		addSequential(new DriveForward(120 , .35));
    	addSequential(new RotateLeft(90 , .6));
    	addSequential(new DriveForward(30 , .35));
    	//place power cube
		}
		
		
	}
	private void RightPositionToRightScaleConfirmActive() {
		if(FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout) == true) {
			RightPositionToRightScaleAlways();
		}
		else {
			addSequential(new DrivePastAutonLine());
		}
		
	}
	 
}
