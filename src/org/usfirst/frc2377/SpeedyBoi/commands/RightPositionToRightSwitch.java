package org.usfirst.frc2377.SpeedyBoi.commands;
//whyd you touch my spaghett

import org.usfirst.frc2377.SpeedyBoi.Robot;
import org.usfirst.frc2377.SpeedyBoi.subsystems.FmsSubSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPositionToRightSwitch extends CommandGroup {
//	 public RightPositionToRightSwitch() {
//		 RightPositionToRightSwitchConfirmActive();
//    }
	 public RightPositionToRightSwitch(boolean confirmActive) {
		 if(confirmActive) {
			 RightPositionToRightSwitchConfirmActive();
		 }
		 else {
			 RightPositionToRightSwitchAlways();
		 }
	 
	 }
	private void RightPositionToRightSwitchAlways() {
		if(FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
		addSequential(new DriveForward(60 , .35));
    	addSequential(new RotateLeft(90 , .6));
    	addSequential(new DriveForward(30 , .35));
    	//place power cube
		}
		
	}
	private void RightPositionToRightSwitchConfirmActive() {
		if(FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			RightPositionToRightSwitchAlways();
			
		}
		else {
			addSequential(new DrivePastAutonLine());
		}
		
	}

}