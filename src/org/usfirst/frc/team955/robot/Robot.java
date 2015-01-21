package org.usfirst.frc.team955.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot 
{
    Controller contr = new Controller(Config.Controller.chn, Config.Controller.maxButtons, Config.Controller.linearity);
    CameraFeeds cameraFeeds = new CameraFeeds(contr);
    
    /**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{

	}

	/**
	 * This function is called once at the beginning during 
	 * teleopPeriodic
	 */
	public void teleopInit()
	{
		cameraFeeds.init();
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		contr.update();
		cameraFeeds.run();
	}

	/**
	 * This function is called once at the beginning when the robot
	 * is disabled
	 */
	public void disabledInit()
	{
		cameraFeeds.end();
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{

	}
}