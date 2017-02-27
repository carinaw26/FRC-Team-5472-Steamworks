package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

//when the boiler is on right and starting from inner line of overflow loading station
public class AutoMidToBoilerCommand extends Command {
	public AutoMidToBoilerCommand() {
		requires(Robot.driveSubsystem);
	}
	@Override
	public void end() {
		Robot.driveSubsystem.stop();
	}
	@Override
	public void execute() {
		while (Robot.driveSubsystem.getLeftEncoder().getDistance() > -10.4315)
			Robot.driveSubsystem.drive(-0.3, -0.3);
		Robot.driveSubsystem.drive(0.1, 0.1);// slow down
		Timer.delay(0.3);

		Robot.driveSubsystem.drive(0, 0);// stop
		Robot.driveSubsystem.turnToHeading(-90);// turn right 90 degrees

		Robot.driveSubsystem.getLeftEncoder().reset();
		Robot.driveSubsystem.getRightEncoder().reset();

		while (Robot.driveSubsystem.getLeftEncoder().getDistance() > -110.39)
			Robot.driveSubsystem.drive(-0.3, -0.3);

		Robot.driveSubsystem.drive(0.1, 0.1);// slow down
		Timer.delay(0.3);

		Robot.driveSubsystem.drive(0, 0);// stop

		Robot.driveSubsystem.turnToHeading(0);
		Robot.driveSubsystem.getLeftEncoder().reset();
		Robot.driveSubsystem.getRightEncoder().reset();

		while (Robot.driveSubsystem.getLeftEncoder().getDistance() > -117.94)
			Robot.driveSubsystem.drive(-0.3, -0.3);

		Robot.driveSubsystem.drive(0.1, 0.1);// slow down
		Timer.delay(0.3);

		Robot.driveSubsystem.drive(0, 0);// stop


		Robot.driveSubsystem.turnToHeading(60);// turn to be facing lift

		Robot.driveSubsystem.getLeftEncoder().reset();
		Robot.driveSubsystem.getRightEncoder().reset();

		while (Robot.driveSubsystem.getLeftEncoder().getDistance() > -55.88)
			Robot.driveSubsystem.drive(-0.3, -0.3);

		Robot.driveSubsystem.drive(0.1, 0.1);
		Timer.delay(0.3);
		Robot.driveSubsystem.drive(0.0, 0.0);
		// time for pilot to pick up gear
		Robot.driveSubsystem.stop();

		// add shooting
	}

	@Override
	public void initialize() {
		//do I put anything here?
	}

	@Override
	public void interrupted() {
		end();
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

