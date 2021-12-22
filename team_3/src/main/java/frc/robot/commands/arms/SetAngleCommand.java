// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arms;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

// sets the "angle" (angle's in encoder units) that we aim at
// meant to be used when closed up around a ball
// need to reset to be vertical after shooting
public class SetAngleCommand extends PIDCommand {
    private ArmSubsystem armSubsystem;

    public SetAngleCommand(ArmSubsystem armSubsystem, double encoderGoal) {
        super(
            new PIDController(ArmConstants.ARM_P, ArmConstants.ARM_I, ArmConstants.ARM_D),
            // returns measurement
            armSubsystem::getEncoders,
            // setpoint
            encoderGoal,
            output -> {
                armSubsystem.moveFrontArm(output);
            }
        );
        this.armSubsystem = armSubsystem;
        addRequirements(armSubsystem);
        getController().setTolerance(ArmConstants.ARM_ENCODER_TOLERANCE);
    }

    @Override
    public boolean isFinished() {
        return getController().atSetpoint();
    }

    @Override
    public void end(boolean interrupted){
        armSubsystem.stopArms();
    }
}
