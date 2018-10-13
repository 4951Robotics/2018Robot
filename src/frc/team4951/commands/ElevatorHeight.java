package frc.team4951.commands;

public class ElevatorHeight extends CommandBase {

    private int encoderTicks;

    public ElevatorHeight(int encoderTicks) {
        this.encoderTicks = encoderTicks;
    }

    @Override
    protected void execute() {
        frontElevator.setHeight(encoderTicks);
    }

    @Override
    protected boolean isFinished() {
        return  Math.abs(frontElevator.getPosition() - encoderTicks) <= 100 || frontElevator.getBottomLimit();
    }

    @Override
    protected void end() {
        frontElevator.manualMove(0);
    }
}
