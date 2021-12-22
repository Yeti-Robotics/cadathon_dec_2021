// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommand extends CommandBase {
  public final DrivetrainSubsystem drivetrainSubsystem;
  public final double leftPower;
  public final double rightPower;

  public DriveCommand(DrivetrainSubsystem drivetrainSubsystem, double leftPower, double rightPower) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.leftPower = leftPower;
    this.rightPower = rightPower;
    addRequirements(drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrainSubsystem.tankDrive(leftPower, rightPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.stopDrive();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  
}
