package frc.team4951.commands;

public class Turn extends CommandBase {

    private double target;
    private double error;

    public Turn(double t) {
        error = 0;
        target = t;
    }

    @Override
    protected void initialize() {
        driveTrain.reset();
    }

    @Override
    protected void execute() {
        error = target - driveTrain.getGyro();
        double output = error * driveTrain.getkP();
        driveTrain.arcadeDrive(0, output);
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(error) <= 2;
    }

    @Override
    protected void end() {
        driveTrain.stop();
    }
}
