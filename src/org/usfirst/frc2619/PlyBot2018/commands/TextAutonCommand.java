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

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2619.PlyBot2018.subsystems.*;

/**
 *
 */
public class TextAutonCommand extends CommandGroup {
	  private int locFT = 0, locDG = 0;
	  private String computedAuton = "";

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public TextAutonCommand(String rawAuton) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
    	String fourPaths[] = rawAuton.split("\\|");
    	String switchColors = DriverStation.getInstance().getGameSpecificMessage().substring(0, 2);
    	
    	System.out.println(switchColors);
    	
    	for(String a : fourPaths) {
    		System.out.println(a);
    		if (a.startsWith(switchColors)) {
    			computedAuton = a.substring(3);
    		}
    	}
    	
    	System.out.println("ComputedAuton\n" + computedAuton);
    	
    	while(computedAuton.length() > 0) {
    		System.out.println(computedAuton);
    		
	    	locFT = computedAuton.indexOf("ft");
	    	locDG = computedAuton.indexOf("dg");

	    	if(locDG < 0) {
	    		locDG = 999;
	    	}
	    	if(locFT < 0) {
	    		locFT = 999;
	    	}
	    	
	    	if(locDG > locFT) {
	    		//these do not happen
	    		addSequential(new DriveXFeetMotionMagic(Integer.parseInt(computedAuton.substring(0, locFT))));
	    		System.out.println("DrivingXFeet");
	    		if(computedAuton.length() > 3)
	    			computedAuton = computedAuton.substring(locFT+3);
	    		else
	    			computedAuton = "";
	    	}
	    	else {
	    		addSequential(new TurnNDegreesAbsolutePID(Integer.parseInt(computedAuton.substring(0, locDG))));
	    		System.out.println("TurningNDegrees");
	    		if(computedAuton.length() > 3)
	    			computedAuton = computedAuton.substring(locDG+3);
	    		else
	    			computedAuton = "";
	    	}
    	}
    	System.out.println("end");
    } 
}
