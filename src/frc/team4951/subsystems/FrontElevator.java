package frc.team4951.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;


public class FrontElevator {

    private static final double DISTANCE_FROM_FLOOR = 0;
    private static final double MAX_HEIGHT = 1; // max dh of elevator
    private static final double MAX_VOLTAGE = 1; // Voltage measured at MAX_HEIGHT
    private static final double VOLTS_PER_INCH = MAX_VOLTAGE / MAX_HEIGHT;
    // System is not completely linear but close enough
    

    private static FrontElevator instance;

    public static FrontElevator getInstance() {
        if (instance == null)
            instance = new FrontElevator();
        return instance;
    }

    private FrontElevator() {}

    private void manualMove(double speed) {
    
    }
    
}
