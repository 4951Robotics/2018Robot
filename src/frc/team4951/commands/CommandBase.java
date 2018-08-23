package frc.team4951.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4951.subsystems.DriveTrain;

public class CommandBase extends Command {

    static DriveTrain driveTrain;
    static Intake intake;

    public static void init() {
        driveTrain = DriveTrain.getInstance();
        intake = Intake.getInstance();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
