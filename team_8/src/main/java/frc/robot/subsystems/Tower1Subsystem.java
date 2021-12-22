// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tower1Subsystem extends SubsystemBase {
  WPI_TalonFX tTalon;
  /** Creates a new Tower1. */
  public Tower1Subsystem() {
    tTalon = new WPI_TalonFX(5);
  }

  public void load(double speed){
    tTalon.set(speed);
  }
  public void pass(double speed){
    tTalon.set(speed);
  }

}
