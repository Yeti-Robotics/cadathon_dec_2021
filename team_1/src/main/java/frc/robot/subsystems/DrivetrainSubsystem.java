// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class DrivetrainSubsystem extends SubsystemBase {
	public WPI_TalonFX rightMotor1, rightMotor2, rightMotor3;
	public WPI_TalonFX leftMotor1, leftMotor2, leftMotor3;
	public DifferentialDrive dDrive;

  	/** Creates a new DrivetrainSubsystem. */
	public DrivetrainSubsystem() {
		rightMotor1 = new WPI_TalonFX(DrivetrainConstants.RIGHT_MOTOR_PORT1);
		rightMotor2 = new WPI_TalonFX(DrivetrainConstants.RIGHT_MOTOR_PORT2);
		rightMotor3 = new WPI_TalonFX(DrivetrainConstants.RIGHT_MOTOR_PORT3);

		leftMotor1 = new WPI_TalonFX(DrivetrainConstants.LEFT_MOTOR_PORT1);
		leftMotor2 = new WPI_TalonFX(DrivetrainConstants.LEFT_MOTOR_PORT2);
		leftMotor3 = new WPI_TalonFX(DrivetrainConstants.LEFT_MOTOR_PORT3);

		dDrive = new DifferentialDrive(leftMotor1, rightMotor1);

		rightMotor1.setInverted(true);
		rightMotor2.follow(rightMotor1);
		rightMotor2.setInverted(InvertType.FollowMaster);
		rightMotor3.follow(rightMotor1);
		rightMotor3.setInverted(InvertType.FollowMaster);

		leftMotor2.follow(leftMotor1);
		leftMotor2.setInverted(InvertType.FollowMaster);
		leftMotor3.follow(leftMotor1);
		leftMotor3.setInverted(InvertType.FollowMaster);
	}

	public void tankDrive(double leftPow, double rightPow) {
		dDrive.tankDrive(leftPow, rightPow);
	}

	public void stop() {
		leftMotor1.set(0);
		rightMotor1.set(0);
	}

  	@Override
  	public void periodic() {
    	// This method will be called once per scheduler run
  	}
}
