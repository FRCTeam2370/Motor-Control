// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ControlSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class SetCompassVelocity extends Command {
  private double rps;
  /** Creates a new SetCompassVelocity. */
  public SetCompassVelocity(double rps, ControlSubsystem mControlSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(mControlSubsystem);

    this.rps = rps;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ControlSubsystem.setCompassVelocity(rps);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ControlSubsystem.setCompassSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
