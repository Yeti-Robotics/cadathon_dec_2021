// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AutoDriveCommand extends CommandBase {
private final DrivetrainSubsystem drivetrainSubsystem;
  public AutoDriveCommand(DrivetrainSubsystem drivetrainSubsystem) {
   this.drivetrainSubsystem = drivetrainSubsystem; 
  }

 
  @Override
  public void initialize() {}

 
  @Override
  public void execute() {
   drivetrainSubsystem.drive(.1, .1);
  }

 
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
