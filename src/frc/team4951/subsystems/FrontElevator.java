package frc.team4951.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4951.RobotMap;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;
import org.opencv.core.Mat;


public class FrontElevator extends Subsystem {

    private static WPI_TalonSRX talon;
    
    private static FrontElevator instance;

    private DigitalInput bottomSwitch;

    private static final int TIMEOUT = 30, CRUISE_VEL = 0, ACCELERATION = 0,
                                TOP_LIMIT = 10000, BOTTOM_LIMIT = 100, THRESHOLD = 10;

    private static final double KF = 0.0,
                                KP = 0.0,
                                KI = 0.0,
                                KD = 0.0;
    
    // TODO find encoder ticks per inch of movement
    private static final double TICKS_PER_INCH = 500;

    private static int topSpeed = 0;

    public static FrontElevator getInstance() {
        if (instance == null)
            instance = new FrontElevator();
        return instance;
    }


    private FrontElevator() {
        talon = new WPI_TalonSRX(RobotMap.FRONT_ELEVATOR_TALON);

        bottomSwitch = new DigitalInput(RobotMap.BOTTOM_LIMIT_SWITCH);

        talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        talon.setSensorPhase(true);
        talon.setInverted(true);
        talon.setStatusFramePeriod(StatusFrame.Status_10_MotionMagic, 10, TIMEOUT);
        talon.configNominalOutputForward(0);
        talon.configNominalOutputReverse(0);
        talon.configPeakOutputForward(1);
        talon.configPeakOutputReverse(-1);
        
        talon.selectProfileSlot(0, 0);
        talon.config_kF(0, KF, TIMEOUT);
        talon.config_kP(0, KP, TIMEOUT);
        talon.config_kI(0, KI, TIMEOUT);
        talon.config_kD(0, KD, TIMEOUT);
        
        talon.configMotionCruiseVelocity(CRUISE_VEL);
        talon.configMotionAcceleration(ACCELERATION);
//        talon.configForwardSoftLimitThreshold(TOP_LIMIT);
//        talon.configReverseSoftLimitThreshold(BOTTOM_LIMIT);
//        talon.configForwardSoftLimitEnable(true);
//        talon.configReverseSoftLimitEnable(true);
        talon.setNeutralMode(NeutralMode.Brake);
        reset();
    }
    
    @Override
    protected void initDefaultCommand () {}
    
    public void log() {
        SmartDashboard.putNumber("Elevator Encoder", talon.getSelectedSensorPosition());
        SmartDashboard.putNumber("Elevator Rotations", talon.getSelectedSensorPosition() / 4096.0);
        if (talon.getSelectedSensorVelocity() > topSpeed)
            topSpeed = talon.getSelectedSensorVelocity();
        SmartDashboard.putNumber("Top Speed: ", topSpeed);

    }
    
    public void neutralMode(NeutralMode neutralMode) {talon.setNeutralMode(neutralMode);}
    
    public void reset () {talon.setSelectedSensorPosition(0);}
    
    public boolean onTarget() {
        return Math.abs(talon.getClosedLoopTarget() - talon.getClosedLoopError()) <= THRESHOLD;
    }

    public boolean getBottomLimit() {
        return bottomSwitch.get();
    }

    /**
     * @param height Height of the elevator to travel, in encoder ticks
     */
    public void setHeight(double height) {
        talon.set(ControlMode.MotionMagic, height);
    }
    
    /**
     * @param speed Percent output from -1 to 1
     */
    public void manualMove(double speed) {
        talon.set(ControlMode.PercentOutput, speed);
    }
    
}
