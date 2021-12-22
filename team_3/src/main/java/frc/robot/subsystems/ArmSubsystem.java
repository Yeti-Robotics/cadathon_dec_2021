// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    private TalonSRX frontTalon1; 
    private TalonSRX frontTalon2; 
    private TalonSRX backTalon1; 
    private TalonSRX backTalon2; 

    private VictorSPX frontRoller; 
    private VictorSPX backRoller; 

    // enable with arms fully contracted within the robot to zero them
    // positive values should move both arms towards the front of the robot
    // inversions would occur accordingly when tested ^
    public ArmSubsystem() {
        // motors at the base of each arm (2 per arm)
        frontTalon1 = new TalonSRX(ArmConstants.FRONT_TALON_1);
        frontTalon2 = new TalonSRX(ArmConstants.FRONT_TALON_2);
        backTalon1 = new TalonSRX(ArmConstants.BACK_TALON_1);
        backTalon2 = new TalonSRX(ArmConstants.BACK_TALON_2);

        // motors to roll at the top of each arm
        frontRoller = new VictorSPX(ArmConstants.FRONT_ROLLER);
        backRoller = new VictorSPX(ArmConstants.BACK_ROLLER);

        // configure mag encoders
        frontTalon1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        backTalon1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        
        // have motors on the same sides follow each other
        // likely need to invert one of the rollers too, however best to 
        // check with Phoenix Tuner instead of setting arbitrarily
        frontTalon2.follow(frontTalon1);
        frontTalon2.setInverted(InvertType.OpposeMaster); // prevents fighting since they will be facing opposite one another
        backTalon2.follow(backTalon1);
        backTalon2.setInverted(InvertType.OpposeMaster);

        // set motors to brake instead of coast
        frontTalon1.setNeutralMode(NeutralMode.Brake);
        frontTalon2.setNeutralMode(NeutralMode.Brake);
        backTalon1.setNeutralMode(NeutralMode.Brake);
        backTalon2.setNeutralMode(NeutralMode.Brake);
    }

    public void rollIn(){
        frontRoller.set(ControlMode.PercentOutput, ArmConstants.ROLLER_SPEED);
        backRoller.set(ControlMode.PercentOutput, ArmConstants.ROLLER_SPEED);
    }

    public void rollOut(){
        frontRoller.set(ControlMode.PercentOutput, -ArmConstants.ROLLER_SPEED);
        backRoller.set(ControlMode.PercentOutput, -ArmConstants.ROLLER_SPEED);
    }

    public void stopRoll(){
        frontRoller.set(ControlMode.PercentOutput, 0.0);
        backRoller.set(ControlMode.PercentOutput, 0.0);
    }
    
    public double getFrontEncoder(){
        return frontTalon1.getSelectedSensorPosition();
    }
    
    public double getBackEncoder(){
        return backTalon1.getSelectedSensorPosition();
    }
    
    // in raw encoder units
    // gear ratios don't really matter here bc actual distance is not desired
    public double getEncoders(){
        return (getFrontEncoder() + getBackEncoder()) / 2.0;
    }
    
    public void resetEncoders(){
        frontTalon1.setSelectedSensorPosition(0.0);
        backTalon1.setSelectedSensorPosition(0.0);
    }

    public void closeArms(){
        frontTalon1.set(ControlMode.PercentOutput, -ArmConstants.ARM_SPEED);
        backTalon1.set(ControlMode.PercentOutput, ArmConstants.ARM_SPEED);
    }

    public void openArms(){
        frontTalon1.set(ControlMode.PercentOutput, ArmConstants.ARM_SPEED);
        backTalon1.set(ControlMode.PercentOutput, -ArmConstants.ARM_SPEED);
    }

    public void armsForward(){
        frontTalon1.set(ControlMode.PercentOutput, ArmConstants.ARM_SPEED);
        backTalon1.set(ControlMode.PercentOutput, ArmConstants.ARM_SPEED);
    }

    public void armsBackward(){
        frontTalon1.set(ControlMode.PercentOutput, -ArmConstants.ARM_SPEED);
        backTalon1.set(ControlMode.PercentOutput, -ArmConstants.ARM_SPEED);
    }
    
    // for PID commands
    public void closeArms(double speed){
        frontTalon1.set(ControlMode.PercentOutput, -speed);
        backTalon1.set(ControlMode.PercentOutput, speed);
    }
    
    public void openArms(double speed){
        frontTalon1.set(ControlMode.PercentOutput, speed);
        backTalon1.set(ControlMode.PercentOutput, -speed);
    }

    public void moveArms(double speed){
        frontTalon1.set(ControlMode.PercentOutput, speed);
        backTalon1.set(ControlMode.PercentOutput, speed);
    }

    // for shooting commands
    // moves just the forward arm to aim
    public void moveFrontArm(double speed){ 
        frontTalon1.set(ControlMode.PercentOutput, speed);
    }

    public void stopArms(){
        frontTalon1.set(ControlMode.PercentOutput, 0.0);
        backTalon1.set(ControlMode.PercentOutput, 0.0);
    }
}
