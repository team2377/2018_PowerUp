/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2377.robot;

import org.usfirst.frc.team2377.robot.commands.*;
import org.usfirst.frc.team2377.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2377.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	
	public Joystick driveJoystick;
	public Joystick manipulatorJoystick;
    public JoystickButton extendClimber;
    public JoystickButton raiseClimber;
    public JoystickButton deployGripper;
    public JoystickButton openGripper;
    public JoystickButton closeGripper;
    public JoystickButton lowerElevator;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    
        driveJoystick = new Joystick(0);
        manipulatorJoystick = new Joystick(1);
        extendClimber = new JoystickButton(manipulatorJoystick, RobotMap.EXTENDCLIMBER);//Y
        raiseClimber = new JoystickButton(manipulatorJoystick, RobotMap.RAISECLIMBER);//A
        deployGripper = new JoystickButton(manipulatorJoystick,RobotMap.DEPLOYGRIPPER);//X
        lowerElevator = new JoystickButton(manipulatorJoystick, RobotMap.LOWERELEVATOR);//B
        openGripper = new JoystickButton(manipulatorJoystick, RobotMap.OPENGRIPPERBUTTON);//LeftBumper
        closeGripper = new JoystickButton(manipulatorJoystick, RobotMap.CLOSEGRIPPERBUTTON);//RightBumper
        


        // SmartDashboard Buttons
        //SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        //SmartDashboard.putData("driveWithJoystick", new driveWithJoystick());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    	
    
    
//   TODO public JoystickButton getDeployGripper() {
//    	return deployGripper.get();
//    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getdriveJoystick() {
        return driveJoystick;
    }
    public Joystick getmanipulatorJoystick() {
        return manipulatorJoystick;
    }
}
