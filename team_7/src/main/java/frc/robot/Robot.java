package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
    WPI_TalonFX leftMotor1, leftMotor2, rightMotor1, rightMotor2, shootingMotor1, pickingUpMotor;

    private Joystick joystick1 = new Joystick(0); // 0 is the port number

    private double startTime; // for keeping track of time in autonomous

    private RobotContainer m_robotContainer;

    private Drive drive;

    private boolean ballPickedUp;

    private button x = new button();

  @Override
  public void robotInit() {
      leftMotor1 = new WPI_TalonFX(0); // declare motors
      leftMotor2 = new WPI_TalonFX(1);
      rightMotor1 = new WPI_TalonFX(2);
      rightMotor2 = new WPI_TalonFX(3);
      shootingMotor1 = new WPI_TalonFX(4); // motor for shooting
      m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();

    if (time - startTime < 3) { // 3 for 3 seconds.
        leftMotor1.set(0.6); // movement of the motors
        leftMotor2.set(0.6); // running them at 60% power, 1 is 100% and 0 is 0%
        rightMotor1.set(-0.6); // the right motors are negative because they are opposite the left motors, but we still want them to turn the same direction so the robot goes forward/backward instead of spinning.
        rightMotor2.set(-0.6);
    } else {
        leftMotor1.set(0);
        leftMotor2.set(0); // running them at 0% power
        rightMotor1.set(0); // the right motors are negative because they are opposite the left motors, but we still want them to turn the same direction so the robot goes forward/backward instead of spinning.
        rightMotor2.set(0);
    }

    if (time - startTime < 4 && time - startTime > 3) // shoots the ball after the robot has moved forward
        shootingMotor1.set(1); 
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {  // TeleopPeriodic runs during teleop
        double speed = -joystick1.getRawAxis(1) - 0.6; // 1 is the axis number for power
        double turn = joystick1.getRawAxis(2) - 0.3; // 2 (in this case) is the axis number for turning

        double left = speed + turn; // This is cheesy drive
        double right = speed - turn;

      leftMotor1.set(left); // the actual movement of the motors :)
      leftMotor2.set(left);
      rightMotor1.set(-right); // the right motors are negative because they are opposite the left motors, but we still want them to turn the same direction so the robot goes forward/backward instead of spinning.
      rightMotor2.set(-right);

      if (x.isPressed()){  // checks if the x button on a controller is pressed.
        if (time - startTime < 2){ // moves the picking up mechanism down for 2 seconds and picks the ball up.
          pickinUpMotor.set(1);
        }
        pickingUpMotor.set(-1); // moves the mechanism back to the starting position.
        ballPickedUp = true;
      }

      if (joystick1.isPressed() && ballPickedUp){  // shoots the ball if the joystick is pressed down and if the robot has a ball.
        shootingMotor1.set(1);
      }
      
      drive.drive(joystick1.getY(), joystick1.getX()); // drives the robot based on the joystick's x and y coordinates.
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}

