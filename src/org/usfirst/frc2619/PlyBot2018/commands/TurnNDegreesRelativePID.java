// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2619.PlyBot2018.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc2619.PlyBot2018.Robot;
import org.usfirst.frc2619.PlyBot2018.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class TurnNDegreesRelativePID extends PIDCommand {
	private double initial;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_nDegrees;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private ControlMode previousControlMode;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public TurnNDegreesRelativePID(double nDegrees) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("TurnNDegreesRelativePID", 1.0, 0.0, 0.0, 0.02);
        getPIDController().setContinuous(true);
        getPIDController().setAbsoluteTolerance(1.0);
        getPIDController().setInputRange(0.0, 360.0);
        getPIDController().setOutputRange(-0.5, 0.5);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_nDegrees = nDegrees;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    @Override
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        return RobotMap.driveTrainAHRS.getAngle();

    }

    @Override
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	int sign = (int) Math.signum(output);
    	double minSpeed = 1;
    	double finalOutput = sign * (Math.max(minSpeed, Math.abs(output)));
    	//if pid output is lower than minSpeed, set it to minSpeed

        RobotMap.driveTrainLeftFrontMotor.pidWrite(finalOutput);
        RobotMap.driveTrainRightFrontMotor.pidWrite(finalOutput);
        //PIDContoller automatically finds the shortest angle to setpoint
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	this.setTimeout(3);
    	previousControlMode = Robot.driveTrain.getControlMode();
		initial = RobotMap.driveTrainAHRS.getAngle();
		RobotMap.driveTrainAHRS.setAngleAdjustment(-initial);
		//^^^ I think this essentially sets initial angle to 0; whenever it returns the current angle,
		//it adds -initial to it, then resets it when the turn is finished.
		getPIDController().setSetpoint(m_nDegrees);
		Robot.driveTrain.setControlMode(ControlMode.PercentOutput);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isTimedOut() || getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveTrain.stop();
		RobotMap.driveTrainAHRS.setAngleAdjustment(0);
		Robot.driveTrain.setControlMode(previousControlMode);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
