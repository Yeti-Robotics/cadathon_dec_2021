//Kevin:
//Sorry if this code sucks lmao ;)
// - Varun

package frc.robot;

import javax.swing.Spring;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.autoRoutines.ShootAndDriveForwardCommandGroup;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.intake.CenterPieceCommand;
import frc.robot.commands.intake.CloseClawCommand;
import frc.robot.commands.intake.IntakeInCommand;
import frc.robot.commands.intake.IntakeVoidCommand;
import frc.robot.commands.intake.OpenClawCommand;
import frc.robot.commands.pivot.PivotBackwardCommand;
import frc.robot.commands.pivot.PivotForwardCommand;
import frc.robot.commands.shifter.ShiftToggleCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.ShiftingGearsSubsystem;
import frc.robot.subsystems.SpringShootSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public final Joystick driverJoy;
  public DrivetrainSubsystem drivetrainSubsystem;
  public IntakeSubsystem intakeSubsystem;
  public PivotSubsystem pivotSubsystem;
  public ShiftingGearsSubsystem shiftingGearsSubsystem;
  public SpringShootSubsystem springShootSubsystem;

  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    driverJoy = new Joystick(1);

    drivetrainSubsystem = new DrivetrainSubsystem();
    intakeSubsystem = new IntakeSubsystem();
    pivotSubsystem = new PivotSubsystem();
    shiftingGearsSubsystem = new ShiftingGearsSubsystem();
    springShootSubsystem = new SpringShootSubsystem();
    

    
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
      default:
        // tank 
        drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> drivetrainSubsystem.tankDrive(getLeftY(), getRightY()), drivetrainSubsystem));
        break;
    }
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // bottom row
    setJoystickButtonWhileHeld(driverJoy, 1, new IntakeInCommand(intakeSubsystem));
    setJoystickButtonWhileHeld(driverJoy, 2, new IntakeVoidCommand(intakeSubsystem));

    setJoystickButtonWhenPressed(driverJoy, 3, new ShiftToggleCommand(shiftingGearsSubsystem));
    
    setJoystickButtonWhenPressed(driverJoy, 4, new OpenClawCommand(intakeSubsystem));
    setJoystickButtonWhenPressed(driverJoy, 5, new CloseClawCommand(intakeSubsystem));

    setJoystickButtonWhenPressed(driverJoy, 6, new ShootCommand(intakeSubsystem, springShootSubsystem));

    setJoystickButtonWhileHeld(driverJoy, 7, new PivotForwardCommand(pivotSubsystem));
    setJoystickButtonWhileHeld(driverJoy, 8, new PivotBackwardCommand(pivotSubsystem));

    setJoystickButtonWhileHeld(driverJoy, 9, new CenterPieceCommand(intakeSubsystem));

  }


  public double getLeftY() {
    return -driverJoy.getRawAxis(0);
  }

  public double getLeftX() {
    return driverJoy.getRawAxis(1);
  }

  public double getRightY() {
    return -driverJoy.getRawAxis(2);
  }

  public double getRightX() {
    return -driverJoy.getRawAxis(3);
  }

  public double getLeftThrottle() {
    return (driverJoy.getThrottle() + 1) / 2;
  }

  private void setJoystickButtonWhenPressed(Joystick joystick, int button, CommandBase command) {
    new JoystickButton(joystick, button).whenPressed(command);
  }

  private void setJoystickButtonWhileHeld(Joystick joystick, int button, CommandBase command) {
    new JoystickButton(joystick, button).whileHeld(command);
  }
   
  public Command getAutonomousCommand() {
     return new ShootAndDriveForwardCommandGroup(drivetrainSubsystem, intakeSubsystem);
  }
}
