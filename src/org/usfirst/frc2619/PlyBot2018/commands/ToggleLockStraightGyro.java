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
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2619.PlyBot2018.Robot;
import org.usfirst.frc2619.PlyBot2018.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class ToggleLockStraightGyro extends Command {
	
	private final WPI_TalonSRX leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
	private final WPI_TalonSRX rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
	private final double ERROR = 5;
	
	private double leftSpeed;
	private double rightSpeed;
	private double currentYaw;
	private double correctTo;
	private boolean correcting;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ToggleLockStraightGyro() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	correctTo = 0;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	RobotMap.driveTrainAHRS.setAngleAdjustment(-RobotMap.driveTrainAHRS.getYaw());
    		//zeros the angle
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	double currentCorrection = correctTo;
    	double speedCorrection;
    	
    	currentYaw = RobotMap.driveTrainAHRS.getYaw();
    	if (Math.abs(currentYaw) < ERROR)
    		currentYaw = 0;	//set deadband
    	
    	correctTo = -currentYaw;

		if (currentCorrection != correctTo) {
			currentCorrection = correctTo;
			correcting = !correcting;
			if (correctTo != 0) {
				leftSpeed = leftFrontMotor.getSelectedSensorVelocity(0);
				rightSpeed = rightFrontMotor.getSelectedSensorVelocity(0);
				//store motor speed at moment lock is toggled
			}
		}
		//flip toggle if yaw entered or exited the deadband zone between the last execute and this
		
		if (correcting) {
			if (correctTo > 0) {	//move CW
				Robot.driveTrain.run(1.0, rightSpeed);
			}	//testing at 1.0 speed right now, will change later
			else {	//move CCW
				Robot.driveTrain.run(leftSpeed, 1.0);
			}
		}
		else if (correctTo == 0 && currentCorrection != 0) {
			Robot.driveTrain.run(leftSpeed, rightSpeed);
			//if it gets corrected and it is not currently correcting (implied)
		}
    	
    	/*
    	if (correctTo != 0 && currentCorrection == 0) {	//if it gets off course
    		leftSpeed = leftFrontMotor.getSelectedSensorVelocity(0);
    		rightSpeed = rightFrontMotor.getSelectedSensorVelocity(0);
    		if (correctTo == 1)
    			Robot.driveTrain.run(1.0, rightSpeed);
    		else	//if 0
    			Robot.driveTrain.run(leftSpeed, 1.0);
    	}
    	
    	else if (correctTo != 0 && correctTo != 0) {
    		if (correctTo == 1)
    			Robot.driveTrain.run(1.0, rightSpeed);
    		else	//if 0
    			Robot.driveTrain.run(leftSpeed, 1.0);
    	}
    	
    	else {	//if it gets back on course
    		Robot.driveTrain.run(leftSpeed, rightSpeed);
    	}
    	*/
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	RobotMap.driveTrainAHRS.setAngleAdjustment(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
