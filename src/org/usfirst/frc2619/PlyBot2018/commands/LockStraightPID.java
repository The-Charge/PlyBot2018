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

import org.usfirst.frc2619.PlyBot2018.MathUtil;
import org.usfirst.frc2619.PlyBot2018.Robot;
import org.usfirst.frc2619.PlyBot2018.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 *
 */
public class LockStraightPID extends PIDCommand {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	private double setpointAngle;
	private ControlMode previousControlMode;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public LockStraightPID() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        super("LockStraightPID", 1.0, 0.0, 0.0, 0.02);
        getPIDController().setInputRange(-180.0, 180.0);
        getPIDController().setContinuous(true);
        getPIDController().setAbsoluteTolerance(0.2);
        getPIDController().setOutputRange(-1.0, 1.0);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

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

        return RobotMap.driveTrainAHRS.pidGet();

    }

    @Override
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

    	double rightSpeed, leftSpeed;
    	rightSpeed = -Robot.oi.rightJoystick.getY();
    	leftSpeed = -Robot.oi.leftJoystick.getY();
    	rightSpeed = MathUtil.adjSpeed(rightSpeed);
    	leftSpeed = MathUtil.adjSpeed(leftSpeed);
    	
    	double averageSpeed;
    	averageSpeed = (leftSpeed+rightSpeed)/2;
    	leftSpeed = averageSpeed;
    	rightSpeed = averageSpeed;
    	
    	if (output > 0) {	//if it needs to turn right; slow down right motor
            RobotMap.driveTrainLeftFrontMotor.pidWrite(leftSpeed);
            RobotMap.driveTrainRightFrontMotor.pidWrite(rightSpeed - output);
    	}
    	else if (output < 0) {	//if it needs to turn left; slow down left motor
            RobotMap.driveTrainLeftFrontMotor.pidWrite(leftSpeed + output);
            RobotMap.driveTrainRightFrontMotor.pidWrite(rightSpeed);
    	}
    	else {	//otherwise just use joystick input
            RobotMap.driveTrainLeftFrontMotor.pidWrite(leftSpeed);
            RobotMap.driveTrainRightFrontMotor.pidWrite(rightSpeed);
    	}

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	setpointAngle = RobotMap.driveTrainAHRS.pidGet();
    	getPIDController().setSetpoint(setpointAngle);
    	previousControlMode = Robot.driveTrain.getControlMode();
    	Robot.driveTrain.setControlMode(ControlMode.PercentOutput);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveTrain.stop();
    	Robot.driveTrain.setControlMode(previousControlMode);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
