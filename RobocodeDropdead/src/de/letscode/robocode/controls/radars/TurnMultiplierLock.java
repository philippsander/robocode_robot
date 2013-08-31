package de.letscode.robocode.controls.radars;

import robocode.ScannedRobotEvent;
import robocode.util.Utils;
import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;
import de.philippsander.robocode.core.controls.advanced.AdvancedRadar;

public class TurnMultiplierLock extends AdvancedRadar {

	public TurnMultiplierLock(final AdvancedRobotComposition robot) {
		super(robot);
	}

	@Override
	public ScannedRobotEvent handleScannedRobotEvent(final ScannedRobotEvent e) {
		double radarTurn =
		// Absolute bearing to target
		(getRobot().getHeadingRadians() + e.getBearingRadians())
		// Subtract current radar heading to get turn required
				- getRobot().getRadarHeadingRadians();

		getRobot().setTurnRadarRightRadians(
				Utils.normalRelativeAngle(radarTurn));

		return e;
	}

	@Override
	public void scan() {
		if (getRobot().getRadarTurnRemaining() == 0.0) {

			if(this.shouldRadarTurnRight()) {
			getRobot().setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
			}
			else {
				getRobot().setTurnRadarLeftRadians(Double.POSITIVE_INFINITY);
			}
		}
	}

	private boolean shouldRadarTurnRight() {
		double posXInPercent = getRobot().getX()
				/ getRobot().getBattleFieldWidth();
		double posYInPercent = getRobot().getY()
				/ getRobot().getBattleFieldHeight();
		
		double battleFieldAngle = Math.tan(getRobot().getBattleFieldWidth() / getRobot().getBattleFieldHeight());

		if (posXInPercent < 50) {
			if (posYInPercent < 50) {

			} else {

			}
		} else {
			if (posYInPercent < 50) {

			} else {

			}
		}

		return false;
	}

}
