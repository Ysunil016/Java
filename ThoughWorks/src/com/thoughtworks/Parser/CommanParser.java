package com.thoughtworks.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughworks.Commands.CommandInterface;
import com.thoughworks.Commands.LeftCommand;
import com.thoughworks.Commands.MoveCommand;
import com.thoughworks.Commands.RightCommand;

public class CommanParser {

	private String roverCommand;

	private Map<Character, CommandInterface> stringToCommandMap = new HashMap<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put('L', new LeftCommand());
			put('R', new RightCommand());
			put('M', new MoveCommand());
		}
	};

	public CommanParser(String roverCommand) {
		this.roverCommand = roverCommand;
	}

	public List<CommandInterface> getCommand() {
		List<CommandInterface> commandInterfaces = new ArrayList<>();
		for (Character command : this.roverCommand.toCharArray()) {
			if (command == null)
				break;
			commandInterfaces.add(getCommandInterface(command));
		}
		return commandInterfaces;
	}

	private CommandInterface getCommandInterface(Character command) {
		return stringToCommandMap.get(command);
	}

}
