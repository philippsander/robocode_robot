package de.philippsander.robocode.core.controls.advanced;

import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;
import de.philippsander.robocode.core.controls.Radar;

public abstract class AdvancedRadar extends AdvancedControl implements Radar {

	public AdvancedRadar(final AdvancedRobotComposition robot) {
		super(robot);
	}

}
