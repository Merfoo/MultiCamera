package org.usfirst.frc.team955.robot;

public class Config
{
    public class Controller
    {
    	public static final int chn = 0;
    	public static final int maxButtons = 12;
    	public static final double linearity = 1.5;
    }
    
    public class CameraFeeds
    {
    	public static final int btCamCenter = 1;
    	public static final int btCamRight = 2;
    	
    	public static final String camNameCenter = "cam0";
    	public static final String camNameRight = "cam1";
    	public static final int imgQuality = 60;
    }
}