package com.github.igmfilho.challenge.nasarobot.command;

import com.github.igmfilho.challenge.nasarobot.model.Robot;

public class MoveCommand implements ICommand {

	@Override
	public void execute(Robot robot) {
		robot.move();
	}
}
