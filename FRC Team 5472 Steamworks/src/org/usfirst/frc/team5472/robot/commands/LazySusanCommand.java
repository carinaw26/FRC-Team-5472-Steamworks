package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class LazySusanCommand extends Command {

private Joystick j;
	
	public LazySusanCommand(){
		requires(Robot.shootSubsystem);
		
	}
	@Override
	public void initialize(){
		j = Robot.oi.getJoystick();
	}
	protected boolean isFinished() {
		return false;
	}
	
	
	@Override
	public void execute(){
		double turn = 0.0;
		int angle = j.getPOV();
		if(angle == 90)
			turn = 0.3;
		else if(angle == 270)
			turn = -0.3;
		Robot.shootSubsystem.setSusanMotor(turn);
	}
	
	
	public void end(){
		Robot.shootSubsystem.setSusanMotor(0);
	}
	
	public void interrupted(){
		end();
	}
}
