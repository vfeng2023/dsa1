package main;

import world.Move;
import world.Roomba;

public class MyRoomba extends Roomba{
	
	/*You can put variables here if it will be helpful*/
	/*Examples: Roomba is currently turning, Roomba is trying to get to some new direction, etc. */

	public MyRoomba(int x, int y, int radius) {
		super(x, y, radius);
	}

	@Override
	public Move makeMove() {
		/*TODO: Make this method better. Here's an example Roomba that always turns a random direction*/
		// if(this.frontBumper){
		// 	return Move.TURNCLOCKWISE;
		// }else{
		// 	return Move.FORWARD;
		// }
		//if we bump into something, turn
		// if(this.frontBumper){
		// 	double r = Math.random();
		// 	if(r < 0.5)
		// 	return Move.TURNCLOCKWISE;
		// 	return Move.TURNCOUNTERCLOCKWISE;
			
		// }
			
		if(this.wallSensor){
			double r = Math.random();
			if(r < 0.5){
				return Move.TURNCLOCKWISE;
			}else if(r < 0.75){
				return Move.TURNCOUNTERCLOCKWISE;
			}else{
				return Move.FORWARD;
			}
		}

		if(this.infraredSensor < 5){
			double r = Math.random();
			if(r < 0.5)
				return Move.TURNCLOCKWISE;
			else if(r < 0.75){
				return Move.TURNCOUNTERCLOCKWISE;
			}
		}
		//otherwise just move forward
		double r = Math.random();
		if(r < 0.99)
			return Move.FORWARD;
		return Move.TURNCLOCKWISE;
	}
	
}
