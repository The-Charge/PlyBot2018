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

/**
 *
 */
public class DroneDrive extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DroneDrive() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	double forward, turn, leftSpeed, rightSpeed;
    	forward = -Robot.oi.leftJoystick.getRawAxis(5);
    	turn = -Robot.oi.leftJoystick.getRawAxis(0);
    	if (forward > 0.0) {
            if (turn > 0.0) {
              leftSpeed = forward - turn;
              rightSpeed = Math.max(forward, turn);
            } 
            else {
              leftSpeed = Math.max(forward, -turn);
              rightSpeed = forward + turn;
            }
        } 
        else {
            if (turn > 0.0) {
              leftSpeed = -Math.max(-forward, turn);
              rightSpeed = forward + turn;
            } 
            else {
              leftSpeed = forward - turn;
              rightSpeed = -Math.max(-forward, -turn);
            }
        }
        Robot.driveTrain.run(leftSpeed, rightSpeed);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
