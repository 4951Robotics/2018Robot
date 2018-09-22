package frc.team4951.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4951.RobotMap;

public class BackElevator extends Subsystem {
    
    private static BackElevator instance;

    public static BackElevator getInstance() {
        if (instance == null)
            instance = new BackElevator();
        return instance;
    }

    private Spark backMotor;

    private BackElevator() {
        backMotor = new Spark(RobotMap.BACK_ELEVATOR_MOTOR);
    }

    public void moveElevator(double speed) {backMotor.set(speed);}

    public void stop() {backMotor.set(0);}

    public void initDefaultCommand() {}
}

