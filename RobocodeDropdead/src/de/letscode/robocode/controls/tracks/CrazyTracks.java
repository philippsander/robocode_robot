package de.letscode.robocode.controls.tracks;


import robocode.HitWallEvent;
import robocode.TurnCompleteCondition;
import de.philippsander.robocode.core.compositions.AdvancedRobotComposition;
import de.philippsander.robocode.core.controls.advanced.AdvancedTrack;


public class CrazyTracks extends AdvancedTrack
{

	private boolean	movingForward;

	public CrazyTracks(final AdvancedRobotComposition robot)
	{
		super(robot);
	}

	/**
	 * onHitWall:  Handle collision with wall.
	 */
	public void handleHitWall(final HitWallEvent e) {
		// Bounce off!
		this.reverseDirection();
	}

	@Override
	public void move()
	{
		// Tell the game we will want to move ahead 40000 -- some large number
		getRobot().setAhead(40000);
		this.movingForward = true;
		// Tell the game we will want to turn right 90
		getRobot().setTurnRight(90);
		// At this point, we have indicated to the game that *when we do something*,
		// we will want to move ahead and turn right. That's what "set" means.
		// It is important to realize we have not done anything yet!
		// In order to actually move, we'll want to call a method that
		// takes real time, such as waitFor.
		// waitFor actually starts the action -- we start moving and turning.
		// It will not return until we have finished turning.
		getRobot().waitFor(new TurnCompleteCondition(getRobot()));
		// Note: We are still moving ahead now, but the turn is complete.
		// Now we'll turn the other way...
		getRobot().setTurnLeft(180);
		// ... and wait for the turn to finish ...
		getRobot().waitFor(new TurnCompleteCondition(getRobot()));
		// ... then the other way ...
		getRobot().setTurnRight(180);
		// .. and wait for that turn to finish.
		getRobot().waitFor(new TurnCompleteCondition(getRobot()));

	}

	/**
	 * reverseDirection:  Switch from ahead to back & vice versa
	 */
	public void reverseDirection() {
		if (this.movingForward) {
			getRobot().setBack(40000);
			this.movingForward = false;
		} else {
			getRobot().setAhead(40000);
			this.movingForward = true;
		}
	}
}
