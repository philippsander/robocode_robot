package de.philippsander.robocode.core.controls;

import robocode.ScannedRobotEvent;

public interface Radar {
	public ScannedRobotEvent handleScannedRobotEvent(ScannedRobotEvent e);

	public void scan();
}
