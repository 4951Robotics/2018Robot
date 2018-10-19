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

    private static final double INCHES_PER_PULSE = 6 * Math.PI / 360;  // Wheel diameter of 6 inches and 360 encoder pulses per rotation

    private DifferentialDrive drive;
    
    private static Encoder encoder;

    private AnalogGyro gyro;

    private DriveTrain() {

        super("DriveTrain PID", 0.025, 0.0, 0.25);

        setAbsoluteTolerance(1);

        setOutputRange(-0.7, 0.7);

        VictorSP left = new VictorSP(RobotMap.LEFT_VICTOR);
        VictorSP right = new VictorSP(RobotMap.RIGHT_VICTOR);
        
        drive = new DifferentialDrive(left, right);

        encoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
        encoder.setDistancePerPulse(INCHES_PER_PULSE);
        encoder.reset();
        
        gyro = new AnalogGyro(RobotMap.GYRO_CHANNEL);
        gyro.calibrate();
        gyro.reset();

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
        if (Math.abs(error) > 5) {
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
        SmartDashboard.putData("Drive PID", this.getPIDController());
        SmartDashboard.putNumber("Encoder", encoder.get());
        SmartDashboard.putNumber("Encoder Distance", encoder.getDistance());
        SmartDashboard.putNumber("Gyro", gyro.getAngle());
    }

}
