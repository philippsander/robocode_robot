package de.letscode.robocode.controls.guns;

import robocode.BulletHitBulletEvent;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.Rules;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;
import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;
import de.philippsander.robocode.core.controls.advanced.AdvancedGun;


public class SimpleDirectionGun extends AdvancedGun
{

	public SimpleDirectionGun(final AdvancedRobotComposition robot)
	{
		super(robot);
	}

	@Override
	public void handleBulletHit(final BulletHitEvent event)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void handleBulletHitBullet(final BulletHitBulletEvent event)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void handleBulletMissed(final BulletMissedEvent event)
	{

	}

	@Override
	public void handleScannedRobotEvent(final ScannedRobotEvent e)
	{
		
		
		double gunTurn =
				// Absolute bearing to target
				(getRobot().getHeadingRadians() + e.getBearingRadians())
				// Subtract current gun heading to get turn required
						- getRobot().getGunHeadingRadians();

				getRobot().setTurnGunRightRadians(
						Utils.normalRelativeAngle(gunTurn));
				
		//getRobot().setFire(Rules.MAX_BULLET_POWER * 75 / e.getDistance());
		getRobot().setFire(Rules.MAX_BULLET_POWER);
	}

}
