package frc.team4951;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class ButtonDebouncer {

    /*
    Button debouncer so button only registers once when pressed
     */

    private Joystick joystick;
    private int button;
    private double latest;
    private double period;

    public ButtonDebouncer(Joystick joystick, int button) {
        this.joystick = joystick;
        this.button = button;
        this.period = 0.5;
        this.latest = 0;
    }

    public ButtonDebouncer(Joystick joystick, int button, double period) {
        this.joystick = joystick;
        this.button = button;
        this.period = period;
        this.latest = 0;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public boolean get() {
        double now = Timer.getFPGATimestamp();
        if (joystick.getRawButton(button) ) {
            if ((now-latest > period)) {
                latest = now;
                return true;
            }
        }
        return false;
    }

}
