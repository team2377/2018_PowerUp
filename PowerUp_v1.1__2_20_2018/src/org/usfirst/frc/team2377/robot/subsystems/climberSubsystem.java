
package org.usfirst.frc.team2377.robot.subsystems;

import org.usfirst.frc.team2377.robot.RobotMap;
import org.usfirst.frc.team2377.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Ultrasonic;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class climberSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
 
	public void initDefaultCommand() 
		{
        	setDefaultCommand(new moveClimber());
		}
        public void periodic() {
            // Put code here to be run every loop
        }    
        
}

