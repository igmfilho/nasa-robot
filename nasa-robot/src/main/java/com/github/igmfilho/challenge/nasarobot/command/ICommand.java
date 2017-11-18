package com.github.igmfilho.challenge.nasarobot.command;

import com.github.igmfilho.challenge.nasarobot.model.Robot;

public interface ICommand {
	void execute(Robot robot);
}
