package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intake extends SubsystemBase {
    VictorSPX roller1;
    VictorSPX roller2;
    VictorSPX roller3;
    VictorSPX roller4;
    DoubleSolenoid piston1;
    DoubleSolenoid piston2;
    DoubleSolenoid piston3;
    DoubleSolenoid piston4;
  
    public void IntakeSubsystem() {
      roller1 = new VictorSPX(1);
      roller2 = new VictorSPX(2);
      roller3 = new VictorSPX(3);
      roller4 = new VictorSPX(4);
      piston1 = new DoubleSolenoid(0, 1);
      piston2 = new DoubleSolenoid(0, 2);
      piston3 = new DoubleSolenoid(0, 3);
      piston4 = new DoubleSolenoid(0, 4);
    }
    
    
      
    
  
    public void intakeIn() {
      roller1.set(ControlMode.PercentOutput, 0.5);
      roller2.set(ControlMode.PercentOutput, 0.5);
      roller3.set(ControlMode.PercentOutput, 0.5);
      roller4.set(ControlMode.PercentOutput, 0.5);
    }
  
    public void intakeOut() {
      roller1.set(ControlMode.PercentOutput, -0.5);
      roller2.set(ControlMode.PercentOutput, -0.5);
      roller3.set(ControlMode.PercentOutput, -0.5);
      roller4.set(ControlMode.PercentOutput, -0.5);
    }
  
    public void extend() {
     piston1.set(Value.kReverse);
     piston2.set(Value.kReverse);
     piston3.set(Value.kReverse);
     piston4.set(Value.kReverse);
    }
  
    public void retract() {
      piston1.set(Value.kForward);
      piston2.set(Value.kForward);
      piston2.set(Value.kForward);
      piston4.set(Value.kForward);
    }
  
    public void stop() {


      roller1.set(ControlMode.PercentOutput, 0);
      roller2.set(ControlMode.PercentOutput, 0);
      roller3.set(ControlMode.PercentOutput, 0);
      roller4.set(ControlMode.PercentOutput, 0);
    }
  
    
  }