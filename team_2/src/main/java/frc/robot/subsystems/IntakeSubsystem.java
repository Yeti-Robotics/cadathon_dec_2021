package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeSubsystem extends SubsystemBase{

    public enum ClawStatus{
        OPEN, CLOSED
    }

    public ClawStatus clawStatus;

    private WPI_TalonFX intakeRollers, centeringRollers;
    private DoubleSolenoid pistons;

    public IntakeSubsystem() {
        pistons = new DoubleSolenoid(IntakeConstants.SOLENOID_CLAW[0], IntakeConstants.SOLENOID_CLAW[1]);
        intakeRollers = new WPI_TalonFX(IntakeConstants.INTAKE_FALCON);
        centeringRollers = new WPI_TalonFX(IntakeConstants.CENTERING_FALCON);

        clawStatus = ClawStatus.CLOSED;
    }



    public void open() {
        pistons.set(DoubleSolenoid.Value.kForward);
        clawStatus = ClawStatus.OPEN;
    }
    
    public void close() {
        pistons.set(DoubleSolenoid.Value.kReverse);
        clawStatus = ClawStatus.CLOSED;
    }

    public void intake() {
        intakeRollers.set(ControlMode.PercentOutput, IntakeConstants.INTAKE_SPEED);
    }

    public void purgeClaw() {
        intakeRollers.set(ControlMode.PercentOutput, IntakeConstants.REVERSE_INTAKE_SPEED);
    }

    public void stopIntake() {
        intakeRollers.set(ControlMode.PercentOutput, 0);
    }

    public void spinCenteringRollers() {
        centeringRollers.set(ControlMode.PercentOutput, IntakeConstants.INTAKE_SPEED);
    }

}
