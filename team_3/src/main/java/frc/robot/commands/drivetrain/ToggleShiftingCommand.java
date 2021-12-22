// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShiftingSubsystem;

public class ToggleShiftingCommand extends CommandBase {
    private ShiftingSubsystem shiftingSubsystem;

    public ToggleShiftingCommand(ShiftingSubsystem shiftingSubsystem) {
        this.shiftingSubsystem = shiftingSubsystem;
        addRequirements(shiftingSubsystem);
    }

    @Override
    public void initialize() {
        shiftingSubsystem.toggleShift();
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return true;
    }
}
