package com.github.igmfilho.challenge.nasarobot.parser;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.igmfilho.challenge.nasarobot.command.ICommand;
import com.github.igmfilho.challenge.nasarobot.factory.CommandFactory;

@Component
public class CommandParser {
	
	private CommandFactory cmdFactory;

	@Autowired
	public void setCommandFactory(CommandFactory cmdFactory) {
		this.cmdFactory = cmdFactory;
	}
	
	public List<ICommand> parse(final String command) {
		return command.chars().mapToObj(cmd -> cmdFactory.getInstance((char) cmd))
										.collect(Collectors.toList());
	}
}