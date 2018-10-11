/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4951;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4951.commands.*;
import frc.team4951.commands.Auto.Autonomous;
import frc.team4951.subsystems.DriveTrain;
import frc.team4951.subsystems.FrontElevator;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot {

    private Command autonomousCommand;
    private SendableChooser<Autonomous.AutoMode> chooser = new SendableChooser<>();
    private SendableChooser<Autonomous.StartPosition> start = new SendableChooser<>();

    private Compressor compressor;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() 
    {
        CommandBase.init();
        start.addDefault("Left", Autonomous.StartPosition.LEFT);
        start.addObject("Center", Autonomous.StartPosition.CENTER);
        start.addObject("Right", Autonomous.StartPosition.RIGHT);
        SmartDashboard.putData("Starting Position", start);
        
        chooser.addObject("Scale", Autonomous.AutoMode.SCALE);
        chooser.addObject("Switch", Autonomous.AutoMode.SWITCH);
        chooser.addDefault("Drive", Autonomous.AutoMode.DRIVE);
        SmartDashboard.putData("Auto Mode", chooser);
        
        compressor = new Compressor();
        compressor.start();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {

        new Turn(180).start();
//        autonomousCommand = new Autonomous(start.getSelected(), chooser.getSelected());
        
  //      autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
        log();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) 
        {
            autonomousCommand.cancel();
        }

        Command arcadeDrive = new ArcadeDrive();
        arcadeDrive.start();

        Command backElevatorControls = new BackElevatorControl();
        backElevatorControls.start();
        
        Command intakeControl = new IntakeControl();
        intakeControl.start();
        
        Command frontElevatorControl = new FrontElevatorManual();
        frontElevatorControl.start();
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() 
    {}
    
    private void log() {
        DriveTrain.getInstance().log();
        FrontElevator.getInstance().log();
    }
}
