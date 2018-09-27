package frc.team4951.commands;

public class IntakeOut extends CommandBase {
    
    @Override
    protected void initialize () {
    }

    @Override
    protected void execute () {
        intake.out();
    }
}
