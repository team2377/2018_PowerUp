package org.usfirst.frc.team2377.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2377.robot.commands.*;
import org.usfirst.frc.team2377.robot.subsystems.*;
import org.usfirst.frc.team2377.robot.subsystems.gripperSubsystem;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static double[] kSetPoints = {.7, 1.0, 1.2};
	
	private int m_index = 0;
	private boolean m_previousButtonValue = false;
//	public static final ExampleSubsystem kExampleSubsystem
//			= new ExampleSubsystem();
	public static UsbCamera cam0;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	Preferences prefs;
	public static OI oi;
	public static driveSystem driveSystem;//6 wheel drive
	public static gripperSubsystem driveShooterSubsystem;// 2 wheel shooter drive


    
    public static String switchScaleLayout = "XXX";
    public static double speedLimiter = .5;
    
    
    //PID
    public static final double kP =  2.0;
	public static final double kI = 0.01;
	public static final double kD = -.1;
    public static PIDController m_pidController;
	
	
    public static final int kPotChannel = 0;
	public static final int kMotorChannel = 2; 
	public static final int kJoystickChannel = 0;

 	// bottom, middle, and top elevator setpoints
	
	
	
	
	
	//Declaring Preferences
    public static double autonLine;//start-end
    public static double RotateRight;
    public static double RotateLeft;//end
    public static double RaiseElevatorSw;
    public static double RaiseElevatorSc;

    public static double C2LSw_Leg_1;//start
    public static double C2LSw_Leg_2;
    public static double C2LSw_Leg_3;//end
    
    public static double R2RSw_Leg_1;//start
    public static double R2RSw_Leg_2;//end
    public static double R2RSc_Leg_1;//start
    public static double R2RSc_Leg_2;//end
    
    public static double L2LSw_Leg_1;//start
    public static double L2LSw_Leg_2;//end    
    public static double L2LSc_Leg_1;//start
    public static double L2LSc_Leg_2;//end

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		prefs=Preferences.getInstance();
		autonLine=prefs.getDouble("autonLine",0);
        RotateLeft=prefs.getDouble("RotateLeft",0);
        RotateRight=prefs.getDouble("RotateRight",0);
        RaiseElevatorSc=prefs.getDouble("RaiseElevatorSc", 0);
        RaiseElevatorSw= prefs.getDouble("RaiseElevatorSw", 0);

        C2LSw_Leg_1=prefs.getDouble("C2LSw_Leg_1",0);
        C2LSw_Leg_2=prefs.getDouble("C2LSw_Leg_2",0);
        C2LSw_Leg_3=prefs.getDouble("C2LSw_Leg_3",0);
        
        R2RSw_Leg_1=prefs.getDouble("R2RSw_Leg_1",0);
        R2RSw_Leg_2=prefs.getDouble("R2RSw_Leg_2",0);
        R2RSc_Leg_1=prefs.getDouble("R2RSc_Leg_1",0);
        R2RSc_Leg_2=prefs.getDouble("R2RSc_Leg_2",0);
        
        L2LSw_Leg_1=prefs.getDouble("L2LSw_Leg_1",0);
        L2LSw_Leg_2=prefs.getDouble("L2LSw_Leg_2",0);        
        L2LSc_Leg_1=prefs.getDouble("L2LSc_Leg_1",0);
        L2LSc_Leg_2=prefs.getDouble("L2LSc_Leg_2",0);
		System.out.println(autonLine);
		
		
		
		m_pidController = new PIDController(kP, kI, kD, RobotMap.m_potentiometer, RobotMap.m_elevatorMotor);
		m_pidController.setInputRange(.2, 1.5);

		oi = new OI();
		driveSystem = new driveSystem();// 6 wheel drive
		driveShooterSubsystem = new gripperSubsystem();// gripper shooter drive
       
     
		
    	switchScaleLayout = FmsSubSystem.getSwitchAndScaleLayout();
    	
    	System.out.println("Starting the auto chooser with FMS value of:" + switchScaleLayout);//printed the printline START HERE ON 1/20 TODO
    	chooser.addDefault("Autonomous Command", new CenterSwitch());

//        chooser.addObject("Do nothing", new SpeedyBoiStop());
        chooser.addObject("Auton Line", new DrivePastAutonLine());
        chooser.addObject("Center Switch", new CenterSwitch());
        chooser.addObject("Right Scale / AutonLine", new RightPositionToRightScale(true));	//tests right scale then default is auto-line
        chooser.addObject("Left Scale / AutonLine", new LeftPositionToLeftScale(true));		//tests left scale then default is auto-line
        chooser.addObject("Right Switch / AutonLine", new RightPositionToRightSwitch(true));//tests right switch then default is auto-line
        chooser.addObject("Left Switch / AutonLine", new LeftPositionToLeftSwitch(true));	//tests left switch then default is auto-line
        chooser.addObject("Right All Scale Priority", new RightPositionAllPriority(false));
        chooser.addObject("Right All Switch Priority", new RightPositionAllPriority(true));
        chooser.addObject("Left All Scale Priority", new LeftPositionAllPriority(false));
        chooser.addObject("Left All Switch Priority", new LeftPositionAllPriority(true));
		SmartDashboard.putData("Auto mode", chooser);
    	SmartDashboard.putBoolean("Solonoid value", RobotMap.openCloseGripper.get());
    	kSetPoints[0] = prefs.getDouble("", 0);
    	kSetPoints[1] = prefs.getDouble("", 0);
    	
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_pidController.enable();
		SmartDashboard.putNumber("m_index", 0);
		m_index = (int) SmartDashboard.getNumber("m_index", 0);
		
		m_pidController.setSetpoint(kSetPoints[m_index]);
		
		
		// schedule the autonomous command (example)
		//switchScaleLayout = FmsSubSystem.getSwitchAndScaleLayout(); 
    	System.out.println("Entering autonomous init: " + FmsSubSystem.getSwitchAndScaleLayout());
        autonomousCommand = chooser.getSelected();
        System.out.println(autonomousCommand);
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        System.out.println("Leaving autonomous init");
        RobotMap.driveADXR450Gyro.reset();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    	SmartDashboard.putString("Reading FMS value", FmsSubSystem.getSwitchAndScaleLayout());
        SmartDashboard.putNumber("Encoder value", RobotMap.driveEncoder.getDistance());
        SmartDashboard.putNumber("Gyro value", RobotMap.driveADXR450Gyro.getAngle());
        SmartDashboard.putNumber("Potentiometer Average Voltage", RobotMap.m_potentiometer.getAverageVoltage());
		SmartDashboard.putNumber("Potentiometer Voltage", RobotMap.m_potentiometer.getVoltage());	
		SmartDashboard.putNumber("Potentiometer Reading", RobotMap.m_potentiometer.getValue());	
		SmartDashboard.putNumber("PID input", -m_pidController.getError() + m_pidController.getSetpoint());	
		SmartDashboard.putNumber("PID output", m_pidController.get());	
		SmartDashboard.putNumber("PID target", m_pidController.getSetpoint());		
		SmartDashboard.putNumber("PID Distance From Setpoint", m_pidController.getError());
		SmartDashboard.putNumber("Motor Current Speed", RobotMap.m_elevatorMotor.get());	
		SmartDashboard.putNumber("m_index", m_index);
        
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
