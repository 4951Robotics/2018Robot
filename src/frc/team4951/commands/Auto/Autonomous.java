package frc.team4951.commands.Auto;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
    
    public enum AutoMode {
        SCALE, // Get the scale on start or other side
        SWITCH, // Get the switch
        DRIVE // Drive forward
    }
    
    public enum StartPosition {LEFT, CENTER, RIGHT}
    
    private char posChar;
    
    public Autonomous(StartPosition position, AutoMode mode) {
        
        String gameData = DriverStation.getInstance().getGameSpecificMessage();
        
        switch (position) {
            case LEFT:
                posChar = 'L';
                break;
            case RIGHT:
                posChar = 'R';
                break;
            case CENTER:
                posChar = 'C';
                break;
        }
        
        switch (mode) {
            case DRIVE:
                this.addSequential(new AutoLine());
                break;
            case SCALE:
                if (posChar == gameData.charAt(1)) {
                    addSequential(new Scale(position));
                } else if (posChar == gameData.charAt(0)) {
                    addSequential(new Switch(position, posChar));
                } else {
                    addSequential(new AutoLine());
                }
                break;
            case SWITCH:
                addSequential(new Switch(position, gameData.charAt(0)));
        }
        
    }
    
}
