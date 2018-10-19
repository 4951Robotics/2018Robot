package frc.team4951.commands;

import frc.team4951.ButtonDebouncer;
import frc.team4951.OI;
import frc.team4951.subsystems.FrontElevator;

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
            new ElevatorHeight(FrontElevator.getSwitchHeight()).start();
        }

        if (xDebouncer.get()) {
            new ElevatorHeight(FrontElevator.getLowScaleHeight()).start();
        }

        if (yDebouncer.get()) {
            new ElevatorHeight(FrontElevator.getHighScaleHeight()).start();
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
