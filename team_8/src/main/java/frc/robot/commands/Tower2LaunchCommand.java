// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower2Subsystem;

public class Tower2LaunchCommand extends CommandBase {
private final Tower2Subsystem tower2Subsystem;
  public Tower2LaunchCommand(Tower2Subsystem tower2Subsystem) {
    this.tower2Subsystem = tower2Subsystem;
  }

  @Override
  public void execute() {
    tower2Subsystem.launch(.7239, .7239);
  }

 

}
