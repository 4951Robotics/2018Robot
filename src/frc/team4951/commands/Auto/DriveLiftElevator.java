package frc.team4951.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4951.commands.DriveStraight;
import frc.team4951.commands.ElevatorHeight;

public class DriveLiftElevator extends CommandGroup {

    public  DriveLiftElevator(int distance, int height) {
        this.addParallel(new DriveStraight(distance));
        this.addParallel(new ElevatorHeight(height));
    }

}
