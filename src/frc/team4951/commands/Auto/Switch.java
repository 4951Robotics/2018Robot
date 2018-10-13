package frc.team4951.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4951.commands.*;
import frc.team4951.subsystems.FrontElevator;

class Switch extends CommandGroup {
    
    Switch(Autonomous.StartPosition position, char switchSide) {
        
        if (position == Autonomous.StartPosition.LEFT && switchSide =='L') {

            addSequential(new DriveStraight(150));
            addSequential(new Turn(90));
            addParallel(new DropIntake(0.5));
            addSequential(new DriveLiftElevator(13, FrontElevator.getSwitchHeight()));
            addSequential(new IntakeOut(0.5));
            
        } else if (position == Autonomous.StartPosition.RIGHT && switchSide == 'R') {

            addSequential(new DriveStraight(150));
            addSequential(new Turn(-90));
            addParallel(new DropIntake(0.5));
            addSequential(new DriveLiftElevator(13, FrontElevator.getSwitchHeight()));
            addSequential(new IntakeOut(0.5));
    
        }
    }
    
}
