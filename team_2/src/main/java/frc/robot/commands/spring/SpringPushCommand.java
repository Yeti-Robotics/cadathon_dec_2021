package frc.robot.commands.spring;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.SpringShootSubsystem;

public class SpringPushCommand extends SequentialCommandGroup {

    private final SpringShootSubsystem springShootSubsystem;

    public SpringPushCommand(SpringShootSubsystem springShootSubsystem) {
        this.springShootSubsystem = springShootSubsystem;
        addRequirements(springShootSubsystem);
    }
    
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        springShootSubsystem.pushBall();
        new WaitCommand(0.5);
        springShootSubsystem.pusherStop();
        new WaitCommand(0.3);
        springShootSubsystem.retractPusher();
        new WaitCommand(0.5);
        springShootSubsystem.pusherStop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
