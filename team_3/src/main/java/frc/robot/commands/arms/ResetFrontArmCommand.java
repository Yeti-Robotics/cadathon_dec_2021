// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arms;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

// resets the front arm after aiming
// somewhat janky way to do it but the thought is the back arm keeps the ball in place, 
// the front drops to aim, and then returns to be parallel with the back arm
public class ResetFrontArmCommand extends PIDCommand {
    private ArmSubsystem armSubsystem;

    public ResetFrontArmCommand(ArmSubsystem armSubsystem) {
        super(
            new PIDController(ArmConstants.ARM_P, ArmConstants.ARM_I, ArmConstants.ARM_D),
            // returns measurement
            armSubsystem::getFrontEncoder,
            // setpoint
            ArmConstants.ARM_VERTICAL_LIMIT,
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
