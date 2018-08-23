package frc.team4951;

public interface Constants {

    // All values are hypothetical and not calibrated to robot
    // Buttons and axis values not yet found, use 0 as placeholder for now
    // TODO find values for controller input

    // Controller
    byte A_BUTTON = 0;
    byte B_BUTTON = 0;
    byte X_BUTTON = 0;
    byte Y_BUTTON = 0;
    byte L_BUMPER = 0;
    byte R_BUMPER = 0;
    byte L_TRIGGER = 0;
    byte R_TRIGGER = 0;
    byte L_XAXIS = 0;
    byte L_YAXIS = 0;
    byte R_XAXIS = 0;
    byte R_YAXIS = 0;


    double INTAKESPEED = 0.7; // Speed to run intake wheels
    int WHEELDIAMETER = 4; // Diameter of wheel in inches
    double WHEELCIRCUM = WHEELDIAMETER * Math.PI; // Circumference of wheel in inches
    double GYRO_KP = 0.05; // Kp constant for gyro P loop

}
