package frc.team4951.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4951.commands.DriveStraight;


public class AutoLine extends CommandGroup {
    
    public AutoLine() {
        addSequential(new DriveStraight(126));
    }
    
}
