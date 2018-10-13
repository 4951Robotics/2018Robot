package frc.team4951.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4951.OI;
import frc.team4951.subsystems.BackElevator;
import frc.team4951.subsystems.DriveTrain;
import frc.team4951.subsystems.FrontElevator;
import frc.team4951.subsystems.Intake;

public class CommandBase extends Command {

    public static DriveTrain driveTrain;
    static BackElevator backElevator;
    static Intake intake;
    static FrontElevator frontElevator;

    public static void init() {
        OI.init();
        
        frontElevator = FrontElevator.getInstance();
        intake = Intake.getInstance();
        driveTrain = DriveTrain.getInstance();
        backElevator = BackElevator.getInstance();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
