
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    VictorSPX rollerIntake;
    VictorSPX pivotIntake;

    public enum IntakeStatus{
        IN, STOP, OUT;

		public static boolean getIntakeStatus() {
			return false;
		}
      }
      public static IntakeStatus intakeStatus;
    
    public IntakeSubsystem() {
        rollerIntake = new VictorSPX(IntakeConstants.ROLLER_VICTOR);
        pivotIntake = new VictorSPX(IntakeConstants.PIVOT_VICTOR);
    }

    public void intakeIn() {
        rollerIntake.set(ControlMode.PercentOutput, IntakeConstants.ROLL_IN_SPEED);
        intakeStatus = IntakeStatus.IN;
    }

    public void intakeOut() {
        rollerIntake.set(ControlMode.PercentOutput, IntakeConstants.ROLL_OUT_SPEED);
        intakeStatus = IntakeStatus.OUT;
    }
    
    public void stop() {
        rollerIntake.set(ControlMode.PercentOutput, 0);
        intakeStatus = IntakeStatus.STOP;
    }
    
    public void stopPivot() {
        pivotIntake.set(ControlMode.PercentOutput, 0);
    }

    public void pivotUp() {
        pivotIntake.set(ControlMode.PercentOutput, IntakeConstants.PIVOT_UP_SPEED);
    }

    public void pivotDown() {
        pivotIntake.set(ControlMode.PercentOutput, IntakeConstants.PIVOT_DOWN_SPEED);
    }

    public static IntakeStatus getIntakeStatus() {
        return intakeStatus;
    }

}

