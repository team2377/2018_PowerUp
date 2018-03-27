package org.usfirst.frc.team2377.robot;

import org.usfirst.frc.team2377.robot.commands.AutoTester;
import org.usfirst.frc.team2377.robot.commands.CenterSwitch;
import org.usfirst.frc.team2377.robot.commands.CloseGripper;
import org.usfirst.frc.team2377.robot.commands.DrivePastAutonLine;
import org.usfirst.frc.team2377.robot.commands.LeftPositionAllPriority;
import org.usfirst.frc.team2377.robot.commands.LeftPositionBothScales;
import org.usfirst.frc.team2377.robot.commands.LeftPositionToLeftScale;
import org.usfirst.frc.team2377.robot.commands.LeftPositionToLeftSwitch;
import org.usfirst.frc.team2377.robot.commands.OpenGripper;
import org.usfirst.frc.team2377.robot.commands.RightPositionAllPriority;
import org.usfirst.frc.team2377.robot.commands.RightPositionBothScales;
import org.usfirst.frc.team2377.robot.commands.RightPositionToRightScale;
import org.usfirst.frc.team2377.robot.commands.RightPositionToRightSwitch;
import org.usfirst.frc.team2377.robot.commands.SwitchOElGearO;
import org.usfirst.frc.team2377.robot.subsystems.FmsSubSystem;
import org.usfirst.frc.team2377.robot.subsystems.climberSubsystem;
import org.usfirst.frc.team2377.robot.subsystems.driveSystem;
import org.usfirst.frc.team2377.robot.subsystems.elevatorSubsystem;
import org.usfirst.frc.team2377.robot.subsystems.gripperSubsystem;
import org.usfirst.frc.team2377.robot.subsystems.intakeShooterWheelsSubsystem;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 * 
 * Love me forklift
 */
public class Robot extends TimedRobot {

	public static String selected = "";

	private boolean m_previousButtonValue = false;
	// public static final ExampleSubsystem kExampleSubsystem
	// = new ExampleSubsystem();
	public static UsbCamera cam0;
	public static CameraServer server;
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	Preferences prefs;
	public static OI oi;
	public static driveSystem driveSystem;// 6 wheel drive
	public static gripperSubsystem driveShooterSubsystem;// 2 wheel shooter drive
	public static elevatorSubsystem elevatorSystem;
	public static climberSubsystem climberSystem;
	public static FmsSubSystem FmsSubSystem;

	public static intakeShooterWheelsSubsystem intake;
	// public static outputShooterWheelsSubsystem output;

	// public static pidElevatorSubsystem pidElevatorSubsystem;
	public static String switchScaleLayout = "XXX";
	public static double speedLimiter = .5;
	String version = "1.2 1 day left";
	// version 1.1 added in encoder logic to drive forward, added in new fms
	// formating for calculating fms in auto init

	// Declaring Preferences
	public static double autonLine;// start-end
	public static double RotateRight;
	public static double RotateLeft;// end
	public static double RaiseElevatorSw; // low
	public static double RaiseElevatorSc; // high
	public static double VoltsToInches; // conversion factor

	public static double C2LSw_Leg_1;// start
	public static double C2LSw_Leg_2;
	public static double C2LSw_Leg_3;// end

	public static double R2RSw_Leg_1;// start
	public static double R2RSw_Leg_2;// end
	public static double R2RSc_Leg_1;// start
	public static double R2RSc_Leg_2;// end

	public static double L2LSw_Leg_1;// start
	public static double L2LSw_Leg_2;// end
	public static double L2LSc_Leg_1;// start
	public static double L2LSc_Leg_2;// end

	public static double L2RSc_Leg_1;
	public static double L2RSc_Leg_2;
	public static double L2RSc_Leg_3;
	public static double L2RSc_Leg_4;

	public static double R2LSc_Leg_1;
	public static double R2LSc_Leg_2;
	public static double R2LSc_Leg_3;
	public static double R2LSc_Leg_4;

	public static double MultiplicationFactorForVoltage;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		System.out.println("Begining of robot init");
		RobotMap.init();
		System.out.println("After RobotMap.init");

		oi = new OI();
		System.out.println("After OI delcaration");
		driveSystem = new driveSystem();// 6 wheel drive
		System.out.println("After drive initialization" + driveSystem);
		driveShooterSubsystem = new gripperSubsystem();// gripper shooter drive
		System.out.println("Got the subsystem   " + driveShooterSubsystem);

		elevatorSystem = new elevatorSubsystem();
		climberSystem = new climberSubsystem();
		FmsSubSystem = new FmsSubSystem();

		intake = new intakeShooterWheelsSubsystem();
		// output = new outputShooterWheelsSubsystem();

		SmartDashboard.putString("Version Number: ", version);
		prefs = Preferences.getInstance();
		autonLine = prefs.getDouble("autonLine", 0);
		RotateLeft = prefs.getDouble("RotateLeft", 0);
		RotateRight = prefs.getDouble("RotateRight", 0);
		RaiseElevatorSc = prefs.getDouble("RaiseElevatorSc", 0);
		RaiseElevatorSw = prefs.getDouble("RaiseElevatorSw", 0);

		C2LSw_Leg_1 = prefs.getDouble("C2LSw_Leg_1", 0);
		C2LSw_Leg_2 = prefs.getDouble("C2LSw_Leg_2", 0);
		C2LSw_Leg_3 = prefs.getDouble("C2LSw_Leg_3", 0);

		R2RSw_Leg_1 = prefs.getDouble("R2RSw_Leg_1", 0);
		R2RSw_Leg_2 = prefs.getDouble("R2RSw_Leg_2", 0);
		R2RSc_Leg_1 = prefs.getDouble("R2RSc_Leg_1", 0);
		R2RSc_Leg_2 = prefs.getDouble("R2RSc_Leg_2", 0);

		L2LSw_Leg_1 = prefs.getDouble("L2LSw_Leg_1", 0);
		L2LSw_Leg_2 = prefs.getDouble("L2LSw_Leg_2", 0);
		L2LSc_Leg_1 = prefs.getDouble("L2LSc_Leg_1", 0);
		L2LSc_Leg_2 = prefs.getDouble("L2LSc_Leg_2", 0);

		L2RSc_Leg_1 = prefs.getDouble("L2RSc_Leg_1", 0);
		L2RSc_Leg_2 = prefs.getDouble("L2RSc_Leg_2", 0);
		L2RSc_Leg_3 = prefs.getDouble("L2RSc_Leg_3", 0);
		L2RSc_Leg_4 = prefs.getDouble("L2RSc_Leg_4", 0);

		R2LSc_Leg_1 = prefs.getDouble("R2LSc_Leg_1", 0);
		R2LSc_Leg_2 = prefs.getDouble("R2LSc_Leg_2", 0);
		R2LSc_Leg_3 = prefs.getDouble("R2LSc_Leg_3", 0);
		R2LSc_Leg_4 = prefs.getDouble("R2LSc_Leg_4", 0);

		MultiplicationFactorForVoltage = prefs.getDouble("Multiplication Factor For Voltage", 0);
		System.out.println(autonLine);

		// switchScaleLayout = FmsSubSystem.getSwitchAndScaleLayout();

		System.out.println("Starting the auto chooser with FMS value of:" + switchScaleLayout);// printed the printline
																								// START HERE ON 1/20
																								// TODO
		// chooser.addDefault("Autonomous Command", new CenterSwitch());
		chooser.addDefault("Center Switch", new AutoTester(1));// 1
		chooser.addObject("Right Scale / AutonLine", new AutoTester(2));// 2
		chooser.addObject("Left Scale / AutonLine", new AutoTester(3));// 3 //tests left scale then default is auto-line
		chooser.addObject("Right Switch / AutonLine", new AutoTester(4));// 4 //tests right switch then default is
																			// auto-line
		chooser.addObject("Left Switch / AutonLine", new AutoTester(5));// 5 //tests left switch then default is
																		// auto-line
		chooser.addObject("Right All Scale Priority", new AutoTester(6));// 6
		chooser.addObject("Right All Switch Priority", new AutoTester(7));// 7
		chooser.addObject("Left All Scale Priority", new AutoTester(8));// 8
		chooser.addObject("Left All Switch Priority", new AutoTester(9)); // 9
		chooser.addObject("Left To Both Scales", new AutoTester(11));// 10
		chooser.addObject("Right To Both Scales", new AutoTester(10));// 11

		// chooser.addObject("Do nothing", new SpeedyBoiStop());
		// chooser.addObject("Auton Line", new AutoTester(1));//0
		// chooser.addObject("Center Switch", new ());//1
		// chooser.addObject("Right Scale / AutonLine", new
		// RightPositionToRightScale(true));//2
		// chooser.addObject("Left Scale / AutonLine", new
		// LeftPositionToLeftScale(true));//3
		// chooser.addObject("Right Switch / AutonLine", new
		// RightPositionToRightSwitch(true));//4
		// chooser.addObject("Left Switch / AutonLine", new
		// LeftPositionToLeftSwitch(true));//5
		// chooser.addObject("Right All Scale Priority", new
		// RightPositionAllPriority(false));//6
		// chooser.addObject("Right All Switch Priority", new
		// RightPositionAllPriority(true));//7
		// chooser.addObject("Left All Scale Priority", new
		// LeftPositionAllPriority(false));//8
		// //chooser.addObject("Left All Switch Priority", new
		// LeftPositionAllPriority(true));//9
		// chooser.setName("Left All Switch Priority", nine); //9
		// chooser.addObject("Left To Both Scales", new RightPositionBothScales());//10
		// chooser.addObject("Right To Both Scales", new LeftPositionBothScales());//11
		//
		SmartDashboard.putData("Auto mode", chooser);
		System.out.println("Should have displayed autonomous chooser");
		SmartDashboard.putBoolean("Solonoid value for gripper", RobotMap.openCloseGripper.get());
		SmartDashboard.putBoolean("Solonoid value for switching gears", RobotMap.switchGear.get());

		SmartDashboard.putBoolean("TopElevatorSwitch", RobotMap.elevatorTopLimitSwitch.get());
		SmartDashboard.putBoolean("BottomElevatorSwitch", RobotMap.elevatorBottomLimitSwitch.get());
		SmartDashboard.putBoolean("DeployedGripperSwitch", RobotMap.gripperDeployedLimitSwitch.get());
		SmartDashboard.putBoolean("StoredGripperSwitch", RobotMap.gripperStoredLimitSwitch.get());

		cam0 = CameraServer.getInstance().startAutomaticCapture("Front", 0);
		cam0.setResolution(IMG_WIDTH, IMG_HEIGHT);
		cam0.setFPS(15);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
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
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		// TODO Fix FMS readings
		System.out.println("Begining of automouse init");
		AutoTester thing = (AutoTester) chooser.getSelected();
		switchScaleLayout = FmsSubSystem.getSwitchAndScaleLayout();
		// selected = chooser.getSelected().getName();
		System.out.println("Start of choosing commands");

		if (thing.x == 1) {
			autonomousCommand = new CenterSwitch();
		} else if (thing.x == 2) {
			autonomousCommand = new RightPositionToRightScale(true); // does scale the autonline
		} else if (thing.x == 3) {
			autonomousCommand = new LeftPositionToLeftScale(true); // does scale the autonline
		} else if (thing.x == 4) {
			autonomousCommand = new RightPositionToRightSwitch(true); // does switch the autonline
		} else if (thing.x == 5) {
			autonomousCommand = new LeftPositionToLeftSwitch(true); // does switch the autonline
		} else if (thing.x == 6) {
			autonomousCommand = new RightPositionAllPriority(false); // does scale then switch then autonline
		} else if (thing.x == 7) {
			autonomousCommand = new RightPositionAllPriority(true); // does switch then scale then autonline
		} else if (thing.x == 8) {
			autonomousCommand = new LeftPositionAllPriority(false); // does scale then switch then autonline
		} else if (thing.x == 9) {
			autonomousCommand = new LeftPositionAllPriority(true); // does switch then scale then autonline
		} else if (thing.x == 10) {
			autonomousCommand = new RightPositionBothScales(); // does scale regardless of position
		} else if (thing.x == 11) {
			autonomousCommand = new LeftPositionBothScales(); // does scale regardless of position
		} else {
			autonomousCommand = new DrivePastAutonLine(); // passes the autonline
		}
		// autonomousCommand = new DrivePastAutonLine();
		System.out.println("After choosing commands");

		// schedule the autonomous command (example)
		// switchScaleLayout = FmsSubSystem.getSwitchAndScaleLayout();
		System.out.println("Entering autonomous init: " + FmsSubSystem.getSwitchAndScaleLayout());
		// autonomousCommand = chooser.getSelected();
		System.out.println(autonomousCommand);

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		System.out.println("Leaving autonomous init");
		RobotMap.driveADXR450Gyro.reset();
		SmartDashboard.putBoolean("Solonoid value for switching gears (High Gear is false)", RobotMap.switchGear.get());
		RobotMap.switchGear.set(false);

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putString("Reading FMS value", FmsSubSystem.getSwitchAndScaleLayout());
		SmartDashboard.putNumber("Encoder value", RobotMap.driveEncoder.getDistance());
		// TODO add visual for elevator height
		// SmartDashboard.putNumber("Elevator distance(Potentiometer Voltage)",
		// Robot.elevatorSystem.getFeedback());
		SmartDashboard.putNumber("Gyro value", RobotMap.driveADXR450Gyro.getAngle());
		// SmartDashboard.putNumber("Potentiometer Average Voltage",
		// RobotMap.m_potentiometer.getAverageVoltage());
		// SmartDashboard.putNumber("Potentiometer Voltage",
		// RobotMap.m_potentiometer.getVoltage());
		// SmartDashboard.putNumber("Potentiometer Reading",
		// RobotMap.m_potentiometer.getValue());
		SmartDashboard.putNumber("Motor Current Speed", RobotMap.elevatorMotor.get());
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
		// System.out.println("Running teleop");
		System.out.println("In teleop periodic");
		Robot.oi.gearLeftTrigger.whenPressed(new SwitchOElGearO(true));
		Robot.oi.gearRightTrigger.whenPressed(new SwitchOElGearO(false));
		Robot.oi.openGripper.whenPressed(new OpenGripper());
		Robot.oi.closeGripper.whenPressed(new CloseGripper());

		// Robot.oi.leftTrigger.whenActive(new IntakeDriveShooterWheels());
		// Robot.oi.rightTrigger.whileActive(new OutputDriveShooterWheels());

		// SmartDashboard.putNumber("Elevator distance(Potentiometer Voltage)",
		// RobotMap.m_potentiometer.getVoltage() * MultiplicationFactorForVoltage);
		SmartDashboard.putBoolean("Solonoid value for gripper", RobotMap.openCloseGripper.get());
		SmartDashboard.putBoolean("Solonoid value for switching gears (High Gear)", RobotMap.switchGear.get());

		SmartDashboard.putBoolean("TopElevatorSwitch", RobotMap.elevatorTopLimitSwitch.get());
		SmartDashboard.putBoolean("BottomElevatorSwitch", RobotMap.elevatorBottomLimitSwitch.get());
		SmartDashboard.putBoolean("DeployedGripperSwitch", RobotMap.gripperDeployedLimitSwitch.get());
		SmartDashboard.putBoolean("StoredGripperSwitch", RobotMap.gripperStoredLimitSwitch.get());

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
