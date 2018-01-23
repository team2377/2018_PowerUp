package org.usfirst.frc2377.SpeedyBoi.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2377.SpeedyBoi.Robot;
import org.usfirst.frc2377.SpeedyBoi.subsystems.*;


public class CenterSwitch extends CommandGroup {
	//private double m_distance = 0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATION

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public CenterSwitch() {
    	System.out.println("Entering center switch code, " + FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout));
    	if(FmsSubSystem.getRightSwitchActive(Robot.switchScaleLayout))
    	{
    	addSequential(new DriveForward( 200  , .6 ));
    //	addSequential(new PlaceBlock( some thingy that we will put in here based off manipulator mechanics));
    	}
    	else
    	{
        	addSequential(new DriveForward( 200  ,  .6 ));
        	addSequential(new RotateLeft( 90  ,  .6));
        	addSequential(new DriveForward( 200  ,  .6 ));
        	addSequential(new RotateRight( 90  ,  .6 ));
        	addSequential(new DriveForward( 200  , .6 ));
   	//	addSequential(new PlaceBlock( some thingy that we will put in here based off manipulator mechanics));
    	}
    		
    		
    		
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
}
