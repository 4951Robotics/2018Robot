package frc.team4951.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BackElevator extends Subsystem {

    private static final int BACK_ELEVATOR_MOTOR = 0;

    private static BackElevator instance;

    public static BackElevator getInstance() {
        if (instance == null)
            instance = new BackElevator();
        return instance;
    }

    private Spark backMotor;

    private BackElevator() {
        backMotor = new Spark(BACK_ELEVATOR_MOTOR);
    }

    public void moveElevator(double speed) {backMotor.set(speed);}

    public void stop() {backMotor.set(0);}

    public void initDefaultCommand() {}
}

