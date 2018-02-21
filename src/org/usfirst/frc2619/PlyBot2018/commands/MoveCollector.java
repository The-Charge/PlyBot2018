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
public class MoveCollector extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private boolean m_forward;
    private boolean m_reverse;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public MoveCollector(boolean forward, boolean reverse) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_forward = forward;
        m_reverse = reverse;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.collector);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.reverseCollector);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	if (m_forward) {
    		Robot.collector.setOutput(.05);
        	Robot.reverseCollector.setOutput(.05);
        	Robot.collector.enable();
        	Robot.reverseCollector.enable();
    	}
    	else if (m_reverse) {
    		Robot.collector.setOutput(-.05);
        	Robot.reverseCollector.setOutput(-.05);
        	Robot.collector.enable();
        	Robot.reverseCollector.enable();
    	}
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
    	Robot.collector.stop();
    	Robot.reverseCollector.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
