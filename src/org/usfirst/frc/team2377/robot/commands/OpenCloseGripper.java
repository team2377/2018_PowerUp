package org.usfirst.frc.team2377.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2377.robot.Robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import org.usfirst.frc.team2377.robot.RobotMap;



/**
 * An example command.  You can replace me with your own command.
 */
public class OpenCloseGripper extends Command {
	private static enum statetype{INIT,OFF,HON,ON,HOFF};
	private static statetype state;
	public OpenCloseGripper() {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.kExampleSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//TODO check to see if solenoid states match correctly with button use
		switch (state)
    	{
    	case INIT:
    		RobotMap.openCloseGripper.set(false);
    		state = statetype.OFF;
    		break;
    	case OFF:
    		if(Robot.oi.manipulatorJoystick.getRawButton(RobotMap.CLOSEGRIPPERBUTTON))
    			state = statetype.HON;
    		break;
    	case HON:
    		if(!Robot.oi.manipulatorJoystick.getRawButton(RobotMap.CLOSEGRIPPERBUTTON))
    		{
    			RobotMap.openCloseGripper.set(true);
    			state = statetype.ON;
    		}
    		break;
    	case ON:
    		if(Robot.oi.manipulatorJoystick.getRawButton(RobotMap.OPENGRIPPERBUTTON))
        		state = statetype.HOFF;
    		break;
    	case HOFF:
    		if(!Robot.oi.manipulatorJoystick.getRawButton(RobotMap.OPENGRIPPERBUTTON))
    		{
    			RobotMap.openCloseGripper.set(false);
    			state = statetype.OFF;
    		}
    		break;
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
