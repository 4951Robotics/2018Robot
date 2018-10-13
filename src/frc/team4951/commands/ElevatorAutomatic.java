package frc.team4951.commands;

import frc.team4951.ButtonDebouncer;
import frc.team4951.OI;

public class ElevatorAutomatic extends CommandBase {

    private ButtonDebouncer aDebouncer, xDebouncer, yDebouncer;

    @Override
    protected void initialize() {
        aDebouncer = new ButtonDebouncer(OI.getOperatorController(), OI.A_BUTTON, 10);
        xDebouncer = new ButtonDebouncer(OI.getOperatorController(), OI.X_BUTTON, 10);
        yDebouncer = new ButtonDebouncer(OI.getOperatorController(), OI.Y_BUTTON, 10);
    }

    @Override
    protected void execute() {

        if (aDebouncer.get()) {
            new ElevatorHeight(frontElevator.getSwitchHeight()).start();
        }

        if (xDebouncer.get()) {
            new ElevatorHeight(frontElevator.getLowScaleHeight()).start();
        }

        if (yDebouncer.get()) {
            new ElevatorHeight(frontElevator.getHighScaleHeight()).start();
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        frontElevator.manualMove(0);
    }
}
