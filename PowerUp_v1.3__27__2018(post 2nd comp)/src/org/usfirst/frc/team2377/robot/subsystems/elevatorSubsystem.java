
package org.usfirst.frc.team2377.robot.subsystems;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.RobotMap;
import org.usfirst.frc.team2377.robot.commands.moveElevator;

import edu.wpi.first.wpilibj.command.Subsystem;

public class elevatorSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		setDefaultCommand(new moveElevator());
	}

	public void periodic() {
		// Put code here to be run every loop
	}

	public boolean getButton() {
		return Robot.oi.manipulatorJoystick.getRawButton(RobotMap.CONTROLLER_B);
	}

	public boolean getTopLimitSwitch() {
		return RobotMap.elevatorTopLimitSwitch.get();
	}

	public boolean getBottomLimitSwitch() {
		return RobotMap.elevatorBottomLimitSwitch.get();
	}

	// public double getFeedback() {
	// //return RobotMap.m_potentiometer.getVoltage();
	// }

	public void set(double p_speed) {
		RobotMap.elevatorMotor.set(p_speed);
	}

}
