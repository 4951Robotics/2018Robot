package frc.team4951.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4951.commands.DriveStraight;
import frc.team4951.commands.FrontElevatorControl;
import frc.team4951.commands.IntakeOut;
import frc.team4951.commands.Turn;

class Switch extends CommandGroup {
    
    Switch(Autonomous.StartPosition position, char switchSide) {
        
        if (position == Autonomous.StartPosition.LEFT && switchSide =='L') {
            
            addSequential(new DriveStraight(150));
            addSequential(new Turn(90));
            addSequential(new DriveStraight(13));
            addSequential(new IntakeOut());
            
        } else if (position == Autonomous.StartPosition.RIGHT && switchSide == 'R') {
    
            addSequential(new DriveStraight(150));
            addSequential(new Turn(-90));
            addSequential(new DriveStraight(13));
            addSequential(new IntakeOut());
    
        }
    }
    
}
