// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arms;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

public class MoveFrontArmCommand extends CommandBase {
    private ArmSubsystem armSubsystem;
    private double speed; 

    public MoveFrontArmCommand(ArmSubsystem armSubsystem, double speed) {
        this.armSubsystem = armSubsystem;
        this.speed = speed;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        armSubsystem.moveFrontArm(speed);
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stopArms();
    }

    @Override
    public boolean isFinished() {
        return armSubsystem.getEncoders() >= ArmConstants.ARM_UPPER_LIMIT - ArmConstants.ARM_ENCODER_TOLERANCE ||
               armSubsystem.getEncoders() <= ArmConstants.ARM_VERTICAL_LIMIT + ArmConstants.ARM_ENCODER_TOLERANCE;
    }
}
