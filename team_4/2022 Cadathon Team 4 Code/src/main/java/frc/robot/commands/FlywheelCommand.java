// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelSubsystem;


public class FlywheelCommand extends CommandBase {
   private final FlywheelSubsystem flywheelSubsystem;
   private double spinSpeed;

   public FlywheelCommand(FlywheelSubsystem flywheelSubsystem) {
     this.flywheelSubsystem = flywheelSubsystem;
     this.spinSpeed = spinSpeed;
     
    
    
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    FlywheelCommand.spin(spinSpeed); 

    

  }

  

  private static void spin(double spinSpeed2) {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
