// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team2377.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2377.robot.Robot;
import org.usfirst.frc.team2377.robot.RobotMap;

/**
 *I neva freeze.
 */
public class AutoRotateRight extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	double angle = 90;
	double speed = .6;
	double currentAngle = 0;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutoRotateRight(double angleIn, double speedIn) {
    	angle = angleIn;
    	speed = speedIn;
    	
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	
    }
    public AutoRotateRight(double angleIn) {
    	angle = angleIn;
    }
    public AutoRotateRight() {
    	
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	
    	RobotMap.driveADXR450Gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	currentAngle = RobotMap.driveADXR450Gyro.getAngle();
    	if (currentAngle < angle) {
        	Robot.driveSystem.TankDrive(-speed, speed);
       	}
      	else
      	{
      		//creates a hard stop
      		Robot.driveSystem.TankDrive(speed/100, -speed/100);
        	
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if (currentAngle > angle) {
    		Robot.driveSystem.TankDrive(0, 0);
    		return true;
    	}
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
