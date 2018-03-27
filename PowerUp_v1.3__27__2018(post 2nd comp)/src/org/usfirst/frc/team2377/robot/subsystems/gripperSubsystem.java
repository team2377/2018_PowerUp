
package org.usfirst.frc.team2377.robot.subsystems;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.RobotMap;
import org.usfirst.frc.team2377.robot.commands.RotatesArm;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class gripperSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	// private final SpeedController rightMotor = RobotMap.rightShooterWheelMotor;
	// private final SpeedController leftMotor = RobotMap.leftShooterWheelMotor;
	private final RobotDrive robotShooterDrive21 = RobotMap.driveSubsystemShooterWheels21;

	public void initDefaultCommand() {
		setDefaultCommand(new RotatesArm());
	}

	public void periodic() {
		// Put code here to be run every loop

	}

	public double getAxisUsage() {
		return Robot.oi.manipulatorJoystick.getRawAxis(RobotMap.AXIS_M_LEFTDRIVE);
	}

	// shooting drive train
	public void TankDrive(double leftValue, double rightValue) {
		robotShooterDrive21.tankDrive(leftValue, rightValue);
	}
	// rotating drive train

}
