package de.philippsander.robocode.core.controls.advanced;

import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;
import de.philippsander.robocode.core.controls.Track;

public abstract class AdvancedTrack extends AdvancedControl implements Track {

	public AdvancedTrack(final AdvancedRobotComposition robot) {
		super(robot);
	}

}

