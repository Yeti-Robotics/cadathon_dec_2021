// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallOutSubsystem extends SubsystemBase {
  /** Creates a new BallOutSubsystem. */
  DoubleSolenoid BallOutPiston2;

    DoubleSolenoid BallOutPiston;

  public BallOutSubsystem() {
    BallOutPiston2 = new DoubleSolenoid(1, 2);

    BallOutPiston = new DoubleSolenoid(0, 7);
  }

  public void Down() {
    BallOutPiston.set(Value.kReverse);
    BallOutPiston2.set(Value.kReverse);
  }

  public void Up() {
    BallOutPiston.set(Value.kForward);
    BallOutPiston2.set(Value.kForward);
  }
  




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
