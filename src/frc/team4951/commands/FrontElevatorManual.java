package frc.team4951.commands;

import frc.team4951.OI;
import frc.team4951.commands.CommandBase;

public class FrontElevatorManual extends CommandBase {

    private static final double DEADZONE = 0.5;

    @Override
    protected void execute() {
        if (OI.getOperatorRightY() > DEADZONE) {
            frontElevator.manualMove(OI.getOperatorRightY());
        } else
            frontElevator.manualMove(0);
    }
}