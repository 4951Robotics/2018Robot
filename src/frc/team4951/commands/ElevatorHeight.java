package frc.team4951.commands;

import frc.team4951.OI;

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
        if (frontElevator.getTopLimit()) {
            frontElevator.setEncoderPosition(frontElevator.getTopEncoderLimit());
        } else if (frontElevator.getBottomLimit()) {
            frontElevator.reset();
        }
        return  Math.abs(frontElevator.getPosition() - encoderTicks) <= 300 || frontElevator.getTopLimit()
                || Math.abs(OI.getOperatorRightY()) > frontElevator.getDeadzone();
    }

    @Override
    protected void end() {
        frontElevator.manualMove(0);
    }
}
