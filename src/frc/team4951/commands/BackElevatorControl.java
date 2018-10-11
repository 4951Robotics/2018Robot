package frc.team4951.commands;

import frc.team4951.OI;
import frc.team4951.subsystems.BackElevator;

public class BackElevatorControl extends CommandBase {

    private static final double DEADZONE = 0.3;
    
    @Override
    protected void initialize () {
    }
    
    @Override
    protected void execute() {
        if (Math.abs(OI.getOperatorLeftY()) >= DEADZONE)
            backElevator.moveElevator(-OI.getOperatorLeftY());
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
