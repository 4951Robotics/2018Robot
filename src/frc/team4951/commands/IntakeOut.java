package frc.team4951.commands;

public class IntakeOut extends CommandBase {

    private double timeout;

    public IntakeOut(double timeout) {
        this.timeout = timeout;
    }

    @Override
    protected void initialize () {
        setTimeout(timeout);
    }

    @Override
    protected void execute () {
        intake.out();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        intake.stop();
    }
}
