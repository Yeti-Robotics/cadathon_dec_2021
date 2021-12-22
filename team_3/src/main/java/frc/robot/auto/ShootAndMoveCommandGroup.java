// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.arms.ResetFrontArmCommand;
import frc.robot.commands.arms.SetAngleCommand;
import frc.robot.commands.arms.SetArmsVerticalCommand;
import frc.robot.commands.drivetrain.DriveForDistanceCommand;
import frc.robot.commands.shooter.ShootCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// need to be aimed straight at the target and start at the 
// border between the white and other zone
public class ShootAndMoveCommandGroup extends SequentialCommandGroup {
    public ShootAndMoveCommandGroup(ArmSubsystem armSubsystem, ShooterSubsystem shooterSubsystem, DrivetrainSubsystem drivetrainSubsystem) {
        addCommands(
            new SetArmsVerticalCommand(armSubsystem), 
            new SetAngleCommand(armSubsystem, ArmConstants.ARM_SHOOTING_LIMIT), 
            new ShootCommand(shooterSubsystem).withTimeout(3.0), // would test to find better value, although it's okay if it's rough
            new ResetFrontArmCommand(armSubsystem), 
            new DriveForDistanceCommand(drivetrainSubsystem, 24.0, DriveConstants.AUTO_SPEED)
        );
    }
}
