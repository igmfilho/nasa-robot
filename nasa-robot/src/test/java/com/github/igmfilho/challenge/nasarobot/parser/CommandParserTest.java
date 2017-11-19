package com.github.igmfilho.challenge.nasarobot.parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.github.igmfilho.challenge.nasarobot.command.ICommand;
import com.github.igmfilho.challenge.nasarobot.command.MoveCommand;
import com.github.igmfilho.challenge.nasarobot.command.RotateLeftCommand;
import com.github.igmfilho.challenge.nasarobot.command.RotateRightCommand;
import com.github.igmfilho.challenge.nasarobot.exception.InvalidCommandException;
import com.github.igmfilho.challenge.nasarobot.factory.CommandFactory;

public class CommandParserTest {
	
	private CommandParser parser; 
	
	@Before
	public void setUp() {
		parser = new CommandParser();
		parser.setCommandFactory(new CommandFactory());
	}
	
	@Test
    public void shouldReturnAnInstanceOfRotateLeftCommand(){
        List<ICommand> cmds = parser.parse("L");
        assertTrue(cmds.get(0) instanceof RotateLeftCommand);
    }

    @Test
    public void shouldReturnAnInstanceOfRotateRightCommand(){
        List<ICommand> cmds = parser.parse("R");
        assertTrue(cmds.get(0) instanceof RotateRightCommand);
    }

    @Test
    public void shouldReturnAnInstanceOfMoveCommand() throws Exception {
        List<ICommand> cmds = parser.parse("M");
        assertTrue(cmds.get(0) instanceof MoveCommand);
    }
    
    @Test
    public void shouldContainFiveCommands() throws Exception {
        List<ICommand> cmds = parser.parse("MLRLR");
        assertEquals(cmds.size(), 5);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldValidateInvalidCommand() throws Exception {
    	parser.parse("LMRA");
    }
}