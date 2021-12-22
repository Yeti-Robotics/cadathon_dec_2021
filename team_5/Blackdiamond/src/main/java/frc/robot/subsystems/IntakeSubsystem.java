
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    VictorSPX rollerIntake;
    VictorSPX pivotIntake;
    
    public IntakeSubsystem() {
        rollerIntake = new VictorSPX(8);
        pivotIntake = new VictorSPX(0);
    }

    public void intakeIn() {
        rollerIntake.set(ControlMode.PercentOutput, 0.5);
    }

    public void intakeOut() {
        rollerIntake.set(ControlMode.PercentOutput, -0.5);
    }
    
    public void stop() {
        rollerIntake.set(ControlMode.PercentOutput, 0);
    }
    
    public void stopPivot() {
        pivotIntake.set(ControlMode.PercentOutput, 0);
    }

    public void pivotUp() {
        pivotIntake.set(ControlMode.PercentOutput, 0.5);
    }

    public void pivotDown() {
        pivotIntake.set(ControlMode.PercentOutput, -0.5);
    }

}

