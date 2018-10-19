package frc.team4951.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4951.commands.*;
import frc.team4951.subsystems.FrontElevator;

class Scale extends CommandGroup {
    
    Scale (Autonomous.StartPosition pos, char scaleSide) {
    
        if (pos == Autonomous.StartPosition.LEFT ) {
            if (scaleSide == 'L') {
                this.addParallel(new DropIntake(0.5));
                this.addSequential(new DriveLiftElevator(264, FrontElevator.getHighScaleHeight()));
                this.addSequential(new Turn(45));
                this.addSequential(new IntakeOut(1));
            } else if (scaleSide == 'R') {
                this.addSequential(new DriveStraight(256));
                this.addSequential(new Turn(90));
                this.addSequential(new DriveStraight(181));
            }
        
        } else if (pos == Autonomous.StartPosition.RIGHT) {
            if (scaleSide == 'R') {
                this.addParallel(new DropIntake(0.5));
                this.addSequential(new DriveLiftElevator(264, FrontElevator.getHighScaleHeight()));
                this.addSequential(new Turn(-45));
                this.addSequential(new IntakeOut(1));
            } else if (scaleSide == 'L') {
                this.addSequential(new DriveStraight(256));
                this.addSequential(new Turn(-90));
                this.addSequential(new DriveStraight(181));
            }
        }
    }
}
