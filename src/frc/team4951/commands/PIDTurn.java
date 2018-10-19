package frc.team4951.commands;

public class PIDTurn extends PIDCommandBase {

    public PIDTurn(double t) {
        super(0.0185,0, 0);
        getPIDController().setOutputRange(-0.5, 0.5);
        getPIDController().setAbsoluteTolerance(3);
        getPIDController().setSetpoint(t);
        driveTrain.reset();
    }

    @Override
    protected void execute() {
        getPIDController().enable();
    }

    @Override
    protected double returnPIDInput() {
        return driveTrain.getGyro();
    }

    @Override
    protected void usePIDOutput(double output) {
        driveTrain.arcadeDrive(0, output);
    }

    @Override
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }

    @Override
    protected void end() {
        driveTrain.stop();
    }


}
