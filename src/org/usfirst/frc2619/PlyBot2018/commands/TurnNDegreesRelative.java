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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2619.PlyBot2018.MathUtil;
import org.usfirst.frc2619.PlyBot2018.Robot;

/**
 *
 */
public class TurnNDegreesRelative  extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_nDegrees;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double initial;
    private double current;
    private double direction;
    private double finalyaw;
 

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    
 // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	initial = Robot.driveTrain.getYaw();
    	direction = MathUtil.calcDirection(initial, initial+m_nDegrees);
    	finalyaw = initial + m_nDegrees;
    	if (finalyaw == 360) {
    		finalyaw = 0;
    	}
    	
    	this.setTimeout(3);
    }
    
    public TurnNDegreesRelative(double nDegrees) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_nDegrees = nDegrees;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	if (m_nDegrees == 360) {
    		m_nDegrees = 0;
    	}
    	
    }


    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	current = Robot.driveTrain.getYaw();
    	direction = MathUtil.calcDirection(current, finalyaw);
    	SmartDashboard.putNumber("Current Yaw", current);
    	SmartDashboard.putNumber("Final Yaw" , finalyaw);
    	SmartDashboard.putNumber("Direction" , direction);
    	
    	run();
    }
    
    private void run() {
    	final double TURNSPEED = .75;
    	double dir = 0;
    	
    	//when direction  (different from local dir), run() again to change turning direction.
    	//prevents it from going in circles when it overshoots.
    	if (direction != dir) {
    		dir = direction;
        	if (direction < 0) {	//turning left in place
        		Robot.driveTrain.run(-TURNSPEED, TURNSPEED);
        	}
        	else	//turning right
        		Robot.driveTrain.run(TURNSPEED,  -TURNSPEED);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	final double ERROR = 5;
    	
    	return (Math.abs(Math.abs(current)-Math.abs(finalyaw)) < ERROR || this.isTimedOut());
    	
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