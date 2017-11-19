package com.github.igmfilho.challenge.nasarobot.factory;

import org.springframework.stereotype.Component;

import com.github.igmfilho.challenge.nasarobot.command.ICommand;
import com.github.igmfilho.challenge.nasarobot.command.MoveCommand;
import com.github.igmfilho.challenge.nasarobot.command.RotateLeftCommand;
import com.github.igmfilho.challenge.nasarobot.command.RotateRightCommand;
import com.github.igmfilho.challenge.nasarobot.exception.InvalidCommandException;

@Component
public class CommandFactory {

	private static final char LEFT = 'L';
	private static final char MOVE = 'M';
	private static final char RIGHT = 'R';
	
	public CommandFactory() {}

	public ICommand getInstance(final char letter) {
		ICommand cmd;
		switch (letter) {
		case LEFT:
			cmd=new RotateLeftCommand();
			break;
		case MOVE:
			cmd=new MoveCommand();
			break;
		case RIGHT:
			cmd=new RotateRightCommand();
			break;
		default:
			throw new InvalidCommandException();
		}
		return cmd;
	}
}