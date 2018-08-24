package frc.team4951.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team4951.OI;
import frc.team4951.RobotMap;
import frc.team4951.commands.ArcadeDrive;


public class DriveTrain extends PIDSubsystem {

    private static DriveTrain instance;

    public static DriveTrain getInstance() {
        if (instance == null)
            instance = new DriveTrain();
        return instance;
    }

    private DifferentialDrive drive;

    private AnalogGyro gyro;

    private DriveTrain() {
        // Initialize your subsystem here
        super(0, 0, 0 /* TODO: decide which super constructor to use/call and set the appropriate values */);
        setAbsoluteTolerance(0.1);

        Talon leftMotor = new Talon(RobotMap.LEFT_MOTOR);
        Talon rightMotor = new Talon(RobotMap.RIGHT_MOTOR);

        drive = new DifferentialDrive(leftMotor, rightMotor);

        gyro = new AnalogGyro(RobotMap.GYRO_CHANNEL);
        gyro.calibrate();

    }

    public void arcadeDrive() {
        double ly = OI.getDriverLeftY();
        double rx = OI.getDriverRightX();

        drive.arcadeDrive(ly, rx);
    }


    public void initDefaultCommand() {setDefaultCommand(new ArcadeDrive());}


    // TODO set up pid control for driving a distance

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }


    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }


}
