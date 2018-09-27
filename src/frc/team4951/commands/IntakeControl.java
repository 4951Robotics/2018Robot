package frc.team4951.commands;

import frc.team4951.ButtonDebouncer;
import frc.team4951.OI;

public class IntakeControl extends CommandBase {

    private ButtonDebouncer debouncer;

    @Override
    protected void initialize () {
        debouncer = new ButtonDebouncer(OI.getOperatorController(), OI.B_BUTTON);
    }
    
    @Override
    protected void execute() {

        if (OI.getOperatorRB()) {
            intake.in();
        } else if (OI.getOperatorLB()) {
            intake.out();
        } else {
            intake.stop();
        }

        if (debouncer.get()) {
            if (intake.isOpen())
                intake.close();
            else
                intake.open();
        }

    }
    
}
