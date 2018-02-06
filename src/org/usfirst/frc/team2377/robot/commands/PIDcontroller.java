
package org.usfirst.frc.team2377.robot.commands;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.RobotMap;


public class PIDcontroller extends Command{


		public int m_index = 0;
		
		
		public PIDcontroller(int thingymbobber) {
			 m_index = thingymbobber;
		}
	    @Override
	    protected void initialize() {
	
			
	    }

	    @Override
	    protected void execute() {
	    	
				Robot.m_pidController.setSetpoint(Robot.kSetPoints[m_index]);
		
	    }

	    
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
