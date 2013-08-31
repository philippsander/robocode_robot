package de.philippsander.robocode.core.controls.advanced;

import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;
import de.philippsander.robocode.core.controls.Gun;

public abstract class AdvancedGun extends AdvancedControl implements Gun {

	public AdvancedGun(final AdvancedRobotComposition robot) {
		super(robot);
	}

}

