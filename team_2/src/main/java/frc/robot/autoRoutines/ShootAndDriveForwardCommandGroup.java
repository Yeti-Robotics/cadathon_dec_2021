package frc.robot.autoRoutines;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.drivetrain.DriveDistanceCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.SpringShootSubsystem;

public class ShootAndDriveForwardCommandGroup extends SequentialCommandGroup {

    SpringShootSubsystem springShootSubsystem;

    public ShootAndDriveForwardCommandGroup(DrivetrainSubsystem drivetrainSubsystem, IntakeSubsystem intakeSubsystem) {
		addCommands(
            new ShootCommand(intakeSubsystem, springShootSubsystem).withTimeout(2),
            new WaitCommand(2),
            new DriveDistanceCommand(drivetrainSubsystem, 60.0, 0.8, 0.8)

        );
    }
    
}
