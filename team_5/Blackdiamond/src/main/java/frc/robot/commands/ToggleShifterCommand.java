// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GearShifterSubsystem;

public class ToggleShifterCommand extends CommandBase {
  private final GearShifterSubsystem gearShifterSubsystem;

  public ToggleShifterCommand(GearShifterSubsystem gearShifterSubsystem) {
    this.gearShifterSubsystem = gearShifterSubsystem;
    addRequirements(gearShifterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (GearShifterSubsystem.getShifterPosition() == GearShifterSubsystem.ShiftStatus.HIGH) {
      gearShifterSubsystem.shiftDown();
    } else {
      gearShifterSubsystem.shiftUp();
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
