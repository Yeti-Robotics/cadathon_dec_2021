// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class ShiftingSubsystem extends SubsystemBase {
    private DoubleSolenoid shifter;

    public enum ShiftStatus {
        LOW, 
        HIGH
    }

    private static ShiftStatus shiftStatus;

    public ShiftingSubsystem(){
        shifter = new DoubleSolenoid(DriveConstants.SHIFTING_SOLENOID[0], DriveConstants.SHIFTING_SOLENOID[1]);
        shifter.set(Value.kForward); // default to high gear on startup
    }

    public void upshift() {
        shifter.set(Value.kForward);
        shiftStatus = ShiftStatus.HIGH;
    }

    public void downshift() {
        shifter.set(Value.kReverse);
        shiftStatus = ShiftStatus.LOW;
    }

    public void toggleShift(){
        shifter.toggle();
        shiftStatus = (shifter.get() == Value.kForward) ? ShiftStatus.HIGH : ShiftStatus.LOW;
    }

    public static boolean isHighGear(){
        return shiftStatus == ShiftStatus.HIGH;
    }
}
