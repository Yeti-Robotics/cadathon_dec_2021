// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arms;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

// sets arms to be vertical and parallel
// meant to be used after opening & when the ball is in the robot to wrap around it (close)
// assumes arms mirror each other (i.e. if front arm was moved, it was reset already)
public class SetArmsVerticalCommand extends PIDCommand {
    private ArmSubsystem armSubsystem;

    public SetArmsVerticalCommand(ArmSubsystem armSubsystem) {
        super(
            new PIDController(ArmConstants.ARM_P, ArmConstants.ARM_I, ArmConstants.ARM_D),
            // returns measurement
            armSubsystem::getEncoders,
            // setpoint
            ArmConstants.ARM_VERTICAL_LIMIT,
            output -> {
                // if statement redundant but helps the code make
                // more sense logically imo
                if(output < 0){
                    armSubsystem.closeArms(-output);
                } else {
                    armSubsystem.openArms(output);
                }
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
