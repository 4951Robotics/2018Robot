package frc.team4951.commands;

import frc.team4951.OI;

public class IntakeControl extends CommandBase {
    
    @Override
    protected void initialize () {
        requires(intake);
    }
    
    @Override
    protected void execute() {

        if (OI.getOperatorRB()) {
            intake.in();
        } else if (OI.getOperatorLB()) {
            intake.out();
        }

        if (OI.getOperatorBButton()) {
            if (intake.isOpen())
                intake.close();
            else
                intake.open();
        }

    }
    
}
