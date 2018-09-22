package frc.team4951.commands.Auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4951.commands.DriveStraight;
import frc.team4951.commands.FrontElevatorControl;
import frc.team4951.commands.IntakeOut;
import frc.team4951.commands.Turn;

/**
 * 2018Robot
 * Created by Carter
 * Version 1.0
 */
public class Scale extends CommandGroup {
    
    public Scale(StartPosition pos) {
        
        if (pos == StartPosition.LEFT) {
            if (DriverStation.getInstance().getGameSpecificMessage().charAt(1) == 'L') {
                this.addParallel(new DriveStraight(264));
                this.addSequential(new FrontElevatorControl(FrontElevatorControl.HEIGHTS.SCALE1));
                this.addSequential(new Turn(20));
                this.addSequential(new IntakeOut());
            }
        }
        
    }
    
}
