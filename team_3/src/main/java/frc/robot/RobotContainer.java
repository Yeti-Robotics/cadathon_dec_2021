// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.auto.ShootAndMoveCommandGroup;
import frc.robot.commands.arms.CloseArmsCommand;
import frc.robot.commands.arms.IntakeInCommand;
import frc.robot.commands.arms.IntakeOutCommand;
import frc.robot.commands.arms.MoveFrontArmCommand;
import frc.robot.commands.arms.OpenArmsCommand;
import frc.robot.commands.arms.ResetFrontArmCommand;
import frc.robot.commands.arms.SetAngleCommand;
import frc.robot.commands.arms.SetArmsVerticalCommand;
import frc.robot.commands.drivetrain.ToggleShiftingCommand;
import frc.robot.commands.shooter.ShootCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ShiftingSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
    private Joystick driveJoystick; 
    private DrivetrainSubsystem drivetrainSubsystem;
    private ShiftingSubsystem shiftingSubsystem;
    private ArmSubsystem armSubsystem;
    private ShooterSubsystem shooterSubsystem;

    public RobotContainer(){
        driveJoystick = new Joystick(OIConstants.DRIVER_STATION_JOY);
        drivetrainSubsystem = new DrivetrainSubsystem();
        shiftingSubsystem = new ShiftingSubsystem();
        armSubsystem = new ArmSubsystem();
        shooterSubsystem = new ShooterSubsystem();

        switch (drivetrainSubsystem.getDriveMode()) {
            case TANK:
                drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> drivetrainSubsystem.tankDrive(getLeftY(), getRightY()), drivetrainSubsystem));
                break;
            case CHEEZY:
                drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> drivetrainSubsystem.cheezyDrive(getLeftY(), getRightX()), drivetrainSubsystem));
                break;
            case ARCADE:
                drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> drivetrainSubsystem.arcadeDrive(getLeftY(), getRightX()), drivetrainSubsystem));
                break;
        }

        configureButtonBindings();
    }
    
    private void configureButtonBindings(){
        setJoystickButtonWhileHeld(driveJoystick, 1, new IntakeInCommand(armSubsystem));
        setJoystickButtonWhileHeld(driveJoystick, 2, new OpenArmsCommand(armSubsystem)); // manually set arms
        setJoystickButtonWhenPressed(driveJoystick, 3, new SetArmsVerticalCommand(armSubsystem)); // close arms
        setJoystickButtonWhenPressed(driveJoystick, 4, new SetAngleCommand(armSubsystem, ArmConstants.ARM_LAUNCHING_LIMIT));
        setJoystickButtonWhileHeld(driveJoystick, 5, new ShootCommand(shooterSubsystem));

        setJoystickButtonWhileHeld(driveJoystick, 6, new IntakeOutCommand(armSubsystem)); // wouldn't do much if ball is already in bc our design, but it's here nonetheless
        setJoystickButtonWhileHeld(driveJoystick, 7, new CloseArmsCommand(armSubsystem)); // manually set arms
        setJoystickButtonWhileHeld(driveJoystick, 8, new MoveFrontArmCommand(armSubsystem, -ArmConstants.ARM_SPEED)); // manually aim (angle down)
        setJoystickButtonWhileHeld(driveJoystick, 9, new MoveFrontArmCommand(armSubsystem, ArmConstants.ARM_SPEED)); // manually aim (angle up)
        setJoystickButtonWhenPressed(driveJoystick, 10, new ResetFrontArmCommand(armSubsystem)); // necessary after aiming

        setJoystickButtonWhenPressed(driveJoystick, 12, new ToggleShiftingCommand(shiftingSubsystem));
    }

    private double getLeftY() {
        return -driveJoystick.getRawAxis(0);
    }

    private double getLeftX() {
        return driveJoystick.getRawAxis(1);
    }

    private double getRightY() {
        return -driveJoystick.getRawAxis(2);
    }

    private double getRightX() {
        return driveJoystick.getRawAxis(3);
    }

    private void setJoystickButtonWhenPressed(Joystick driveJoystick, int button, CommandBase command) {
        new JoystickButton(driveJoystick, button).whenPressed(command);
    }

    private void setJoystickButtonWhileHeld(Joystick driveJoystick, int button, CommandBase command) {
        new JoystickButton(driveJoystick, button).whileHeld(command);
    }

    // reset any encoders or other necessary parts in between enables
    public void resetRobot(){
        armSubsystem.resetEncoders();
    }

    public Command getAutonomousCommand(){
        return new ShootAndMoveCommandGroup(armSubsystem, shooterSubsystem, drivetrainSubsystem);
    }
}
