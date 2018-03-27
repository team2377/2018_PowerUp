package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;

public class DrivePastAutonLine extends DriveForward {

	// autonLine=Robot.prefs.getDouble("autonLine",500);
	public DrivePastAutonLine() {
		// 100% low gear works accurately
		// was originally 60% in low gear
		super(Robot.autonLine, 1);// super referneces the extend class which is DriveForward
		// so super would take values which are passed to it and use them in drive
		// forward
	}
}
