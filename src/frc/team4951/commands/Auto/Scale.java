package frc.team4951.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4951.commands.DriveStraight;
import frc.team4951.commands.FrontElevatorControl;
import frc.team4951.commands.IntakeOut;
import frc.team4951.commands.Turn;

class Scale extends CommandGroup {
    
    Scale (Autonomous.StartPosition pos) {
    
        if (pos == Autonomous.StartPosition.LEFT) {
            this.addParallel(new DriveStraight(264));
            this.addSequential(new FrontElevatorControl(FrontElevatorControl.HEIGHTS.SCALE1));
            this.addSequential(new Turn(20));
            this.addSequential(new IntakeOut());
        
        } else if (pos == Autonomous.StartPosition.RIGHT) {
            this.addParallel(new DriveStraight(264));
            this.addSequential(new FrontElevatorControl(FrontElevatorControl.HEIGHTS.SCALE1));
            this.addSequential(new Turn(-20));
            this.addSequential(new IntakeOut());
        }
    }
}
