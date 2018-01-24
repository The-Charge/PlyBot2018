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

import org.usfirst.frc2619.PlyBot2018.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick leftJoystick;
    public JoystickButton shiftHighBtn;
    public JoystickButton shiftLowBtn;
    public JoystickButton invertDriveBtn;
    public Joystick rightJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        rightJoystick = new Joystick(1);
        
        invertDriveBtn = new JoystickButton(rightJoystick, 2);
        invertDriveBtn.whenPressed(new DriveInverted());
        shiftLowBtn = new JoystickButton(rightJoystick, 3);
        shiftLowBtn.whenPressed(new ShiftLow());
        shiftHighBtn = new JoystickButton(rightJoystick, 4);
        shiftHighBtn.whenPressed(new ShiftHigh());
        leftJoystick = new Joystick(0);
        


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("TankDrive", new TankDrive());
        SmartDashboard.putData("HaloDrive", new HaloDrive());
        SmartDashboard.putData("XBoxDrive", new XBoxDrive());
        SmartDashboard.putData("ClaytonDrive", new ClaytonDrive());
        SmartDashboard.putData("ArcadeDrive", new ArcadeDrive());
        SmartDashboard.putData("DroneDrive", new DroneDrive());
        SmartDashboard.putData("TurnNDegreesRelative: 90", new TurnNDegreesRelative(90));
        SmartDashboard.putData("DriveXFeetMotionMagic: MotionMagic5Feet", new DriveXFeetMotionMagic(5));
        SmartDashboard.putData("TurnNDegreesAbs: 90", new TurnNDegreesAbs(90));
        SmartDashboard.putData("ShiftHigh", new ShiftHigh());
        SmartDashboard.putData("ShiftLow", new ShiftLow());
        SmartDashboard.putData("TurnNDegreesRelativePID: 90 degrees", new TurnNDegreesRelativePID(90));
        SmartDashboard.putData("TurnNDegreesRelativePID: 180 degrees", new TurnNDegreesRelativePID(180));
        SmartDashboard.putData("TurnNDegreesRelativePID: 270 degrees", new TurnNDegreesRelativePID(270));
        SmartDashboard.putData("DriveInverted", new DriveInverted());
        SmartDashboard.putData("TurnNDegreesAbsolutePID: 90", new TurnNDegreesAbsolutePID(90));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		SmartDashboard.putNumber("Deadband", .1);
		SmartDashboard.putNumber("Root", 1);
		SmartDashboard.putNumber("Power", 3);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

