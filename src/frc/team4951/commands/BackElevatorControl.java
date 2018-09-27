package frc.team4951.commands;

import frc.team4951.OI;
import frc.team4951.subsystems.BackElevator;

public class BackElevatorControl extends CommandBase {

    private static final double MOTOR_SPEED = 0.8;
    private static final double DEADZONE = 0.5;
    
    @Override
    protected void initialize () {
    }
    
    @Override
    protected void execute() {
        if (OI.getOperatorLeftY() >= DEADZONE)
            backElevator.moveElevator(MOTOR_SPEED);
        else if (OI.getOperatorLeftY() <= -DEADZONE)
            backElevator.moveElevator(-MOTOR_SPEED);
        else
            backElevator.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {backElevator.stop();}
}
