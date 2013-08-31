package de.philippsander.robocode.robots.OneOnOne;

import java.awt.Color;

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
		// TODO Auto-generated method stub

	}

}
