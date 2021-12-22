

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.AutoMode;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeRetractCommand;
import frc.robot.commands.IntakeStopCommand;
import frc.robot.commands.Tower1LoadCommand;
import frc.robot.commands.Tower1PassCommand;
import frc.robot.commands.Tower2LaunchCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.Tower1Subsystem;
import frc.robot.subsystems.Tower2Subsystem;


public class RobotContainer {
  Joystick driverstation;
  DrivetrainSubsystem drivetrainSubsystem;
  IntakeSubsystem intakeSubsystem;
  Tower1Subsystem tower1subsytem;
  Tower2Subsystem tower2Subsystem;

  
  public RobotContainer() {
    driverstation = new Joystick(0);
    drivetrainSubsystem = new DrivetrainSubsystem();
    intakeSubsystem = new IntakeSubsystem();
    tower1subsytem = new Tower1Subsystem();
    tower2Subsystem = new Tower2Subsystem();
    configureButtonBindings();
    drivetrainSubsystem.setDefaultCommand(
        new RunCommand(() -> drivetrainSubsystem.drive(-driverstation.getRawAxis(0), -driverstation.getRawAxis(2)),
            drivetrainSubsystem));
  }

  
  private void configureButtonBindings() {
  

    JoystickButton button1 = new JoystickButton(driverstation, 1);
    button1.whenPressed(new IntakeCommand(intakeSubsystem));
    // open intake
    JoystickButton button2 = new JoystickButton(driverstation, 2);
    button2.whenPressed(new IntakeRetractCommand(intakeSubsystem));
    // close intake
    JoystickButton button3 = new JoystickButton(driverstation, 3);
    button3.whenPressed(new IntakeStopCommand(intakeSubsystem));
    // stop intake
    JoystickButton button4 = new JoystickButton(driverstation , 4);
    button4.whenPressed(new Tower1LoadCommand(tower1subsytem));
    // load ball into launcher  
    JoystickButton button5 = new JoystickButton(driverstation, 5);
    button5.whenPressed(new Tower1PassCommand(tower1subsytem));
    // pass ball to teammate 
    JoystickButton button6 = new JoystickButton(driverstation, 6);
    button6.whenPressed(new Tower2LaunchCommand(tower2Subsystem));
    // launch ball into high goal when at starting line
    JoystickButton button7 = new JoystickButton(driverstation, 7);
    button7.whenPressed(new AutoMode());


  }
  public Command getAutoCommand(){
    return new SequentialCommandGroup(new Tower2LaunchCommand(tower2Subsystem),
        new AutoDriveCommand(drivetrainSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
