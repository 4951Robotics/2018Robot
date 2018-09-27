package frc.team4951.commands;


/**
 * 2018Robot
 * Created by Carter
 * Version 1.0
 */
public class DriveStraight extends CommandBase {
    
    private double targetDistance;
    
    public DriveStraight(double distance) {
        targetDistance = distance;
        driveTrain.reset();
    }
    
    @Override
    protected void execute () {
        driveTrain.setSetpoint(targetDistance);
        driveTrain.enable();
    }

    @Override
    protected boolean isFinished() {
        return driveTrain.onTarget();
    }

    @Override
    protected void end() {
        driveTrain.stop();
    }
}
