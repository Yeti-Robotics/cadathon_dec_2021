// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.ArmConstants;
import frc.robot.commands.arms.ResetFrontArmCommand;
import frc.robot.commands.arms.SetAngleCommand;
import frc.robot.commands.shooter.ShootCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// could potentially be used instead of pressing all buttons manually, although gives less control
public class LaunchCommandGroup extends SequentialCommandGroup {
    public LaunchCommandGroup(ArmSubsystem armSubsystem, ShooterSubsystem shooterSubsystem) {
        addCommands(
            new SetAngleCommand(armSubsystem, ArmConstants.ARM_LAUNCHING_LIMIT), 
            new ShootCommand(shooterSubsystem).withTimeout(2.0), // would test to find better value, although can be rough
            new ResetFrontArmCommand(armSubsystem)
        );
    }
}
