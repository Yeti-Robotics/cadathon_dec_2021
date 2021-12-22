package frc.robot.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class drivetrain extends SubsystemBase {

  WPI_TalonFX lefttalon1, lefttalon2,lefttalon3, lefttalon4, righttalon1, righttalon2, righttalon3, righttalon4;
  public void DrivetrainSubsystem() {
    lefttalon1 = new WPI_TalonFX(1);
    lefttalon2 = new WPI_TalonFX(2);
    lefttalon3 = new WPI_TalonFX(3);
    lefttalon4 = new WPI_TalonFX(4);
    righttalon1 = new WPI_TalonFX(5);
    righttalon2 = new WPI_TalonFX(6);
    righttalon3 = new WPI_TalonFX(7);
    righttalon4 = new WPI_TalonFX(8);
    
  }

public void drive(double LPower,double RPower ) {

    lefttalon1.set(-LPower);
    lefttalon2.set(-LPower);
    lefttalon3.set(-LPower);
    lefttalon4.set(-LPower);
    righttalon1.set(-RPower);
    righttalon2.set(-RPower);
    righttalon3.set(-RPower);
    righttalon4.set(-RPower);
    
  }

  
    
}
