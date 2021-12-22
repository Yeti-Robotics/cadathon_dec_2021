package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystem.drivetrain;

public class DriveCommand extends CommandBase {
  private final drivetrain drivetrainSubsystem;
  private final double leftSpeed;
  private final double rightSpeed;

  public DriveCommand(drivetrain drivetrainSubsystem, double leftSpeed, double rightSpeed) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
 drivetrainSubsystem.drive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}