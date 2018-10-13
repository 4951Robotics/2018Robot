package frc.team4951.commands;

import frc.team4951.OI;

public class FrontElevatorManual extends CommandBase {

    private static final double DEADZONE = 0.2;

    @Override
    protected void execute() {
        if (Math.abs(OI.getOperatorRightY()) > DEADZONE) {
            frontElevator.manualMove(-OI.getOperatorRightY());
        } else
            frontElevator.manualMove(0);
    }
}