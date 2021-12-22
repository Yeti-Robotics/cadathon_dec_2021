// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeOutCommand extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;

  /** Creates a new IntakeInCommand. */
  public IntakeOutCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (IntakeSubsystem.getIntakeStatus() == IntakeSubsystem.IntakeStatus.IN  || IntakeSubsystem.getIntakeStatus() == IntakeSubsystem.IntakeStatus.STOP) {
      intakeSubsystem.intakeIn();
    } else {
      intakeSubsystem.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }

}

