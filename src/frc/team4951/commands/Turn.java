package frc.team4951.commands;

public class Turn extends PIDCommandBase {

    public Turn(double t) {
        super("Gyro PID", 1.0/135, 0 , 0);
        getPIDController().setAbsoluteTolerance(2);
        getPIDController().setContinuous(true);
        getPIDController().setInputRange(0, 360);
        getPIDController().setOutputRange(-1, 1);
        setSetpoint(t);
    }

    @Override
    protected void initialize() {
        driveTrain.reset();
    }

    @Override
    protected void execute() {
        getPIDController().enable();
    }

    @Override
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }

    @Override
    protected void end() {
        driveTrain.stop();
        driveTrain.reset();
    }

    @Override
    protected double returnPIDInput() {
        return driveTrain.getGyro();
    }

    @Override
    protected void usePIDOutput(double output) {
        driveTrain.arcadeDrive(0, output);
    }
}
