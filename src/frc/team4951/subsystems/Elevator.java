package frc.team4951.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {

    public Elevator() {
        // TODO find p, i d, and f constants (feed forward used to account for gravity and make system linear)
        super("Elevator", 0, 0, 0, 0);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
