package frc.team4951.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

    private static final double kP = 1.0/90;

    private static final double INCHES_PER_PULSE = 6 * Math.PI / 10.71 / 1440; // TODO find inches travelled per encoder pulse

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
        encoder.setDistancePerPulse(INCHES_PER_PULSE);
        
        gyro = new AnalogGyro(RobotMap.GYRO_CHANNEL);


    }

    public void reset() {
        encoder.reset();
        gyro.reset();
    }

    @Override
    protected double returnPIDInput () {
        return encoder.getDistance();
    }

    @Override
    protected void usePIDOutput (double output) {
        double error = -getGyro();
        double rotation = 0;
        if (Math.abs(error) > 1) {
            rotation = error * kP;
        }
        arcadeDrive(output, rotation);
    }

    public void stop() {arcadeDrive(0, 0);}

    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }

    public void arcadeDrive(double speed, double rotation, boolean squaredInputs) {drive.arcadeDrive(speed, rotation, squaredInputs);}
    
    @Override
    protected void initDefaultCommand () {}

    public double getGyro() {return gyro.getAngle();}

    public void log() {
        SmartDashboard.putNumber("Encoder", encoder.get());
        SmartDashboard.putNumber("Encoder Distance", encoder.getDistance());
        SmartDashboard.putNumber("Gyro", gyro.getAngle());
    }

}
