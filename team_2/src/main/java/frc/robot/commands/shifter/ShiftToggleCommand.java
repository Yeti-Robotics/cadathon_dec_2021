package frc.robot.commands.shifter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShiftingGearsSubsystem;

public class ShiftToggleCommand extends CommandBase {
    
    private final ShiftingGearsSubsystem shiftingGearsSubsystem;

    public ShiftToggleCommand(ShiftingGearsSubsystem shiftingGearsSubsystem) {
        this.shiftingGearsSubsystem = shiftingGearsSubsystem;
        addRequirements(shiftingGearsSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if (ShiftingGearsSubsystem.getShifterPosition() == ShiftingGearsSubsystem.gear.HIGH) {
            shiftingGearsSubsystem.downShift();
        } else {
            shiftingGearsSubsystem.upShift();
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}

