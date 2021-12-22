// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class Drivetrain {
        public static final int kMotor1Port = 0;
        public static final int kMotor2Port = 1;
        public static final int kMotor3Port = 2;
        public static final int kMotor4Port = 3;
        public static final int kGyroPort = 1;
        public static final int kEncoderTicksPerRev = 2048;
        public static final double kSensorGearRatio = 1;
        // Inches
        public static final double kWheelRadius = 3;
        public static final int k100msPerSecond = 10;
        // in kg
        public static final double kRobotMOI = 2;
        // in kg
        public static final double kRobotMass = 69.8532;
        // Meters
        public static final double kDistanceBetweenWheels = 0.762;
        public static final int kMotorsPerSide = 2;
        public static final double kGearRatio = 9.47;
        public static final double kSimDelta = 0.02;

        public static final double ksVolts = 0.22;
        public static final double kvVoltSecondsPerMeter = 1.98;
        public static final double kaVoltsSecondsSquaredPerMeter = 0.2;
        public static final double kPDriveVel = 8.5;

        public static final DifferentialDriveKinematics kDriveKinematics = 
            new DifferentialDriveKinematics(kDistanceBetweenWheels);
        
        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double kRamseteB = 2;
        public static final double kRamseteZeta = 0.7;
    }


    public static final class Intake {
        public static final int kIntakeMotorPortFront = 5;
        public static final int kIntakeMotorPortBack = 6;
    
        public static final double kIntakeMotorSpeed = 1;
    
        public static final double kAutoIntakeTime = 0.6;
    }


    public static final class Hinge {
        public static final int kHingeMotorPortFront = 7;
        public static final int kHingeMotorPortBack = 8;

        public static final int kHingeEncoderPortFront = 9;
        public static final int kHingeEncoderPortBack = 10;

        public static final double kHingeMotorSpeed = 1;

        public static final double kAutoHingeTime = 0.6;

        public static final double kHingeSetP = 0.1;
        public static final double kHingeSetI = 0.0;
        public static final double kHingeSetD = 0.01;
        public static final double kHingeSetTolerance = 1.5;
    }


    public static final class OI {
        public static final int kJoystick1Port = 0;
        public static final int kJoystick2Port = 1;

        // Intakes
        public static final int kIntakeButtonFront = 2;
        public static final int kOutTakeButtonFront = 3;

        public static final int kIntakeButtonBack = 4;
        public static final int kOutTakeButtonBack = 5;

        // Hinges
        public static final int kHingeDownButtonFront = 6;
        public static final int kHingeUpButtonFront = 7;

        public static final int kHingeDownButtonBack = 8;
        public static final int kHingeUpButtonBack = 9;
    }
}
