package Commands;

import Exceptions.WrongNumberOfElementsException;
import Program.CommandManager;
import Program.Console;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand extends AbstractCommand {
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    /**
     * Start execute command.
     * @return Command status.
     */
    @Override
    public boolean startExecute(String arg) {

        return true;
    }
}
