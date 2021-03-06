package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class OpenClawCommand extends CommandBase {
    
    private final IntakeSubsystem intakeSubsystem;

    public OpenClawCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        //This one actually retracts
        intakeSubsystem.open();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}


