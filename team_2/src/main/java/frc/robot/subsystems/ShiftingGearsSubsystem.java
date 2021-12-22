package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


public class ShiftingGearsSubsystem extends SubsystemBase{
    private DoubleSolenoid shifter;
    public enum gear {
        HIGH, LOW
    }
    public static gear currentGear;

    public ShiftingGearsSubsystem() {
        shifter = new DoubleSolenoid(DriveConstants.SOLENOID_SHIFTER[0], DriveConstants.SOLENOID_SHIFTER[1]);
        currentGear = gear.LOW;
    }

    public void upShift() {
        shifter.set(DoubleSolenoid.Value.kForward);
        currentGear = gear.HIGH;
    }
    
    public void downShift() {
        shifter.set(DoubleSolenoid.Value.kReverse);
        currentGear = gear.LOW;
    }

    public static gear getShifterPosition() {
        return currentGear;
    }
}
