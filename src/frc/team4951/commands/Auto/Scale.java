package frc.team4951.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4951.commands.*;
import frc.team4951.subsystems.FrontElevator;

class Scale extends CommandGroup {
    
    Scale (Autonomous.StartPosition pos) {
    
        if (pos == Autonomous.StartPosition.LEFT) {
            this.addParallel(new DropIntake(0.5));
            this.addSequential(new DriveLiftElevator(264, FrontElevator.getHighScaleHeight()));
            this.addSequential(new Turn(20));
            this.addSequential(new IntakeOut(0.5));
        
        } else if (pos == Autonomous.StartPosition.RIGHT) {
            this.addParallel(new DropIntake(0.5));
            this.addSequential(new DriveLiftElevator(264, FrontElevator.getHighScaleHeight()));
            this.addSequential(new Turn(-20));
            this.addSequential(new IntakeOut(0.5));
        }
    }
}
