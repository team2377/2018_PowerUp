package org.usfirst.frc2377.SpeedyBoi.commands;

import org.usfirst.frc2377.SpeedyBoi.Robot;

public class DrivePastAutonLine extends DriveForward {
	
	//autonLine=Robot.prefs.getDouble("autonLine",500);
	public DrivePastAutonLine() {
		
		super(Robot.autonLine,.6);// super referneces the extend class which is DriveForward
		//so super would take values which are passed to it and use them in drive forward
	}
}
