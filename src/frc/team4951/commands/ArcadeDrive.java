package frc.team4951.commands;

import frc.team4951.OI;

/**
    Command used for the driver to drive the robot using controller
 */

public class ArcadeDrive extends CommandBase {

    @Override
    protected void initialize() {
        requires(driveTrain);
    }

    @Override
    protected void execute() {driveTrain.arcadeDrive(OI.getDriverLeftY(), OI.getDriverRightX());}

    @Override
    protected boolean isFinished() {return false;}

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {super.interrupted();}

}
