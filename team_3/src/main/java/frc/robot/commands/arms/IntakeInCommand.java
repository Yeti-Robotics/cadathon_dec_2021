// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arms;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class IntakeInCommand extends CommandBase {
    private ArmSubsystem armSubsystem;

    public IntakeInCommand(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        armSubsystem.rollIn();
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stopRoll();
    }

    @Override
    public boolean isFinished() {
        return false; // ends when button is released
    }
}
