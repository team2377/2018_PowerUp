/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutoMoveElevator extends Command {
	double height = 0;
	double speed = 0;
	public double currentHeight = 0;
	int timer = 0;
	int timer2 = 0;
	int whichTimer = 0;

	// speed has to be negative to go up
	public AutoMoveElevator(double heightIn, double speedIn, int timer) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevatorSystem);
		height = heightIn;
		speed = speedIn;
		whichTimer = timer;

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (whichTimer == 1) {
			timer += 1;

		} else if (whichTimer == 2) {
			timer2 += 1;
		}

		// TODO sets speed negative
		RobotMap.elevatorMotor.set(-speed);

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {

		// return checkPotentiometer();
		return checkTimer();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// private boolean checkPotentiometer() {
	// currentHeight = RobotMap.m_potentiometer.getVoltage() *
	// Robot.MultiplicationFactorForVoltage;
	// if (currentHeight < height || Robot.elevatorSystem.getTopLimitSwitch() ==
	// true) {
	// Robot.elevatorSystem.set(speed);
	// return false;
	// }
	// return true;
	//
	// }

	private boolean checkTimer() {

		// if (Robot.elevatorSystem.getTopLimitSwitch() == false) {
		// Robot.elevatorSystem.set(0);
		// return true;
		// } else if (height == Robot.RaiseElevatorSw) {
		// if (timer > 90 || timer2 > 120) {// FIXME//45 was 90
		// return true;
		// }
		if (Robot.elevatorSystem.getTopLimitSwitch() == false || timer > 90 || timer2 > 210) {// 195
			Robot.elevatorSystem.set(0);
			return true;
		}

		// }
		return false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
