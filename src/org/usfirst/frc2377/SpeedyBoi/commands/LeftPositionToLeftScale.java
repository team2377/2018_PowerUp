package org.usfirst.frc2377.SpeedyBoi.commands;
import org.usfirst.frc2377.SpeedyBoi.Robot;
import org.usfirst.frc2377.SpeedyBoi.subsystems.FmsSubSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionToLeftScale extends CommandGroup {
 	 public LeftPositionToLeftScale(boolean confirmActive) {
		 if(confirmActive) {
			 LeftPositionToLeftScaleConfirmActive();
		 }
		 else {
			 LeftPositionToLeftScaleAlways();
		 }
	 
	 }
	private void LeftPositionToLeftScaleAlways() {
		if(!FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
		addSequential(new DriveForward(60 , .35));
    	addSequential(new RotateRight(90 , .6));
    	addSequential(new DriveForward(30 , .35));
    	//place power cube
		}
	}
	private void LeftPositionToLeftScaleConfirmActive() {
		if(!FmsSubSystem.getRightScaleActive(Robot.switchScaleLayout)) {
			LeftPositionToLeftScaleAlways();
			
		}
		else {
			addSequential(new DrivePastAutonLine());
		}

	}
}
