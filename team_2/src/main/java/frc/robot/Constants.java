// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveConstants{

        public static final int LEFT_FALCON_1 = 1; //all placeholder values
        public static final int LEFT_FALCON_2 = 2;
        public static final int LEFT_FALCON_3 = 3;
        public static final int RIGHT_FALCON_1 = 4;
        public static final int RIGHT_FALCON_2 = 5;
        public static final int RIGHT_FALCON_3 = 6;


        public static final int[] SOLENOID_SHIFTER = {0, 1}; //placeholder

        public static final double DRIVE_ENCODER_RESOLUTION = 2048;
        public static final double DRIVE_WHEEL_DIAMETER = 6.0; 
        public static final double DISTANCE_PER_PULSE = (DRIVE_WHEEL_DIAMETER * Math.PI) / (DRIVE_ENCODER_RESOLUTION);

        public static final double HIGH_GEAR_RATIO = 36.0 / 30.0;
        public static final double LOW_GEAR_RATIO = 22.0 / 44.0;


    }

    public static final class IntakeConstants {

        public static final int INTAKE_FALCON = 7; //placeholder values
        public static final int CENTERING_FALCON = 8;

        public static final int[] SOLENOID_CLAW = {2, 3}; //placeholder

        public static final double INTAKE_SPEED = 1.0;
        public static final double REVERSE_INTAKE_SPEED = -1.0;

        public static final double CENTERING_SPEED = 1.0;
    }

    public static final class PivotConstants {

        public static final int PIVOT_FALCON_1 = 9;
        public static final int PIVOT_FALCON_2 = 10;

        public static final double SPIN_FORWARD_SPEED = 1.0;
        public static final double SPIN_BACKWARD_SPEED = -1.0;

    }

    public static final class SpringConstants {
        
        public static final int SPRING_MOTOR_PORT = 11; //placeholder

        public static final double SHOOT_SPEED = 1.0;
        public static final double RETRACT_SPEED = -1.0;

    }

}
