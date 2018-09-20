package frc.team4951.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 2018Robot
 * Created by Carter
 * Version 1.0
 */
public class DriveStraight extends CommandBase {

    private static final double kP = 0.01, kI = 0.0, kD = 0.0;
    
    private PIDController drivePID;
    private PIDController rotationPID;
    
    private Encoder encoder;
    
    private double targetDistance;
    
    public DriveStraight(double distance) {
        requires(driveTrain);
        targetDistance = distance;
    }
    
    @Override
    protected void execute () {
    
    }
}
