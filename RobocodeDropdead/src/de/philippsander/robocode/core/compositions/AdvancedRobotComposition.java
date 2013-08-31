package de.philippsander.robocode.core.compositions;

import robocode.AdvancedRobot;
import robocode.BulletHitBulletEvent;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import de.philippsander.robocode.core.controls.advanced.AdvancedGun;
import de.philippsander.robocode.core.controls.advanced.AdvancedRadar;
import de.philippsander.robocode.core.controls.advanced.AdvancedTrack;

public abstract class AdvancedRobotComposition extends AdvancedRobot
{

	private AdvancedRadar radar;
	private AdvancedTrack track;
	private AdvancedGun gun;

	protected final AdvancedGun getGun()
	{
		return this.gun;
	}

	//setters
	protected final AdvancedRadar getRadar()
	{
		return this.radar;
	}

	protected final AdvancedTrack getTrack()
	{
		return this.track;
	}

	protected abstract void initColors();

	protected abstract void initControls();

	@Override
	public void onBulletHit(final BulletHitEvent event)
	{
		this.gun.handleBulletHit(event);
	}

	@Override
	public void onBulletHitBullet(final BulletHitBulletEvent event)
	{
		this.gun.handleBulletHitBullet(event);
	}

	@Override
	public void onBulletMissed(final BulletMissedEvent event)
	{
		this.gun.handleBulletMissed(event);
	}

	@Override
	public void onHitWall(final HitWallEvent e)
	{
		this.track.handleHitWall(e);
	}

	//events
	@Override
	public void onScannedRobot(final ScannedRobotEvent event)
	{
		this.radar.handleScannedRobotEvent(event);
		this.gun.handleScannedRobotEvent(event);
	}

	@Override
	public void run() {
		this.initControls();
		this.initColors();

		this.setAdjustGunForRobotTurn(true);
		this.setAdjustRadarForGunTurn(true);
		this.setAdjustRadarForRobotTurn(true);

		do {
			this.radar.scan();
			this.track.move();
		} while (true);
	}

	protected final void setGun(final AdvancedGun gun)
	{
		this.gun = gun;
	}

	protected final void setRadar(final AdvancedRadar radar)
	{
		this.radar = radar;
	}

	protected final void setTrack(final AdvancedTrack track)
	{
		this.track = track;
	}

}

