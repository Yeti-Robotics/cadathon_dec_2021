package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.intake.IntakeVoidCommand;
import frc.robot.commands.spring.SpringPushCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.SpringShootSubsystem;

public class ShootCommand extends SequentialCommandGroup {
    
    private IntakeSubsystem intakeSubsystem;
    private SpringShootSubsystem springShootSubsystem;

    public ShootCommand(IntakeSubsystem intakeSubsystem, SpringShootSubsystem springShootSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.springShootSubsystem = springShootSubsystem;
        addRequirements(intakeSubsystem, springShootSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        new IntakeVoidCommand(intakeSubsystem);
        new WaitCommand(0.1);
        new SpringPushCommand(springShootSubsystem);
        intakeSubsystem.stopIntake();
    }

}
