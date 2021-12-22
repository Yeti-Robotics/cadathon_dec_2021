// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tower2Subsystem extends SubsystemBase {
  WPI_TalonFX t2Talon;
  WPI_TalonFX t21Talon;
  public Tower2Subsystem() {
    t2Talon = new WPI_TalonFX(6);
    t21Talon = new WPI_TalonFX(7);
  }
  public void launch(double t2speed, double t21speed){
    t2Talon.set(t2speed);
    t21Talon.set(t21speed);
  }
 
}
