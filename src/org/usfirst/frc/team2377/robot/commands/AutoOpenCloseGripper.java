package org.usfirst.frc.team2377.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2377.robot.Robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import org.usfirst.frc.team2377.robot.RobotMap;



/**
 * An example command.  You can replace me with your own command.
 */
public class AutoOpenCloseGripper extends Command {
	public static boolean gripperClose;
	public AutoOpenCloseGripper(boolean closeGripper) {
		// Use requires() here to declare subsystem dependencies
		gripperClose=closeGripper;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//TODO check to see if solenoid states match correctly
		if(gripperClose) {
			//close gripper
    		RobotMap.openCloseGripper.set(true);
		}
		if(!gripperClose) {
			//open gripper
    		RobotMap.openCloseGripper.set(false);
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
