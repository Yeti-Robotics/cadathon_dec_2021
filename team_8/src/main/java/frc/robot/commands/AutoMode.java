// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Tower2Subsystem;

/** Add your docs here. */
public class AutoMode extends SequentialCommandGroup {
public void Automode(double leftPower, double rightPower, DrivetrainSubsystem drivetrainSubsystem, Tower2Subsystem tower2Subsystem){
addCommands(
    new Tower2LaunchCommand(tower2Subsystem),
    new AutoDriveCommand(drivetrainSubsystem)

);
}
}