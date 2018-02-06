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
import edu.wpi.first.wpilibj.SPI.Port;
import com.kauailabs.navx.frc.AHRS;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;

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
    public static AnalogGyro driveTraindoNotUse;
    public static Solenoid shiftersSolenoid;
    public static WPI_TalonSRX collectorMotor;
    public static Solenoid clawSolenoid;
    public static Encoder elevatorQuadratureEncoder;
    public static WPI_TalonSRX elevatorMotor;
    public static DoubleSolenoid pneumaticShouldertopShoulderSolenoid;
    public static DoubleSolenoid pneumaticShoulderbottomShoulderSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static final int TIMEOUT_MS = 100;
	
    public static AHRS driveTrainAHRS = new AHRS(Port.kMXP);
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFrontMotor = new WPI_TalonSRX(11);
        
        
        driveTrainLeftRearMotor = new WPI_TalonSRX(10);
        
        
        driveTrainRightFrontMotor = new WPI_TalonSRX(2);
        
        
        driveTrainRightRearMotor = new WPI_TalonSRX(3);
        
        
        driveTrainPot = new AnalogPotentiometer(0, 1.0, 0.0);
        LiveWindow.addSensor("DriveTrain", "Pot", driveTrainPot);
        
        driveTraindoNotUse = new AnalogGyro(1);
        LiveWindow.addSensor("DriveTrain", "doNotUse", driveTraindoNotUse);
        driveTraindoNotUse.setSensitivity(0.007);
        shiftersSolenoid = new Solenoid(0, 0);
        LiveWindow.addActuator("Shifters", "Solenoid", shiftersSolenoid);
        
        collectorMotor = new WPI_TalonSRX(6);
        
        
        clawSolenoid = new Solenoid(0, 2);
        LiveWindow.addActuator("Claw", "Solenoid", clawSolenoid);
        
        elevatorQuadratureEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Elevator", "QuadratureEncoder", elevatorQuadratureEncoder);
        elevatorQuadratureEncoder.setDistancePerPulse(1.0);
        elevatorQuadratureEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        elevatorMotor = new WPI_TalonSRX(5);
        
        
        pneumaticShouldertopShoulderSolenoid = new DoubleSolenoid(0, 1, 3);
        LiveWindow.addActuator("PneumaticShoulder", "topShoulderSolenoid", pneumaticShouldertopShoulderSolenoid);
        
        pneumaticShoulderbottomShoulderSolenoid = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("PneumaticShoulder", "bottomShoulderSolenoid", pneumaticShoulderbottomShoulderSolenoid);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftRearMotor.follow(driveTrainLeftFrontMotor);
        driveTrainRightRearMotor.follow(driveTrainRightFrontMotor);
        driveTrainRightFrontMotor.setInverted(true);
        driveTrainRightRearMotor.setInverted(true);
		driveTrainAHRS = new AHRS(Port.kMXP);
    }
}
