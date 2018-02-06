/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2377.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class AutoMoveElevator extends CommandGroup {
	public AutoMoveElevator() {
		// Use requires() here to declare subsystem dependencies
	
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println("Running Elevator drive with Joysticks");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double direction = Robot.oi.manipulatorJoystick.getRawAxis(5);
		// allows to get input from user to move elevator
		
		RobotMap.elevatorMotor.set(direction);
		// if joystick is going up
		//TODO hommie, figure out if the limit switch is true or false when closed
		addSequential(new PIDcontroller(1));
		if(direction<0)
		{
			//look at top limit switch
			if(RobotMap.elevatorTopLimitSwitch.get()) 
			{
			
				RobotMap.elevatorMotor.set(0);
			}
		}
		else
		{
			//look at bottom limit switch
			if(RobotMap.elevatorBottomLimitSwitch.get()==true) 
			{
				RobotMap.elevatorMotor.set(0);
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
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
