// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeInCommand;
import frc.robot.commands.IntakeOutCommand;
import frc.robot.commands.PivotIntakeDownCommand;
import frc.robot.commands.PivotIntakeUpCommand;
import frc.robot.commands.ToggleShifterCommand;
import frc.robot.commands.ToggleShooterCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.GearShifterSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public Joystick driverStation;
  public DrivetrainSubsystem drivetrainSubsystem;
  public GearShifterSubsystem gearShifterSubsystem;
  public ShooterSubsystem shooterSubsystem;
  public IntakeSubsystem intakeSubsystem;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driverStation = new Joystick(0);
    drivetrainSubsystem = new DrivetrainSubsystem();

    configureButtonBindings();

    drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> drivetrainSubsystem.tankDrive(getLeftY(), getRightY()), drivetrainSubsystem)); 
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton button1 = new JoystickButton(driverStation, 1);
    button1.whenPressed(new ToggleShifterCommand(gearShifterSubsystem));

    JoystickButton button2 = new JoystickButton(driverStation, 2);
    button2.whenPressed(new ToggleShooterCommand(shooterSubsystem));

    JoystickButton button3 = new JoystickButton(driverStation, 3);
    button3.whenPressed(new IntakeInCommand(intakeSubsystem));
    JoystickButton button4 = new JoystickButton(driverStation, 4);
    button4.whenPressed(new IntakeOutCommand(intakeSubsystem));
    JoystickButton button5 = new JoystickButton(driverStation, 5);
    button5.whileActiveContinuous(new PivotIntakeUpCommand(intakeSubsystem));
    JoystickButton button6 = new JoystickButton(driverStation, 6);
    button6.whileActiveContinuous(new PivotIntakeDownCommand(intakeSubsystem));
  }

  public double getLeftY() {
    return -driverStation.getRawAxis(0);
  }
  public double getRightY() {
    return -driverStation.getRawAxis(2);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  /* public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  }*/
}
