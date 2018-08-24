package frc.team4951.commands;

/**
    Command used for the driver to drive the robot using controller
 */

public class ArcadeDrive extends CommandBase {

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {driveTrain.arcadeDrive();}

    @Override
    protected boolean isFinished() {return false;}

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {super.interrupted();}

}
