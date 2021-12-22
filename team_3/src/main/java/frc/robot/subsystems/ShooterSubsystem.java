// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

// "choo-choo" catapulting mechanism
// mainly a mechanical challenge so this subsystem is quite simple
// just needs to move forward, movement based on driver input only
public class ShooterSubsystem extends SubsystemBase {
    private VictorSPX shooterVictor;

    public ShooterSubsystem() {
        shooterVictor = new VictorSPX(ShooterConstants.SHOOTER_VICTOR);
    }

    public void shoot(){
        shooterVictor.set(ControlMode.PercentOutput, ShooterConstants.SHOOTER_SPEED);
    }

    public void reverse(){
        shooterVictor.set(ControlMode.PercentOutput, -ShooterConstants.SHOOTER_SPEED);
    }

    public void stopShooter(){
        shooterVictor.set(ControlMode.PercentOutput, 0.0);
    }
}
