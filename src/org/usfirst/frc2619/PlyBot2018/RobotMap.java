// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2619.PlyBot2018;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SPI.Port;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX driveTrainLeftFrontMotor;
    public static WPI_TalonSRX driveTrainLeftRearMotor;
    public static WPI_TalonSRX driveTrainRightFrontMotor;
    public static WPI_TalonSRX driveTrainRightRearMotor;
    public static AnalogPotentiometer driveTrainPot;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static AHRS driveTrainAHRS;
	
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFrontMotor = new WPI_TalonSRX(11);
        
        
        driveTrainLeftRearMotor = new WPI_TalonSRX(10);
        
        
        driveTrainRightFrontMotor = new WPI_TalonSRX(2);
        
        
        driveTrainRightRearMotor = new WPI_TalonSRX(3);
        
        
        driveTrainPot = new AnalogPotentiometer(0, 1.0, 0.0);
        LiveWindow.addSensor("DriveTrain", "Pot", driveTrainPot);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftRearMotor.follow(driveTrainLeftFrontMotor);
        driveTrainRightRearMotor.follow(driveTrainRightFrontMotor);
        
		driveTrainAHRS = new AHRS(Port.kMXP);
    }
}
