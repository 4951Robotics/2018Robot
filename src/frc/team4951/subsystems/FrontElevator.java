package frc.team4951.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.team4951.RobotMap;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;


public class FrontElevator extends Subsystem {

    private static WPI_TalonSRX talon;
    
    private static FrontElevator instance;
    
    // TODO find
    private static final int TIMEOUT = 30, CRUISE_VEL = 0, ACCELERATION = 0, TICKS_PER_ROTATION = 4069,
                                TOP_LIMIT = 1000, BOTTOM_LIMIT = 100;
    
    private static final double PITCH_DIAMETER = 3; // Pitch diameter of sprocket
    
    private static final double GEAR_RATIO = 9/1.0;
    
    public static FrontElevator getInstance() {
        if (instance == null)
            instance = new FrontElevator();
        return instance;
    }

    private FrontElevator() {
        talon = new WPI_TalonSRX(RobotMap.FRONT_ELEVATOR_TALON);
        
        talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        talon.setSensorPhase(true);
        talon.setInverted(false);
        talon.setStatusFramePeriod(StatusFrame.Status_10_MotionMagic, 10, TIMEOUT);
        talon.configNominalOutputForward(0);
        talon.configNominalOutputReverse(0);
        talon.configPeakOutputForward(1);
        talon.configPeakOutputReverse(-1);
        
        talon.selectProfileSlot(0, 0);
        talon.config_kF(0, 0.1, TIMEOUT);
        talon.config_kP(0, 0.1, TIMEOUT);
        talon.config_kI(0, 0, TIMEOUT);
        talon.config_kD(0, 0, TIMEOUT);
        
        talon.configMotionCruiseVelocity(CRUISE_VEL);
        talon.configMotionAcceleration(ACCELERATION);
        talon.configForwardSoftLimitThreshold(TOP_LIMIT);
        talon.configReverseSoftLimitThreshold(BOTTOM_LIMIT);
        talon.configForwardSoftLimitEnable(true);
        talon.configReverseSoftLimitEnable(true);
        reset();
    }
    
    @Override
    protected void initDefaultCommand () {
    
    }
    
    private void reset () {
        talon.setSelectedSensorPosition(0);
    }
    
    /**
     * @param height Height of the elevator to travel, in inches (for now, might change to encoder ticks)
     */
    public void setHeight(double height) {
        talon.set(ControlMode.MotionMagic, height / (PITCH_DIAMETER * Math.PI) * GEAR_RATIO * TICKS_PER_ROTATION);
    }
    
    /**
     * @param speed Percent output from -1 to 1
     */
    private void manualMove(double speed) {
        talon.set(ControlMode.PercentOutput, speed);
    }
    
}
