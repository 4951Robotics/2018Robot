package frc.team4951.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.team4951.subsystems.DriveTrain;

public abstract class PIDCommandBase extends PIDCommand {

    public static DriveTrain driveTrain;

    public PIDCommandBase(String name, double p, double i, double d) {
        super(name, p, i, d);
    }

    public PIDCommandBase(String name, double p, double i, double d, double period) {
        super(name, p, i, d, period);
    }

    public PIDCommandBase(double p, double i, double d) {
        super(p, i, d);
    }

    public PIDCommandBase(double p, double i, double d, double period) {
        super(p, i, d, period);
    }

    public static void init() {
        driveTrain = DriveTrain.getInstance();
    }
}
