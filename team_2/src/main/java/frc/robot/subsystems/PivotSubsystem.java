package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PivotConstants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class PivotSubsystem extends SubsystemBase {
    
    private WPI_TalonFX leftPivotFalcon, rightPivotFalcon;

    public PivotSubsystem() {

        leftPivotFalcon = new WPI_TalonFX(PivotConstants.PIVOT_FALCON_1);
        rightPivotFalcon = new WPI_TalonFX(PivotConstants.PIVOT_FALCON_2);

        rightPivotFalcon.follow(leftPivotFalcon);
    
        leftPivotFalcon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
        rightPivotFalcon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
        leftPivotFalcon.setNeutralMode(NeutralMode.Brake);
        rightPivotFalcon.setNeutralMode(NeutralMode.Brake);

    }

    public void spinForward() {
        leftPivotFalcon.set(ControlMode.PercentOutput, PivotConstants.SPIN_FORWARD_SPEED);
    }

    public void spinBackward() {
        leftPivotFalcon.set(ControlMode.PercentOutput, PivotConstants.SPIN_BACKWARD_SPEED);
    }
}
