// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/*                                                                                                                                
                                                                  #@/                                                                                 
                                                                  %@,                                                                                 
                                                    %(            @@                            (&                                                    
                                                   *@@            @@      @@@@@@@@@@@@@@@@@@@%#*                                                      
                                                   *@@           ,@%                .@&                                                               
                                                   *@#           /@*                .@%                                                               
                                                   *@*           %@                 .@(                                                               
                                                   *@,           @@                 ,@/                                                               
                                                   *@            @@#&@.             *@,                                                               
                                            /@@@@@@@@@@@@@@@&#/*(@#                 (@,                                                               
                                                   @@           (@/                 %@.                                                               
                                                   @&           @@.                 @@.                                                               
                                                   @%           @@                  @@                                                                
                                                  ,@(          %@@         %@@@@@@@@@@@@@@&&&&&@@                                                     
                                                  #@/           @                                                                                     
                                                   *                                                                                                  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
                              *                                                                                                                       
                             %@                                                                        @                                              
              &@%          .@@         &    ,(&@@@@@@%                      @@# #@@@@@@@@@@@@@@@@@@@@&,                         /                     
               @@         @@/     .@@@@@#*,,.            ,@&               @@              &@                   ,(             &@#                    
               #@,     .@@(           #@*                 (@@             &@               @@                   #@@&           #@%                    
               *@#   ,@@/             (@/                   @@*          /@.               @@                   %@ *@&         *@&                    
               ,@# (@@                /@(   ./%@@@*         @@/         @#                @@                   @@   %@#        @&                    
               ,@@@#              /@@@@@@%/                   %@(       @@                 @@                   @@     @@(      @&                    
               @@%.                    @&                      #@(     (@.                .@@                   @@       @@/    @&                    
               #@. /@@@@&              @@                       #@(    @%                 ,@@                   @&         @@,  @@                    
               %@.       *@@@@@@(      %@*            %@         /@%  &@                  *@%                   @&          .@@,(@.                   
               @@               .       @@          .&@           /@#,@*                  /@#                  .@%            .@@@*                   
               @#                        ,#@@@@@@@#*               ,@@@          .@@@@@@@@@@@@@@@@@@@@@%                         .                 
               
                                                  
                                                    have mercy pls i realize this is quite sussy
                                                            im on a time crunch ;-;
*/

public final class Constants {
    public static final class DriveConstants {
        // port #s
        public static final int LEFT_FALCON_1 = 0;
        public static final int LEFT_FALCON_2 = 1;
        public static final int LEFT_FALCON_3 = 2;
        public static final int RIGHT_FALCON_1 = 3;
        public static final int RIGHT_FALCON_2 = 4;
        public static final int RIGHT_FALCON_3 = 5;

        public static final double DEADBAND = 0.02; // 0.0-1.0 value to reduce possible joystick drift
        public static final int[] SHIFTING_SOLENOID = {0, 1};
        public static final double WHEEL_DIAM = 4.0; // inches
        public static final double CYCLES_PER_REV = 2048.0; // falcon 500 CPR
        public static final double DISTANCE_PER_PULSE = WHEEL_DIAM * Math.PI / CYCLES_PER_REV;
        public static final double HIGH_GEAR_RATIO = 5.88; // JVN calculation
        public static final double LOW_GEAR_RATIO = 11.85; // JVN calculation
        public static final double AUTO_SPEED = 0.4; // %
    }

    public static final class OIConstants {
        // port #
        public static final int DRIVER_STATION_JOY = 0;
    }

    public static final class ArmConstants {
        // port #s
        public static final int FRONT_TALON_1 = 6;
        public static final int FRONT_TALON_2 = 7;
        public static final int BACK_TALON_1 = 8;
        public static final int BACK_TALON_2 = 9;
        public static final int FRONT_ROLLER = 10;
        public static final int BACK_ROLLER = 11;

        // encoder info
        public static final double ARM_LOWER_LIMIT = 0.0; // native encoder units
        // placeholder values; in a perfect world the CAD would be done and rough balues could be 
        // garnered from that ;)
        // otherwise would get value from testing IRL, same method used for the climber which worked well
        // i.e. having set positions by which the system can be controlled
        public static final double ARM_UPPER_LIMIT = 1337.0; // native encoder units
        public static final double ARM_VERTICAL_LIMIT = 1337.0; // native encoder units at which the arms are vertical and parallel 
        public static final double ARM_LAUNCHING_LIMIT = 1337.0; // native encoder units at which we launch across the field; fairly rough
        public static final double ARM_SHOOTING_LIMIT = 1337.0; // native encoder units at which we can shoot from auto on the white/color border; guess n check
        public static final double ARM_ENCODER_TOLERANCE = 10.0; // see above message; would scale tolerance accordingly (native encoder units)

        public static final double ROLLER_SPEED = 0.2; // %
        public static final double ARM_SPEED = 0.2; // %

        // PID constants; would tune ofc :)
        public static final double ARM_P = 0.0;
        public static final double ARM_I = 0.0;
        public static final double ARM_D = 0.0;
    }

    public static final class ShooterConstants {
        // port #
        public static final int SHOOTER_VICTOR = 12;
        public static final double SHOOTER_SPEED = 0.2; // %; just the motor powering the choo-choo
    }
}
