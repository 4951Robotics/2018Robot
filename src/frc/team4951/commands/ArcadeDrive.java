package frc.team4951.commands;

import frc.team4951.OI;

/**
    Command used for the driver to drive the robot using controller
 */

public class ArcadeDrive extends CommandBase {

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        if (OI.getDriverRB()) {
            driveTrain.arcadeDrive(-OI.getDriverLeftY(), OI.getDriverRightX() / 1.5);
        } else {
            driveTrain.arcadeDrive(-OI.getDriverLeftY() / 1.3, OI.getDriverRightX() / 1.5);
        }
    }

    @Override
    protected boolean isFinished() {return false;}

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {super.interrupted();}

}
