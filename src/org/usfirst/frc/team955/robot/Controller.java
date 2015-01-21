package org.usfirst.frc.team955.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * 
 */
public class Controller extends Joystick
{
	private final double linearity;
	private final int maxButtons;
	private int chnLeftX = 0;
	private int chnLeftY = 1;
	private int chnRightX = 2;
	private int chnRightY = 3;
	private boolean[] lastButtonState;
	private boolean[] buttonState;
	private boolean flipLeftX = false;
	private boolean flipLeftY = true;
	private boolean flipRightX = false;
	private boolean flipRightY = true;

	/**
	 * Constructor
	 * @param portNum port number for the controller
	 */
	public Controller(int portNum, int maxButtons, double linearity)
	{
		super(portNum);
		this.maxButtons = maxButtons;
		this.linearity = linearity;
		lastButtonState = new boolean[maxButtons];
		buttonState = new boolean[maxButtons];

		for(int i = 0; i < maxButtons; i++)
		{
			lastButtonState[i] = false;
			buttonState[i] = false;
		}
	}

	/**
	 * Updates the button values for the controller
	 */
	public void update()
	{
		for(int i = 0; i < maxButtons; i++)
		{
			buttonState[i] = !lastButtonState[i] && super.getRawButton(i + 1);
			lastButtonState[i] = super.getRawButton(i + 1);
		}
	}

	/**
	 * Gives button value
	 * @param button the button number on the controller
	 * @return button value
	 */
	public boolean getButton(int button)
	{
		return buttonState[button - 1];
	}

	/**
	 * Gets the x value of the left joystick
	 * @return the x value of the Left joystick
	 */
	public double getRawLeftX()
	{
		return super.getRawAxis(chnLeftX) * (flipLeftX ? -1 : 1);
	}

	/**
	 * Gets the y value of the left joystick
	 * @return the y value of the left joystick
	 */
	public double getRawLeftY()
	{
		return super.getRawAxis(chnLeftY) * (flipLeftY ? -1 : 1);
	}

	/**
	 * Gets the x value of the right joystick
	 * @return the x value of the right joystick
	 */
	public double getRawRightX()
	{
		return super.getRawAxis(chnRightX) * (flipRightX ? -1 : 1);
	}

	/**
	 * Gets the y value of the right joystick
	 * @return the y value of the right joystick
	 */
	public double getRawRightY()
	{
		return super.getRawAxis(chnRightY) * (flipRightY ? -1 : 1);
	}

	public double getLeftX()
	{
		return altInput(getRawLeftX());
	}

	public double getLeftY()
	{
		return altInput(getRawLeftY());
	}

	public double getRightX()
	{
		return altInput(getRawRightX());
	}

	public double getRightY()
	{
		return altInput(getRawRightX());
	}

	public void flipLeftX(boolean flip)
	{
		flipLeftX = flip;
	}

	public void flipLeftY(boolean flip)
	{
		flipLeftY = flip;
	}

	public void flipRightX(boolean flip)
	{
		flipRightX = flip;
	}

	public void flipRightY(boolean flip)
	{
		flipRightY = flip;
	}

	public void setChnLeftX(int chn)
	{
		chnLeftX = chn;
	}

	public void setChnLeftY(int chn)
	{
		chnLeftY = chn;
	}

	public void setChnRightX(int chn)
	{
		chnRightX = chn;
	}

	public void setChnRightY(int chn)
	{
		chnRightY = chn;
	}

	public boolean getDpadUp()
	{
		return super.getPOV(0) == 0;
	}

	public boolean getDpadRight()
	{
		return super.getPOV(0) == 90;
	}

	public boolean getDpadDown()
	{
		return super.getPOV(0) == 180;
	}

	public boolean getDpadLeft()
	{
		return super.getPOV(0) == 270;
	}
	
	/**
	 * Modifies the joystick input to be more of a tan curve
	 * @param input
	 * @return
	 */
	private double altInput(double input)
	{
		return Math.tan((Math.PI / 4) * linearity * input) / Math.tan((Math.PI / 4) * linearity);
	}
}