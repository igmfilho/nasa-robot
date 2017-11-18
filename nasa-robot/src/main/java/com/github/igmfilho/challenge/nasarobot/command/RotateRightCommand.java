package com.github.igmfilho.challenge.nasarobot.command;

import com.github.igmfilho.challenge.nasarobot.model.Robot;

public class RotateRightCommand implements ICommand {

	@Override
	public void execute(Robot robot) {
		robot.rotateRight();
	}
}
