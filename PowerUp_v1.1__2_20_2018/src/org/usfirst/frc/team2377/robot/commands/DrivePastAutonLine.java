package org.usfirst.frc.team2377.robot.commands;

import org.usfirst.frc.team2377.robot.Robot;

public class DrivePastAutonLine extends DriveForward {

	// autonLine=Robot.prefs.getDouble("autonLine",500);
	public DrivePastAutonLine() {

		super(Robot.autonLine, .45);// super referneces the extend class which is DriveForward
		// so super would take values which are passed to it and use them in drive
		// forward
	}
}
