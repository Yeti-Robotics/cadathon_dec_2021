// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class ClawSubsystem extends SubsystemBase {
  public enum ClawStatus {
    UP, DOWN
  }
  public static ClawStatus clawStatus;

  private DoubleSolenoid clawMover, clawShooter;
  public ClawSubsystem() {
    clawMover = new DoubleSolenoid(IntakeConstants.CLAW_MOVER[0], IntakeConstants.CLAW_MOVER[1]);
    clawShooter = new DoubleSolenoid(IntakeConstants.CLAW_SHOOTER[0], IntakeConstants.CLAW_SHOOTER[1]);

    clawStatus = ClawStatus.DOWN;
  }

  public void extendClaw() {
    clawMover.set(DoubleSolenoid.Value.kForward);
    clawStatus = ClawStatus.UP;
  }

  public void retractClaw() {
    clawMover.set(DoubleSolenoid.Value.kReverse);
    clawStatus = ClawStatus.DOWN;
  }

  public void extendShooter() {
    clawShooter.set(DoubleSolenoid.Value.kForward);
  }

  public void retractShooter() {
    clawShooter.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
