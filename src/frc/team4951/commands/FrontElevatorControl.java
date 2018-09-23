package frc.team4951.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.team4951.OI;

public class FrontElevatorControl extends CommandBase {

    public enum HEIGHTS {
        BASE, SWITCH, SCALE1, SCALE2
    }
    private HEIGHTS desiredHeight;
    
    
    // Constant heights of switch and scale
    private static final double[] height_distances = {0, 18, 60, 72};
    
    public FrontElevatorControl() {}
    
    public FrontElevatorControl(HEIGHTS height) {
        desiredHeight = height;
    }
    
    @Override
    protected void initialize () {
        requires(frontElevator);
    }
    
    @Override
    protected void execute() {
        if (OI.getOperatorXButton()) {
            desiredHeight = HEIGHTS.SWITCH;
        } else if (OI.getOperatorAButton()) {
            desiredHeight = HEIGHTS.BASE;
        } else if (OI.getOperatorYButton()) {
            if (desiredHeight != HEIGHTS.SCALE1 &&  desiredHeight != HEIGHTS.SCALE2) {
                desiredHeight = HEIGHTS.SCALE1;
            } else if (desiredHeight == HEIGHTS.SCALE1) {
                desiredHeight = HEIGHTS.SCALE2;
            }
        }
        
        if (desiredHeight == HEIGHTS.BASE)
            frontElevator.neutralMode(NeutralMode.Coast);
        else
            frontElevator.neutralMode(NeutralMode.Brake);
        
        frontElevator.setHeight(height_distances[desiredHeight.ordinal()]);
        
    }

    @Override
    protected boolean isFinished() {return frontElevator.onTarget();}

    @Override
    protected void end() {}
}
