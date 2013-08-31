package de.philippsander.robocode.core.controls;

import robocode.BulletHitBulletEvent;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.ScannedRobotEvent;

public interface Gun {
	public void handleBulletHit(BulletHitEvent event);

	public void handleBulletHitBullet(BulletHitBulletEvent event);

	public void handleBulletMissed(BulletMissedEvent event);

	public void handleScannedRobotEvent(ScannedRobotEvent e);
}
