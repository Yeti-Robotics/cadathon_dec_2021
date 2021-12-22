// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arms;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

public class CloseArmsCommand extends CommandBase {
    private ArmSubsystem armSubsystem;

    public CloseArmsCommand(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        armSubsystem.closeArms();
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stopArms();
    }

    @Override
    public boolean isFinished() {
        return armSubsystem.getEncoders() <= ArmConstants.ARM_LOWER_LIMIT + ArmConstants.ARM_ENCODER_TOLERANCE;
    }
}
