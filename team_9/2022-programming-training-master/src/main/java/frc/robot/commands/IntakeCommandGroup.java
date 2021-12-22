package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Subsystem.drivetrain;
import frc.robot.Subsystem.intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeCommandGroup extends SequentialCommandGroup {
  /** Creates a new IntakeCommandGroup. */
  public IntakeCommandGroup(intake intakeSubsystem, drivetrain drivetrainSubsystem) {

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new IntakeCommand(intakeSubsystem),
      new WaitCommand(1),
      new DriveCommand(drivetrainSubsystem, 0.25, 0.25).withTimeout(2)
    );
  }
}