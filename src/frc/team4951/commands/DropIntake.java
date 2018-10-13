package frc.team4951.commands;

public class DropIntake extends CommandBase{

    private double timeout;

    public DropIntake(double timeout) {
        this.timeout = timeout;
    }

    @Override
    protected void initialize() {
        setTimeout(timeout);
    }

    @Override
    protected void execute() {
        intake.wristDown();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        intake.wristStop();
    }
}
