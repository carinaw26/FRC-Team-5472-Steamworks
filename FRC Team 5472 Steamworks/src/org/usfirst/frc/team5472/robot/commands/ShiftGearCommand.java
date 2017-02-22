package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftGearCommand extends Command {

	public ShiftGearCommand() {
		requires(Robot.driveSubsystem);
	}

	@Override
	public void initialize() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	public void execute() {
		Robot.driveSubsystem.switchSolenoid();
	}

	@Override
	public void interrupted() {
		end();
	}

}