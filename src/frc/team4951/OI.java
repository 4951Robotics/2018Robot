/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4951;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements Constants {
    private static Joystick driverController = new Joystick(0);

    private static Joystick operatorController = new Joystick(1);

    public static double getDriverLeftY() {
        return driverController.getRawAxis(L_YAXIS);
    }

    public static double getDriverRightX() {
        return driverController.getRawAxis(R_YAXIS);
    }

    public static boolean getOperatorAButton() {return operatorController.getRawButton(A_BUTTON);}

    public static boolean getOperatorBButton() {return operatorController.getRawButton(B_BUTTON);}

}
