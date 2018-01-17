// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package src.org.usfirst.frc2619.PlyBot2018.commands;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2619.PlyBot2018.Robot;
import org.usfirst.frc2619.PlyBot2018.RobotMap;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class TurnNDegreesAbs extends Command {
	

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	private double m_Angle;
	private double degreeCurrent;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public TurnNDegreesAbs(double Angle) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
    	 
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
         m_Angle = Angle;
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
         requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {	
    	Robot.driveTrain.absTurn(m_Angle);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	degreeCurrent = Robot.driveTrain.getAHRSAngle();
    	boolean done = false;
    	if (degreeCurrent >= m_Angle -2 || degreeCurrent <= m_Angle + 2)
    		done = true;
    	return isTimedOut() || done;
    }

    private boolean isTimedOut() {
		// TODO Auto-generated method stub
		return false;
	}

	// Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveTrain.run(0,0);
		
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
