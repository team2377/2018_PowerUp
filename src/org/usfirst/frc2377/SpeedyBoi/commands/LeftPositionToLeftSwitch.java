package org.usfirst.frc2377.SpeedyBoi.commands;
import org.usfirst.frc2377.SpeedyBoi.Robot;
import org.usfirst.frc2377.SpeedyBoi.subsystems.FmsSubSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionToLeftSwitch extends CommandGroup {
 	 public LeftPositionToLeftSwitch(boolean confirmActive) {
		 if(confirmActive) {
			 LeftPositionToLeftSwitchConfirmActive();
		 }
		 else {
			 LeftPositionToLeftSwitchAlways();
		 }
	 
	 }
	private  void LeftPositionToLeftSwitchAlways() {
		if(!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
		addSequential(new DriveForward(60 , .35));
    	addSequential(new RotateRight(90 , .6));
    	addSequential(new DriveForward(30 , .35));
    	//place power cube
		}
	}
	private void LeftPositionToLeftSwitchConfirmActive() {
		if(!FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout)) {
			LeftPositionToLeftSwitchAlways();
			
		}
		else {
			addSequential(new DrivePastAutonLine());
		}

	}
}
