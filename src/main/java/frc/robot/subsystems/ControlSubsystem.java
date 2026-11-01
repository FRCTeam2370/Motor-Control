// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicDutyCycle;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlSubsystem extends SubsystemBase {
  public static TalonFX compassMotor = new TalonFX(1); 

  private static TalonFXConfiguration compassConfig = new TalonFXConfiguration();

  private static VelocityDutyCycle velocityDutyCycle = new VelocityDutyCycle(0);
  private static PositionDutyCycle positionDutyCycle = new PositionDutyCycle(0);
  private static MotionMagicDutyCycle magicDutyCycle = new MotionMagicDutyCycle(0);

  /** Creates a new ControlSubsystem. */
  public ControlSubsystem() {
    ConfigCompass();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Compass Motor Velocity", 
      compassMotor.getVelocity().getValueAsDouble());
  }

  public static void setCompassSpeed(double percent) {
    percent /= 100;
    compassMotor.set(percent);
  }

  public static void stopCompass(){
    compassMotor.set(0);
  }

  public static void setCompassVelocity(double rps){
    compassMotor.setControl(velocityDutyCycle.withVelocity(rps).withSlot(0));
  }

  public static void setCompassPosition(double rotations){
    compassMotor.setControl(positionDutyCycle.withPosition(rotations).withSlot(1));
  }

  public static void setCompassPositionMagically(double rotations){
    compassMotor.setControl(magicDutyCycle.withPosition(rotations).withSlot(1));
  }

  private static void ConfigCompass(){
    compassMotor.setPosition(0);

    compassConfig.Slot0.kP = 0.03;//power / oomph
    compassConfig.Slot0.kI = 0.0;//power over time
    compassConfig.Slot0.kD = 0.0;//smoothening towards setpoint

    compassConfig.Slot1.kP = 0.01;//power / oomph
    compassConfig.Slot1.kI = 0.0;//power over time
    compassConfig.Slot1.kD = 0.0;//smoothening towards setpoint

    compassConfig.MotionMagic.MotionMagicAcceleration = 40;
    compassConfig.MotionMagic.MotionMagicCruiseVelocity = 80;

    compassMotor.getConfigurator().apply(compassConfig);//applies config to motor
  }

}
