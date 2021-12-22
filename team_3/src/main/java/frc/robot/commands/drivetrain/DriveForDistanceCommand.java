// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveForDistanceCommand extends CommandBase {
    private DrivetrainSubsystem drivetrainSubsystem;
    private double distanceGoal;
    private double drivePower;

    public DriveForDistanceCommand(DrivetrainSubsystem drivetrainSubsystem, double distanceGoal, double drivePower) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.drivePower = drivePower;
        this.distanceGoal = distanceGoal; // inches
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {
        drivetrainSubsystem.resetEncoders();
    }

    @Override
    public void execute() {
        drivetrainSubsystem.tankDrive(drivePower, drivePower);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrainSubsystem.stopDrive();
    }

    @Override
    public boolean isFinished() {
        return distanceGoal <= this.drivetrainSubsystem.getEncoders();
    }
}