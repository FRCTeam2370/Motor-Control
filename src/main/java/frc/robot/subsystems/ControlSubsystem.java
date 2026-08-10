// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlSubsystem extends SubsystemBase {
  public static TalonFX compassMotor = new TalonFX(1); 

  /** Creates a new ControlSubsystem. */
  public ControlSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static void setCompassSpeed(double percent) {
    percent /= 100;
    compassMotor.set(percent);
  }

  public static void stopCompass(){
    compassMotor.set(0);
  }

}
