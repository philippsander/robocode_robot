package de.letscode.robocode.controls.radars;


import robocode.Rules;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;
import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;
import de.philippsander.robocode.core.controls.advanced.AdvancedRadar;


public class WidthLock extends AdvancedRadar
{

	public WidthLock(final AdvancedRobotComposition robot)
	{
		super(robot);
	}

	public ScannedRobotEvent handleScannedRobotEvent(final ScannedRobotEvent e)
	{
	    // Absolute angle towards target
	    double angleToEnemy = getRobot().getHeadingRadians() + e.getBearingRadians();

	    // Subtract current radar heading to get the turn required to face the enemy, be sure it is normalized
	    double radarTurn = Utils.normalRelativeAngle( angleToEnemy - getRobot().getRadarHeadingRadians() );

	    // Distance we want to scan from middle of enemy to either side
	    // The 36.0 is how many units from the center of the enemy robot it scans.
	    double extraTurn = Math.min( Math.atan( 36.0 / e.getDistance() ), Rules.RADAR_TURN_RATE_RADIANS );

	    // Adjust the radar turn so it goes that much further in the direction it is going to turn
	    // Basically if we were going to turn it left, turn it even more left, if right, turn more right.
	    // This allows us to overshoot our enemy so that we get a good sweep that will not slip.
	    radarTurn += (radarTurn < 0 ? -extraTurn : extraTurn);

	    //Turn the radar
	    getRobot().setTurnRadarRightRadians(radarTurn);

		return e;
	}

	public void scan()
	{
		if (getRobot().getRadarTurnRemaining() == 0.0) {
			getRobot().setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
		}
	}

}
