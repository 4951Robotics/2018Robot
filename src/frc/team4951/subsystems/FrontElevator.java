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

    private DigitalInput topSwitch;

    private static final int TIMEOUT = 30, CRUISE_VEL = 500, ACCELERATION = 750,
                                TOP_LIMIT = 25900;

    private static final double KF = 1.8366,
                                KP = 0.0,
                                KI = 0.0,
                                KD = 0.0;

    private static final int[] ENCODER_TICKS = {8000, 19000, 25900};

    private static final double DEADZONE = 0.2; // Deadzone for controller

    public static FrontElevator getInstance() {
        if (instance == null)
            instance = new FrontElevator();
        return instance;
    }


    private FrontElevator() {
        talon = new WPI_TalonSRX(RobotMap.FRONT_ELEVATOR_TALON);

        bottomSwitch = new DigitalInput(RobotMap.BOTTOM_LIMIT_SWITCH);

        topSwitch = new DigitalInput(RobotMap.TOP_LIMIT_SWITCH);

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
        talon.configForwardSoftLimitThreshold(TOP_LIMIT);
//        talon.configReverseSoftLimitThreshold(BOTTOM_LIMIT);
        talon.configForwardSoftLimitEnable(true);
//        talon.configReverseSoftLimitEnable(true);
        talon.setNeutralMode(NeutralMode.Brake);
        reset();
    }
    
    @Override
    protected void initDefaultCommand () {}
    
    public void log() {
        SmartDashboard.putNumber("Elevator Encoder", talon.getSelectedSensorPosition());
    }

    public void reset () {talon.setSelectedSensorPosition(0);}
    
    public int getPosition() {
        return talon.getSelectedSensorPosition();
    }

    public boolean getBottomLimit() {
        return !bottomSwitch.get();
    }

    public boolean getTopLimit() {return !topSwitch.get();}

    /**
     * @param height Height of the elevator to travel, in encoder ticks
     */
    public void setHeight(int height) {
        talon.set(ControlMode.MotionMagic, height);
    }
    
    /**
     * @param speed Percent output from -1 to 1
     */
    public void manualMove(double speed) {
        if (getBottomLimit()) {
            speed = Math.max(0, speed);
            reset();
        } else if (getTopLimit()) {
            speed = Math.min(0, speed);
            talon.setSelectedSensorPosition(25900);
        }

        talon.set(ControlMode.PercentOutput, speed);
    }

    public void setEncoderPosition(int pos) {talon.setSelectedSensorPosition(pos);}

    public int getTopEncoderLimit() {return TOP_LIMIT;}

    public double getDeadzone() {return DEADZONE;}

    public static int getSwitchHeight() {return ENCODER_TICKS[0];}

    public static int getLowScaleHeight() {return ENCODER_TICKS[1];}

    public static int getHighScaleHeight() {return ENCODER_TICKS[2];}
    
}
