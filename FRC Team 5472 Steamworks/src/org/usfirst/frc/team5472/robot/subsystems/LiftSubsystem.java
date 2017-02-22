package org.usfirst.frc.team5472.robot.subsystems;

import org.usfirst.frc.team5472.robot.RobotMap;
import org.usfirst.frc.team5472.robot.commands.LiftDefaultCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftSubsystem extends Subsystem {
	private CANTalon liftMotor;

	private Solenoid liftSolenoid0;

	public LiftSubsystem() {
		super("Lift");

		this.liftMotor = new CANTalon(RobotMap.liftMotor);
		this.liftSolenoid0 = new Solenoid(RobotMap.liftSolenoid0);

		Thread t = new Thread(() -> {
			double current;
			while (DriverStation.getInstance().isEnabled()) {
				current = liftMotor.getOutputCurrent();
				SmartDashboard.putNumber("Lift Current", current);

				try {
					this.wait(200L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (liftSolenoid0.get())
					SmartDashboard.putString("LiftSolenoid", "LOCKED");
				else
					SmartDashboard.putString("LiftSolenoid", "UNWIND");// check

				if (current > 20)
					SmartDashboard.putString("LiftMonitor", "CURRENT TOO HIGH");// Aramis,

				// here
			}

		});
		t.start();
		System.out.println("Initialized: Lift");
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LiftDefaultCommand());
	}

	public void setLift(double d) {
		if (d >= 0.0)
			liftMotor.set(d);
		else {
			// trigger solenoid to depressurize or pressurize so it can release
			// the robot
			liftSolenoid0.set(false);
			liftMotor.set(d);
		}
	}
}
