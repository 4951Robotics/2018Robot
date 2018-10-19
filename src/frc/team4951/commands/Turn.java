package frc.team4951.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Turn extends CommandBase {

    private double setpoint;
    private double error;
    private double turnSpeed;


    public Turn(double t) {
        setpoint = t;
        error = 0;
        turnSpeed = 0;
    }

    @Override
    protected void initialize() {
        driveTrain.reset();
    }

    @Override
    protected void execute() {
        error = setpoint - driveTrain.getGyro();
        if (error > 3) {
            driveTrain.arcadeDrive(0, 0.5);
        }
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(error) <= 3;
    }

    @Override
    protected void end() {
        driveTrain.stop();
    }

}
