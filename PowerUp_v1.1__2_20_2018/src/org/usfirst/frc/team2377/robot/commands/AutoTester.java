package org.usfirst.frc.team2377.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTester extends Command {
	public int x = 0;
	public AutoTester(int thing) {
		x = thing;
		
	
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
