/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4951;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private static final int LEFT_STICK_X = 1, LEFT_STICK_Y = 1, RIGHT_STICK_X = 4, RIGHT_STICK_Y = 5;
    private static final int DRIVER_JOYSTICK = 0, OPERATOR_JOYSTICK = 1;
    public static final int A_BUTTON = 1, B_BUTTON = 2, X_BUTTON = 3, Y_BUTTON = 4,
            LB = 5, RB = 6, SELECT = 7, START = 8, LEFT_JOY_CLICK = 9, RIGHT_JOY_CLICK = 10;

    private static Joystick driverController;
    private static Joystick operatorController;

    public static void init() {

        driverController = new Joystick(DRIVER_JOYSTICK);

        operatorController = new Joystick(OPERATOR_JOYSTICK);

    }

    public static double getDriverLeftY() {return driverController.getRawAxis(LEFT_STICK_Y);}

    public static double getDriverRightX() {return driverController.getRawAxis(RIGHT_STICK_X);}

    public static double getOperatorRightY() {return operatorController.getRawAxis(RIGHT_STICK_Y);}
    
    public static double getOperatorLeftY() {return operatorController.getRawAxis(LEFT_STICK_Y);}

    public static boolean getOperatorAButton() {return operatorController.getRawButton(A_BUTTON);}

    public static boolean getOperatorBButton() {return operatorController.getRawButton(B_BUTTON);}

    public static boolean getOperatorXButton() {return operatorController.getRawButton(X_BUTTON);}

    public static boolean getOperatorYButton() {return operatorController.getRawButton(Y_BUTTON);}

    public static boolean getOperatorSelect() {return operatorController.getRawButton(SELECT);}

    public static boolean getOperatorStart() {return operatorController.getRawButton(START);}

    public static boolean getOperatorRB() {return operatorController.getRawButton(RB);}
    
    public static boolean getOperatorLB() {return operatorController.getRawButton(LB);}

    public static Joystick getDriverController() {return driverController;}

    public static Joystick getOperatorController() {return operatorController;}
}
