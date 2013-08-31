package de.philippsander.robocode.core.controls;

import robocode.HitWallEvent;

public interface Track {
	public void handleHitWall(HitWallEvent e);

	public void move();
}
