package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystem.intake;

public class IntakeCommand extends CommandBase {
  private final intake intakeSubsystem; 
  public IntakeCommand(intake intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
  }
  

 // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.extend();
    intakeSubsystem.intakeIn();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }

  
}