package com.github.igmfilho.challenge.nasarobot.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.igmfilho.challenge.nasarobot.command.ICommand;
import com.github.igmfilho.challenge.nasarobot.command.MoveCommand;
import com.github.igmfilho.challenge.nasarobot.command.RotateLeftCommand;
import com.github.igmfilho.challenge.nasarobot.command.RotateRightCommand;
import com.github.igmfilho.challenge.nasarobot.exception.InvalidCommandException;

public class CommandFactoryTest {

	private static final char LEFT  = 'L';
	private static final char MOVE  = 'M';
	private static final char RIGHT = 'R';
	private static final char INVALID_COMMAND = 'A';

	private CommandFactory cmdFactory;
	
	@Before
	public void setUp() {
		cmdFactory = new CommandFactory();
	}
	
	@Test
	public void shouldReturnLeftCommandInstance() {
		ICommand cmd = cmdFactory.getInstance(LEFT);
		assertEquals(Boolean.TRUE, (cmd instanceof RotateLeftCommand));
	}
	
	@Test
	public void shouldReturnRightCommandInstance() {
		ICommand cmd = cmdFactory.getInstance(RIGHT);
		assertEquals(Boolean.TRUE, (cmd instanceof RotateRightCommand));
	}
	
	@Test
	public void shouldReturnMoveActionInstance() {
		ICommand cmd = cmdFactory.getInstance(MOVE);
		assertEquals(Boolean.TRUE, (cmd instanceof MoveCommand));
	}
	
	@Test(expected = InvalidCommandException.class)
	public void shouldThrowInvalidCommandException() {
		cmdFactory.getInstance(INVALID_COMMAND);
	}
}