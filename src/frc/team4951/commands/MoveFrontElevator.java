package frc.team4951.commands;

import frc.team4951.OI;

public class MoveFrontElevator extends CommandBase {

    private enum HEIGHTS {
        BASE, SWITCH, SCALE1, SCALE2;
        public static HEIGHTS[] vals = values();
        public HEIGHTS next() {return vals[(this.ordinal()+1)];}
        public HEIGHTS previous() {return vals[this.ordinal()-1];}
    }
    private HEIGHTS desiredHeight = HEIGHTS.BASE;

    // Constant heights of switch and scale
    private static final double SWITCH_HEIGHT = 18.0, SCALE1_HEIGHT = 60.0, SCALE2_HEIGHT = 72.0, BASE_HEIGHT = 0.0;

    private static final double DEADZONE = 0.3;
    private static final double SPEED = 0.6;

    @Override
    protected void execute() {

        if (OI.getOperatorYButton() && desiredHeight != HEIGHTS.SCALE2) {
            desiredHeight = desiredHeight.next();
        } else if (OI.getOperatorAButton() && desiredHeight != HEIGHTS.BASE) {
            desiredHeight = desiredHeight.previous();
        }
/*
        switch (desiredHeight) {
            case BASE:
                frontElevator.setHeight(BASE_HEIGHT);
                break;

            case SWITCH:
                frontElevator.setHeight(SWITCH_HEIGHT);
                break;

            case SCALE1:
                frontElevator.setHeight(SCALE1_HEIGHT);
                break;

            case SCALE2:
                frontElevator.setHeight(SCALE2_HEIGHT);
                break;
        }

        if (OI.getOperatorRightY() > DEADZONE) {
            frontElevator.manualMove(SPEED);
        } else if (Math.abs(OI.getOperatorRightY()) > DEADZONE) {
            frontElevator.manualMove(-SPEED);
        }
*/
    }

    @Override
    protected boolean isFinished() {return false;}

    @Override
    protected void end() {}
}
