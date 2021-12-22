// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private WPI_TalonFX leftFlywheel;
  private WPI_TalonFX rightFlywheel;

  public enum ShooterStatus {
    FORWARDS, OFF;
  }

  public static ShooterStatus shooterStatus;

  public ShooterSubsystem() {
    leftFlywheel = new WPI_TalonFX(5);
    rightFlywheel = new WPI_TalonFX(6);

    rightFlywheel.follow(leftFlywheel);
    rightFlywheel.setInverted(InvertType.OpposeMaster);

    leftFlywheel.setNeutralMode(NeutralMode.Coast);
    rightFlywheel.setNeutralMode(NeutralMode.Coast);
  }

  public void shootFlywheel() {
    leftFlywheel.set(ControlMode.PercentOutput, 0.9);
    shooterStatus = ShooterStatus.FORWARDS;
  }

  public void stopFlywheel() {
    leftFlywheel.set(ControlMode.PercentOutput, 0);
    shooterStatus = ShooterStatus.OFF;
  }

  public static ShooterStatus getShooterStatus() {
    return shooterStatus;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
