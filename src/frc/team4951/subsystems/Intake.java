package frc.team4951.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4951.RobotMap;

public class Intake extends Subsystem {

    // Motor controller running wheels
    private Spark wheels = new Spark(RobotMap.INTAKE_SPARK);
    
    // Motor controller running wrist joint
    private Spark wrist = new Spark(RobotMap.WRIST_SPARK);

    // Solenoid for piston
    private DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.SOLENOID_F, RobotMap.SOLENOID_R);

    // Speed for wheels
    private static final double IN_SPEED = 0.8;
    private static final double OUT_SPEED = -0.5;
    
    // Speed for wrist joint
    private static final double WRIST_SPEED = 0.6;
    
    private static Intake instance;

    public static Intake getInstance() {
        if (instance == null)
            instance = new Intake();
        return instance;
    }

    public void in() {wheels.set(IN_SPEED);}
    
    public void out() {wheels.set(OUT_SPEED);}

    public void stop() {wheels.set(0);}
    
    public void open() {solenoid.set(DoubleSolenoid.Value.kForward);}
    
    public void close() {solenoid.set(DoubleSolenoid.Value.kReverse);}
    
    public void wristUp() {wrist.set(-WRIST_SPEED);}
    
    public void wristDown() {wrist.set(WRIST_SPEED);}

    public void wristStop() {wrist.set(0);}
    
    public boolean isOpen() {return solenoid.get() == DoubleSolenoid.Value.kForward;}

    public void initDefaultCommand() {}

}

