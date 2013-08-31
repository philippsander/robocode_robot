package de.philippsander.robocode.robots.OneOnOne;

import java.awt.Color;

import de.philippsander.robocode.controls.guns.SimpleDirectionGun;
import de.philippsander.robocode.controls.radars.TurnMultiplierLock;
import de.philippsander.robocode.controls.track.RamTracks;
import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;
/**
 * 
 * @author Philipp Sander
 *
 */

public class Dropdead_1_0_0 extends AdvancedRobotComposition {

	@Override
	protected void initColors() {
		this.setBulletColor(Color.CYAN);
		this.setScanColor(Color.GREEN);
		this.setBodyColor(Color.BLACK);
		this.setRadarColor(Color.BLACK);
		this.setGunColor(Color.YELLOW);

	}

	@Override
	protected void initControls() {
		this.setRadar(new TurnMultiplierLock(this));
		this.setTrack(new RamTracks(this));
		this.setGun(new SimpleDirectionGun(this));
	}

}
