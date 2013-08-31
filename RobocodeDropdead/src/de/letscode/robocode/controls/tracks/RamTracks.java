package de.letscode.robocode.controls.tracks;

import robocode.HitWallEvent;
import robocode.TurnCompleteCondition;
import robocode.util.Utils;
import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;
import de.philippsander.robocode.core.controls.advanced.AdvancedTrack;

public class RamTracks extends AdvancedTrack {

	public RamTracks(final AdvancedRobotComposition robot) {
		super(robot);
	}

	@Override
	public void handleHitWall(final HitWallEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		double bearing = Utils.normalRelativeAngle(getRobot()
				.getRadarHeadingRadians() - getRobot().getHeadingRadians());

		getRobot().setTurnRightRadians(bearing);

		getRobot().setAhead(40000);

		getRobot().waitFor(new TurnCompleteCondition(getRobot()));
	}

}
