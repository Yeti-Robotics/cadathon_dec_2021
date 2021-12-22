package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Subsystem.intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeStopCommand extends InstantCommand {
  private final intake intakeSubsystem;
  public IntakeStopCommand(intake intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.retract();
    intakeSubsystem.stop();

  }

  
}