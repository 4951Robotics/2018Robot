package frc.team4951.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4951.commands.*;
import frc.team4951.subsystems.FrontElevator;

class Switch extends CommandGroup {
    
    Switch(Autonomous.StartPosition position, char switchSide) {
        
        if (position == Autonomous.StartPosition.LEFT && switchSide =='L') {

            addSequential(new DriveStraight(168));
            addSequential(new PIDTurn(90));
            addParallel(new DropIntake(0.5));
            addSequential(new DriveLiftElevator(30, FrontElevator.getSwitchHeight()));
            addSequential(new IntakeOut(0.5));
            
        } else if (position == Autonomous.StartPosition.RIGHT && switchSide == 'R') {

            addSequential(new DriveStraight(168));
            addSequential(new PIDTurn(-90));
            addParallel(new DropIntake(0.5));
            addSequential(new DriveLiftElevator(30, FrontElevator.getSwitchHeight()));
            addSequential(new IntakeOut(0.5));
    
        } else if (position == Autonomous.StartPosition.CENTER) {
            if (switchSide == 'L') {

                addSequential(new DriveStraight(24));
                addSequential(new PIDTurn(45));
                addParallel(new DropIntake(0.5));
                addSequential(new DriveLiftElevator(90, FrontElevator.getSwitchHeight()));
                addSequential(new PIDTurn(-45));
                addSequential(new DriveStraight(46));
                addSequential(new IntakeOut(1));

            } else if (switchSide == 'R') {

                addSequential(new DriveStraight(24));
                addSequential(new PIDTurn(-45));
                addParallel(new DropIntake(0.5));
                addSequential(new DriveLiftElevator(90, FrontElevator.getSwitchHeight()));
                addSequential(new PIDTurn(45));
                addSequential(new DriveStraight(46));
                addSequential(new IntakeOut(1));

            }
        }
    }
    
}
