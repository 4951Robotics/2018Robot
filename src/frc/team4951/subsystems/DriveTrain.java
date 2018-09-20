package frc.team4951.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team4951.OI;
import frc.team4951.Robot;
import frc.team4951.RobotMap;
import frc.team4951.commands.ArcadeDrive;
import org.opencv.core.Mat;


public class DriveTrain extends PIDSubsystem {

    private static DriveTrain instance;

    public static DriveTrain getInstance() {
        if (instance == null)
            instance = new DriveTrain();
        return instance;
    }

    private static final double WHEEL_DIAMETER = 6, GEAR_RATIO = 10.4/1, PULSES_PER_ROTATION = 1024;
    
    private PIDController rotationPID;
    
    private DifferentialDrive drive;
    
    private static Encoder encoder;

    private AnalogGyro gyro;

    private DriveTrain() {
        
        super(0.01, 0.0, 0.0);
        
        setAbsoluteTolerance(0.1);
        
        VictorSP left = new VictorSP(RobotMap.LEFT_VICTOR);
        VictorSP right = new VictorSP(RobotMap.RIGHT_VICTOR);
        
        drive = new DifferentialDrive(left, right);

        encoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
        encoder.setDistancePerPulse(WHEEL_DIAMETER * Math.PI / PULSES_PER_ROTATION / GEAR_RATIO);
        
        gyro = new AnalogGyro(RobotMap.GYRO_CHANNEL);
        
    }
    
    @Override
    protected double returnPIDInput () {
        return encoder.getDistance();
    }
    
    @Override
    protected void usePIDOutput (double output) {
    
    }
    
    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }
    
    @Override
    protected void initDefaultCommand () {}
    
}
