package frc.robot.subsystems;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpringConstants;

public class SpringShootSubsystem extends SubsystemBase {
    
    private WPI_TalonFX springFalcon;

    public SpringShootSubsystem() {
        springFalcon = new WPI_TalonFX(SpringConstants.SPRING_MOTOR_PORT);
        //springMotor.setInverted(true);
    }

    public void pushBall() {
        springFalcon.set(ControlMode.PercentOutput, SpringConstants.SHOOT_SPEED);
    }

    public void retractPusher() {
        springFalcon.set(ControlMode.PercentOutput, SpringConstants.RETRACT_SPEED);
    }

    public void pusherStop() {
        springFalcon.set(ControlMode.PercentOutput, 0);
    }

}
