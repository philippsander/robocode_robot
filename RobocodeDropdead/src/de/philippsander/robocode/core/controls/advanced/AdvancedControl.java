package de.philippsander.robocode.core.controls.advanced;

import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;

public abstract class AdvancedControl
{

	private final AdvancedRobotComposition robot;

	public AdvancedControl(final AdvancedRobotComposition robot)
	{
		super();
		this.robot = robot;
	}

	protected final AdvancedRobotComposition getRobot()
	{
		return this.robot;
	}

}
