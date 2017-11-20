package com.github.igmfilho.challenge.nasarobot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.igmfilho.challenge.nasarobot.checker.BorderLimitChecker;
import com.github.igmfilho.challenge.nasarobot.factory.RobotFactory;
import com.github.igmfilho.challenge.nasarobot.factory.TargetGroundFactory;
import com.github.igmfilho.challenge.nasarobot.model.Robot;
import com.github.igmfilho.challenge.nasarobot.model.TargetGround;
import com.github.igmfilho.challenge.nasarobot.parser.CommandParser;

@Component
public class RobotService {

	private RobotFactory robotFactory;
	
	private TargetGroundFactory groundFactory;

	private CommandParser cmdParser;
	
	private BorderLimitChecker borderLimit;

	public Robot execute(final String command) {
		Robot robot = robotFactory.getObject();
		TargetGround ground = groundFactory.getObject();
		cmdParser.parse(command).forEach(icommand->{
									icommand.execute(robot);
									borderLimit.check(ground, robot.getCoordinate());
								});

		return robot;
	}

	@Autowired
	public void setRobotFactory(RobotFactory robotFactory) {
		this.robotFactory = robotFactory;
	}

	@Autowired
	public void setGroundFactory(TargetGroundFactory groundFactory) {
		this.groundFactory = groundFactory;
	}

	@Autowired
	public void setCmdParser(CommandParser cmdParser) {
		this.cmdParser = cmdParser;
	}

	@Autowired
	public void setBorderLimit(BorderLimitChecker borderLimit) {
		this.borderLimit = borderLimit;
	}
}