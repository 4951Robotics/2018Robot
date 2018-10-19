package frc.team4951.commands;

import frc.team4951.OI;

public class FrontElevatorManual extends CommandBase {

    @Override
    protected void execute() {
        if (Math.abs(OI.getOperatorRightY()) > frontElevator.getDeadzone()) {
            frontElevator.manualMove(-OI.getOperatorRightY());
        } else
            frontElevator.manualMove(0);
    }
}