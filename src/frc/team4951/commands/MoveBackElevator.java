package frc.team4951.commands;

import frc.team4951.OI;

public class MoveBackElevator extends CommandBase {

    private static final double MOTOR_SPEED = 0.8;
    private static final double DEADZONE = 0.5;

    @Override
    protected void execute() {
        if (OI.getOperatorRightY() >= DEADZONE)
            backElevator.moveElevator(MOTOR_SPEED);
        else if (OI.getOperatorRightY() <= -DEADZONE)
            backElevator.moveElevator(-MOTOR_SPEED);
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(OI.getOperatorRightY()) < DEADZONE;
    }

    @Override
    protected void end() {backElevator.stop();}
}
