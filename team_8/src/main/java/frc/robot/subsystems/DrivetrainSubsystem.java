// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */
  WPI_TalonFX leftTalon1, leftTalon2, rightTalon1, rightTalon2;
  public DrivetrainSubsystem() {
    leftTalon1 = new WPI_TalonFX(1);
    leftTalon2 = new WPI_TalonFX(2);
    rightTalon1 = new WPI_TalonFX(3);
    rightTalon2 = new WPI_TalonFX(4);
  }


  public void drive(double leftPower, double rightPower){
    leftTalon1.set(leftPower);
    leftTalon2.set(leftPower);
    rightTalon1.set(rightPower);
    rightTalon2.set(rightPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
