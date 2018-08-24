package frc.team4951.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4951.OI;
import frc.team4951.subsystems.BackElevator;
import frc.team4951.subsystems.DriveTrain;

public class CommandBase extends Command {

    static DriveTrain driveTrain;
    static BackElevator backElevator;

    public static void init() {
        OI.init();
        driveTrain = DriveTrain.getInstance();
        backElevator = BackElevator.getInstance();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
