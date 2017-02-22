package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class FeedCommand extends Command {

	private Joystick j;

	public FeedCommand() {
		requires(Robot.feederSubsystem);
	}

	@Override
	public void initialize() {
		j = Robot.oi.getJoystick();
	}

	@Override
	public void execute() {
		if (j.getRawButton(RobotMap.feederButton))
			Robot.feederSubsystem.setFeeder(0.5);
		else if (j.getRawButton(RobotMap.emergencyFeedButton))
			Robot.feederSubsystem.setFeeder(-0.5);
		else
			Robot.feederSubsystem.setFeeder(0);
	}

	@Override
	public void end() {
		Robot.feederSubsystem.stop();
	}

	@Override
	public void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}