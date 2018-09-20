/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4951;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {

    // DRIVETRAIN

    public static final int LEFT_VICTOR = 3;
    public static final int RIGHT_VICTOR = 4;
    
    // INTAKE

    public static final int INTAKE_SPARK = 5;
    public static final int WRIST_SPARK = 7;
    public static final int SOLENOID_F = 0, SOLENOID_R = 1;

    // SENSORS

    public static final int  RIGHT_ENCODER_A = 0, RIGHT_ENCODER_B = 1;
    public static final int GYRO_CHANNEL = 0;

    // BACK ELEVATOR

    public static final int BACK_ELEVATOR_MOTOR = 4;

    // Front Elevator
    
    private static final int FRONT_ELEVATOR_TALON = 0;
}

